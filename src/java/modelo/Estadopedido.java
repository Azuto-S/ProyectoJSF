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
@Table(name = "estadopedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadopedido.findAll", query = "SELECT e FROM Estadopedido e")
    , @NamedQuery(name = "Estadopedido.findByIdestadope", query = "SELECT e FROM Estadopedido e WHERE e.idestadope = :idestadope")
    , @NamedQuery(name = "Estadopedido.findByNomestadope", query = "SELECT e FROM Estadopedido e WHERE e.nomestadope = :nomestadope")})
public class Estadopedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestadope")
    private Integer idestadope;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nomestadope")
    private String nomestadope;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadopedi")
    private Collection<Pedido> pedidoCollection;

    public Estadopedido() {
    }

    public Estadopedido(Integer idestadope) {
        this.idestadope = idestadope;
    }

    public Estadopedido(Integer idestadope, String nomestadope) {
        this.idestadope = idestadope;
        this.nomestadope = nomestadope;
    }

    public Integer getIdestadope() {
        return idestadope;
    }

    public void setIdestadope(Integer idestadope) {
        this.idestadope = idestadope;
    }

    public String getNomestadope() {
        return nomestadope;
    }

    public void setNomestadope(String nomestadope) {
        this.nomestadope = nomestadope;
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
        hash += (idestadope != null ? idestadope.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadopedido)) {
            return false;
        }
        Estadopedido other = (Estadopedido) object;
        if ((this.idestadope == null && other.idestadope != null) || (this.idestadope != null && !this.idestadope.equals(other.idestadope))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Estadopedido[ idestadope=" + idestadope + " ]";
    }
    
}
