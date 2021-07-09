
package controlador;

import EBJ.ClienteFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Cliente;
import modelo.Distrito;

@ManagedBean
@SessionScoped
public class ManagedCliente {
    @EJB
    private ClienteFacadeLocal clienteFacade;
    private List<Cliente> listaCliente;
    private Cliente cli;
    private Distrito dis;

    public List<Cliente> getListaCliente() {
        this.listaCliente = clienteFacade.findAll();
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Distrito getDis() {
        return dis;
    }

    public void setDis(Distrito dis) {
        this.dis = dis;
    }
    
    @PostConstruct
    public void init(){
        this.cli = new Cliente();
        this.dis = new Distrito();
    }
    
    public void guardar(){
        this.cli.setIdDistritocli(dis);
        this.clienteFacade.create(cli);
    }
    
    public void eliminar(Cliente c){
        this.clienteFacade.remove(c);
    }
    
    public void cargarDatos(Cliente c){
        this.dis.setIdDistrito(c.getIdDistritocli().getIdDistrito());
        this.cli = c;
    }
    
    public void modificar(){
        this.cli.setIdDistritocli(dis);
        this.clienteFacade.edit(cli);
    }
}
