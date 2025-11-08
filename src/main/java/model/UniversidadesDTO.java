/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 *
 * @author Jhon Deibys Torres
 */
public class UniversidadesDTO {
   private Integer id;
    private String nombreUniversidad;
    private String contactoEmail;
    private Date fechaRegistro;
    private String creadoPor;   
    private String  ciudadID;
    
    private Integer id_c;
    private Integer id_us;

    public Integer getId_c() {
        return id_c;
    }
    public void setId_c(Integer id_c) {
        this.id_c = id_c;
    }

    public Integer getId_us() {
        return id_us;
    }

    public void setId_us(Integer id_us) {
        this.id_us = id_us;
    }
    
   public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombreUniversidad() { return nombreUniversidad; }
    public void setNombreUniversidad(String nombreUniversidad) { this.nombreUniversidad = nombreUniversidad; }
    public String getContactoEmail() { return contactoEmail; }
    public void setContactoEmail(String contactoEmail) { this.contactoEmail = contactoEmail; }
    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public String getNombreCreador() { return creadoPor; }
    public void setNombreCreador(String nombreCreador) { this.creadoPor = nombreCreador; }
    public String getNombreCiudad() { return ciudadID; }
    public void setNombreCiudad(String nombreCiudad) { this.ciudadID = nombreCiudad; }
}
