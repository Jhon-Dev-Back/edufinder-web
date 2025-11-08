/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.Universidades;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface UniversidadesFacadeLocal {

    void create(Universidades universidades);

    void edit(Universidades universidades);

    void remove(Universidades universidades);

    Universidades find(Object id);

    List<Universidades> findAll();

    List<Universidades> findRange(int[] range);

    int count();
    
}
