/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import entities.Universidades;
import entities.Usuarios;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import services.UniversidadesFacadeLocal;
import services.UsuariosFacadeLocal;

/**
 *
 * @author Jhon Deibys Torres
 */
@Named(value = "dashboard")
@ViewScoped
public class dashboardController implements Serializable {

    
    @EJB 
    UsuariosFacadeLocal ufl;
     @EJB 
     UniversidadesFacadeLocal unfl;
    public dashboardController() {
    }
    
    
      public String getJsonUsuariosPorRol() {
        Map<String, Integer> conteoPorRol = new HashMap<>();

        for (Usuarios u : ufl.findAll()) {
            String nombreRol = u.getRolId().getNombre();
            conteoPorRol.put(nombreRol, conteoPorRol.getOrDefault(nombreRol, 0) + 1);
        }

        StringBuilder json = new StringBuilder("[");
        for (Map.Entry<String, Integer> entry : conteoPorRol.entrySet()) {
            json.append("{\"rol\":\"")
                .append(entry.getKey())
                .append("\",\"cantidad\":")
                .append(entry.getValue())
                .append("},");
        }
        if (json.length() > 1) json.setLength(json.length() - 1); 
        json.append("]");
        return json.toString();
    }
      
       public String getJsonUsuariosPorEspecialidad() {
        Map<String, Integer> conteoSpecialidadMap = new HashMap<>();

        for (Usuarios u : ufl.findAll()) {
            String nombreEsp = u.getEspecialidadId().getNombre();
            conteoSpecialidadMap.put(nombreEsp, conteoSpecialidadMap.getOrDefault(nombreEsp, 0) + 1);
        }

        StringBuilder json = new StringBuilder("[");
        for (Map.Entry<String, Integer> entry : conteoSpecialidadMap.entrySet()) {
            json.append("{\"especialidad\":\"")
                .append(entry.getKey())
                .append("\",\"cantidad\":")
                .append(entry.getValue())
                .append("},");
        }
        if (json.length() > 1) json.setLength(json.length() - 1); 
        json.append("]");
        return json.toString();
    }
       
       
      public String getJsonUsuariosPorEdad() {
        Map<String, Integer> conteoEdadesMap = new HashMap<>();

        for (Usuarios u : ufl.findAll()) {
            String userEdad =  u.getEdad().toString();
            conteoEdadesMap.put(userEdad, conteoEdadesMap.getOrDefault(userEdad, 0) + 1);
        }

        StringBuilder json = new StringBuilder("[");
        for (Map.Entry<String, Integer> entry : conteoEdadesMap.entrySet()) {
            json.append("{\"edad\":\"")
                .append(entry.getKey())
                .append("\",\"cantidad\":")
                .append(entry.getValue())
                .append("},");
        }
        if (json.length() > 1) json.setLength(json.length() - 1); 
        json.append("]");
        return json.toString();
    }
      
      public String getJsonUniversidadesPorCiudad() {
        Map<String, Integer> conteoUniCiudades = new HashMap<>();

        for (Universidades  u : unfl.findAll()) {
            String univer =  u.getCiudadId().getNombre();
            conteoUniCiudades.put(univer, conteoUniCiudades.getOrDefault(univer, 0) + 1);
        }

        StringBuilder json = new StringBuilder("[");
        for (Map.Entry<String, Integer> entry : conteoUniCiudades.entrySet()) {
            json.append("{\"ciudades\":\"")
                .append(entry.getKey())
                .append("\",\"cantidad\":")
                .append(entry.getValue())
                .append("},");
        }
        if (json.length() > 1) json.setLength(json.length() - 1); 
        json.append("]");
        return json.toString();
    }
}
