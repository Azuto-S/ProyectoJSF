
package controlador;

import EBJ.TrabajadorFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Tipotrabajador;
import modelo.Trabajador;

@ManagedBean
@SessionScoped
public class ManagedTrabajador {
    @EJB
    private TrabajadorFacadeLocal trabFacade;
    private List<Trabajador> listaTraba;
    private Trabajador traba;
    private Tipotrabajador tipoTra;

    public List<Trabajador> getListaTraba() {
        this.listaTraba = trabFacade.findAll();
        return listaTraba;
    }

    public void setListaTraba(List<Trabajador> listaTraba) {
        this.listaTraba = listaTraba;
    }

    public Trabajador getTraba() {
        return traba;
    }

    public void setTraba(Trabajador traba) {
        this.traba = traba;
    }

    public Tipotrabajador getTipoTra() {
        return tipoTra;
    }

    public void setTipoTra(Tipotrabajador tipoTra) {
        this.tipoTra = tipoTra;
    }
    
    @PostConstruct
    public void init(){
        this.traba = new Trabajador();
        this.tipoTra = new Tipotrabajador();
    }
    
    public void guardar(){
        this.traba.setIdTipotrabajador(tipoTra);
        this.trabFacade.create(traba);
    }
    public void eliminar(Trabajador t){
        this.trabFacade.remove(t);
    }
    
    public void cargarDatos(Trabajador t){
        this.tipoTra.setIdtipotra(t.getIdTipotrabajador().getIdtipotra());
        this.traba = t;
    }
    
    public void modificar(){
        this.traba.setIdTipotrabajador(tipoTra);
        this.trabFacade.edit(traba);
    }
}
