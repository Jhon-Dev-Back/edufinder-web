/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhon Deibys Torres
 */
@Entity
@Table(name = "correo_destinatarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CorreoDestinatarios.findAll", query = "SELECT c FROM CorreoDestinatarios c"),
    @NamedQuery(name = "CorreoDestinatarios.findById", query = "SELECT c FROM CorreoDestinatarios c WHERE c.id = :id"),
    @NamedQuery(name = "CorreoDestinatarios.findByCorreoExternos", query = "SELECT c FROM CorreoDestinatarios c WHERE c.correoExternos = :correoExternos")})
public class CorreoDestinatarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 1000)
    @Column(name = "correo_externos")
    private String correoExternos;
    @JoinColumn(name = "idcorreo", referencedColumnName = "idcorreo")
    @ManyToOne(optional = false)
    private Correos idcorreo;
    @JoinColumn(name = "destinatario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios destinatarioId;

    public CorreoDestinatarios() {
    }

    public CorreoDestinatarios(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreoExternos() {
        return correoExternos;
    }

    public void setCorreoExternos(String correoExternos) {
        this.correoExternos = correoExternos;
    }

    public Correos getIdcorreo() {
        return idcorreo;
    }

    public void setIdcorreo(Correos idcorreo) {
        this.idcorreo = idcorreo;
    }

    public Usuarios getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(Usuarios destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CorreoDestinatarios)) {
            return false;
        }
        CorreoDestinatarios other = (CorreoDestinatarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CorreoDestinatarios[ id=" + id + " ]";
    }
    
}
