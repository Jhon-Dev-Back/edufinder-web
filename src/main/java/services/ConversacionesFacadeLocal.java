/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.Conversaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface ConversacionesFacadeLocal {

    void create(Conversaciones conversaciones);

    void edit(Conversaciones conversaciones);

    void remove(Conversaciones conversaciones);

    Conversaciones find(Object id);

    List<Conversaciones> findAll();

    List<Conversaciones> findRange(int[] range);

    int count();
    
}
