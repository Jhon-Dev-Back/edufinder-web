/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.Mensajes;
import entities.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface MensajesFacadeLocal {

    void create(Mensajes mensajes);

    void edit(Mensajes mensajes);

    void remove(Mensajes mensajes);

    Mensajes find(Object id);

    List<Mensajes> findAll();

    List<Mensajes> findRange(int[] range);

    int count();
    
    List<Mensajes> findMsgById(Usuarios id_user);
}
