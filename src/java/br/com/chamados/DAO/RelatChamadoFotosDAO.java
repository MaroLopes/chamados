/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.DAO;

import br.com.chamados.VO.RelatChamado;
import br.com.chamados.VO.RelatChamadoFotos;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mlopes
 */
public class RelatChamadoFotosDAO extends dao {
    
    public void salvar(RelatChamadoFotos relatChamadoFotos){
        EntityManager em = getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(relatChamadoFotos);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
        
    }
    
    public RelatChamadoFotos getByChamado(int idRelatChamadoFotos){
        EntityManager em = getEntityManager();
        
        return em.find(RelatChamadoFotos.class, idRelatChamadoFotos);
        
    }
    
    public void update(RelatChamadoFotos relatchamadoFotos){
        EntityManager em = getEntityManager();
        
        try {
            
//            em.getTransaction().begin();
//            Chamado c = em.find(Chamado.class, chamado.getChamadoId());
//            
//            c.setChamadoCidade(chamado.getChamadoCidade());
//            
//            em.getTransaction().commit();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
    }
    
    public void delete(RelatChamadoFotos relatchamadoFotos){
        EntityManager em = getEntityManager();
        
        try {
            
            em.getTransaction().begin();
            RelatChamadoFotos r = em.find(RelatChamadoFotos.class, relatchamadoFotos.getRelatChamadoFotosId());
            
            em.remove(r);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
    }
    
    public List<RelatChamadoFotos> GetALL(){
        EntityManager em = getEntityManager();
        List<RelatChamadoFotos> lista = null;
        
        try {
            
            Query q =  em.createQuery("select object (r) from RelatChamado as r");
            lista = q.getResultList();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.close();
        }
        
        return lista;
    }
    
//    public List<ModelRelat> GetData(Date data){
//        EntityManager em = getEntityManager();
//        List<ModelRelat> lista = null;
//        
//        try {
//            
//            Query q =  em.createQuery("select object (m) from ModelRelat as m where m.chamadoData = :data").setParameter("data", data);
//            lista = q.getResultList();
//            
//        } catch (Exception e) {
//            em.close();
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
//        }
//        
//        return lista;
//    }
    
}
