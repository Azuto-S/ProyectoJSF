/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose2
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByIdpedido", query = "SELECT p FROM Pedido p WHERE p.idpedido = :idpedido")
    , @NamedQuery(name = "Pedido.findByFechapedi", query = "SELECT p FROM Pedido p WHERE p.fechapedi = :fechapedi")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpedido")
    private Integer idpedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechapedi")
    @Temporal(TemporalType.DATE)
    private Date fechapedi;
    @JoinColumn(name = "id_estadopedi", referencedColumnName = "idestadope")
    @ManyToOne(optional = false)
    private Estadopedido idEstadopedi;
    @JoinColumn(name = "id_catpagopedi", referencedColumnName = "idcatpago")
    @ManyToOne(optional = false)
    private Categoriapago idCatpagopedi;
    @JoinColumn(name = "id_tipopagopedi", referencedColumnName = "idpg")
    @ManyToOne(optional = false)
    private Tipopago idTipopagopedi;
    @JoinColumn(name = "id_clientepedi", referencedColumnName = "dnicli")
    @ManyToOne(optional = false)
    private Cliente idClientepedi;
    @JoinColumn(name = "id_detallespedi", referencedColumnName = "iddetallepe")
    @ManyToOne(optional = false)
    private Detallepedido idDetallespedi;

    public Pedido() {
    }

    public Pedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public Pedido(Integer idpedido, Date fechapedi) {
        this.idpedido = idpedido;
        this.fechapedi = fechapedi;
    }

    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public Date getFechapedi() {
        return fechapedi;
    }

    public void setFechapedi(Date fechapedi) {
        this.fechapedi = fechapedi;
    }

    public Estadopedido getIdEstadopedi() {
        return idEstadopedi;
    }

    public void setIdEstadopedi(Estadopedido idEstadopedi) {
        this.idEstadopedi = idEstadopedi;
    }

    public Categoriapago getIdCatpagopedi() {
        return idCatpagopedi;
    }

    public void setIdCatpagopedi(Categoriapago idCatpagopedi) {
        this.idCatpagopedi = idCatpagopedi;
    }

    public Tipopago getIdTipopagopedi() {
        return idTipopagopedi;
    }

    public void setIdTipopagopedi(Tipopago idTipopagopedi) {
        this.idTipopagopedi = idTipopagopedi;
    }

    public Cliente getIdClientepedi() {
        return idClientepedi;
    }

    public void setIdClientepedi(Cliente idClientepedi) {
        this.idClientepedi = idClientepedi;
    }

    public Detallepedido getIdDetallespedi() {
        return idDetallespedi;
    }

    public void setIdDetallespedi(Detallepedido idDetallespedi) {
        this.idDetallespedi = idDetallespedi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpedido != null ? idpedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idpedido == null && other.idpedido != null) || (this.idpedido != null && !this.idpedido.equals(other.idpedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pedido[ idpedido=" + idpedido + " ]";
    }
    
}
