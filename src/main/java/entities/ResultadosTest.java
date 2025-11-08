/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhon Deibys Torres
 */
@Entity
@Table(name = "resultados_test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadosTest.findAll", query = "SELECT r FROM ResultadosTest r"),
    @NamedQuery(name = "ResultadosTest.findById", query = "SELECT r FROM ResultadosTest r WHERE r.id = :id"),
    @NamedQuery(name = "ResultadosTest.findByFecha", query = "SELECT r FROM ResultadosTest r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "ResultadosTest.findByAreaDominante", query = "SELECT r FROM ResultadosTest r WHERE r.areaDominante = :areaDominante")})
public class ResultadosTest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 13)
    @Column(name = "area_dominante")
    private String areaDominante;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios usuarioId;

    public ResultadosTest() {
    }

    public ResultadosTest(Integer id) {
        this.id = id;
    }

    public ResultadosTest(Integer id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAreaDominante() {
        return areaDominante;
    }

    public void setAreaDominante(String areaDominante) {
        this.areaDominante = areaDominante;
    }

    public Usuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuarios usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof ResultadosTest)) {
            return false;
        }
        ResultadosTest other = (ResultadosTest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ResultadosTest[ id=" + id + " ]";
    }
    
}
