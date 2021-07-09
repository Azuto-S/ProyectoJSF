
package controlador;

import EBJ.ProductoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Producto;
import modelo.Subcategoria;

@ManagedBean
@SessionScoped
public class ManagedProducto {
    @EJB
    private ProductoFacadeLocal proFacade;
    private List<Producto> listaPro;
    private Producto pro;
    private Subcategoria sub;

    public List<Producto> getListaPro() {
        this.listaPro = proFacade.findAll();
        return listaPro;
    }

    public void setListaPro(List<Producto> listaPro) {
        this.listaPro = listaPro;
    }

    public Producto getPro() {
        return pro;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }

    public Subcategoria getSub() {
        return sub;
    }

    public void setSub(Subcategoria sub) {
        this.sub = sub;
    }
    
    @PostConstruct
    public void init(){
        this.pro = new Producto();
        this.sub = new Subcategoria();
    }
    
    public void guardar(){
        this.pro.setIdSubcategoria(sub);
        this.proFacade.create(pro);
    }
    
    public void eliminar(Producto p){
        this.proFacade.remove(p);
    }
    
    public void cargarDatos(Producto p){
        this.sub.setIdSub(p.getIdSubcategoria().getIdSub());
        this.pro = p;
    }
    
    public void modificar(){
        this.pro.setIdSubcategoria(sub);
        this.proFacade.edit(pro);
    }
}
