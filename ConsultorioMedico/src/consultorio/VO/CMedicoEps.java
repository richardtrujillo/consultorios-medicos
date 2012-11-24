/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.VO;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arturo
 */
@Entity
@Table(name = "tmedicoeps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CMedicoEps.findAll", query = "SELECT c FROM CMedicoEps c"),
    @NamedQuery(name = "CMedicoEps.findByCodmedico", query = "SELECT c FROM CMedicoEps c WHERE c.codmedico = :codmedico"),
    @NamedQuery(name = "CMedicoEps.findByNombre", query = "SELECT c FROM CMedicoEps c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "CMedicoEps.findByApellido", query = "SELECT c FROM CMedicoEps c WHERE c.apellido = :apellido")})
public class CMedicoEps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Cod_medico")
    private String codmedico;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Apellido")
    private String apellido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tMedicoEpsCodmedico")
    private Collection<CPaciente> cPacienteCollection;
    @JoinColumn(name = "TEps_Cod_Eps", referencedColumnName = "Cod_Eps")
    @ManyToOne(optional = false)
    private CEps tEpsCodEps;

    public CMedicoEps() {
    }

    public CMedicoEps(String codmedico) {
        this.codmedico = codmedico;
    }

    public CMedicoEps(String codmedico, String nombre, String apellido) {
        this.codmedico = codmedico;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getCodmedico() {
        return codmedico;
    }

    public void setCodmedico(String codmedico) {
        this.codmedico = codmedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @XmlTransient
    public Collection<CPaciente> getCPacienteCollection() {
        return cPacienteCollection;
    }

    public void setCPacienteCollection(Collection<CPaciente> cPacienteCollection) {
        this.cPacienteCollection = cPacienteCollection;
    }

    public CEps getTEpsCodEps() {
        return tEpsCodEps;
    }

    public void setTEpsCodEps(CEps tEpsCodEps) {
        this.tEpsCodEps = tEpsCodEps;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmedico != null ? codmedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CMedicoEps)) {
            return false;
        }
        CMedicoEps other = (CMedicoEps) object;
        if ((this.codmedico == null && other.codmedico != null) || (this.codmedico != null && !this.codmedico.equals(other.codmedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "consultorio.VO.CMedicoEps[ codmedico=" + codmedico + " ]";
    }
    
}
