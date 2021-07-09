/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose2
 */
@Entity
@Table(name = "trabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t")
    , @NamedQuery(name = "Trabajador.findByIdtra", query = "SELECT t FROM Trabajador t WHERE t.idtra = :idtra")
    , @NamedQuery(name = "Trabajador.findByNombretra", query = "SELECT t FROM Trabajador t WHERE t.nombretra = :nombretra")
    , @NamedQuery(name = "Trabajador.findByApePaternotra", query = "SELECT t FROM Trabajador t WHERE t.apePaternotra = :apePaternotra")
    , @NamedQuery(name = "Trabajador.findByApeMaternotra", query = "SELECT t FROM Trabajador t WHERE t.apeMaternotra = :apeMaternotra")
    , @NamedQuery(name = "Trabajador.findBySexotra", query = "SELECT t FROM Trabajador t WHERE t.sexotra = :sexotra")
    , @NamedQuery(name = "Trabajador.findByTelefonotra", query = "SELECT t FROM Trabajador t WHERE t.telefonotra = :telefonotra")
    , @NamedQuery(name = "Trabajador.findByCorreotra", query = "SELECT t FROM Trabajador t WHERE t.correotra = :correotra")
    , @NamedQuery(name = "Trabajador.findByContrasenatra", query = "SELECT t FROM Trabajador t WHERE t.contrasenatra = :contrasenatra")
    , @NamedQuery(name = "Trabajador.findByDirecciontra", query = "SELECT t FROM Trabajador t WHERE t.direcciontra = :direcciontra")})
public class Trabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtra")
    private Integer idtra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombretra")
    private String nombretra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ape_paternotra")
    private String apePaternotra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ape_maternotra")
    private String apeMaternotra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sexotra")
    private String sexotra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "telefonotra")
    private String telefonotra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correotra")
    private String correotra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contrasenatra")
    private String contrasenatra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direcciontra")
    private String direcciontra;
    @JoinColumn(name = "id_tipotrabajador", referencedColumnName = "idtipotra")
    @ManyToOne(optional = false)
    private Tipotrabajador idTipotrabajador;

    public Trabajador() {
    }

    public Trabajador(Integer idtra) {
        this.idtra = idtra;
    }

    public Trabajador(Integer idtra, String nombretra, String apePaternotra, String apeMaternotra, String sexotra, String telefonotra, String correotra, String contrasenatra, String direcciontra) {
        this.idtra = idtra;
        this.nombretra = nombretra;
        this.apePaternotra = apePaternotra;
        this.apeMaternotra = apeMaternotra;
        this.sexotra = sexotra;
        this.telefonotra = telefonotra;
        this.correotra = correotra;
        this.contrasenatra = contrasenatra;
        this.direcciontra = direcciontra;
    }

    public Integer getIdtra() {
        return idtra;
    }

    public void setIdtra(Integer idtra) {
        this.idtra = idtra;
    }

    public String getNombretra() {
        return nombretra;
    }

    public void setNombretra(String nombretra) {
        this.nombretra = nombretra;
    }

    public String getApePaternotra() {
        return apePaternotra;
    }

    public void setApePaternotra(String apePaternotra) {
        this.apePaternotra = apePaternotra;
    }

    public String getApeMaternotra() {
        return apeMaternotra;
    }

    public void setApeMaternotra(String apeMaternotra) {
        this.apeMaternotra = apeMaternotra;
    }

    public String getSexotra() {
        return sexotra;
    }

    public void setSexotra(String sexotra) {
        this.sexotra = sexotra;
    }

    public String getTelefonotra() {
        return telefonotra;
    }

    public void setTelefonotra(String telefonotra) {
        this.telefonotra = telefonotra;
    }

    public String getCorreotra() {
        return correotra;
    }

    public void setCorreotra(String correotra) {
        this.correotra = correotra;
    }

    public String getContrasenatra() {
        return contrasenatra;
    }

    public void setContrasenatra(String contrasenatra) {
        this.contrasenatra = contrasenatra;
    }

    public String getDirecciontra() {
        return direcciontra;
    }

    public void setDirecciontra(String direcciontra) {
        this.direcciontra = direcciontra;
    }

    public Tipotrabajador getIdTipotrabajador() {
        return idTipotrabajador;
    }

    public void setIdTipotrabajador(Tipotrabajador idTipotrabajador) {
        this.idTipotrabajador = idTipotrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtra != null ? idtra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.idtra == null && other.idtra != null) || (this.idtra != null && !this.idtra.equals(other.idtra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Trabajador[ idtra=" + idtra + " ]";
    }
    
}
