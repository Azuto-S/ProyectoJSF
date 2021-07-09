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
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findByIdcatpro", query = "SELECT c FROM Categoria c WHERE c.idcatpro = :idcatpro")
    , @NamedQuery(name = "Categoria.findByNombreCat", query = "SELECT c FROM Categoria c WHERE c.nombreCat = :nombreCat")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcatpro")
    private Integer idcatpro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_cat")
    private String nombreCat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    private Collection<Subcategoria> subcategoriaCollection;

    public Categoria() {
    }

    public Categoria(Integer idcatpro) {
        this.idcatpro = idcatpro;
    }

    public Categoria(Integer idcatpro, String nombreCat) {
        this.idcatpro = idcatpro;
        this.nombreCat = nombreCat;
    }

    public Integer getIdcatpro() {
        return idcatpro;
    }

    public void setIdcatpro(Integer idcatpro) {
        this.idcatpro = idcatpro;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    @XmlTransient
    public Collection<Subcategoria> getSubcategoriaCollection() {
        return subcategoriaCollection;
    }

    public void setSubcategoriaCollection(Collection<Subcategoria> subcategoriaCollection) {
        this.subcategoriaCollection = subcategoriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcatpro != null ? idcatpro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idcatpro == null && other.idcatpro != null) || (this.idcatpro != null && !this.idcatpro.equals(other.idcatpro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Categoria[ idcatpro=" + idcatpro + " ]";
    }
    
}
