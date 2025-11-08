/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import entities.Conversaciones;
import entities.Mensajes;
import entities.Usuarios;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.shaded.json.JSONArray;
import org.primefaces.shaded.json.JSONObject;
import services.ConversacionesFacadeLocal;
import services.MensajesFacadeLocal;

/**
 *
 * @author Jhon Deibys Torres
 */
@Named(value = "chat_AI")
@SessionScoped
public class Chat_AI implements Serializable {

    private String promt;
    private String respuesta;
    Mensajes msg = new Mensajes();
    Conversaciones conver = new Conversaciones();
    
    @EJB
    MensajesFacadeLocal msgfLocal;
    @EJB
    ConversacionesFacadeLocal conflocal;
    

    public Chat_AI() {
    }

    public String getPromt() {
        return promt;
    }

    public void setPromt(String promt) {
        this.promt = promt;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    private void disableSSLVerification() {
        try {
            javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[]{
                new javax.net.ssl.X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
            };
            javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void message_ai() {
        disableSSLVerification();
        try {
            System.out.println("IA Fallando" + System.getenv("OPEN_IA"));
            String key = System.getenv("OPEN_IA");
            URL url = new URL("https://api.openai.com/v1/chat/completions");
            HttpURLConnection conx = (HttpURLConnection) url.openConnection();
            conx.setRequestMethod("POST");
            conx.setRequestProperty("Content-Type", "application/json");
            conx.setRequestProperty("Authorization", "Bearer " + key);
            conx.setDoOutput(true);
            
            JSONObject jso = new JSONObject();
            jso.put("model", "gpt-4o-mini");
            JSONArray mss = new JSONArray();
            
            JSONObject systemMsg = new JSONObject();
            systemMsg.put("role", "system");
            systemMsg.put("content", "Eres un asistente experto en temas relacionado a  universidades su informacion general, costos, ubicaciones, etc... "
                    + "Solo debes responder preguntas relacionadas con ese tema y rechazar otras. Si te pregunta cosas diferentes diras que solo eres un Aistente"+
                    "que proporcianara cualquier inforacion relacionado a universidades ya sea de Colombia o del mundo entero, por supuesto puedes responder los saludos y las "
                    + "despedidas tambien.");

            JSONObject userMss = new JSONObject();
            userMss.put("role", "user");
            userMss.put("content", promt);
            mss.put(systemMsg);
            mss.put(userMss);
            jso.put("messages", mss);
            try (OutputStream os = conx.getOutputStream()) {
                os.write(jso.toString().getBytes("UTF-8"));
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(conx.getInputStream(), "UTF-8"));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            JSONObject respuestaJson = new JSONObject(response.toString());
            this.respuesta = respuestaJson.getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content");
            
             Usuarios usuarioLogueado = (Usuarios) FacesContext.getCurrentInstance()
        .getExternalContext().getSessionMap().get("usuario");
            
            conver.setIdUsuario(usuarioLogueado);
            conver.setFechaInicio(new Date());
            conflocal.create(conver);
            
            msg.setEmisor("usuario");
            msg.setContenido(promt);
            msg.setFechaEnvio(new Date());
            msg.setIdConversacion(conver);
            msgfLocal.create(msg);
            
             msg.setEmisor("ia");
            msg.setContenido(respuesta);
            msg.setFechaEnvio(new Date());
            msg.setIdConversacion(conver);
            msgfLocal.create(msg);
            this.promt = "";
            
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al realizar la petición: " + e.getMessage(), null));
        }
    }

    public List<Mensajes> listaDeMensajes(){
        
        Usuarios usuarioLogueado = (Usuarios) FacesContext.getCurrentInstance()
        .getExternalContext().getSessionMap().get("usuario");
        return  msgfLocal.findMsgById(usuarioLogueado);
        
    }
}
