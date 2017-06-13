/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.VO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mlopes
 */
@Entity
@Table(name = "mails_envio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MailsEnvio.findAll", query = "SELECT m FROM MailsEnvio m"),
    @NamedQuery(name = "MailsEnvio.findByMailsId", query = "SELECT m FROM MailsEnvio m WHERE m.mailsId = :mailsId"),
    @NamedQuery(name = "MailsEnvio.findByMailsEnvioDesc", query = "SELECT m FROM MailsEnvio m WHERE m.mailsEnvioDesc = :mailsEnvioDesc")})
public class MailsEnvio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mails_id")
    private Integer mailsId;
    @Basic(optional = false)
    @Column(name = "mails_envio_desc")
    private String mailsEnvioDesc;
    @JoinColumn(name = "usuario_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario usuarioUsuarioId;

    public MailsEnvio() {
    }

    public MailsEnvio(Integer mailsId) {
        this.mailsId = mailsId;
    }

    public MailsEnvio(Integer mailsId, String mailsEnvioDesc) {
        this.mailsId = mailsId;
        this.mailsEnvioDesc = mailsEnvioDesc;
    }

    public Integer getMailsId() {
        return mailsId;
    }

    public void setMailsId(Integer mailsId) {
        this.mailsId = mailsId;
    }

    public String getMailsEnvioDesc() {
        return mailsEnvioDesc;
    }

    public void setMailsEnvioDesc(String mailsEnvioDesc) {
        this.mailsEnvioDesc = mailsEnvioDesc;
    }

    public Usuario getUsuarioUsuarioId() {
        return usuarioUsuarioId;
    }

    public void setUsuarioUsuarioId(Usuario usuarioUsuarioId) {
        this.usuarioUsuarioId = usuarioUsuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mailsId != null ? mailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MailsEnvio)) {
            return false;
        }
        MailsEnvio other = (MailsEnvio) object;
        if ((this.mailsId == null && other.mailsId != null) || (this.mailsId != null && !this.mailsId.equals(other.mailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chamados.VO.MailsEnvio[ mailsId=" + mailsId + " ]";
    }
    
}
