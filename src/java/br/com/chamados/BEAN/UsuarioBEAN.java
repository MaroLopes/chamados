/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.BEAN;

import br.com.chamados.DAO.RelatChamadoFotosDAO;
import br.com.chamados.DAO.UsuarioDAO;
import br.com.chamados.VO.RelatChamadoFotos;
import br.com.chamados.VO.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author mlopes
 */
@ManagedBean (name="usuarioBean")
@RequestScoped
public class UsuarioBEAN {
    
    private Usuario usuario = new Usuario();  
    private List<Usuario> usuarios;
    private List<Usuario> selectedUsuarios;

    /**
     * Creates a new instance of UsuarioBEAN
     */
    public UsuarioBEAN() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        
        UsuarioDAO dao = new UsuarioDAO();
                
        try {
            
            List<Usuario> lista = dao.GetALL();
            usuarios = lista;
        } catch (Exception e) {
            
        }
        
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario> getSelectedUsuarios() {
        return selectedUsuarios;
    }

    public void setSelectedUsuarios(List<Usuario> selectedUsuarios) {
        this.selectedUsuarios = selectedUsuarios;
    }
    
    public void addUsuario(){
        
        try {
            
            UsuarioDAO dao = new UsuarioDAO();
            dao.salvar(usuario);
            RequestContext.getCurrentInstance().closeDialog(this);
//            sendMail(chamado);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro:", "Agendamento Cadastrada com sucesso!"));
        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", e.toString()));
        } 
        
    }
    
    public void deleteUsuario(){
        
        try {
            if (selectedUsuarios.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletar:", "Selecione um ou mais Usuarios para deleta-los!"));
            }else{
                for (Usuario u : selectedUsuarios) {
                    UsuarioDAO dao = new UsuarioDAO();
                    dao.delete(u);
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados:", "Usuarios selecionados deletados com sucesso!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados Error!", e.getMessage()));
        }
        
    }
    
    public void updateUsuario(){
        
        try {
            
            UsuarioDAO dao = new UsuarioDAO();
            dao.update(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização:", "Usuario atualizado com sucesso!"));
            
        } catch (Exception e) {
            
        }
        
    }
    
    public void novoUsuario() {
        
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 800);
        options.put("height", 550);
        options.put("closable", true);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        usuario = new Usuario();
        RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        
    }
    
    public void editarUsuario() {
        
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 550);
        options.put("closable", false);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        
        if (selectedUsuarios.size() == 1) {
            usuario = selectedUsuarios.get(0);
            RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Selecionar:", "Selecione um usuario a ser Editado!"));
        }
        
    }
    
    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(this);
    }
    
}
