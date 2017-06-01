/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.DAO;

import br.com.chamados.VO.ModelRelat;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mlopes
 */
public class ModelRelatDAO extends dao {
    
     public void salvar(ModelRelat modelrelat){
        EntityManager em = getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(modelrelat);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
        
    }
    
    public ModelRelat getByChamado(int idModelRelat){
        EntityManager em = getEntityManager();
        
        return em.find(ModelRelat.class, idModelRelat);
        
    }
    
    public void update(ModelRelat modelrelat){
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
    
    public void delete(ModelRelat modelrelat){
        EntityManager em = getEntityManager();
        
        try {
            
            em.getTransaction().begin();
            ModelRelat m = em.find(ModelRelat.class, modelrelat.getModelRelatId());
            
            em.remove(m);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
    }
    
    public List<ModelRelat> GetALL(){
        EntityManager em = getEntityManager();
        List<ModelRelat> lista = null;
        
        try {
            
            Query q =  em.createQuery("select object (M) from ModelRelat as M");
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
