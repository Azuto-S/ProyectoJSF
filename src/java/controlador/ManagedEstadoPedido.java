/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EBJ.EstadopedidoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Estadopedido;


@ManagedBean
@SessionScoped
public class ManagedEstadoPedido {
    @EJB
    private EstadopedidoFacadeLocal estadopedidoFacade;
    private List<Estadopedido> listEstadoPedido;
    private Estadopedido estadopedido;

    
    public List<Estadopedido> getListEstadoPedido() {
        this.listEstadoPedido = this.estadopedidoFacade.findAll();
        return listEstadoPedido;
    }

    public void setListEstadoPedido(List<Estadopedido> listEstadoPedido) {
        
        this.listEstadoPedido = listEstadoPedido;
    }

    public Estadopedido getEstadopedido() {
        return estadopedido;
    }

    public void setEstadopedido(Estadopedido estadopedido) {
        this.estadopedido = estadopedido;
    }
    
    @PostConstruct
    public void init(){
        this.estadopedido = new Estadopedido();
    }
    
    public void guardar(){
        this.estadopedidoFacade.create(estadopedido);
    }
    
    public void eliminar(Estadopedido e){
        this.estadopedidoFacade.remove(e);
    }
    
    public void cargarDatos(Estadopedido e){
        this.estadopedido = e;
    }
    
    public void modificar(){
        this.estadopedidoFacade.edit(estadopedido);
    }
}
