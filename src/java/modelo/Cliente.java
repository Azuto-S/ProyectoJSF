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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByDnicli", query = "SELECT c FROM Cliente c WHERE c.dnicli = :dnicli")
    , @NamedQuery(name = "Cliente.findByNombrecli", query = "SELECT c FROM Cliente c WHERE c.nombrecli = :nombrecli")
    , @NamedQuery(name = "Cliente.findByApePaternocli", query = "SELECT c FROM Cliente c WHERE c.apePaternocli = :apePaternocli")
    , @NamedQuery(name = "Cliente.findByApeMaternocli", query = "SELECT c FROM Cliente c WHERE c.apeMaternocli = :apeMaternocli")
    , @NamedQuery(name = "Cliente.findBySexocli", query = "SELECT c FROM Cliente c WHERE c.sexocli = :sexocli")
    , @NamedQuery(name = "Cliente.findByTelefonocli", query = "SELECT c FROM Cliente c WHERE c.telefonocli = :telefonocli")
    , @NamedQuery(name = "Cliente.findByCorreocli", query = "SELECT c FROM Cliente c WHERE c.correocli = :correocli")
    , @NamedQuery(name = "Cliente.findByContrasenacli", query = "SELECT c FROM Cliente c WHERE c.contrasenacli = :contrasenacli")
    , @NamedQuery(name = "Cliente.findByDireccioncli", query = "SELECT c FROM Cliente c WHERE c.direccioncli = :direccioncli")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dnicli")
    private Integer dnicli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombrecli")
    private String nombrecli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ape_paternocli")
    private String apePaternocli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ape_maternocli")
    private String apeMaternocli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sexocli")
    private String sexocli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "telefonocli")
    private String telefonocli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correocli")
    private String correocli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contrasenacli")
    private String contrasenacli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccioncli")
    private String direccioncli;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "referenciacli")
    private String referenciacli;
    @JoinColumn(name = "id_distritocli", referencedColumnName = "id_distrito")
    @ManyToOne(optional = false)
    private Distrito idDistritocli;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClientepedi")
    private Collection<Pedido> pedidoCollection;

    public Cliente() {
    }

    public Cliente(Integer dnicli) {
        this.dnicli = dnicli;
    }

    public Cliente(Integer dnicli, String nombrecli, String apePaternocli, String apeMaternocli, String sexocli, String telefonocli, String correocli, String contrasenacli, String direccioncli, String referenciacli) {
        this.dnicli = dnicli;
        this.nombrecli = nombrecli;
        this.apePaternocli = apePaternocli;
        this.apeMaternocli = apeMaternocli;
        this.sexocli = sexocli;
        this.telefonocli = telefonocli;
        this.correocli = correocli;
        this.contrasenacli = contrasenacli;
        this.direccioncli = direccioncli;
        this.referenciacli = referenciacli;
    }

    public Integer getDnicli() {
        return dnicli;
    }

    public void setDnicli(Integer dnicli) {
        this.dnicli = dnicli;
    }

    public String getNombrecli() {
        return nombrecli;
    }

    public void setNombrecli(String nombrecli) {
        this.nombrecli = nombrecli;
    }

    public String getApePaternocli() {
        return apePaternocli;
    }

    public void setApePaternocli(String apePaternocli) {
        this.apePaternocli = apePaternocli;
    }

    public String getApeMaternocli() {
        return apeMaternocli;
    }

    public void setApeMaternocli(String apeMaternocli) {
        this.apeMaternocli = apeMaternocli;
    }

    public String getSexocli() {
        return sexocli;
    }

    public void setSexocli(String sexocli) {
        this.sexocli = sexocli;
    }

    public String getTelefonocli() {
        return telefonocli;
    }

    public void setTelefonocli(String telefonocli) {
        this.telefonocli = telefonocli;
    }

    public String getCorreocli() {
        return correocli;
    }

    public void setCorreocli(String correocli) {
        this.correocli = correocli;
    }

    public String getContrasenacli() {
        return contrasenacli;
    }

    public void setContrasenacli(String contrasenacli) {
        this.contrasenacli = contrasenacli;
    }

    public String getDireccioncli() {
        return direccioncli;
    }

    public void setDireccioncli(String direccioncli) {
        this.direccioncli = direccioncli;
    }

    public String getReferenciacli() {
        return referenciacli;
    }

    public void setReferenciacli(String referenciacli) {
        this.referenciacli = referenciacli;
    }

    public Distrito getIdDistritocli() {
        return idDistritocli;
    }

    public void setIdDistritocli(Distrito idDistritocli) {
        this.idDistritocli = idDistritocli;
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
        hash += (dnicli != null ? dnicli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.dnicli == null && other.dnicli != null) || (this.dnicli != null && !this.dnicli.equals(other.dnicli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cliente[ dnicli=" + dnicli + " ]";
    }
    
}
