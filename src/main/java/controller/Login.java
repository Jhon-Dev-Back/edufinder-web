/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import entities.Especialidades;
import entities.Roles;
import entities.TiposDocumento;
import entities.Usuarios;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import services.EspecialidadesFacadeLocal;
import services.RolesFacadeLocal;
import services.TiposDocumentoFacadeLocal;
import services.UsuariosFacadeLocal;

/**
 *
 * @author Jhon Deibys Torres
 *
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

    private String usuario;
    private String contrasenna;
    private String correo;
    private String newContraseña;
    

    private Usuarios user = new Usuarios();
    Roles rol = new Roles();
    Especialidades esp = new Especialidades();
    TiposDocumento tipod = new TiposDocumento();


    @EJB
    UsuariosFacadeLocal ufl;
    @EJB
    RolesFacadeLocal rlf;
    @EJB
    EspecialidadesFacadeLocal spcl;
    @EJB
    TiposDocumentoFacadeLocal tp;

    public Login(String usuario, String contrasenna, String correo) {
        this.usuario = usuario;
        this.contrasenna = contrasenna;
        this.correo = correo;
    }

    public Login() {
        System.out.println("Bean Login instanciado correctamente");
        
    }

    public String getNewContraseña() {
        return newContraseña;
    }

    public void setNewContraseña(String newContraseña) {
        this.newContraseña = newContraseña;
    }
    
    

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public Especialidades getEsp() {
        return esp;
    }

    public void setEsp(Especialidades esp) {
        this.esp = esp;
    }

    public TiposDocumento getTipod() {
        return tipod;
    }

    public void setTipod(TiposDocumento tipod) {
        this.tipod = tipod;
    }



    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String iniciarSesion() {
        user = this.ufl.iniciarSesion(usuario, contrasenna, correo);
        if (user.getNumeroDocumento() != null && user.getRolId().getId() == 1) {
            HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            sesion.setAttribute("usuario", user);
            return "/views/desarrollador_Temp_Cliente.xhtml?faces-redirect=true";
        } else if (user.getNumeroDocumento() != null && user.getRolId().getId() == 4) {
            HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            sesion.setAttribute("usuario", user);
            return "/views/inicio_principal_Temp_Cliente.xhtml?faces-redirect=true";
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "nombre de usuario y/o contraseña invalidos", "MSG_ERROR");
            context.addMessage(null, fm);
            return null;
        }
    }

    public String cerrarSesion() {

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/inicioSesion.xhtml?faces-redirect=true";
    }
    
    
     public void actualizarUsuario() {
        try {
            Usuarios usuarioExistente = ufl.find(user.getId());
            user.setContraseña(usuarioExistente.getContraseña());
            user.setRolId(rlf.find(user.getRolId().getId()));
            user.setEspecialidadId(spcl.find(user.getEspecialidadId().getId()));
            user.setTipoDocumentoId(tp.find(user.getTipoDocumentoId().getId()));

            ufl.edit(user);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Editado Exitosamente", null));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al editar usuario: " + e.getMessage(), null));
        }
        
      
    }

     public void cambiarContraseña(){
         
         try{
         Usuarios pass = ufl.find(user.getId());
         if (pass.getContraseña().equals(user.getContraseña())) {
             
             if (contrasenna.equals(newContraseña)) {
                 user.setContraseña(contrasenna);
                  ufl.edit(user);
                   FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Contraseña Cambiada Exitosamente", null));
             }else{
                   FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las contraseñas nuevas no coinciden", null));
             }
         }else{
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las contraseña actual no coincide", null));
         }
         
        
         }catch(Exception e){
              e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al editar contraseña: " + e.getMessage(), null));
         }
         
      
     }

   

}
