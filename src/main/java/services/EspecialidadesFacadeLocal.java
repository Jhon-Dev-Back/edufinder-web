/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.Especialidades;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface EspecialidadesFacadeLocal {

    void create(Especialidades especialidades);

    void edit(Especialidades especialidades);

    void remove(Especialidades especialidades);

    Especialidades find(Object id);

    List<Especialidades> findAll();

    List<Especialidades> findRange(int[] range);

    int count();
    
}
