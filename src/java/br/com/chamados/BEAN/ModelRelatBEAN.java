/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.BEAN;

import br.com.chamados.DAO.ModelRelatDAO;
import br.com.chamados.VO.ModelRelat;
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
@ManagedBean (name="modelRelatBEAN")
@RequestScoped
public class ModelRelatBEAN {

    private ModelRelat modelo = new ModelRelat();  
    private List<ModelRelat> modelos;
    private List<ModelRelat> selectedModelos;
    
    /**
     * Creates a new instance of ModelRelatBEAN
     */
    public ModelRelatBEAN() {
    }

    public ModelRelat getModelo() {
        return modelo;
    }

    public void setModelo(ModelRelat modelo) {
        this.modelo = modelo;
    }

    public List<ModelRelat> getModelos() {
        
        ModelRelatDAO dao = new ModelRelatDAO();
                
        try {
            
            List<ModelRelat> lista = dao.GetALL();
            modelos = lista;
        } catch (Exception e) {
            
        }
        
        return modelos;
    }

    public void setModelos(List<ModelRelat> modelos) {
        this.modelos = modelos;
    }

    public List<ModelRelat> getSelectedModelos() {
        return selectedModelos;
    }

    public void setSelectedModelos(List<ModelRelat> selectedModelos) {
        this.selectedModelos = selectedModelos;
    }
    
    public void addModelo(){
        
        try {
            
            ModelRelatDAO dao = new ModelRelatDAO();
            dao.salvar(modelo);
            RequestContext.getCurrentInstance().closeDialog(this);
//            sendMail(chamado);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro:", "Agendamento Cadastrada com sucesso!"));
        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", e.toString()));
        } 
        
    }
    
    public void deleteModelo(){
        
        try {
            if (selectedModelos.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletar:", "Selecione um ou mais modelos para deleta-los!"));
            }else{
                for (ModelRelat m : selectedModelos) {
                    ModelRelatDAO dao = new ModelRelatDAO();
                    dao.delete(m);
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados:", "Modelos selecionados deletados com sucesso!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados Error!", e.getMessage()));
        }
        
    }
    
    public void updateModelo(){
        
        try {
            
            ModelRelatDAO dao = new ModelRelatDAO();
            dao.update(modelo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização:", "Modelo atualizado com sucesso!"));
            
        } catch (Exception e) {
            
        }
        
    }
    
    public void novoModelo() {
        
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 800);
        options.put("height", 550);
        options.put("closable", true);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        modelo = new ModelRelat();
        RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        
    }
    
    public void editarModelo() {
        
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 550);
        options.put("closable", false);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        
        if (selectedModelos.size() == 1) {
            modelo = selectedModelos.get(0);
            RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Selecionar:", "Selecione um modelo a ser Editado!"));
        }
        
    }
    
    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(this);
    }
    
}
