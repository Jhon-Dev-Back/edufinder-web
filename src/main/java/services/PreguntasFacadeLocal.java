/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.Preguntas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface PreguntasFacadeLocal {

    void create(Preguntas preguntas);

    void edit(Preguntas preguntas);

    void remove(Preguntas preguntas);

    Preguntas find(Object id);

    List<Preguntas> findAll();

    List<Preguntas> findRange(int[] range);

    int count();
    
}
