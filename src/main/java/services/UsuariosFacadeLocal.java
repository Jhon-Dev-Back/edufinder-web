/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface UsuariosFacadeLocal {

    void create(Usuarios usuarios);

    void edit(Usuarios usuarios);

    void remove(Usuarios usuarios);

    Usuarios find(Object id);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();
    
    Usuarios iniciarSesion(String nombres, String contrasenna, String correo);
    
    List<Usuarios> findByProfesional(int rolid);

    public List<Usuarios> findByCliente(int clienteid);

    public List<Usuarios> findByAdmin(int admin);
      public Usuarios findByAd(String admin);
      
         public Usuarios findByEmail(String correo);
          public Usuarios findById(Integer id);
      public Usuarios findByIdentificacion(String ident);
}
