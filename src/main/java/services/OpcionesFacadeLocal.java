/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.Opciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface OpcionesFacadeLocal {

    void create(Opciones opciones);

    void edit(Opciones opciones);

    void remove(Opciones opciones);

    Opciones find(Object id);

    List<Opciones> findAll();

    List<Opciones> findRange(int[] range);

    int count();
    
}
