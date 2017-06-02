/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.BEAN;

import br.com.chamados.DAO.MailsEnvioDAO;
import br.com.chamados.VO.MailsEnvio;
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
@ManagedBean
@RequestScoped
public class MailsEnvioBEAN {
    
    private MailsEnvio mail = new MailsEnvio();  
    private List<MailsEnvio> mails;
    private List<MailsEnvio> selectedMails;

    /**
     * Creates a new instance of MailsEnvioBEAN
     */
    public MailsEnvioBEAN() {
    }

    public MailsEnvio getMail() {
        return mail;
    }

    public void setMail(MailsEnvio mail) {
        this.mail = mail;
    }

    public List<MailsEnvio> getMails() {
        
        MailsEnvioDAO dao = new MailsEnvioDAO();
                
        try {
            
            List<MailsEnvio> lista = dao.GetALL();
            mails = lista;
        } catch (Exception e) {
            
        }
        
        return mails;
    }

    public void setMails(List<MailsEnvio> mails) {
        this.mails = mails;
    }

    public List<MailsEnvio> getSelectedMails() {
        return selectedMails;
    }

    public void setSelectedMails(List<MailsEnvio> selectedMails) {
        this.selectedMails = selectedMails;
    }
    
    public void addMail(){
        
        try {
            
            MailsEnvioDAO dao = new MailsEnvioDAO();
            dao.salvar(mail);
            RequestContext.getCurrentInstance().closeDialog(this);
//            sendMail(chamado);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro:", "Agendamento Cadastrada com sucesso!"));
        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", e.toString()));
        } 
        
    }
    
    public void deleteMail(){
        
        try {
            if (selectedMails.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletar:", "Selecione um ou mais E-mails para deleta-los!"));
            }else{
                for (MailsEnvio m : selectedMails) {
                    MailsEnvioDAO dao = new MailsEnvioDAO();
                    dao.delete(m);
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados:", "E-mails selecionados deletados com sucesso!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados Error!", e.getMessage()));
        }
        
    }
    
    public void updateMail(){
        
        try {
            
            MailsEnvioDAO dao = new MailsEnvioDAO();
            dao.update(mail);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização:", "E-mail atualizado com sucesso!"));
            
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
        mail = new MailsEnvio();
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
        
        if (selectedMails.size() == 1) {
            mail = selectedMails.get(0);
            RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Selecionar:", "Selecione um E-mail a ser Editado!"));
        }
        
    }
    
    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(this);
    }
    
}
