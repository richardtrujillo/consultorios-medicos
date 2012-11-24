/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.VO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arturo
 */
@Entity
@Table(name = "valoracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CValoracion.findAll", query = "SELECT c FROM CValoracion c"),
    @NamedQuery(name = "CValoracion.findByCodValoracion", query = "SELECT c FROM CValoracion c WHERE c.cValoracionPK.codValoracion = :codValoracion"),
    @NamedQuery(name = "CValoracion.findByHistoriaClinica", query = "SELECT c FROM CValoracion c WHERE c.historiaClinica = :historiaClinica"),
    @NamedQuery(name = "CValoracion.findByDocPaciente", query = "SELECT c FROM CValoracion c WHERE c.docPaciente = :docPaciente"),
    @NamedQuery(name = "CValoracion.findByNumHistoriaClinica", query = "SELECT c FROM CValoracion c WHERE c.numHistoriaClinica = :numHistoriaClinica"),
    @NamedQuery(name = "CValoracion.findByMedico", query = "SELECT c FROM CValoracion c WHERE c.medico = :medico"),
    @NamedQuery(name = "CValoracion.findByNumSesion", query = "SELECT c FROM CValoracion c WHERE c.numSesion = :numSesion"),
    @NamedQuery(name = "CValoracion.findByPeso", query = "SELECT c FROM CValoracion c WHERE c.peso = :peso"),
    @NamedQuery(name = "CValoracion.findByEstatura", query = "SELECT c FROM CValoracion c WHERE c.estatura = :estatura"),
    @NamedQuery(name = "CValoracion.findByPresionArterial", query = "SELECT c FROM CValoracion c WHERE c.presionArterial = :presionArterial"),
    @NamedQuery(name = "CValoracion.findByFrecuenciaCardiaca", query = "SELECT c FROM CValoracion c WHERE c.frecuenciaCardiaca = :frecuenciaCardiaca"),
    @NamedQuery(name = "CValoracion.findByTHistoriaClinicaPacienteDocPaciente", query = "SELECT c FROM CValoracion c WHERE c.cValoracionPK.tHistoriaClinicaPacienteDocPaciente = :tHistoriaClinicaPacienteDocPaciente")})
public class CValoracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CValoracionPK cValoracionPK;
    @Basic(optional = false)
    @Column(name = "HistoriaClinica")
    private String historiaClinica;
    @Basic(optional = false)
    @Column(name = "DocPaciente")
    private String docPaciente;
    @Basic(optional = false)
    @Column(name = "NumHistoriaClinica")
    private String numHistoriaClinica;
    @Basic(optional = false)
    @Column(name = "Medico")
    private String medico;
    @Basic(optional = false)
    @Column(name = "NumSesion")
    private int numSesion;
    @Basic(optional = false)
    @Column(name = "Peso")
    private float peso;
    @Basic(optional = false)
    @Column(name = "Estatura")
    private float estatura;
    @Basic(optional = false)
    @Column(name = "PresionArterial")
    private String presionArterial;
    @Basic(optional = false)
    @Column(name = "FrecuenciaCardiaca")
    private String frecuenciaCardiaca;
    @Basic(optional = false)
    @Lob
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "THistoriaClinica_Paciente_Doc_Paciente", referencedColumnName = "Paciente_Doc_Paciente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private THistoriaClinica tHistoriaClinica;

    public CValoracion() {
    }

    public CValoracion(CValoracionPK cValoracionPK) {
        this.cValoracionPK = cValoracionPK;
    }

    public CValoracion(CValoracionPK cValoracionPK, String historiaClinica, String docPaciente, String numHistoriaClinica, String medico, int numSesion, float peso, float estatura, String presionArterial, String frecuenciaCardiaca, String descripcion) {
        this.cValoracionPK = cValoracionPK;
        this.historiaClinica = historiaClinica;
        this.docPaciente = docPaciente;
        this.numHistoriaClinica = numHistoriaClinica;
        this.medico = medico;
        this.numSesion = numSesion;
        this.peso = peso;
        this.estatura = estatura;
        this.presionArterial = presionArterial;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.descripcion = descripcion;
    }

    public CValoracion(String codValoracion, String tHistoriaClinicaPacienteDocPaciente) {
        this.cValoracionPK = new CValoracionPK(codValoracion, tHistoriaClinicaPacienteDocPaciente);
    }

    public CValoracionPK getCValoracionPK() {
        return cValoracionPK;
    }

    public void setCValoracionPK(CValoracionPK cValoracionPK) {
        this.cValoracionPK = cValoracionPK;
    }

    public String getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(String historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public String getDocPaciente() {
        return docPaciente;
    }

    public void setDocPaciente(String docPaciente) {
        this.docPaciente = docPaciente;
    }

    public String getNumHistoriaClinica() {
        return numHistoriaClinica;
    }

    public void setNumHistoriaClinica(String numHistoriaClinica) {
        this.numHistoriaClinica = numHistoriaClinica;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public int getNumSesion() {
        return numSesion;
    }

    public void setNumSesion(int numSesion) {
        this.numSesion = numSesion;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public String getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(String presionArterial) {
        this.presionArterial = presionArterial;
    }

    public String getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(String frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public THistoriaClinica getTHistoriaClinica() {
        return tHistoriaClinica;
    }

    public void setTHistoriaClinica(THistoriaClinica tHistoriaClinica) {
        this.tHistoriaClinica = tHistoriaClinica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cValoracionPK != null ? cValoracionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CValoracion)) {
            return false;
        }
        CValoracion other = (CValoracion) object;
        if ((this.cValoracionPK == null && other.cValoracionPK != null) || (this.cValoracionPK != null && !this.cValoracionPK.equals(other.cValoracionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "consultorio.VO.CValoracion[ cValoracionPK=" + cValoracionPK + " ]";
    }
    
}
