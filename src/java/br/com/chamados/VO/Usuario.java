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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mlopes
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuarioId", query = "SELECT u FROM Usuario u WHERE u.usuarioId = :usuarioId"),
    @NamedQuery(name = "Usuario.findByUsuarioMatriculaEnsel", query = "SELECT u FROM Usuario u WHERE u.usuarioMatriculaEnsel = :usuarioMatriculaEnsel"),
    @NamedQuery(name = "Usuario.findByUsuarioNomeCompleto", query = "SELECT u FROM Usuario u WHERE u.usuarioNomeCompleto = :usuarioNomeCompleto"),
    @NamedQuery(name = "Usuario.findByUsuarioMobile", query = "SELECT u FROM Usuario u WHERE u.usuarioMobile = :usuarioMobile"),
    @NamedQuery(name = "Usuario.findByUsuarioNickname", query = "SELECT u FROM Usuario u WHERE u.usuarioNickname = :usuarioNickname"),
    @NamedQuery(name = "Usuario.findByUsuarioMail", query = "SELECT u FROM Usuario u WHERE u.usuarioMail = :usuarioMail"),
    @NamedQuery(name = "Usuario.findByUsuarioPassword", query = "SELECT u FROM Usuario u WHERE u.usuarioPassword = :usuarioPassword"),
    @NamedQuery(name = "Usuario.findByUsuarioStatus", query = "SELECT u FROM Usuario u WHERE u.usuarioStatus = :usuarioStatus"),
    @NamedQuery(name = "Usuario.findByUsuarioDataCriacao", query = "SELECT u FROM Usuario u WHERE u.usuarioDataCriacao = :usuarioDataCriacao"),
    @NamedQuery(name = "Usuario.findByUsuarioCriacao", query = "SELECT u FROM Usuario u WHERE u.usuarioCriacao = :usuarioCriacao"),
    @NamedQuery(name = "Usuario.findByUsuarioDataUpdate", query = "SELECT u FROM Usuario u WHERE u.usuarioDataUpdate = :usuarioDataUpdate"),
    @NamedQuery(name = "Usuario.findByUsuarioUpdate", query = "SELECT u FROM Usuario u WHERE u.usuarioUpdate = :usuarioUpdate"),
    @NamedQuery(name = "Usuario.findByFuncFuncId", query = "SELECT u FROM Usuario u WHERE u.funcFuncId = :funcFuncId")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_id")
    private Integer usuarioId;
    @Column(name = "usuario_matricula_ensel")
    private Integer usuarioMatriculaEnsel;
    @Size(max = 200)
    @Column(name = "usuario_nome_completo")
    private String usuarioNomeCompleto;
    @Size(max = 11)
    @Column(name = "usuario_mobile")
    private String usuarioMobile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuario_nickname")
    private String usuarioNickname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuario_mail")
    private String usuarioMail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "usuario_password")
    private String usuarioPassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_status")
    private boolean usuarioStatus;
    @Column(name = "usuario_data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuarioDataCriacao;
    @Size(max = 100)
    @Column(name = "usuario_criacao")
    private String usuarioCriacao;
    @Column(name = "usuario_data_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuarioDataUpdate;
    @Size(max = 100)
    @Column(name = "usuario_update")
    private String usuarioUpdate;
    @Column(name = "func_func_id")
    private Integer funcFuncId;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Acesso> acessoList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Chamado> chamadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioUsuarioId")
    private List<MailsEnvio> mailsEnvioList;

    public Usuario() {
    }

    public Usuario(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario(Integer usuarioId, String usuarioNickname, String usuarioMail, String usuarioPassword, boolean usuarioStatus) {
        this.usuarioId = usuarioId;
        this.usuarioNickname = usuarioNickname;
        this.usuarioMail = usuarioMail;
        this.usuarioPassword = usuarioPassword;
        this.usuarioStatus = usuarioStatus;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getUsuarioMatriculaEnsel() {
        return usuarioMatriculaEnsel;
    }

    public void setUsuarioMatriculaEnsel(Integer usuarioMatriculaEnsel) {
        this.usuarioMatriculaEnsel = usuarioMatriculaEnsel;
    }

    public String getUsuarioNomeCompleto() {
        return usuarioNomeCompleto;
    }

    public void setUsuarioNomeCompleto(String usuarioNomeCompleto) {
        this.usuarioNomeCompleto = usuarioNomeCompleto;
    }

    public String getUsuarioMobile() {
        return usuarioMobile;
    }

    public void setUsuarioMobile(String usuarioMobile) {
        this.usuarioMobile = usuarioMobile;
    }

    public String getUsuarioNickname() {
        return usuarioNickname;
    }

    public void setUsuarioNickname(String usuarioNickname) {
        this.usuarioNickname = usuarioNickname;
    }

    public String getUsuarioMail() {
        return usuarioMail;
    }

    public void setUsuarioMail(String usuarioMail) {
        this.usuarioMail = usuarioMail;
    }

    public String getUsuarioPassword() {
        return usuarioPassword;
    }

    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }

    public boolean getUsuarioStatus() {
        return usuarioStatus;
    }

    public void setUsuarioStatus(boolean usuarioStatus) {
        this.usuarioStatus = usuarioStatus;
    }

    public Date getUsuarioDataCriacao() {
        return usuarioDataCriacao;
    }

    public void setUsuarioDataCriacao(Date usuarioDataCriacao) {
        this.usuarioDataCriacao = usuarioDataCriacao;
    }

    public String getUsuarioCriacao() {
        return usuarioCriacao;
    }

    public void setUsuarioCriacao(String usuarioCriacao) {
        this.usuarioCriacao = usuarioCriacao;
    }

    public Date getUsuarioDataUpdate() {
        return usuarioDataUpdate;
    }

    public void setUsuarioDataUpdate(Date usuarioDataUpdate) {
        this.usuarioDataUpdate = usuarioDataUpdate;
    }

    public String getUsuarioUpdate() {
        return usuarioUpdate;
    }

    public void setUsuarioUpdate(String usuarioUpdate) {
        this.usuarioUpdate = usuarioUpdate;
    }

    public Integer getFuncFuncId() {
        return funcFuncId;
    }

    public void setFuncFuncId(Integer funcFuncId) {
        this.funcFuncId = funcFuncId;
    }

    @XmlTransient
    public List<Acesso> getAcessoList() {
        return acessoList;
    }

    public void setAcessoList(List<Acesso> acessoList) {
        this.acessoList = acessoList;
    }

    @XmlTransient
    public List<Chamado> getChamadoList() {
        return chamadoList;
    }

    public void setChamadoList(List<Chamado> chamadoList) {
        this.chamadoList = chamadoList;
    }

    @XmlTransient
    public List<MailsEnvio> getMailsEnvioList() {
        return mailsEnvioList;
    }

    public void setMailsEnvioList(List<MailsEnvio> mailsEnvioList) {
        this.mailsEnvioList = mailsEnvioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chamados.VO.Usuario[ usuarioId=" + usuarioId + " ]";
    }
    
}
