
package controlador;

import EBJ.PedidoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Categoriapago;
import modelo.Cliente;
import modelo.Detallepedido;
import modelo.Estadopedido;
import modelo.Pedido;
import modelo.Tipopago;

@ManagedBean
@SessionScoped
public class ManagedPedido {
    @EJB
    private PedidoFacadeLocal pedidoFacade;
    private List<Pedido> listaPedido;
    private Pedido pedid;
    private Estadopedido estadoPedido;
    private Tipopago tipoPago;
    private Categoriapago catPago;
    private Cliente cli;
    private Detallepedido detallePedido;

    public List<Pedido> getListaPedido() {
        this.listaPedido = pedidoFacade.findAll();
        return listaPedido;
    }

    public void setListaPedido(List<Pedido> listaPedido) {
        this.listaPedido = listaPedido;
    }

    public Pedido getPedid() {
        return pedid;
    }

    public void setPedid(Pedido pedid) {
        this.pedid = pedid;
    }

    public Estadopedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(Estadopedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Tipopago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(Tipopago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Categoriapago getCatPago() {
        return catPago;
    }

    public void setCatPago(Categoriapago catPago) {
        this.catPago = catPago;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Detallepedido getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(Detallepedido detallePedido) {
        this.detallePedido = detallePedido;
    }
    
    @PostConstruct
    public void init(){
        this.pedid = new Pedido();
        this.estadoPedido = new Estadopedido();
        this.tipoPago = new Tipopago();
        this.catPago = new Categoriapago();
        this.cli = new Cliente();
        this.detallePedido = new Detallepedido();
    }
    
    public void guardar(){
        this.pedid.setIdCatpagopedi(catPago);
        this.pedid.setIdClientepedi(cli);
        this.pedid.setIdDetallespedi(detallePedido);
        this.pedid.setIdEstadopedi(estadoPedido);
        this.pedid.setIdTipopagopedi(tipoPago);
        this.pedidoFacade.create(pedid);
    }
    
    public void eliminar(Pedido p){
        this.pedidoFacade.remove(p);
    }
    
    public void cargarDatos(Pedido p){
        this.catPago.setIdcatpago(p.getIdCatpagopedi().getIdcatpago());
        this.cli.setDnicli(p.getIdClientepedi().getDnicli());
        this.detallePedido.setIddetallepe(p.getIdDetallespedi().getIddetallepe());
        this.estadoPedido.setIdestadope(p.getIdEstadopedi().getIdestadope());
        this.tipoPago.setIdpg(p.getIdTipopagopedi().getIdpg());
        this.pedid =p;
    }
    
    public void modificar(){
        this.pedid.setIdCatpagopedi(catPago);
        this.pedid.setIdClientepedi(cli);
        this.pedid.setIdDetallespedi(detallePedido);
        this.pedid.setIdEstadopedi(estadoPedido);
        this.pedid.setIdTipopagopedi(tipoPago);
        this.pedidoFacade.edit(pedid);
    }
}
