/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.BEAN;

import br.com.chamados.DAO.DocumentosChamadoDAO;
import br.com.chamados.VO.DocumentosChamado;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author mlopes
 */
@ManagedBean (name="testeBEAN")
@SessionScoped
public class TesteBean {

    /**
     * Creates a new instance of TesteBean
     */
    public TesteBean() {
       
    }
    
   private StreamedContent file;
   private DocumentosChamado documento1;

    public DocumentosChamado getDocumento1() {
        return documento1;
    }

    public void setDocumento1(DocumentosChamado documento1) {
        this.documento1 = documento1;
    }
   
    public StreamedContent getFile() {
        return file;
    }
    
    public void teste() {
         DocumentosChamadoDAO dao = new DocumentosChamadoDAO();
            documento1 = dao.getByDocumento(56);
            InputStream stream1 = new ByteArrayInputStream(documento1.getDocumentosChamadoDoc());
//        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("./resources/images/excel.png");
        file = new DefaultStreamedContent(stream1, "", documento1.getDocumentosChamadosDesc());
    }
}
