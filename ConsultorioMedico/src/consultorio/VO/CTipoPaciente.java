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
import javax.persistence.Lob;
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
@Table(name = "tipo_paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTipoPaciente.findAll", query = "SELECT c FROM CTipoPaciente c"),
    @NamedQuery(name = "CTipoPaciente.findByCodTipo", query = "SELECT c FROM CTipoPaciente c WHERE c.codTipo = :codTipo"),
    @NamedQuery(name = "CTipoPaciente.findByTipoPaciente", query = "SELECT c FROM CTipoPaciente c WHERE c.tipoPaciente = :tipoPaciente")})
public class CTipoPaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Cod_Tipo")
    private String codTipo;
    @Basic(optional = false)
    @Column(name = "Tipo_Paciente")
    private String tipoPaciente;
    @Basic(optional = false)
    @Lob
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPacienteCodTipo")
    private Collection<CPaciente> cPacienteCollection;

    public CTipoPaciente() {
    }

    public CTipoPaciente(String codTipo) {
        this.codTipo = codTipo;
    }

    public CTipoPaciente(String codTipo, String tipoPaciente, String descripcion) {
        this.codTipo = codTipo;
        this.tipoPaciente = tipoPaciente;
        this.descripcion = descripcion;
    }

    public String getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(String codTipo) {
        this.codTipo = codTipo;
    }

    public String getTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(String tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<CPaciente> getCPacienteCollection() {
        return cPacienteCollection;
    }

    public void setCPacienteCollection(Collection<CPaciente> cPacienteCollection) {
        this.cPacienteCollection = cPacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipo != null ? codTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTipoPaciente)) {
            return false;
        }
        CTipoPaciente other = (CTipoPaciente) object;
        if ((this.codTipo == null && other.codTipo != null) || (this.codTipo != null && !this.codTipo.equals(other.codTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "consultorio.VO.CTipoPaciente[ codTipo=" + codTipo + " ]";
    }
    
}
