/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.CorreoDestinatarios;
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
public class CorreoDestinatariosFacade extends AbstractFacade<CorreoDestinatarios> implements CorreoDestinatariosFacadeLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CorreoDestinatariosFacade() {
        super(CorreoDestinatarios.class);
    }

    @Override
    public List<CorreoDestinatarios> findCorreosDest(Usuarios id) {
           return em.createQuery("SELECT c FROM CorreoDestinatarios c WHERE c.destinatarioId=:id", CorreoDestinatarios.class)
             .setParameter("id", id)
             .getResultList();
    }
    
}
