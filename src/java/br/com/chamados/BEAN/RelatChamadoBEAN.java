/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.BEAN;

import br.com.chamados.DAO.ModelRelatItensDAO;
import br.com.chamados.DAO.RelatChamadoDAO;
import br.com.chamados.VO.ModelRelatItens;
import br.com.chamados.VO.RelatChamado;
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
@ManagedBean (name="relatChamadoBEAN")
@RequestScoped
public class RelatChamadoBEAN {
    
    private RelatChamado relatorio = new RelatChamado();  
    private List<RelatChamado> relatorios;
    private List<RelatChamado> selectedRelatorios;

    /**
     * Creates a new instance of RelatChamadoBEAN
     */
    public RelatChamadoBEAN() {
    }

    public RelatChamado getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(RelatChamado relatorio) {
        this.relatorio = relatorio;
    }

    public List<RelatChamado> getRelatorios() {
        
        RelatChamadoDAO dao = new RelatChamadoDAO();
                
        try {
            
            List<RelatChamado> lista = dao.GetALL();
            relatorios = lista;
        } catch (Exception e) {
            
        }
        
        return relatorios;
    }

    public void setRelatorios(List<RelatChamado> relatorios) {
        this.relatorios = relatorios;
    }

    public List<RelatChamado> getSelectedRelatorios() {
        return selectedRelatorios;
    }

    public void setSelectedRelatorios(List<RelatChamado> selectedRelatorios) {
        this.selectedRelatorios = selectedRelatorios;
    }
    
    public void addRelatorio(){
        
        try {
            
            RelatChamadoDAO dao = new RelatChamadoDAO();
            dao.salvar(relatorio);
            RequestContext.getCurrentInstance().closeDialog(this);
//            sendMail(chamado);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro:", "Agendamento Cadastrada com sucesso!"));
        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", e.toString()));
        } 
        
    }
    
    public void deleteRelatorio(){
        
        try {
            if (selectedRelatorios.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletar:", "Selecione um ou mais Relatorios para deleta-los!"));
            }else{
                for (RelatChamado r : selectedRelatorios) {
                    RelatChamadoDAO dao = new RelatChamadoDAO();
                    dao.delete(r);
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados:", "Relatorios selecionados deletados com sucesso!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados Error!", e.getMessage()));
        }
        
    }
    
    public void updateRelatorio(){
        
        try {
            
            RelatChamadoDAO dao = new RelatChamadoDAO();
            dao.update(relatorio);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização:", "Relatório atualizado com sucesso!"));
            
        } catch (Exception e) {
            
        }
        
    }
    
    public void novoRelatorio() {
        
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 800);
        options.put("height", 550);
        options.put("closable", true);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        relatorio = new RelatChamado();
        RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        
    }
    
    public void editarRelatorio() {
        
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 550);
        options.put("closable", false);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        
        if (selectedRelatorios.size() == 1) {
            relatorio = selectedRelatorios.get(0);
            RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Selecionar:", "Selecione um relatório a ser Editado!"));
        }
        
    }
    
    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(this);
    }
    
}
