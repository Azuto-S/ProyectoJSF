
package controlador;

import EBJ.DistritoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Distrito;


@ManagedBean
@SessionScoped
public class ManagedDistrito {
    @EJB
    private DistritoFacadeLocal distritoFacade;
    private List<Distrito> ListarDistrito;
    private Distrito distri;

    public List<Distrito> getListarDistrito() {
        this.ListarDistrito = this.distritoFacade.findAll();
        return ListarDistrito;
    }

    public void setListarDistrito(List<Distrito> ListarDistrito) {
        
        this.ListarDistrito = ListarDistrito;
    }

    public Distrito getDistri() {
        return distri;
    }

    public void setDistri(Distrito distri) {
        this.distri = distri;
    }
    
    @PostConstruct
    public void init(){
        this.distri = new Distrito();
    }
    
    
    public void guardar(){
        this.distritoFacade.create(distri);
    }
    
    public void eliminar(Distrito d){
        this.distritoFacade.remove(d);
    }
    
    public void cargarDatos(Distrito d){
        this.distri = d;
    }
    
    public void modificar(){
        this.distritoFacade.edit(distri);
    }
}
