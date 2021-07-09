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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jose2
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdpro", query = "SELECT p FROM Producto p WHERE p.idpro = :idpro")
    , @NamedQuery(name = "Producto.findByNombrepro", query = "SELECT p FROM Producto p WHERE p.nombrepro = :nombrepro")
    , @NamedQuery(name = "Producto.findByPreciopro", query = "SELECT p FROM Producto p WHERE p.preciopro = :preciopro")
    , @NamedQuery(name = "Producto.findByStockpro", query = "SELECT p FROM Producto p WHERE p.stockpro = :stockpro")
    , @NamedQuery(name = "Producto.findByImagen", query = "SELECT p FROM Producto p WHERE p.imagen = :imagen")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpro")
    private Integer idpro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombrepro")
    private String nombrepro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciopro")
    private BigDecimal preciopro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stockpro")
    private int stockpro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "imagen")
    private String imagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproductodetallepe")
    private Collection<Detallepedido> detallepedidoCollection;
    @JoinColumn(name = "id_subcategoria", referencedColumnName = "id_sub")
    @ManyToOne(optional = false)
    private Subcategoria idSubcategoria;

    public Producto() {
    }

    public Producto(Integer idpro) {
        this.idpro = idpro;
    }

    public Producto(Integer idpro, String nombrepro, BigDecimal preciopro, int stockpro, String imagen) {
        this.idpro = idpro;
        this.nombrepro = nombrepro;
        this.preciopro = preciopro;
        this.stockpro = stockpro;
        this.imagen = imagen;
    }

    public Integer getIdpro() {
        return idpro;
    }

    public void setIdpro(Integer idpro) {
        this.idpro = idpro;
    }

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    public BigDecimal getPreciopro() {
        return preciopro;
    }

    public void setPreciopro(BigDecimal preciopro) {
        this.preciopro = preciopro;
    }

    public int getStockpro() {
        return stockpro;
    }

    public void setStockpro(int stockpro) {
        this.stockpro = stockpro;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @XmlTransient
    public Collection<Detallepedido> getDetallepedidoCollection() {
        return detallepedidoCollection;
    }

    public void setDetallepedidoCollection(Collection<Detallepedido> detallepedidoCollection) {
        this.detallepedidoCollection = detallepedidoCollection;
    }

    public Subcategoria getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(Subcategoria idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpro != null ? idpro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idpro == null && other.idpro != null) || (this.idpro != null && !this.idpro.equals(other.idpro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Producto[ idpro=" + idpro + " ]";
    }
    
}
