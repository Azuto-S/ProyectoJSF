/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EBJ;

import java.util.List;
import javax.ejb.Local;
import modelo.Detallepedido;

/**
 *
 * @author jose2
 */
@Local
public interface DetallepedidoFacadeLocal {

    void create(Detallepedido detallepedido);

    void edit(Detallepedido detallepedido);

    void remove(Detallepedido detallepedido);

    Detallepedido find(Object id);

    List<Detallepedido> findAll();

    List<Detallepedido> findRange(int[] range);

    int count();
    
}
