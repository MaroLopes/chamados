/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.DAO;

import br.com.chamados.VO.MailsEnvio;
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
public class MailsEnvioDAO extends dao {
    
    public void salvar(MailsEnvio mailsenvio){
        EntityManager em = getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(mailsenvio);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
        
    }
    
    public MailsEnvio getByChamado(int idMailsEnvio){
        EntityManager em = getEntityManager();
        
        return em.find(MailsEnvio.class, idMailsEnvio);
        
    }
    
    public void update(MailsEnvio mailsEnvio){
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
    
    public void delete(MailsEnvio mailsEnvio){
        EntityManager em = getEntityManager();
        
        try {
            
            em.getTransaction().begin();
            MailsEnvio r = em.find(MailsEnvio.class, mailsEnvio.getMailsId());
            
            em.remove(r);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
    }
    
    public List<MailsEnvio> GetALL(){
        EntityManager em = getEntityManager();
        List<MailsEnvio> lista = null;
        
        try {
            
            Query q =  em.createQuery("select object (m) from MailsEnvio as m");
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
