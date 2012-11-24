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
@Table(name = "medicoprofesional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CMedicoprofesional.findAll", query = "SELECT c FROM CMedicoprofesional c"),
    @NamedQuery(name = "CMedicoprofesional.findByRegProfesional", query = "SELECT c FROM CMedicoprofesional c WHERE c.regProfesional = :regProfesional"),
    @NamedQuery(name = "CMedicoprofesional.findByDocIdent", query = "SELECT c FROM CMedicoprofesional c WHERE c.docIdent = :docIdent"),
    @NamedQuery(name = "CMedicoprofesional.findByNombres", query = "SELECT c FROM CMedicoprofesional c WHERE c.nombres = :nombres"),
    @NamedQuery(name = "CMedicoprofesional.findByApellidos", query = "SELECT c FROM CMedicoprofesional c WHERE c.apellidos = :apellidos"),
    @NamedQuery(name = "CMedicoprofesional.findByEspecialidad", query = "SELECT c FROM CMedicoprofesional c WHERE c.especialidad = :especialidad"),
    @NamedQuery(name = "CMedicoprofesional.findByDirecion", query = "SELECT c FROM CMedicoprofesional c WHERE c.direcion = :direcion"),
    @NamedQuery(name = "CMedicoprofesional.findByTelefono", query = "SELECT c FROM CMedicoprofesional c WHERE c.telefono = :telefono")})
public class CMedicoprofesional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Reg_Profesional")
    private String regProfesional;
    @Basic(optional = false)
    @Column(name = "DocIdent")
    private String docIdent;
    @Basic(optional = false)
    @Column(name = "Nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "Apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "Especialidad")
    private String especialidad;
    @Column(name = "Direcion")
    private String direcion;
    @Basic(optional = false)
    @Column(name = "Telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoProfesionalRegProfesional")
    private Collection<CPaciente> cPacienteCollection;

    public CMedicoprofesional() {
    }

    public CMedicoprofesional(String regProfesional) {
        this.regProfesional = regProfesional;
    }

    public CMedicoprofesional(String regProfesional, String docIdent, String nombres, String apellidos, String especialidad, String telefono) {
        this.regProfesional = regProfesional;
        this.docIdent = docIdent;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.telefono = telefono;
    }

    public String getRegProfesional() {
        return regProfesional;
    }

    public void setRegProfesional(String regProfesional) {
        this.regProfesional = regProfesional;
    }

    public String getDocIdent() {
        return docIdent;
    }

    public void setDocIdent(String docIdent) {
        this.docIdent = docIdent;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        hash += (regProfesional != null ? regProfesional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CMedicoprofesional)) {
            return false;
        }
        CMedicoprofesional other = (CMedicoprofesional) object;
        if ((this.regProfesional == null && other.regProfesional != null) || (this.regProfesional != null && !this.regProfesional.equals(other.regProfesional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "consultorio.VO.CMedicoprofesional[ regProfesional=" + regProfesional + " ]";
    }
    
}
