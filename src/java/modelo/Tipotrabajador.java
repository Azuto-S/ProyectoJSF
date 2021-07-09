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
@Table(name = "tipotrabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipotrabajador.findAll", query = "SELECT t FROM Tipotrabajador t")
    , @NamedQuery(name = "Tipotrabajador.findByIdtipotra", query = "SELECT t FROM Tipotrabajador t WHERE t.idtipotra = :idtipotra")
    , @NamedQuery(name = "Tipotrabajador.findByNomtipotra", query = "SELECT t FROM Tipotrabajador t WHERE t.nomtipotra = :nomtipotra")})
public class Tipotrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipotra")
    private Integer idtipotra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nomtipotra")
    private String nomtipotra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipotrabajador")
    private Collection<Trabajador> trabajadorCollection;

    public Tipotrabajador() {
    }

    public Tipotrabajador(Integer idtipotra) {
        this.idtipotra = idtipotra;
    }

    public Tipotrabajador(Integer idtipotra, String nomtipotra) {
        this.idtipotra = idtipotra;
        this.nomtipotra = nomtipotra;
    }

    public Integer getIdtipotra() {
        return idtipotra;
    }

    public void setIdtipotra(Integer idtipotra) {
        this.idtipotra = idtipotra;
    }

    public String getNomtipotra() {
        return nomtipotra;
    }

    public void setNomtipotra(String nomtipotra) {
        this.nomtipotra = nomtipotra;
    }

    @XmlTransient
    public Collection<Trabajador> getTrabajadorCollection() {
        return trabajadorCollection;
    }

    public void setTrabajadorCollection(Collection<Trabajador> trabajadorCollection) {
        this.trabajadorCollection = trabajadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipotra != null ? idtipotra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipotrabajador)) {
            return false;
        }
        Tipotrabajador other = (Tipotrabajador) object;
        if ((this.idtipotra == null && other.idtipotra != null) || (this.idtipotra != null && !this.idtipotra.equals(other.idtipotra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tipotrabajador[ idtipotra=" + idtipotra + " ]";
    }
    
}
