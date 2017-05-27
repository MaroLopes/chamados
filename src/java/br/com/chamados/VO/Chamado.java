/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.VO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mlopes
 */
@Entity
@Table(name = "chamado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chamado.findAll", query = "SELECT c FROM Chamado c"),
    @NamedQuery(name = "Chamado.findByChamadoId", query = "SELECT c FROM Chamado c WHERE c.chamadoId = :chamadoId"),
    @NamedQuery(name = "Chamado.findByChamadoOs", query = "SELECT c FROM Chamado c WHERE c.chamadoOs = :chamadoOs"),
    @NamedQuery(name = "Chamado.findByChamadoOrcamento", query = "SELECT c FROM Chamado c WHERE c.chamadoOrcamento = :chamadoOrcamento"),
    @NamedQuery(name = "Chamado.findByChamadoData", query = "SELECT c FROM Chamado c WHERE c.chamadoData = :chamadoData"),
    @NamedQuery(name = "Chamado.findByChamadoHora", query = "SELECT c FROM Chamado c WHERE c.chamadoHora = :chamadoHora"),
    @NamedQuery(name = "Chamado.findByChamadoProjetoId", query = "SELECT c FROM Chamado c WHERE c.chamadoProjetoId = :chamadoProjetoId"),
    @NamedQuery(name = "Chamado.findByChamadoCidade", query = "SELECT c FROM Chamado c WHERE c.chamadoCidade = :chamadoCidade"),
    @NamedQuery(name = "Chamado.findByChamadoUf", query = "SELECT c FROM Chamado c WHERE c.chamadoUf = :chamadoUf"),
    @NamedQuery(name = "Chamado.findByChamadoClienteFinal", query = "SELECT c FROM Chamado c WHERE c.chamadoClienteFinal = :chamadoClienteFinal"),
    @NamedQuery(name = "Chamado.findByChamadoSolicitante", query = "SELECT c FROM Chamado c WHERE c.chamadoSolicitante = :chamadoSolicitante")})
public class Chamado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "chamado_id")
    private Integer chamadoId;
    @Basic(optional = false)
    @Column(name = "chamado_os")
    private String chamadoOs;
    @Basic(optional = false)
    @Column(name = "chamado_orcamento")
    private String chamadoOrcamento;
    @Basic(optional = false)
    @Column(name = "chamado_data")
    @Temporal(TemporalType.DATE)
    private Date chamadoData;
    @Basic(optional = false)
    @Column(name = "chamado_hora")
    @Temporal(TemporalType.TIME)
    private Date chamadoHora;
    @Basic(optional = false)
    @Column(name = "chamado_projeto_id")
    private String chamadoProjetoId;
    @Basic(optional = false)
    @Column(name = "chamado_cidade")
    private String chamadoCidade;
    @Basic(optional = false)
    @Column(name = "chamado_uf")
    private String chamadoUf;
    @Basic(optional = false)
    @Column(name = "chamado_cliente_final")
    private String chamadoClienteFinal;
    @Basic(optional = false)
    @Column(name = "chamado_solicitante")
    private String chamadoSolicitante;
    @Basic(optional = false)
    @Lob
    @Column(name = "chamado_descricao_atividade")
    private String chamadoDescricaoAtividade;
    @JoinTable(name = "usuario_has_chamado", joinColumns = {
        @JoinColumn(name = "chamado_chamado_id", referencedColumnName = "chamado_id")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_usuario_id", referencedColumnName = "usuario_id")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @JoinColumn(name = "model_relat_model_relat_id", referencedColumnName = "model_relat_id")
    @ManyToOne(optional = false)
    private ModelRelat modelRelatModelRelatId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chamadoChamadoId")
    private Collection<DocumentosChamado> documentosChamadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chamadoChamadoId")
    private Collection<RelatChamado> relatChamadoCollection;

    public Chamado() {
    }

    public Chamado(Integer chamadoId) {
        this.chamadoId = chamadoId;
    }

    public Chamado(Integer chamadoId, String chamadoOs, String chamadoOrcamento, Date chamadoData, Date chamadoHora, String chamadoProjetoId, String chamadoCidade, String chamadoUf, String chamadoClienteFinal, String chamadoSolicitante, String chamadoDescricaoAtividade) {
        this.chamadoId = chamadoId;
        this.chamadoOs = chamadoOs;
        this.chamadoOrcamento = chamadoOrcamento;
        this.chamadoData = chamadoData;
        this.chamadoHora = chamadoHora;
        this.chamadoProjetoId = chamadoProjetoId;
        this.chamadoCidade = chamadoCidade;
        this.chamadoUf = chamadoUf;
        this.chamadoClienteFinal = chamadoClienteFinal;
        this.chamadoSolicitante = chamadoSolicitante;
        this.chamadoDescricaoAtividade = chamadoDescricaoAtividade;
    }

    public Integer getChamadoId() {
        return chamadoId;
    }

    public void setChamadoId(Integer chamadoId) {
        this.chamadoId = chamadoId;
    }

    public String getChamadoOs() {
        return chamadoOs;
    }

    public void setChamadoOs(String chamadoOs) {
        this.chamadoOs = chamadoOs;
    }

    public String getChamadoOrcamento() {
        return chamadoOrcamento;
    }

    public void setChamadoOrcamento(String chamadoOrcamento) {
        this.chamadoOrcamento = chamadoOrcamento;
    }

    public Date getChamadoData() {
        return chamadoData;
    }

    public void setChamadoData(Date chamadoData) {
        this.chamadoData = chamadoData;
    }

    public Date getChamadoHora() {
        return chamadoHora;
    }

    public void setChamadoHora(Date chamadoHora) {
        this.chamadoHora = chamadoHora;
    }

    public String getChamadoProjetoId() {
        return chamadoProjetoId;
    }

    public void setChamadoProjetoId(String chamadoProjetoId) {
        this.chamadoProjetoId = chamadoProjetoId;
    }

    public String getChamadoCidade() {
        return chamadoCidade;
    }

    public void setChamadoCidade(String chamadoCidade) {
        this.chamadoCidade = chamadoCidade;
    }

    public String getChamadoUf() {
        return chamadoUf;
    }

    public void setChamadoUf(String chamadoUf) {
        this.chamadoUf = chamadoUf;
    }

    public String getChamadoClienteFinal() {
        return chamadoClienteFinal;
    }

    public void setChamadoClienteFinal(String chamadoClienteFinal) {
        this.chamadoClienteFinal = chamadoClienteFinal;
    }

    public String getChamadoSolicitante() {
        return chamadoSolicitante;
    }

    public void setChamadoSolicitante(String chamadoSolicitante) {
        this.chamadoSolicitante = chamadoSolicitante;
    }

    public String getChamadoDescricaoAtividade() {
        return chamadoDescricaoAtividade;
    }

    public void setChamadoDescricaoAtividade(String chamadoDescricaoAtividade) {
        this.chamadoDescricaoAtividade = chamadoDescricaoAtividade;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public ModelRelat getModelRelatModelRelatId() {
        return modelRelatModelRelatId;
    }

    public void setModelRelatModelRelatId(ModelRelat modelRelatModelRelatId) {
        this.modelRelatModelRelatId = modelRelatModelRelatId;
    }

    @XmlTransient
    public Collection<DocumentosChamado> getDocumentosChamadoCollection() {
        return documentosChamadoCollection;
    }

    public void setDocumentosChamadoCollection(Collection<DocumentosChamado> documentosChamadoCollection) {
        this.documentosChamadoCollection = documentosChamadoCollection;
    }

    @XmlTransient
    public Collection<RelatChamado> getRelatChamadoCollection() {
        return relatChamadoCollection;
    }

    public void setRelatChamadoCollection(Collection<RelatChamado> relatChamadoCollection) {
        this.relatChamadoCollection = relatChamadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chamadoId != null ? chamadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chamado)) {
            return false;
        }
        Chamado other = (Chamado) object;
        if ((this.chamadoId == null && other.chamadoId != null) || (this.chamadoId != null && !this.chamadoId.equals(other.chamadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chamados.VO.Chamado[ chamadoId=" + chamadoId + " ]";
    }
    
}
