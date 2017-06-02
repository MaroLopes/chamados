/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.BEAN;

import br.com.chamados.DAO.RelatChamadoFotosDAO;
import br.com.chamados.VO.RelatChamadoFotos;
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
@ManagedBean (name="relatChamadoFotosBEAN")
@RequestScoped
public class RelatChamadoFotosBEAN {
    
    private RelatChamadoFotos foto = new RelatChamadoFotos();  
    private List<RelatChamadoFotos> fotos;
    private List<RelatChamadoFotos> selectedFotos;

    /**
     * Creates a new instance of RelatChamadoFotosBEAN
     */
    public RelatChamadoFotosBEAN() {
    }

    public RelatChamadoFotos getFoto() {
        return foto;
    }

    public void setFoto(RelatChamadoFotos foto) {
        this.foto = foto;
    }

    public List<RelatChamadoFotos> getFotos() {
        
        RelatChamadoFotosDAO dao = new RelatChamadoFotosDAO();
                
        try {
            
            List<RelatChamadoFotos> lista = dao.GetALL();
            fotos = lista;
        } catch (Exception e) {
            
        }
        
        return fotos;
    }

    public void setFotos(List<RelatChamadoFotos> fotos) {
        this.fotos = fotos;
    }

    public List<RelatChamadoFotos> getSelectedFotos() {
        return selectedFotos;
    }

    public void setSelectedFotos(List<RelatChamadoFotos> selectedFotos) {
        this.selectedFotos = selectedFotos;
    }
    
    public void addFoto(){
        
        try {
            
            RelatChamadoFotosDAO dao = new RelatChamadoFotosDAO();
            dao.salvar(foto);
            RequestContext.getCurrentInstance().closeDialog(this);
//            sendMail(chamado);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro:", "Agendamento Cadastrada com sucesso!"));
        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", e.toString()));
        } 
        
    }
    
    public void deleteFoto(){
        
        try {
            if (selectedFotos.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletar:", "Selecione uma ou mais Fotos para deleta-las!"));
            }else{
                for (RelatChamadoFotos f : selectedFotos) {
                    RelatChamadoFotosDAO dao = new RelatChamadoFotosDAO();
                    dao.delete(f);
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados:", "Fotos selecionados deletadas com sucesso!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados Error!", e.getMessage()));
        }
        
    }
    
    public void updateFoto(){
        
        try {
            
            RelatChamadoFotosDAO dao = new RelatChamadoFotosDAO();
            dao.update(foto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização:", "Foto atualizada com sucesso!"));
            
        } catch (Exception e) {
            
        }
        
    }
    
    public void novoFoto() {
        
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 800);
        options.put("height", 550);
        options.put("closable", true);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        foto = new RelatChamadoFotos();
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
        
        if (selectedFotos.size() == 1) {
            foto = selectedFotos.get(0);
            RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Selecionar:", "Selecione uma foto a ser Editada!"));
        }
        
    }
    
    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(this);
    }
    
}
