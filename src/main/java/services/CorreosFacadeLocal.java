/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.Correos;
import entities.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface CorreosFacadeLocal {

    void create(Correos correos);

    void edit(Correos correos);

    void remove(Correos correos);

    Correos find(Object id);

    List<Correos> findAll();

    List<Correos> findRange(int[] range);

    int count();
    
    List<Correos> findCorres(Usuarios id);
}
