/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EBJ;

import java.util.List;
import javax.ejb.Local;
import modelo.Tipotrabajador;

/**
 *
 * @author jose2
 */
@Local
public interface TipotrabajadorFacadeLocal {

    void create(Tipotrabajador tipotrabajador);

    void edit(Tipotrabajador tipotrabajador);

    void remove(Tipotrabajador tipotrabajador);

    Tipotrabajador find(Object id);

    List<Tipotrabajador> findAll();

    List<Tipotrabajador> findRange(int[] range);

    int count();
    
}
