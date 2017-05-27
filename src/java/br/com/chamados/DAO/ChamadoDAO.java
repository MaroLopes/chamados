/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.DAO;


import br.com.chamados.VO.Chamado;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mlopes
 */
public class ChamadoDAO extends dao{
    
     public void salvar(Chamado chamado){
        EntityManager em = getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(chamado);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
        
    }
    
    public Chamado getByChamado(int idChamado){
        EntityManager em = getEntityManager();
        
        return em.find(Chamado.class, idChamado);
        
    }
    
    public void update(Chamado chamado){
        EntityManager em = getEntityManager();
        
        try {
            
            em.getTransaction().begin();
            Chamado c = em.find(Chamado.class, chamado.getChamadoId());
            
            c.setChamadoCidade(chamado.getChamadoCidade());
            
            em.getTransaction().commit();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
    }
    
    public void delete(Chamado chamado){
        EntityManager em = getEntityManager();
        
        try {
            
            em.getTransaction().begin();
            Chamado c = em.find(Chamado.class, chamado.getChamadoId());
            
            em.remove(c);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
    }
    
    public List<Chamado> GetALL(){
        EntityManager em = getEntityManager();
        List<Chamado> lista = null;
        
        try {
            
            Query q =  em.createQuery("select object (u) from Chamado as u");
            lista = q.getResultList();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.close();
        }
        
        return lista;
    }
    
}
