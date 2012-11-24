/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.VO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arturo
 */
@Entity
@Table(name = "thistoriaclinica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "THistoriaClinica.findAll", query = "SELECT t FROM THistoriaClinica t"),
    @NamedQuery(name = "THistoriaClinica.findByPacienteDocPaciente", query = "SELECT t FROM THistoriaClinica t WHERE t.pacienteDocPaciente = :pacienteDocPaciente"),
    @NamedQuery(name = "THistoriaClinica.findByFechaApertura", query = "SELECT t FROM THistoriaClinica t WHERE t.fechaApertura = :fechaApertura")})
public class THistoriaClinica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Paciente_Doc_Paciente")
    private String pacienteDocPaciente;
    @Basic(optional = false)
    @Column(name = "fecha_apertura")
    @Temporal(TemporalType.DATE)
    private Date fechaApertura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tHistoriaClinica")
    private Collection<CValoracion> cValoracionCollection;
    @JoinColumn(name = "Paciente_Doc_Paciente", referencedColumnName = "Doc_Paciente", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private CPaciente cPaciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tHistoriaClinica")
    private Collection<CConsulta> cConsultaCollection;

    public THistoriaClinica() {
    }

    public THistoriaClinica(String pacienteDocPaciente) {
        this.pacienteDocPaciente = pacienteDocPaciente;
    }

    public THistoriaClinica(String pacienteDocPaciente, Date fechaApertura) {
        this.pacienteDocPaciente = pacienteDocPaciente;
        this.fechaApertura = fechaApertura;
    }

    public String getPacienteDocPaciente() {
        return pacienteDocPaciente;
    }

    public void setPacienteDocPaciente(String pacienteDocPaciente) {
        this.pacienteDocPaciente = pacienteDocPaciente;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    @XmlTransient
    public Collection<CValoracion> getCValoracionCollection() {
        return cValoracionCollection;
    }

    public void setCValoracionCollection(Collection<CValoracion> cValoracionCollection) {
        this.cValoracionCollection = cValoracionCollection;
    }

    public CPaciente getCPaciente() {
        return cPaciente;
    }

    public void setCPaciente(CPaciente cPaciente) {
        this.cPaciente = cPaciente;
    }

    @XmlTransient
    public Collection<CConsulta> getCConsultaCollection() {
        return cConsultaCollection;
    }

    public void setCConsultaCollection(Collection<CConsulta> cConsultaCollection) {
        this.cConsultaCollection = cConsultaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacienteDocPaciente != null ? pacienteDocPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof THistoriaClinica)) {
            return false;
        }
        THistoriaClinica other = (THistoriaClinica) object;
        if ((this.pacienteDocPaciente == null && other.pacienteDocPaciente != null) || (this.pacienteDocPaciente != null && !this.pacienteDocPaciente.equals(other.pacienteDocPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "consultorio.VO.THistoriaClinica[ pacienteDocPaciente=" + pacienteDocPaciente + " ]";
    }
    
}
