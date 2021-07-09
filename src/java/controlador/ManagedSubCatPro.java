
package controlador;

import EBJ.SubcategoriaFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Categoria;
import modelo.Subcategoria;

@ManagedBean
@SessionScoped
public class ManagedSubCatPro {
    @EJB
    private SubcategoriaFacadeLocal subCatFacade;
    private List<Subcategoria> listaSubCatPro;
    private Subcategoria subCatPro;
    private Categoria catPro;

    public List<Subcategoria> getListaSubCatPro() {
        this.listaSubCatPro = subCatFacade.findAll();
        return listaSubCatPro;
    }

    public void setListaSubCatPro(List<Subcategoria> listaSubCatPro) {
        this.listaSubCatPro = listaSubCatPro;
    }

    public Subcategoria getSubCatPro() {
        return subCatPro;
    }

    public void setSubCatPro(Subcategoria subCatPro) {
        this.subCatPro = subCatPro;
    }

    public Categoria getCatPro() {
        return catPro;
    }

    public void setCatPro(Categoria catPro) {
        this.catPro = catPro;
    }
    
    @PostConstruct
    public void init(){
        this.subCatPro = new Subcategoria();
        this.catPro = new Categoria();
    }
    
    public void guardar(){
        this.subCatPro.setIdCategoria(catPro);
        this.subCatFacade.create(subCatPro);
    }
    
    public void eliminar(Subcategoria s){
        this.subCatFacade.remove(s);
    }
    
    public void cargarDatos(Subcategoria s){
        this.catPro.setIdcatpro(s.getIdCategoria().getIdcatpro());
        
        this.subCatPro = s;
    }
    
    public void modificar(){
        this.subCatPro.setIdCategoria(catPro);
        this.subCatFacade.edit(subCatPro);
    }
    
}
