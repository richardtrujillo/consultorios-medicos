/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.VO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arturo
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CPaciente.findAll", query = "SELECT c FROM CPaciente c"),
    @NamedQuery(name = "CPaciente.findByDocPaciente", query = "SELECT c FROM CPaciente c WHERE c.docPaciente = :docPaciente"),
    @NamedQuery(name = "CPaciente.findByCodmedico", query = "SELECT c FROM CPaciente c WHERE c.codmedico = :codmedico"),
    @NamedQuery(name = "CPaciente.findByPrimerNombre", query = "SELECT c FROM CPaciente c WHERE c.primerNombre = :primerNombre"),
    @NamedQuery(name = "CPaciente.findBySegundoNombre", query = "SELECT c FROM CPaciente c WHERE c.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "CPaciente.findByPrimerApellido", query = "SELECT c FROM CPaciente c WHERE c.primerApellido = :primerApellido"),
    @NamedQuery(name = "CPaciente.findBySegundoApellido", query = "SELECT c FROM CPaciente c WHERE c.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "CPaciente.findByFechaNacimineto", query = "SELECT c FROM CPaciente c WHERE c.fechaNacimineto = :fechaNacimineto"),
    @NamedQuery(name = "CPaciente.findByLugarNacimiento", query = "SELECT c FROM CPaciente c WHERE c.lugarNacimiento = :lugarNacimiento"),
    @NamedQuery(name = "CPaciente.findByLugarResidencia", query = "SELECT c FROM CPaciente c WHERE c.lugarResidencia = :lugarResidencia"),
    @NamedQuery(name = "CPaciente.findByTelefonos", query = "SELECT c FROM CPaciente c WHERE c.telefonos = :telefonos"),
    @NamedQuery(name = "CPaciente.findByDireccionResidencia", query = "SELECT c FROM CPaciente c WHERE c.direccionResidencia = :direccionResidencia"),
    @NamedQuery(name = "CPaciente.findByDireccionTrabajo", query = "SELECT c FROM CPaciente c WHERE c.direccionTrabajo = :direccionTrabajo"),
    @NamedQuery(name = "CPaciente.findByGenero", query = "SELECT c FROM CPaciente c WHERE c.genero = :genero"),
    @NamedQuery(name = "CPaciente.findByEstCivil", query = "SELECT c FROM CPaciente c WHERE c.estCivil = :estCivil"),
    @NamedQuery(name = "CPaciente.findByOcupacion", query = "SELECT c FROM CPaciente c WHERE c.ocupacion = :ocupacion"),
    @NamedQuery(name = "CPaciente.findByEmail", query = "SELECT c FROM CPaciente c WHERE c.email = :email"),
    @NamedQuery(name = "CPaciente.findByRh", query = "SELECT c FROM CPaciente c WHERE c.rh = :rh"),
    @NamedQuery(name = "CPaciente.findByDiscapacidad", query = "SELECT c FROM CPaciente c WHERE c.discapacidad = :discapacidad"),
    @NamedQuery(name = "CPaciente.findByTipoPaciente", query = "SELECT c FROM CPaciente c WHERE c.tipoPaciente = :tipoPaciente")})
public class CPaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Doc_Paciente")
    private String docPaciente;
    @Basic(optional = false)
    @Column(name = "Cod_medico")
    private String codmedico;
    @Basic(optional = false)
    @Column(name = "PrimerNombre")
    private String primerNombre;
    @Column(name = "SegundoNombre")
    private String segundoNombre;
    @Basic(optional = false)
    @Column(name = "PrimerApellido")
    private String primerApellido;
    @Column(name = "SegundoApellido")
    private String segundoApellido;
    @Basic(optional = false)
    @Column(name = "FechaNacimineto")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimineto;
    @Column(name = "LugarNacimiento")
    private String lugarNacimiento;
    @Basic(optional = false)
    @Column(name = "LugarResidencia")
    private String lugarResidencia;
    @Basic(optional = false)
    @Column(name = "Telefonos")
    private String telefonos;
    @Basic(optional = false)
    @Column(name = "DireccionResidencia")
    private String direccionResidencia;
    @Column(name = "DireccionTrabajo")
    private String direccionTrabajo;
    @Basic(optional = false)
    @Column(name = "Genero")
    private String genero;
    @Basic(optional = false)
    @Column(name = "EstCivil")
    private String estCivil;
    @Basic(optional = false)
    @Column(name = "Ocupacion")
    private String ocupacion;
    @Lob
    @Column(name = "PerfilProfesional")
    private String perfilProfesional;
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "RH")
    private String rh;
    @Column(name = "Discapacidad")
    private String discapacidad;
    @Basic(optional = false)
    @Column(name = "TipoPaciente")
    private String tipoPaciente;
    @JoinColumn(name = "MedicoProfesional_Reg_Profesional", referencedColumnName = "Reg_Profesional")
    @ManyToOne(optional = false)
    private CMedicoprofesional medicoProfesionalRegProfesional;
    @JoinColumn(name = "TMedicoEps_Cod_medico", referencedColumnName = "Cod_medico")
    @ManyToOne(optional = false)
    private CMedicoEps tMedicoEpsCodmedico;
    @JoinColumn(name = "Tipo_Paciente_Cod_Tipo", referencedColumnName = "Cod_Tipo")
    @ManyToOne(optional = false)
    private CTipoPaciente tipoPacienteCodTipo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cPaciente")
    private THistoriaClinica tHistoriaClinica;

    public CPaciente() {
    }

    public CPaciente(String docPaciente) {
        this.docPaciente = docPaciente;
    }

    public CPaciente(String docPaciente, String codmedico, String primerNombre, String primerApellido, Date fechaNacimineto, String lugarResidencia, String telefonos, String direccionResidencia, String genero, String estCivil, String ocupacion, String rh, String tipoPaciente) {
        this.docPaciente = docPaciente;
        this.codmedico = codmedico;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.fechaNacimineto = fechaNacimineto;
        this.lugarResidencia = lugarResidencia;
        this.telefonos = telefonos;
        this.direccionResidencia = direccionResidencia;
        this.genero = genero;
        this.estCivil = estCivil;
        this.ocupacion = ocupacion;
        this.rh = rh;
        this.tipoPaciente = tipoPaciente;
    }

    public String getDocPaciente() {
        return docPaciente;
    }

    public void setDocPaciente(String docPaciente) {
        this.docPaciente = docPaciente;
    }

    public String getCodmedico() {
        return codmedico;
    }

    public void setCodmedico(String codmedico) {
        this.codmedico = codmedico;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimineto() {
        return fechaNacimineto;
    }

    public void setFechaNacimineto(Date fechaNacimineto) {
        this.fechaNacimineto = fechaNacimineto;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getLugarResidencia() {
        return lugarResidencia;
    }

    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getDireccionTrabajo() {
        return direccionTrabajo;
    }

    public void setDireccionTrabajo(String direccionTrabajo) {
        this.direccionTrabajo = direccionTrabajo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstCivil() {
        return estCivil;
    }

    public void setEstCivil(String estCivil) {
        this.estCivil = estCivil;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getPerfilProfesional() {
        return perfilProfesional;
    }

    public void setPerfilProfesional(String perfilProfesional) {
        this.perfilProfesional = perfilProfesional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(String tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }

    public CMedicoprofesional getMedicoProfesionalRegProfesional() {
        return medicoProfesionalRegProfesional;
    }

    public void setMedicoProfesionalRegProfesional(CMedicoprofesional medicoProfesionalRegProfesional) {
        this.medicoProfesionalRegProfesional = medicoProfesionalRegProfesional;
    }

    public CMedicoEps getTMedicoEpsCodmedico() {
        return tMedicoEpsCodmedico;
    }

    public void setTMedicoEpsCodmedico(CMedicoEps tMedicoEpsCodmedico) {
        this.tMedicoEpsCodmedico = tMedicoEpsCodmedico;
    }

    public CTipoPaciente getTipoPacienteCodTipo() {
        return tipoPacienteCodTipo;
    }

    public void setTipoPacienteCodTipo(CTipoPaciente tipoPacienteCodTipo) {
        this.tipoPacienteCodTipo = tipoPacienteCodTipo;
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
        hash += (docPaciente != null ? docPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CPaciente)) {
            return false;
        }
        CPaciente other = (CPaciente) object;
        if ((this.docPaciente == null && other.docPaciente != null) || (this.docPaciente != null && !this.docPaciente.equals(other.docPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "consultorio.VO.CPaciente[ docPaciente=" + docPaciente + " ]";
    }
    
}
