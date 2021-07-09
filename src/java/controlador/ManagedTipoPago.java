
package controlador;

import EBJ.TipopagoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Tipopago;


@ManagedBean
@SessionScoped
public class ManagedTipoPago {
    @EJB
    private TipopagoFacadeLocal tipoPagoFacade;
    private List<Tipopago> listTipoPago;
    private Tipopago tipopa;

    public List<Tipopago> getListTipoPago() {
        this.listTipoPago = this.tipoPagoFacade.findAll();
        return listTipoPago;
    }

    public void setListTipoPago(List<Tipopago> listTipoPago) {
        
        this.listTipoPago = listTipoPago;
    }

    public Tipopago getTipopa() {
        return tipopa;
    }

    public void setTipopa(Tipopago tipopa) {
        this.tipopa = tipopa;
    }
    
    @PostConstruct
    public void init(){
        this.tipopa = new Tipopago();
    }
    
    public void guardar(){
        this.tipoPagoFacade.create(tipopa);
    }
    
    public void eliminar(Tipopago t){
        this.tipoPagoFacade.remove(t);
    }
    
    public void cargarDatos(Tipopago t){
        this.tipopa = t;
    }
    
    public void modificar(){
        this.tipoPagoFacade.edit(tipopa);
    }
}
