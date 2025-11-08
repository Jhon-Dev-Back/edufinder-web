/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import entities.CorreoDestinatarios;
import entities.Correos;
import entities.Usuarios;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import services.CorreoDestinatariosFacadeLocal;
import services.CorreosFacadeLocal;

/**
 *
 * @author Jhon Deibys Torres
 */
@Named(value = "controllerCorreos")
@ViewScoped
public class controllerCorreos implements Serializable {

    /**
     * Creates a new instance of controllerCorreos
     */
    public controllerCorreos() {
    }
    
    Correos cor = new Correos();
    CorreoDestinatarios dest = new CorreoDestinatarios();
    
    @EJB
    CorreoDestinatariosFacadeLocal destfl;
    @EJB
    CorreosFacadeLocal corfl;

    public Correos getCor() {
        return cor;
    }

    public void setCor(Correos cor) {
        this.cor = cor;
    }

    public CorreoDestinatarios getDest() {
        return dest;
    }

    public void setDest(CorreoDestinatarios dest) {
        this.dest = dest;
    }
    
    
    public List<Correos> listarCorreosUser(){
        try {
               Usuarios usuarioLogueado = (Usuarios) FacesContext.getCurrentInstance()
        .getExternalContext().getSessionMap().get("usuario");
            return corfl.findCorres(usuarioLogueado);
        } catch (Exception e) {
            return null;
        }
    }
    
        public List<CorreoDestinatarios> listarCorreosUserDes(){
        try {
               Usuarios usuarioLogueado = (Usuarios) FacesContext.getCurrentInstance()
        .getExternalContext().getSessionMap().get("usuario");
            return destfl.findCorreosDest(usuarioLogueado);
        } catch (Exception e) {
            return null;
        }
    }
}
