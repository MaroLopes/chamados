/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.VO;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @Basic(optional = false)
    @Column(name = "usuario_nome_completo")
    private String usuarioNomeCompleto;
    @Column(name = "usuario_mobile")
    private Integer usuarioMobile;
    @Basic(optional = false)
    @Column(name = "usuario_nickname")
    private String usuarioNickname;
    @Basic(optional = false)
    @Column(name = "usuario_mail")
    private String usuarioMail;
    @Basic(optional = false)
    @Column(name = "usuario_password")
    private String usuarioPassword;
    @Basic(optional = false)
    @Column(name = "usuario_status")
    private boolean usuarioStatus;
    @Column(name = "func_func_id")
    private Integer funcFuncId;
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<Acesso> acessoCollection;
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<Chamado> chamadoCollection;

    public Usuario() {
    }

    public Usuario(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario(Integer usuarioId, String usuarioNomeCompleto, String usuarioNickname, String usuarioMail, String usuarioPassword, boolean usuarioStatus) {
        this.usuarioId = usuarioId;
        this.usuarioNomeCompleto = usuarioNomeCompleto;
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

    public Integer getUsuarioMobile() {
        return usuarioMobile;
    }

    public void setUsuarioMobile(Integer usuarioMobile) {
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

    public Integer getFuncFuncId() {
        return funcFuncId;
    }

    public void setFuncFuncId(Integer funcFuncId) {
        this.funcFuncId = funcFuncId;
    }

    @XmlTransient
    public Collection<Acesso> getAcessoCollection() {
        return acessoCollection;
    }

    public void setAcessoCollection(Collection<Acesso> acessoCollection) {
        this.acessoCollection = acessoCollection;
    }

    @XmlTransient
    public Collection<Chamado> getChamadoCollection() {
        return chamadoCollection;
    }

    public void setChamadoCollection(Collection<Chamado> chamadoCollection) {
        this.chamadoCollection = chamadoCollection;
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
