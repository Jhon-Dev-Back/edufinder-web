/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jhon Deibys Torres
 */
@Entity
@Table(name = "correos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Correos.findAll", query = "SELECT c FROM Correos c"),
    @NamedQuery(name = "Correos.findByIdcorreo", query = "SELECT c FROM Correos c WHERE c.idcorreo = :idcorreo"),
    @NamedQuery(name = "Correos.findByFechaEnvio", query = "SELECT c FROM Correos c WHERE c.fechaEnvio = :fechaEnvio"),
    @NamedQuery(name = "Correos.findByAsunto", query = "SELECT c FROM Correos c WHERE c.asunto = :asunto")})
public class Correos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcorreo")
    private Integer idcorreo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_envio")
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    @Size(max = 255)
    @Column(name = "asunto")
    private String asunto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "detalle")
    private String detalle;
    @JoinColumn(name = "remitente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios remitenteId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcorreo")
    private Collection<CorreoDestinatarios> correoDestinatariosCollection;

    public Correos() {
    }

    public Correos(Integer idcorreo) {
        this.idcorreo = idcorreo;
    }

    public Correos(Integer idcorreo, Date fechaEnvio, String detalle) {
        this.idcorreo = idcorreo;
        this.fechaEnvio = fechaEnvio;
        this.detalle = detalle;
    }

    public Integer getIdcorreo() {
        return idcorreo;
    }

    public void setIdcorreo(Integer idcorreo) {
        this.idcorreo = idcorreo;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Usuarios getRemitenteId() {
        return remitenteId;
    }

    public void setRemitenteId(Usuarios remitenteId) {
        this.remitenteId = remitenteId;
    }

    @XmlTransient
    public Collection<CorreoDestinatarios> getCorreoDestinatariosCollection() {
        return correoDestinatariosCollection;
    }

    public void setCorreoDestinatariosCollection(Collection<CorreoDestinatarios> correoDestinatariosCollection) {
        this.correoDestinatariosCollection = correoDestinatariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcorreo != null ? idcorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correos)) {
            return false;
        }
        Correos other = (Correos) object;
        if ((this.idcorreo == null && other.idcorreo != null) || (this.idcorreo != null && !this.idcorreo.equals(other.idcorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Correos[ idcorreo=" + idcorreo + " ]";
    }
    
}
