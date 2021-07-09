
package controlador;

import EBJ.CategoriapagoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Categoriapago;

@ManagedBean
@SessionScoped
public class ManagedCategoriaPago {
    @EJB
    private CategoriapagoFacadeLocal catPagoFacade;
    private List<Categoriapago> listCatPago;
    private Categoriapago catPago;

    public List<Categoriapago> getListCatPago() {
        this.listCatPago = this.catPagoFacade.findAll();
        return listCatPago;
    }

    public void setListCatPago(List<Categoriapago> listCatPago) {
        this.listCatPago = listCatPago;
    }

    public Categoriapago getCatPago() {
        return catPago;
    }

    public void setCatPago(Categoriapago catPago) {
        this.catPago = catPago;
    }
    
    @PostConstruct
    public void init(){
        this.catPago = new Categoriapago();
    }
    
    public void guardar(){
        this.catPagoFacade.create(catPago);
    }
    
    public void eliminar(Categoriapago c){
        this.catPagoFacade.remove(c);
    }
    
    public void cargarDatos(Categoriapago c){
        this.catPago = c;
    }
    
    public void modificar(){
        this.catPagoFacade.edit(catPago);
    }
}
