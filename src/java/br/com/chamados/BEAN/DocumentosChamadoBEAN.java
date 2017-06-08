/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template fileUp, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.BEAN;

import br.com.chamados.DAO.DocumentosChamadoDAO;
import br.com.chamados.VO.DocumentosChamado;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author mlopes
 */
@ManagedBean (name="documentosChamadoBEAN")
@SessionScoped
public class DocumentosChamadoBEAN {
    
    private DocumentosChamado documento = new DocumentosChamado();  
    private List<DocumentosChamado> documentos;
    private List<DocumentosChamado> selectedDocumentos;
    private DocumentosChamado selectedDocumentoChamado;
    private UploadedFile fileUp;
    private StreamedContent fileDown;
    private int tamanho;

    /**
     * Creates a new instance of DocumentosChamadoBEAN
     */
    public DocumentosChamadoBEAN() {
        
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    public DocumentosChamado getSelectedDocumentoChamado() {
        return selectedDocumentoChamado;
    }

    public void setSelectedDocumentoChamado(DocumentosChamado selectedDocumentoChamado) {
        this.selectedDocumentoChamado = selectedDocumentoChamado;
    }
    
    public StreamedContent getFileDown() {
        return fileDown;
    }

    public void setFileDown(StreamedContent fileDown) {
        this.fileDown = fileDown;
    }
    
    public UploadedFile getFileUp() {
        return fileUp;
    }

    public void setFileUp(UploadedFile file) {
        this.fileUp = file;
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
            documento.setDocumentosChamadoDoc(fileUp.getContents());
            documento.setDocumentosChamadosDesc(fileUp.getFileName());
            dao.salvar(documento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro:", "Arquivo " + fileUp.getFileName() + " Cadastrado com sucesso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", e.toString()));
        }
        
    }
    
    public void deleteDocumento(){
        
        try {  
            if(selectedDocumentoChamado != null){
                DocumentosChamadoDAO dao = new DocumentosChamadoDAO();
                dao.delete(selectedDocumentoChamado);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado:", "Arquivo " + selectedDocumentoChamado.getDocumentosChamadosDesc() + " deletado com sucesso!"));
            } else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nulo:", "Arquivo nulo verificar com o administrador do sistema!"));
            }   
          
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados Error!", e.getMessage()));
        }
        
    }
    
    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(this);
    }
    
    public void downloadDocumento(int idDocumento){
        
        try {
            DocumentosChamadoDAO dao = new DocumentosChamadoDAO();
            documento = dao.getByDocumento(idDocumento);
            tamanho = documento.getDocumentosChamadoDoc().length;
            InputStream stream = new ByteArrayInputStream(documento.getDocumentosChamadoDoc());
            fileDown = new DefaultStreamedContent(stream, "", documento.getDocumentosChamadosDesc());
            if(fileDown != null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Donwload:", "Download realizado! " + documento.getDocumentosChamadosDesc()));            
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro:", "Arquivo não localizado!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro:", "Download falhou!" + e.getMessage()));
        }
        
    }
    
}
