/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EBJ;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Tipotrabajador;

/**
 *
 * @author jose2
 */
@Stateless
public class TipotrabajadorFacade extends AbstractFacade<Tipotrabajador> implements TipotrabajadorFacadeLocal {

    @PersistenceContext(unitName = "ProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipotrabajadorFacade() {
        super(Tipotrabajador.class);
    }
    
}
