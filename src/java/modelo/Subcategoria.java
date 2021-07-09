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
@Table(name = "subcategoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subcategoria.findAll", query = "SELECT s FROM Subcategoria s")
    , @NamedQuery(name = "Subcategoria.findByIdSub", query = "SELECT s FROM Subcategoria s WHERE s.idSub = :idSub")
    , @NamedQuery(name = "Subcategoria.findByNombreSub", query = "SELECT s FROM Subcategoria s WHERE s.nombreSub = :nombreSub")})
public class Subcategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sub")
    private Integer idSub;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_sub")
    private String nombreSub;
    @JoinColumn(name = "id_categoria", referencedColumnName = "idcatpro")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubcategoria")
    private Collection<Producto> productoCollection;

    public Subcategoria() {
    }

    public Subcategoria(Integer idSub) {
        this.idSub = idSub;
    }

    public Subcategoria(Integer idSub, String nombreSub) {
        this.idSub = idSub;
        this.nombreSub = nombreSub;
    }

    public Integer getIdSub() {
        return idSub;
    }

    public void setIdSub(Integer idSub) {
        this.idSub = idSub;
    }

    public String getNombreSub() {
        return nombreSub;
    }

    public void setNombreSub(String nombreSub) {
        this.nombreSub = nombreSub;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSub != null ? idSub.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subcategoria)) {
            return false;
        }
        Subcategoria other = (Subcategoria) object;
        if ((this.idSub == null && other.idSub != null) || (this.idSub != null && !this.idSub.equals(other.idSub))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Subcategoria[ idSub=" + idSub + " ]";
    }
    
}
