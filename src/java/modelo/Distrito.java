/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jose2
 */
@Entity
@Table(name = "distrito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distrito.findAll", query = "SELECT d FROM Distrito d")
    , @NamedQuery(name = "Distrito.findByIdDistrito", query = "SELECT d FROM Distrito d WHERE d.idDistrito = :idDistrito")
    , @NamedQuery(name = "Distrito.findByNomDis", query = "SELECT d FROM Distrito d WHERE d.nomDis = :nomDis")
    , @NamedQuery(name = "Distrito.findByCostoenvio", query = "SELECT d FROM Distrito d WHERE d.costoenvio = :costoenvio")})
public class Distrito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_distrito")
    private Integer idDistrito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_dis")
    private String nomDis;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "costoenvio")
    private BigDecimal costoenvio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDistritocli")
    private Collection<Cliente> clienteCollection;

    public Distrito() {
    }

    public Distrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }

    public Distrito(Integer idDistrito, String nomDis, BigDecimal costoenvio) {
        this.idDistrito = idDistrito;
        this.nomDis = nomDis;
        this.costoenvio = costoenvio;
    }

    public Integer getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNomDis() {
        return nomDis;
    }

    public void setNomDis(String nomDis) {
        this.nomDis = nomDis;
    }

    public BigDecimal getCostoenvio() {
        return costoenvio;
    }

    public void setCostoenvio(BigDecimal costoenvio) {
        this.costoenvio = costoenvio;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDistrito != null ? idDistrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distrito)) {
            return false;
        }
        Distrito other = (Distrito) object;
        if ((this.idDistrito == null && other.idDistrito != null) || (this.idDistrito != null && !this.idDistrito.equals(other.idDistrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Distrito[ idDistrito=" + idDistrito + " ]";
    }
    
}
