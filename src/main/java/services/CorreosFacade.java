/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Correos;
import entities.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jhon Deibys Torres
 */
@Stateless
public class CorreosFacade extends AbstractFacade<Correos> implements CorreosFacadeLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CorreosFacade() {
        super(Correos.class);
    }

    @Override
    public List<Correos> findCorres(Usuarios id) {
       return em.createQuery("SELECT c FROM Correos c WHERE c.remitenteId=:id", Correos.class)
             .setParameter("id", id)
             .getResultList();
    }
    
}
