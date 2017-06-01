/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.DAO;

import br.com.chamados.VO.DocumentosChamado;
import br.com.chamados.VO.MailsEnvio;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.Document;

/**
 *
 * @author mlopes
 */
public class DocumentosChamadoDAO extends dao {
    
    public void salvar(DocumentosChamado documentosEnvio){
        EntityManager em = getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(documentosEnvio);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
        
    }
    
    public DocumentosChamado getByChamado(int idDocumentosChamado){
        EntityManager em = getEntityManager();
        
        return em.find(DocumentosChamado.class, idDocumentosChamado);
        
    }
    
    public void update(DocumentosChamado documentosChamado){
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
    
    public void delete(DocumentosChamado documentosChamado){
        EntityManager em = getEntityManager();
        
        try {
            
            em.getTransaction().begin();
            DocumentosChamado d = em.find(DocumentosChamado.class, documentosChamado.getDocumentosChamadosId());
            
            em.remove(d);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
    }
    
    public List<DocumentosChamado> GetALL(){
        EntityManager em = getEntityManager();
        List<DocumentosChamado> lista = null;
        
        try {
            
            Query q =  em.createQuery("select object (d) from DocumentosChamado as d");
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
