/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.VO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "Chamado.findByChamadoSolicitante", query = "SELECT c FROM Chamado c WHERE c.chamadoSolicitante = :chamadoSolicitante"),
    @NamedQuery(name = "Chamado.findByChamadoUsuarioCriacao", query = "SELECT c FROM Chamado c WHERE c.chamadoUsuarioCriacao = :chamadoUsuarioCriacao"),
    @NamedQuery(name = "Chamado.findByChamadoDataCriacao", query = "SELECT c FROM Chamado c WHERE c.chamadoDataCriacao = :chamadoDataCriacao"),
    @NamedQuery(name = "Chamado.findByChamadoUsuarioUpdate", query = "SELECT c FROM Chamado c WHERE c.chamadoUsuarioUpdate = :chamadoUsuarioUpdate"),
    @NamedQuery(name = "Chamado.findByChamadoUsuarioDataUpdate", query = "SELECT c FROM Chamado c WHERE c.chamadoUsuarioDataUpdate = :chamadoUsuarioDataUpdate"),
    @NamedQuery(name = "Chamado.findByChamadoStatusChamado", query = "SELECT c FROM Chamado c WHERE c.chamadoStatusChamado = :chamadoStatusChamado"),
    @NamedQuery(name = "Chamado.findByChamadoStatusAtividade", query = "SELECT c FROM Chamado c WHERE c.chamadoStatusAtividade = :chamadoStatusAtividade"),
    @NamedQuery(name = "Chamado.findByChamadoOperadora", query = "SELECT c FROM Chamado c WHERE c.chamadoOperadora = :chamadoOperadora"),
    @NamedQuery(name = "Chamado.findByChamadoDeletado", query = "SELECT c FROM Chamado c WHERE c.chamadoDeletado = :chamadoDeletado")})
public class Chamado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "chamado_id")
    private Integer chamadoId;
    @Size(max = 45)
    @Column(name = "chamado_os")
    private String chamadoOs;
    @Size(max = 45)
    @Column(name = "chamado_orcamento")
    private String chamadoOrcamento;
    @Column(name = "chamado_data")
    @Temporal(TemporalType.DATE)
    private Date chamadoData;
    @Column(name = "chamado_hora")
    @Temporal(TemporalType.TIME)
    private Date chamadoHora;
    @Size(max = 100)
    @Column(name = "chamado_projeto_id")
    private String chamadoProjetoId;
    @Size(max = 100)
    @Column(name = "chamado_cidade")
    private String chamadoCidade;
    @Size(max = 2)
    @Column(name = "chamado_uf")
    private String chamadoUf;
    @Size(max = 100)
    @Column(name = "chamado_cliente_final")
    private String chamadoClienteFinal;
    @Size(max = 100)
    @Column(name = "chamado_solicitante")
    private String chamadoSolicitante;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "chamado_descricao_atividade")
    private String chamadoDescricaoAtividade;
    @Size(max = 100)
    @Column(name = "chamado_usuario_criacao")
    private String chamadoUsuarioCriacao;
    @Column(name = "chamado_data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chamadoDataCriacao;
    @Size(max = 100)
    @Column(name = "chamado_usuario_update")
    private String chamadoUsuarioUpdate;
    @Column(name = "chamado_usuario_data_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chamadoUsuarioDataUpdate;
    @Column(name = "chamado_status_chamado")
    private Boolean chamadoStatusChamado;
    @Column(name = "chamado_status_atividade")
    private Boolean chamadoStatusAtividade;
    @Size(max = 100)
    @Column(name = "chamado_operadora")
    private String chamadoOperadora;
    @Column(name = "chamado_deletado")
    private Boolean chamadoDeletado;
    @JoinTable(name = "usuario_has_chamado", joinColumns = {
        @JoinColumn(name = "chamado_chamado_id", referencedColumnName = "chamado_id")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_usuario_id", referencedColumnName = "usuario_id")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @JoinColumn(name = "model_relat_model_relat_id", referencedColumnName = "model_relat_id")
    @ManyToOne
    private ModelRelat modelRelatModelRelatId;
    @OneToMany(mappedBy = "chamadoChamadoId")
    private List<DocumentosChamado> documentosChamadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chamadoChamadoId")
    private List<RelatChamado> relatChamadoList;

    public Chamado() {
    }

    public Chamado(Integer chamadoId) {
        this.chamadoId = chamadoId;
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

    public String getChamadoUsuarioCriacao() {
        return chamadoUsuarioCriacao;
    }

    public void setChamadoUsuarioCriacao(String chamadoUsuarioCriacao) {
        this.chamadoUsuarioCriacao = chamadoUsuarioCriacao;
    }

    public Date getChamadoDataCriacao() {
        return chamadoDataCriacao;
    }

    public void setChamadoDataCriacao(Date chamadoDataCriacao) {
        this.chamadoDataCriacao = chamadoDataCriacao;
    }

    public String getChamadoUsuarioUpdate() {
        return chamadoUsuarioUpdate;
    }

    public void setChamadoUsuarioUpdate(String chamadoUsuarioUpdate) {
        this.chamadoUsuarioUpdate = chamadoUsuarioUpdate;
    }

    public Date getChamadoUsuarioDataUpdate() {
        return chamadoUsuarioDataUpdate;
    }

    public void setChamadoUsuarioDataUpdate(Date chamadoUsuarioDataUpdate) {
        this.chamadoUsuarioDataUpdate = chamadoUsuarioDataUpdate;
    }

    public Boolean getChamadoStatusChamado() {
        return chamadoStatusChamado;
    }

    public void setChamadoStatusChamado(Boolean chamadoStatusChamado) {
        this.chamadoStatusChamado = chamadoStatusChamado;
    }

    public Boolean getChamadoStatusAtividade() {
        return chamadoStatusAtividade;
    }

    public void setChamadoStatusAtividade(Boolean chamadoStatusAtividade) {
        this.chamadoStatusAtividade = chamadoStatusAtividade;
    }

    public String getChamadoOperadora() {
        return chamadoOperadora;
    }

    public void setChamadoOperadora(String chamadoOperadora) {
        this.chamadoOperadora = chamadoOperadora;
    }

    public Boolean getChamadoDeletado() {
        return chamadoDeletado;
    }

    public void setChamadoDeletado(Boolean chamadoDeletado) {
        this.chamadoDeletado = chamadoDeletado;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public ModelRelat getModelRelatModelRelatId() {
        return modelRelatModelRelatId;
    }

    public void setModelRelatModelRelatId(ModelRelat modelRelatModelRelatId) {
        this.modelRelatModelRelatId = modelRelatModelRelatId;
    }

    @XmlTransient
    public List<DocumentosChamado> getDocumentosChamadoList() {
        return documentosChamadoList;
    }

    public void setDocumentosChamadoList(List<DocumentosChamado> documentosChamadoList) {
        this.documentosChamadoList = documentosChamadoList;
    }

    @XmlTransient
    public List<RelatChamado> getRelatChamadoList() {
        return relatChamadoList;
    }

    public void setRelatChamadoList(List<RelatChamado> relatChamadoList) {
        this.relatChamadoList = relatChamadoList;
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
