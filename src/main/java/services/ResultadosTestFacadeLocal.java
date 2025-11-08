/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.ResultadosTest;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface ResultadosTestFacadeLocal {

    void create(ResultadosTest resultadosTest);

    void edit(ResultadosTest resultadosTest);

    void remove(ResultadosTest resultadosTest);

    ResultadosTest find(Object id);

    List<ResultadosTest> findAll();

    List<ResultadosTest> findRange(int[] range);

    int count();
    
}
