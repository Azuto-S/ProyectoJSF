
package controlador;

import EBJ.DetallepedidoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Detallepedido;
import modelo.Producto;

@ManagedBean
@SessionScoped
public class ManagedDetallePedido {
    @EJB
    private DetallepedidoFacadeLocal detalleFacade;
    private List<Detallepedido> listDetalle;
    private Detallepedido detalle;
    private Producto prod;

    public List<Detallepedido> getListDetalle() {
        this.listDetalle = detalleFacade.findAll();
        return listDetalle;
    }

    public void setListDetalle(List<Detallepedido> listDetalle) {
        this.listDetalle = listDetalle;
    }

    public Detallepedido getDetalle() {
        return detalle;
    }

    public void setDetalle(Detallepedido detalle) {
        this.detalle = detalle;
    }

    public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }
    
    @PostConstruct
    public void init(){
        this.detalle = new Detallepedido();
        this.prod = new Producto();
    }
    
    public void guardar(){
        this.detalle.setIdproductodetallepe(prod);
        this.detalleFacade.create(detalle);
    }
    
    public void eliminar(Detallepedido d){
        this.detalleFacade.remove(d);
    }
    
    public void cargarDatos(Detallepedido d){
        this.prod.setIdpro(d.getIdproductodetallepe().getIdpro());
        this.detalle = d;
    }
    
    public void modificar(){
        this.detalle.setIdproductodetallepe(prod);
        this.detalleFacade.edit(detalle);
    }
}
