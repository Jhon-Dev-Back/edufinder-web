/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.CorreoDestinatarios;
import entities.Correos;
import entities.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface CorreoDestinatariosFacadeLocal {

    void create(CorreoDestinatarios correoDestinatarios);

    void edit(CorreoDestinatarios correoDestinatarios);

    void remove(CorreoDestinatarios correoDestinatarios);

    CorreoDestinatarios find(Object id);

    List<CorreoDestinatarios> findAll();

    List<CorreoDestinatarios> findRange(int[] range);

    int count();
     List<CorreoDestinatarios> findCorreosDest(Usuarios id);
}
