/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.BEAN;

import br.com.chamados.DAO.ModelRelatFotosDAO;
import br.com.chamados.VO.ModelRelatFotos;
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
@ManagedBean (name="modelRelatFotosBEAN")
@RequestScoped
public class ModelRelatFotosBEAN {
    
    private ModelRelatFotos modeloFoto = new ModelRelatFotos();  
    private List<ModelRelatFotos> modeloFotos;
    private List<ModelRelatFotos> selectedModeloFotos;

    /**
     * Creates a new instance of ModelRelatFotosBEAN
     */
    public ModelRelatFotosBEAN() {
    }

    public ModelRelatFotos getModeloFoto() {
        return modeloFoto;
    }

    public void setModeloFoto(ModelRelatFotos modeloFoto) {
        this.modeloFoto = modeloFoto;
    }

    public List<ModelRelatFotos> getModeloFotos() {
        
        ModelRelatFotosDAO dao = new ModelRelatFotosDAO();
                
        try {
            
            List<ModelRelatFotos> lista = dao.GetALL();
            modeloFotos = lista;
        } catch (Exception e) {
            
        }
        
        return modeloFotos;
    }

    public void setModeloFotos(List<ModelRelatFotos> modeloFotos) {
        this.modeloFotos = modeloFotos;
    }

    public List<ModelRelatFotos> getSelectedModeloFotos() {
        return selectedModeloFotos;
    }

    public void setSelectedModeloFotos(List<ModelRelatFotos> selectedModeloFotos) {
        this.selectedModeloFotos = selectedModeloFotos;
    }
    
    public void addModeloFoto(){
        
        try {
            
            ModelRelatFotosDAO dao = new ModelRelatFotosDAO();
            dao.salvar(modeloFoto);
            RequestContext.getCurrentInstance().closeDialog(this);
//            sendMail(chamado);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro:", "Agendamento Cadastrada com sucesso!"));
        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", e.toString()));
        } 
        
    }
    
    public void deleteModeloFoto(){
        
        try {
            if (selectedModeloFotos.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletar:", "Selecione uma ou mais Fotos para deleta-las!"));
            }else{
                for (ModelRelatFotos m : selectedModeloFotos) {
                    ModelRelatFotosDAO dao = new ModelRelatFotosDAO();
                    dao.delete(m);
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados:", "Fotos selecionadas deletadas com sucesso!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados Error!", e.getMessage()));
        }
        
    }
    
    public void updateModeloFoto(){
        
        try {
            
            ModelRelatFotosDAO dao = new ModelRelatFotosDAO();
            dao.update(modeloFoto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização:", "Foto atualizada com sucesso!"));
            
        } catch (Exception e) {
            
        }
        
    }
    
    public void novaFoto() {
        
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 800);
        options.put("height", 550);
        options.put("closable", true);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        modeloFoto = new ModelRelatFotos();
        RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        
    }
    
    public void editarFoto() {
        
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 550);
        options.put("closable", false);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        
        if (selectedModeloFotos.size() == 1) {
            modeloFoto = selectedModeloFotos.get(0);
            RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Selecionar:", "Selecione uma foto a ser Editada!"));
        }
        
    }
    
    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(this);
    }
    
}
