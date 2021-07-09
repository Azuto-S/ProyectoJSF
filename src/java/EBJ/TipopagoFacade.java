/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EBJ;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Tipopago;

/**
 *
 * @author jose2
 */
@Stateless
public class TipopagoFacade extends AbstractFacade<Tipopago> implements TipopagoFacadeLocal {

    @PersistenceContext(unitName = "ProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipopagoFacade() {
        super(Tipopago.class);
    }
    
}
