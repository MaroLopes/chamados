/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.BEAN;

import br.com.chamados.DAO.AcessoDAO;
import br.com.chamados.VO.Acesso;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author mlopes
 */
@ManagedBean (name="acessoBean")
@SessionScoped
public class AcessoBEAN implements java.io.Serializable {
    
    private String local = "dashboard.xhtml";
    private String cabecalho = "Home";
    private Acesso acesso = new Acesso();  
    private List<Acesso> acessos;
    private List<Acesso> selectedAcessos;

    /**
     * Creates a new instance of AcessoBEAN
     */
    public AcessoBEAN() {
        local = "dashboard.xhtml";
        cabecalho = "Home";
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(String cabecalho) {
        this.cabecalho = cabecalho;
    }
    
    public void chamaTela(String loc, String cab){
        
        setLocal(loc);
        setCabecalho(cab);
    }

    public Acesso getAcesso() {
        return acesso;
    }

    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }

    public List<Acesso> getAcessos() {
        
        AcessoDAO dao = new AcessoDAO();
                
        try {
            
            List<Acesso> lista = dao.GetALL();
            acessos = lista;
        } catch (Exception e) {
            
        }
        
        return acessos;
    }

    public void setAcessos(List<Acesso> acessos) {
        this.acessos = acessos;
    }

    public List<Acesso> getSelectedAcessos() {
        return selectedAcessos;
    }

    public void setSelectedAcessos(List<Acesso> selectedAcessos) {
        this.selectedAcessos = selectedAcessos;
    }
    
    public void addAcesso(){
        
        try {
            
            AcessoDAO dao = new AcessoDAO();
            dao.salvar(acesso);
            RequestContext.getCurrentInstance().closeDialog(this);
//            sendMail(chamado);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro:", "Agendamento Cadastrada com sucesso!"));
        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", e.toString()));
        } 
        
    }
    
    public void deleteAcesso(){
        
        try {
            if (selectedAcessos.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletar:", "Selecione um ou mais acessos para deleta-los!"));
            }else{
                for (Acesso a : selectedAcessos) {
                    AcessoDAO dao = new AcessoDAO();
                    dao.delete(a);
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados:", "Acessos selecionados deletados com sucesso!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados Error!", e.getMessage()));
        }
        
    }
    
    public void updateAcesso(){
        
        try {
            
            AcessoDAO dao = new AcessoDAO();
            dao.update(acesso);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização:", "Acesso atualizado com sucesso!"));
            
        } catch (Exception e) {
            
        }
        
    }
    
    public void novoAcesso() {
        
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 800);
        options.put("height", 550);
        options.put("closable", true);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        acesso = new Acesso();
        RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        
    }
    
    public void editarAcesso() {
        
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 550);
        options.put("closable", false);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        
        if (selectedAcessos.size() == 1) {
            acesso = selectedAcessos.get(0);
            RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Selecionar:", "Selecione um acesso a ser Editado!"));
        }
        
    }
    
    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(this);
    }
    
}
