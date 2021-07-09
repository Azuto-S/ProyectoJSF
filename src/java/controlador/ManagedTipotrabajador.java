
package controlador;

import EBJ.TipotrabajadorFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Tipotrabajador;

@ManagedBean
@SessionScoped
public class ManagedTipotrabajador {
    @EJB
    private TipotrabajadorFacadeLocal tipoFacade;
    private List<Tipotrabajador> lisTipo;
    private Tipotrabajador tipo;

    public List<Tipotrabajador> getLisTipo() {
        this.lisTipo = tipoFacade.findAll();
        return lisTipo;
    }

    public void setLisTipo(List<Tipotrabajador> lisTipo) {
        this.lisTipo = lisTipo;
    }

    public Tipotrabajador getTipo() {
        return tipo;
    }

    public void setTipo(Tipotrabajador tipo) {
        this.tipo = tipo;
    }
    
    @PostConstruct
    public void init(){
        this.tipo = new Tipotrabajador();
    }
    
    public void guardar(){
        this.tipoFacade.create(tipo);
    }
    
    public void eliminar(Tipotrabajador t){
        this.tipoFacade.remove(t);
    }
    
    public void cargarDatos(Tipotrabajador t){
        this.tipo = t;
    }
    
    public void modificar(){
        this.tipoFacade.edit(tipo);
    }
}
