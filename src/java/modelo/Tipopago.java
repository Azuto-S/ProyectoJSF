/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
@Table(name = "tipopago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopago.findAll", query = "SELECT t FROM Tipopago t")
    , @NamedQuery(name = "Tipopago.findByIdpg", query = "SELECT t FROM Tipopago t WHERE t.idpg = :idpg")
    , @NamedQuery(name = "Tipopago.findByNombrepg", query = "SELECT t FROM Tipopago t WHERE t.nombrepg = :nombrepg")})
public class Tipopago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpg")
    private Integer idpg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombrepg")
    private String nombrepg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipopagopedi")
    private Collection<Pedido> pedidoCollection;

    public Tipopago() {
    }

    public Tipopago(Integer idpg) {
        this.idpg = idpg;
    }

    public Tipopago(Integer idpg, String nombrepg) {
        this.idpg = idpg;
        this.nombrepg = nombrepg;
    }

    public Integer getIdpg() {
        return idpg;
    }

    public void setIdpg(Integer idpg) {
        this.idpg = idpg;
    }

    public String getNombrepg() {
        return nombrepg;
    }

    public void setNombrepg(String nombrepg) {
        this.nombrepg = nombrepg;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpg != null ? idpg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopago)) {
            return false;
        }
        Tipopago other = (Tipopago) object;
        if ((this.idpg == null && other.idpg != null) || (this.idpg != null && !this.idpg.equals(other.idpg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tipopago[ idpg=" + idpg + " ]";
    }
    
}
