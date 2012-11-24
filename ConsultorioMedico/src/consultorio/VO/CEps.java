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
@Table(name = "teps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CEps.findAll", query = "SELECT c FROM CEps c"),
    @NamedQuery(name = "CEps.findByCodEps", query = "SELECT c FROM CEps c WHERE c.codEps = :codEps"),
    @NamedQuery(name = "CEps.findByNit", query = "SELECT c FROM CEps c WHERE c.nit = :nit"),
    @NamedQuery(name = "CEps.findByNombreEps", query = "SELECT c FROM CEps c WHERE c.nombreEps = :nombreEps")})
public class CEps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Cod_Eps")
    private String codEps;
    @Basic(optional = false)
    @Column(name = "Nit")
    private String nit;
    @Basic(optional = false)
    @Column(name = "NombreEps")
    private String nombreEps;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tEpsCodEps")
    private Collection<CMedicoEps> cMedicoEpsCollection;

    public CEps() {
    }

    public CEps(String codEps) {
        this.codEps = codEps;
    }

    public CEps(String codEps, String nit, String nombreEps) {
        this.codEps = codEps;
        this.nit = nit;
        this.nombreEps = nombreEps;
    }

    public String getCodEps() {
        return codEps;
    }

    public void setCodEps(String codEps) {
        this.codEps = codEps;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreEps() {
        return nombreEps;
    }

    public void setNombreEps(String nombreEps) {
        this.nombreEps = nombreEps;
    }

    @XmlTransient
    public Collection<CMedicoEps> getCMedicoEpsCollection() {
        return cMedicoEpsCollection;
    }

    public void setCMedicoEpsCollection(Collection<CMedicoEps> cMedicoEpsCollection) {
        this.cMedicoEpsCollection = cMedicoEpsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEps != null ? codEps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CEps)) {
            return false;
        }
        CEps other = (CEps) object;
        if ((this.codEps == null && other.codEps != null) || (this.codEps != null && !this.codEps.equals(other.codEps))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "consultorio.VO.CEps[ codEps=" + codEps + " ]";
    }
    
}
