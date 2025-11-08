/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Mensajes;
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
public class MensajesFacade extends AbstractFacade<Mensajes> implements MensajesFacadeLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajesFacade() {
        super(Mensajes.class);
    }

    @Override
    public List<Mensajes> findMsgById(Usuarios id_user) {
        return em.createQuery("SELECT m FROM Mensajes m WHERE m.idConversacion.idUsuario=:id_user")
             .setParameter("id_user", id_user)
             .getResultList();
    }
    
}
