/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.BEAN;

import br.com.chamados.DAO.DocumentosChamadoDAO;
import br.com.chamados.VO.DocumentosChamado;
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
@ManagedBean (name="documentosChamadoBEAN")
@RequestScoped
public class DocumentosChamadoBEAN {
    
    private DocumentosChamado documento = new DocumentosChamado();  
    private List<DocumentosChamado> documentos;
    private List<DocumentosChamado> selectedDocumentos;

    /**
     * Creates a new instance of DocumentosChamadoBEAN
     */
    public DocumentosChamadoBEAN() {
        
    }

    public DocumentosChamado getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentosChamado documento) {
        this.documento = documento;
    }

    public List<DocumentosChamado> getDocumentos() {
        
        DocumentosChamadoDAO dao = new DocumentosChamadoDAO();
                
        try {
            
            List<DocumentosChamado> lista = dao.GetALL();
            documentos = lista;
        } catch (Exception e) {
            
        }
        
        return documentos;
    }

    public void setDocumentos(List<DocumentosChamado> documentos) {
        this.documentos = documentos;
    }

    public List<DocumentosChamado> getSelectedDocumentos() {
        return selectedDocumentos;
    }

    public void setSelectedDocumentos(List<DocumentosChamado> selectedDocumentos) {
        this.selectedDocumentos = selectedDocumentos;
    }
    
    public void addDocumento(){
        
        try {
            
            DocumentosChamadoDAO dao = new DocumentosChamadoDAO();
            dao.salvar(documento);
            RequestContext.getCurrentInstance().closeDialog(this);
//            sendMail(chamado);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro:", "Agendamento Cadastrada com sucesso!"));
        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", e.toString()));
        } 
        
    }
    
    public void deleteDocumento(){
        
        try {
            if (selectedDocumentos.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletar:", "Selecione um ou mais acessos para deleta-los!"));
            }else{
                for (DocumentosChamado d : selectedDocumentos) {
                    DocumentosChamadoDAO dao = new DocumentosChamadoDAO();
                    dao.delete(d);
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados:", "Acessos selecionados deletados com sucesso!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados Error!", e.getMessage()));
        }
        
    }
    
    public void updateDocumento(){
        
        try {
            
            DocumentosChamadoDAO dao = new DocumentosChamadoDAO();
            dao.update(documento);
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
        documento = new DocumentosChamado();
        RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        
    }
    
    public void editarDocumento() {
        
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 550);
        options.put("closable", false);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        
        if (selectedDocumentos.size() == 1) {
            documento = selectedDocumentos.get(0);
            RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Selecionar:", "Selecione um acesso a ser Editado!"));
        }
        
    }
    
    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(this);
    }
    
    
}
