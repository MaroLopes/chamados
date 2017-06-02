/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.BEAN;

import br.com.chamados.DAO.ModelRelatItensDAO;
import br.com.chamados.VO.ModelRelatItens;
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
@ManagedBean (name="modelRelatItensBEAN")
@RequestScoped
public class ModelRelatItensBEAN {
    
    private ModelRelatItens item = new ModelRelatItens();  
    private List<ModelRelatItens> itens;
    private List<ModelRelatItens> selectedItens;

    /**
     * Creates a new instance of ModelRelatItensBEAN
     */
    public ModelRelatItensBEAN() {
    }

    public ModelRelatItens getItem() {
        return item;
    }

    public void setItem(ModelRelatItens item) {
        this.item = item;
    }

    public List<ModelRelatItens> getItens() {
        
        ModelRelatItensDAO dao = new ModelRelatItensDAO();
                
        try {
            
            List<ModelRelatItens> lista = dao.GetALL();
            itens = lista;
        } catch (Exception e) {
            
        }
        
        return itens;
    }

    public void setItens(List<ModelRelatItens> itens) {
        this.itens = itens;
    }

    public List<ModelRelatItens> getSelectedItens() {
        return selectedItens;
    }

    public void setSelectedItens(List<ModelRelatItens> selectedItens) {
        this.selectedItens = selectedItens;
    }
    
    public void addItem(){
        
        try {
            
            ModelRelatItensDAO dao = new ModelRelatItensDAO();
            dao.salvar(item);
            RequestContext.getCurrentInstance().closeDialog(this);
//            sendMail(chamado);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro:", "Agendamento Cadastrada com sucesso!"));
        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", e.toString()));
        } 
        
    }
    
    public void deleteItem(){
        
        try {
            if (selectedItens.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletar:", "Selecione uma ou mais Itens para deleta-los!"));
            }else{
                for (ModelRelatItens i : selectedItens) {
                    ModelRelatItensDAO dao = new ModelRelatItensDAO();
                    dao.delete(i);
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados:", "Itens selecionados deletadas com sucesso!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados Error!", e.getMessage()));
        }
        
    }
    
    public void updateItem(){
        
        try {
            
            ModelRelatItensDAO dao = new ModelRelatItensDAO();
            dao.update(item);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização:", "Item atualizado com sucesso!"));
            
        } catch (Exception e) {
            
        }
        
    }
    
    public void novoItem() {
        
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 800);
        options.put("height", 550);
        options.put("closable", true);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        item = new ModelRelatItens();
        RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        
    }
    
    public void editarItem() {
        
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 550);
        options.put("closable", false);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        
        if (selectedItens.size() == 1) {
            item = selectedItens.get(0);
            RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Selecionar:", "Selecione um Item a ser Editado!"));
        }
        
    }
    
    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(this);
    }
    
    
}
