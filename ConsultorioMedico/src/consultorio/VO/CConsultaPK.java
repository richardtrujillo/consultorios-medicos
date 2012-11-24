/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.VO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author arturo
 */
@Embeddable
public class CConsultaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Cod_Consulta")
    private String codConsulta;
    @Basic(optional = false)
    @Column(name = "THistoriaClinica_Paciente_Doc_Paciente")
    private String tHistoriaClinicaPacienteDocPaciente;

    public CConsultaPK() {
    }

    public CConsultaPK(String codConsulta, String tHistoriaClinicaPacienteDocPaciente) {
        this.codConsulta = codConsulta;
        this.tHistoriaClinicaPacienteDocPaciente = tHistoriaClinicaPacienteDocPaciente;
    }

    public String getCodConsulta() {
        return codConsulta;
    }

    public void setCodConsulta(String codConsulta) {
        this.codConsulta = codConsulta;
    }

    public String getTHistoriaClinicaPacienteDocPaciente() {
        return tHistoriaClinicaPacienteDocPaciente;
    }

    public void setTHistoriaClinicaPacienteDocPaciente(String tHistoriaClinicaPacienteDocPaciente) {
        this.tHistoriaClinicaPacienteDocPaciente = tHistoriaClinicaPacienteDocPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codConsulta != null ? codConsulta.hashCode() : 0);
        hash += (tHistoriaClinicaPacienteDocPaciente != null ? tHistoriaClinicaPacienteDocPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CConsultaPK)) {
            return false;
        }
        CConsultaPK other = (CConsultaPK) object;
        if ((this.codConsulta == null && other.codConsulta != null) || (this.codConsulta != null && !this.codConsulta.equals(other.codConsulta))) {
            return false;
        }
        if ((this.tHistoriaClinicaPacienteDocPaciente == null && other.tHistoriaClinicaPacienteDocPaciente != null) || (this.tHistoriaClinicaPacienteDocPaciente != null && !this.tHistoriaClinicaPacienteDocPaciente.equals(other.tHistoriaClinicaPacienteDocPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "consultorio.VO.CConsultaPK[ codConsulta=" + codConsulta + ", tHistoriaClinicaPacienteDocPaciente=" + tHistoriaClinicaPacienteDocPaciente + " ]";
    }
    
}
