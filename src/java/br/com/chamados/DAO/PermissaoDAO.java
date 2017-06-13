/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.DAO;

import br.com.chamados.BEAN.PermissaoBEAN;
import br.com.chamados.VO.Permissao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tarcio
 */
@Stateless
public class PermissaoDAO extends PermissaoBEAN<Permissao> {

    @PersistenceContext(unitName = "chamadosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PermissaoDAO() {
        super(Permissao.class);
    }
    
}
