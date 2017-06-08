/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.VO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mlopes
 */
@Entity
@Table(name = "documentos_chamado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentosChamado.findAll", query = "SELECT d FROM DocumentosChamado d"),
    @NamedQuery(name = "DocumentosChamado.findByDocumentosChamadosId", query = "SELECT d FROM DocumentosChamado d WHERE d.documentosChamadosId = :documentosChamadosId"),
    @NamedQuery(name = "DocumentosChamado.findByDocumentosChamadosDesc", query = "SELECT d FROM DocumentosChamado d WHERE d.documentosChamadosDesc = :documentosChamadosDesc"),
    @NamedQuery(name = "DocumentosChamado.findByDocumentosChamadoUsuarioCria", query = "SELECT d FROM DocumentosChamado d WHERE d.documentosChamadoUsuarioCria = :documentosChamadoUsuarioCria"),
    @NamedQuery(name = "DocumentosChamado.findByDocumentosChamadoDataCriacao", query = "SELECT d FROM DocumentosChamado d WHERE d.documentosChamadoDataCriacao = :documentosChamadoDataCriacao")})
public class DocumentosChamado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "documentos_chamados_id")
    private Integer documentosChamadosId;
    @Size(max = 100)
    @Column(name = "documentos_chamados_desc")
    private String documentosChamadosDesc;
    @Lob
    @Column(name = "documentos_chamado_doc")
    private byte[] documentosChamadoDoc;
    @Size(max = 100)
    @Column(name = "documentos_chamado_usuario_cria")
    private String documentosChamadoUsuarioCria;
    @Column(name = "documentos_chamado_data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date documentosChamadoDataCriacao;
    @JoinColumn(name = "chamado_chamado_id", referencedColumnName = "chamado_id")
    @ManyToOne
    private Chamado chamadoChamadoId;

    public DocumentosChamado() {
    }

    public DocumentosChamado(Integer documentosChamadosId) {
        this.documentosChamadosId = documentosChamadosId;
    }

    public Integer getDocumentosChamadosId() {
        return documentosChamadosId;
    }

    public void setDocumentosChamadosId(Integer documentosChamadosId) {
        this.documentosChamadosId = documentosChamadosId;
    }

    public String getDocumentosChamadosDesc() {
        return documentosChamadosDesc;
    }

    public void setDocumentosChamadosDesc(String documentosChamadosDesc) {
        this.documentosChamadosDesc = documentosChamadosDesc;
    }

    public byte[] getDocumentosChamadoDoc() {
        return documentosChamadoDoc;
    }

    public void setDocumentosChamadoDoc(byte[] documentosChamadoDoc) {
        this.documentosChamadoDoc = documentosChamadoDoc;
    }

    public String getDocumentosChamadoUsuarioCria() {
        return documentosChamadoUsuarioCria;
    }

    public void setDocumentosChamadoUsuarioCria(String documentosChamadoUsuarioCria) {
        this.documentosChamadoUsuarioCria = documentosChamadoUsuarioCria;
    }

    public Date getDocumentosChamadoDataCriacao() {
        return documentosChamadoDataCriacao;
    }

    public void setDocumentosChamadoDataCriacao(Date documentosChamadoDataCriacao) {
        this.documentosChamadoDataCriacao = documentosChamadoDataCriacao;
    }

    public Chamado getChamadoChamadoId() {
        return chamadoChamadoId;
    }

    public void setChamadoChamadoId(Chamado chamadoChamadoId) {
        this.chamadoChamadoId = chamadoChamadoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentosChamadosId != null ? documentosChamadosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentosChamado)) {
            return false;
        }
        DocumentosChamado other = (DocumentosChamado) object;
        if ((this.documentosChamadosId == null && other.documentosChamadosId != null) || (this.documentosChamadosId != null && !this.documentosChamadosId.equals(other.documentosChamadosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chamados.VO.DocumentosChamado[ documentosChamadosId=" + documentosChamadosId + " ]";
    }
    
}
