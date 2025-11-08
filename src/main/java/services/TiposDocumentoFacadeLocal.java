/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.TiposDocumento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface TiposDocumentoFacadeLocal {

    void create(TiposDocumento tiposDocumento);

    void edit(TiposDocumento tiposDocumento);

    void remove(TiposDocumento tiposDocumento);

    TiposDocumento find(Object id);

    List<TiposDocumento> findAll();

    List<TiposDocumento> findRange(int[] range);

    int count();
    
}
