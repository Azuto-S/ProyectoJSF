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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jose2
 */
@Entity
@Table(name = "detallepedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallepedido.findAll", query = "SELECT d FROM Detallepedido d")
    , @NamedQuery(name = "Detallepedido.findByIddetallepe", query = "SELECT d FROM Detallepedido d WHERE d.iddetallepe = :iddetallepe")
    , @NamedQuery(name = "Detallepedido.findByCantidaddetellepe", query = "SELECT d FROM Detallepedido d WHERE d.cantidaddetellepe = :cantidaddetellepe")
    , @NamedQuery(name = "Detallepedido.findByTotaldetallepe", query = "SELECT d FROM Detallepedido d WHERE d.totaldetallepe = :totaldetallepe")})
public class Detallepedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetallepe")
    private Integer iddetallepe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidaddetellepe")
    private int cantidaddetellepe;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "totaldetallepe")
    private BigDecimal totaldetallepe;
    @JoinColumn(name = "idproductodetallepe", referencedColumnName = "idpro")
    @ManyToOne(optional = false)
    private Producto idproductodetallepe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDetallespedi")
    private Collection<Pedido> pedidoCollection;

    public Detallepedido() {
    }

    public Detallepedido(Integer iddetallepe) {
        this.iddetallepe = iddetallepe;
    }

    public Detallepedido(Integer iddetallepe, int cantidaddetellepe, BigDecimal totaldetallepe) {
        this.iddetallepe = iddetallepe;
        this.cantidaddetellepe = cantidaddetellepe;
        this.totaldetallepe = totaldetallepe;
    }

    public Integer getIddetallepe() {
        return iddetallepe;
    }

    public void setIddetallepe(Integer iddetallepe) {
        this.iddetallepe = iddetallepe;
    }

    public int getCantidaddetellepe() {
        return cantidaddetellepe;
    }

    public void setCantidaddetellepe(int cantidaddetellepe) {
        this.cantidaddetellepe = cantidaddetellepe;
    }

    public BigDecimal getTotaldetallepe() {
        return totaldetallepe;
    }

    public void setTotaldetallepe(BigDecimal totaldetallepe) {
        this.totaldetallepe = totaldetallepe;
    }

    public Producto getIdproductodetallepe() {
        return idproductodetallepe;
    }

    public void setIdproductodetallepe(Producto idproductodetallepe) {
        this.idproductodetallepe = idproductodetallepe;
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
        hash += (iddetallepe != null ? iddetallepe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallepedido)) {
            return false;
        }
        Detallepedido other = (Detallepedido) object;
        if ((this.iddetallepe == null && other.iddetallepe != null) || (this.iddetallepe != null && !this.iddetallepe.equals(other.iddetallepe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Detallepedido[ iddetallepe=" + iddetallepe + " ]";
    }
    
}
