/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.DAO;

import br.com.chamados.VO.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mlopes
 */
public class UsuarioDAO extends dao {
    
     public void salvar(Usuario usuario){
        EntityManager em = getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
        
    }
    
    public Usuario getByUsuario(int idUsuario){
        EntityManager em = getEntityManager();
        
        return em.find(Usuario.class, idUsuario);
        
    }
    
    public void update(Usuario usuario){
        EntityManager em = getEntityManager();
        
        try {
            
            em.getTransaction().begin();
            Usuario u = em.find(Usuario.class, usuario.getUsuarioId());
            
            u.setUsuarioMail(usuario.getUsuarioMail());
            u.setUsuarioMatriculaEnsel(usuario.getUsuarioMatriculaEnsel());
            u.setUsuarioMobile(usuario.getUsuarioMobile());
            u.setUsuarioNickname(usuario.getUsuarioNickname());
            u.setUsuarioNomeCompleto(usuario.getUsuarioNomeCompleto());
            u.setUsuarioStatus(usuario.getUsuarioStatus());
            u.setUsuarioPassword(usuario.getUsuarioPassword());
            
            em.getTransaction().commit();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
    }
    
    public void delete(Usuario usuario){
        EntityManager em = getEntityManager();
        
        try {
            
            em.getTransaction().begin();
            Usuario u = em.find(Usuario.class, usuario.getUsuarioId());
            
            em.remove(u);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
    }
    
    public List<Usuario> GetALL(){
        EntityManager em = getEntityManager();
        List<Usuario> lista = null;
        
        try {
            
            Query q =  em.createQuery("select object (u) from Usuario as u");
            lista = q.getResultList();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.close();
        }
        
        return lista;
    }
    
}
