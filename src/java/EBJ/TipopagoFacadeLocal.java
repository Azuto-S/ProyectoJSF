/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EBJ;

import java.util.List;
import javax.ejb.Local;
import modelo.Tipopago;

/**
 *
 * @author jose2
 */
@Local
public interface TipopagoFacadeLocal {

    void create(Tipopago tipopago);

    void edit(Tipopago tipopago);

    void remove(Tipopago tipopago);

    Tipopago find(Object id);

    List<Tipopago> findAll();

    List<Tipopago> findRange(int[] range);

    int count();
    
}
