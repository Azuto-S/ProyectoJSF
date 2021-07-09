
package controlador;


import EBJ.CategoriaFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Categoria;


@ManagedBean
@SessionScoped
public class ManagedCategoriaProducto {
    @EJB
    private CategoriaFacadeLocal catproFacade;
    private List<Categoria> listCatPro;
    private Categoria catPro;

    public List<Categoria> getListCatPro() {
        this.listCatPro = this.catproFacade.findAll();
        return listCatPro;
    }

    public void setListCatPro(List<Categoria> listCatPro) {
        
        this.listCatPro = listCatPro;
    }

    public Categoria getCatPro() {
        return catPro;
    }

    public void setCatPro(Categoria catPro) {
        this.catPro = catPro;
    }
    
    @PostConstruct
    public void init(){
        this.catPro = new Categoria();
    }
    
    public void guardar(){
        this.catproFacade.create(catPro);
    }
    
    public void eliminar(Categoria c){
        this.catproFacade.remove(c);
    }
    
    public void cargarDatos(Categoria c){
        this.catPro = c;
    }
    
    public void modificar(){
        this.catproFacade.edit(catPro);
    }
}
