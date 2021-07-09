/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EBJ;

import java.util.List;
import javax.ejb.Local;
import modelo.Categoriapago;

/**
 *
 * @author jose2
 */
@Local
public interface CategoriapagoFacadeLocal {

    void create(Categoriapago categoriapago);

    void edit(Categoriapago categoriapago);

    void remove(Categoriapago categoriapago);

    Categoriapago find(Object id);

    List<Categoriapago> findAll();

    List<Categoriapago> findRange(int[] range);

    int count();
    
}
