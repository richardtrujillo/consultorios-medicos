/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.VO;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arturo
 */
@Entity
@Table(name = "consulta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CConsulta.findAll", query = "SELECT c FROM CConsulta c"),
    @NamedQuery(name = "CConsulta.findByCodConsulta", query = "SELECT c FROM CConsulta c WHERE c.cConsultaPK.codConsulta = :codConsulta"),
    @NamedQuery(name = "CConsulta.findByHistoriaClinica", query = "SELECT c FROM CConsulta c WHERE c.historiaClinica = :historiaClinica"),
    @NamedQuery(name = "CConsulta.findByCodtipo", query = "SELECT c FROM CConsulta c WHERE c.codtipo = :codtipo"),
    @NamedQuery(name = "CConsulta.findByDocPaciente", query = "SELECT c FROM CConsulta c WHERE c.docPaciente = :docPaciente"),
    @NamedQuery(name = "CConsulta.findByNumHistoriaClinica", query = "SELECT c FROM CConsulta c WHERE c.numHistoriaClinica = :numHistoriaClinica"),
    @NamedQuery(name = "CConsulta.findByMedico", query = "SELECT c FROM CConsulta c WHERE c.medico = :medico"),
    @NamedQuery(name = "CConsulta.findByFecha", query = "SELECT c FROM CConsulta c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CConsulta.findByHora", query = "SELECT c FROM CConsulta c WHERE c.hora = :hora"),
    @NamedQuery(name = "CConsulta.findByCanSesiones", query = "SELECT c FROM CConsulta c WHERE c.canSesiones = :canSesiones"),
    @NamedQuery(name = "CConsulta.findByTipoConsulta", query = "SELECT c FROM CConsulta c WHERE c.tipoConsulta = :tipoConsulta"),
    @NamedQuery(name = "CConsulta.findByHistoriaEnfermedad", query = "SELECT c FROM CConsulta c WHERE c.historiaEnfermedad = :historiaEnfermedad"),
    @NamedQuery(name = "CConsulta.findByTHistoriaClinicaPacienteDocPaciente", query = "SELECT c FROM CConsulta c WHERE c.cConsultaPK.tHistoriaClinicaPacienteDocPaciente = :tHistoriaClinicaPacienteDocPaciente")})
public class CConsulta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CConsultaPK cConsultaPK;
    @Basic(optional = false)
    @Column(name = "HistoriaClinica")
    private String historiaClinica;
    @Basic(optional = false)
    @Column(name = "Cod_tipo")
    private String codtipo;
    @Basic(optional = false)
    @Column(name = "Doc_Paciente")
    private String docPaciente;
    @Basic(optional = false)
    @Column(name = "NumHistoriaClinica")
    private String numHistoriaClinica;
    @Basic(optional = false)
    @Column(name = "Medico")
    private String medico;
    @Basic(optional = false)
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "Hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Basic(optional = false)
    @Column(name = "CanSesiones")
    private int canSesiones;
    @Basic(optional = false)
    @Column(name = "TipoConsulta")
    private String tipoConsulta;
    @Basic(optional = false)
    @Lob
    @Column(name = "MotivoConsulta")
    private String motivoConsulta;
    @Basic(optional = false)
    @Column(name = "HistoriaEnfermedad")
    private String historiaEnfermedad;
    @Basic(optional = false)
    @Lob
    @Column(name = "Antecedentes")
    private String antecedentes;
    @JoinColumn(name = "THistoriaClinica_Paciente_Doc_Paciente", referencedColumnName = "Paciente_Doc_Paciente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private THistoriaClinica tHistoriaClinica;

    public CConsulta() {
    }

    public CConsulta(CConsultaPK cConsultaPK) {
        this.cConsultaPK = cConsultaPK;
    }

    public CConsulta(CConsultaPK cConsultaPK, String historiaClinica, String codtipo, String docPaciente, String numHistoriaClinica, String medico, Date fecha, Date hora, int canSesiones, String tipoConsulta, String motivoConsulta, String historiaEnfermedad, String antecedentes) {
        this.cConsultaPK = cConsultaPK;
        this.historiaClinica = historiaClinica;
        this.codtipo = codtipo;
        this.docPaciente = docPaciente;
        this.numHistoriaClinica = numHistoriaClinica;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;
        this.canSesiones = canSesiones;
        this.tipoConsulta = tipoConsulta;
        this.motivoConsulta = motivoConsulta;
        this.historiaEnfermedad = historiaEnfermedad;
        this.antecedentes = antecedentes;
    }

    public CConsulta(String codConsulta, String tHistoriaClinicaPacienteDocPaciente) {
        this.cConsultaPK = new CConsultaPK(codConsulta, tHistoriaClinicaPacienteDocPaciente);
    }

    public CConsultaPK getCConsultaPK() {
        return cConsultaPK;
    }

    public void setCConsultaPK(CConsultaPK cConsultaPK) {
        this.cConsultaPK = cConsultaPK;
    }

    public String getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(String historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public String getCodtipo() {
        return codtipo;
    }

    public void setCodtipo(String codtipo) {
        this.codtipo = codtipo;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public int getCanSesiones() {
        return canSesiones;
    }

    public void setCanSesiones(int canSesiones) {
        this.canSesiones = canSesiones;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getHistoriaEnfermedad() {
        return historiaEnfermedad;
    }

    public void setHistoriaEnfermedad(String historiaEnfermedad) {
        this.historiaEnfermedad = historiaEnfermedad;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
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
        hash += (cConsultaPK != null ? cConsultaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CConsulta)) {
            return false;
        }
        CConsulta other = (CConsulta) object;
        if ((this.cConsultaPK == null && other.cConsultaPK != null) || (this.cConsultaPK != null && !this.cConsultaPK.equals(other.cConsultaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "consultorio.VO.CConsulta[ cConsultaPK=" + cConsultaPK + " ]";
    }
    
}
