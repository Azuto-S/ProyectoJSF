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
@Table(name = "categoriapago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoriapago.findAll", query = "SELECT c FROM Categoriapago c")
    , @NamedQuery(name = "Categoriapago.findByIdcatpago", query = "SELECT c FROM Categoriapago c WHERE c.idcatpago = :idcatpago")
    , @NamedQuery(name = "Categoriapago.findByNomcatpago", query = "SELECT c FROM Categoriapago c WHERE c.nomcatpago = :nomcatpago")})
public class Categoriapago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcatpago")
    private Integer idcatpago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nomcatpago")
    private String nomcatpago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCatpagopedi")
    private Collection<Pedido> pedidoCollection;

    public Categoriapago() {
    }

    public Categoriapago(Integer idcatpago) {
        this.idcatpago = idcatpago;
    }

    public Categoriapago(Integer idcatpago, String nomcatpago) {
        this.idcatpago = idcatpago;
        this.nomcatpago = nomcatpago;
    }

    public Integer getIdcatpago() {
        return idcatpago;
    }

    public void setIdcatpago(Integer idcatpago) {
        this.idcatpago = idcatpago;
    }

    public String getNomcatpago() {
        return nomcatpago;
    }

    public void setNomcatpago(String nomcatpago) {
        this.nomcatpago = nomcatpago;
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
        hash += (idcatpago != null ? idcatpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoriapago)) {
            return false;
        }
        Categoriapago other = (Categoriapago) object;
        if ((this.idcatpago == null && other.idcatpago != null) || (this.idcatpago != null && !this.idcatpago.equals(other.idcatpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Categoriapago[ idcatpago=" + idcatpago + " ]";
    }
    
}
