
package br.com.chamados.BEAN;

import br.com.chamados.DAO.UsuariosDAO;
import br.com.chamados.VO.Usuarios;
import java.util.List;
//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Tarcio
 */
//@Stateless
public class UsuariosBEAN extends UsuariosDAO<Usuarios> {

    @PersistenceContext(unitName = "chamadosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosBEAN() {
        super(Usuarios.class);
    }
    
    public List<Usuarios> getUsuarios() {
        return em.createNamedQuery("Usuarios.findAll").getResultList();
    }
}
