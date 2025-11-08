/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Ciudades;
import entities.Universidades;
import entities.Usuarios;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.Part;
import model.UniversidadesDTO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import services.CiudadesFacadeLocal;
import services.UniversidadesFacadeLocal;
import services.UsuariosFacadeLocal;

/**
 *
 * @author Jhon Deibys Torres
 */
@Named(value = "controllerUniversity")
@SessionScoped
public class controllerUniversity implements Serializable {

    Universidades uni = new Universidades();
     UniversidadesDTO undt = new UniversidadesDTO();
    Ciudades ciu = new Ciudades();
    Usuarios user = new Usuarios();
    private Integer idUsuarioSeleccionado;

    List<SelectItem> listaCiudades;
    
    private Part file;
    
    Date date = new Date();

    @EJB
    UniversidadesFacadeLocal unfl;
    @EJB
    CiudadesFacadeLocal cl;
    @EJB
    UsuariosFacadeLocal ufl;

    public controllerUniversity() {
    }

    public UniversidadesDTO getUndt() {
        return undt;
    }

    public void setUndt(UniversidadesDTO undt) {
        this.undt = undt;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Integer getIdUsuarioSeleccionado() {
        return idUsuarioSeleccionado;
    }

    public void setIdUsuarioSeleccionado(Integer idUsuarioSeleccionado) {
        this.idUsuarioSeleccionado = idUsuarioSeleccionado;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }

    public Universidades getUni() {
        return uni;
    }

    public void setUni(Universidades uni) {
        this.uni = uni;
    }

    public Ciudades getCiu() {
        return ciu;
    }

    public void setCiu(Ciudades ciu) {
        this.ciu = ciu;
    }

    public List<Universidades> listarUniversidades() {

        try {
            return this.unfl.findAll();
        } catch (Exception e) {
        }

        return null;
    }

    public List<SelectItem> listarCiudades() {
        listaCiudades = new ArrayList<>();
        try {
            for (Ciudades ciud : this.cl.findAll()) {

                SelectItem item = new SelectItem(ciud.getId(), ciud.getNombre());
                listaCiudades.add(item);

            }

            return listaCiudades;
        } catch (Exception e) {
        }
        return null;
    }

    public String registrarUniversidades() {
        try {
             
            
            uni.setFechaRegistro(new Date());
            uni.setCiudadId(cl.find(undt.getId_c()));
            
            Usuarios ust = ufl.find(undt.getId_us());
            uni.setCreadoPor(ust);
            uni.setContactoEmail(undt.getContactoEmail());
            uni.setNombreUniversidad(undt.getNombreUniversidad());
            this.unfl.create(uni);
            undt = new UniversidadesDTO();
            ciu = new Ciudades();

            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Universidad Registrada Exitosamente", "MSG_INFO");
            context.addMessage(null, fm);

            if (FacesContext.getCurrentInstance().getViewRoot().getViewId().contains("Universidad")) {
                return "inicioSesionUniversidad.xhtml?faces-redirect=true";
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Registrar Universidad" + e.getMessage(), null));
        }
        return null;
    }

    public String EliminarUniversidad(UniversidadesDTO unidto) {
        try {
            
          
            this.unfl.remove(unfl.find(unidto.getId()));
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion exitosa al Eliminar Universidad" , null));
        } catch (Exception e) {
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Eliminar Universidad" + e.getMessage(), null));
        }
        return "inicioSesionUniversidad.xhtml?faces-redirect=true";
    }

    public void editarUniversidad(UniversidadesDTO unis) {

            this.undt = unis;
            Usuarios ust = ufl.find(undt.getId_us());
            uni.setCreadoPor(ust);
            Ciudades ciudad = cl.find(this.undt.getId_c());
            ciu.setId(ciudad.getId());
    }

    public String actualizarUniversidades() {
        try {

          int ciudad;
        
        switch (undt.getNombreCiudad()) {
            case "Bogota":
                    ciudad =1;
                break;
            case "Barranquilla":
                ciudad =4;
                break;
            case "Medellin":
                ciudad =2;
                break;
            case "Cali":
                ciudad =3;
                break;
            case "Bucaramanga":
                ciudad =5;
                break;
            default:
                throw new AssertionError();
        }
          
       
        this.uni.setId(undt.getId());
          this.uni.setCiudadId(cl.find(ciudad));
          
            this.uni.setCreadoPor(ufl.find(undt.getId_us()));
            
           this.uni.setNombreUniversidad(undt.getNombreUniversidad());
           
           this.uni.setContactoEmail(undt.getContactoEmail());
           this.uni.setFechaRegistro(undt.getFechaRegistro());

            this.unfl.edit(uni);
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion de Universidad Editada Exitosamente", "MSG_INFO"));

        } catch (Exception e) {
            
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error  al Editar Universidad" + e.getMessage(), null));
        }
        return "inicioSesionUniversidad.xhtml?faces-redirect=true";
    }
    
    
    
    public void procesarCsvUniversidades(){
        
        try(Reader reader = new InputStreamReader(file.getInputStream())) {
            
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
            for(CSVRecord record : records){
               
               
                uni.setNombreUniversidad(record.get("nombre_universidades"));
                uni.setContactoEmail(record.get("correo"));
             
                uni.setFechaRegistro(date);
                Usuarios encargado = ufl.findByAd(record.get("nombre_usuario_encargado"));
                uni.setCreadoPor(encargado);
                
                int ciudad;
                switch (record.get("ciudad")) {
                    case "Bogota":
                            ciudad = 1;
                        break;
                    case "Medellin":
                            ciudad = 2;
                        break;
                    case "Cali":
                            ciudad = 3;
                        break;
                    case "Barranquilla":
                            ciudad = 4;
                        break;
                     case "Bucaramanga":
                            ciudad = 5;
                        break;
                    default:
                        throw new AssertionError();
                }
                
                uni.setCiudadId(cl.find(ciudad));
                
                unfl.create(uni);
            }
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Universidades cargadas desde CSV correctamente", null));
            
        } catch (Exception e) {
              e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al procesar CSV: " + e.getMessage(), null));
        }
    }
    
    
public List<UniversidadesDTO> obtenerUniversidades() {
    String urls = "http://localhost:8084/univer";
    try {
        URL us = new URL(urls);
        HttpURLConnection conn = (HttpURLConnection) us.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder json = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            json.append(output);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json.toString(), new TypeReference<List<UniversidadesDTO>>() {});
        
    } catch (Exception e) {
        e.printStackTrace();
         FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Cargar las Universidades desde la web: " + e.getMessage(), null));
        return null;
    }
}

}
