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
public class CValoracionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Cod_Valoracion")
    private String codValoracion;
    @Basic(optional = false)
    @Column(name = "THistoriaClinica_Paciente_Doc_Paciente")
    private String tHistoriaClinicaPacienteDocPaciente;

    public CValoracionPK() {
    }

    public CValoracionPK(String codValoracion, String tHistoriaClinicaPacienteDocPaciente) {
        this.codValoracion = codValoracion;
        this.tHistoriaClinicaPacienteDocPaciente = tHistoriaClinicaPacienteDocPaciente;
    }

    public String getCodValoracion() {
        return codValoracion;
    }

    public void setCodValoracion(String codValoracion) {
        this.codValoracion = codValoracion;
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
        hash += (codValoracion != null ? codValoracion.hashCode() : 0);
        hash += (tHistoriaClinicaPacienteDocPaciente != null ? tHistoriaClinicaPacienteDocPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CValoracionPK)) {
            return false;
        }
        CValoracionPK other = (CValoracionPK) object;
        if ((this.codValoracion == null && other.codValoracion != null) || (this.codValoracion != null && !this.codValoracion.equals(other.codValoracion))) {
            return false;
        }
        if ((this.tHistoriaClinicaPacienteDocPaciente == null && other.tHistoriaClinicaPacienteDocPaciente != null) || (this.tHistoriaClinicaPacienteDocPaciente != null && !this.tHistoriaClinicaPacienteDocPaciente.equals(other.tHistoriaClinicaPacienteDocPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "consultorio.VO.CValoracionPK[ codValoracion=" + codValoracion + ", tHistoriaClinicaPacienteDocPaciente=" + tHistoriaClinicaPacienteDocPaciente + " ]";
    }
    
}
