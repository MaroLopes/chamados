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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "acesso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acesso.findAll", query = "SELECT a FROM Acesso a"),
    @NamedQuery(name = "Acesso.findByAcessoId", query = "SELECT a FROM Acesso a WHERE a.acessoId = :acessoId"),
    @NamedQuery(name = "Acesso.findByAcessoNome", query = "SELECT a FROM Acesso a WHERE a.acessoNome = :acessoNome"),
    @NamedQuery(name = "Acesso.findByAcessoArquivo", query = "SELECT a FROM Acesso a WHERE a.acessoArquivo = :acessoArquivo")})
public class Acesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "acesso_id")
    private Integer acessoId;
    @Column(name = "acesso_nome")
    private String acessoNome;
    @Column(name = "acesso_arquivo")
    private String acessoArquivo;
    @JoinTable(name = "acesso_has_usuario", joinColumns = {
        @JoinColumn(name = "acesso_acesso_id", referencedColumnName = "acesso_id")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_usuario_id", referencedColumnName = "usuario_id")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;

    public Acesso() {
    }

    public Acesso(Integer acessoId) {
        this.acessoId = acessoId;
    }

    public Integer getAcessoId() {
        return acessoId;
    }

    public void setAcessoId(Integer acessoId) {
        this.acessoId = acessoId;
    }

    public String getAcessoNome() {
        return acessoNome;
    }

    public void setAcessoNome(String acessoNome) {
        this.acessoNome = acessoNome;
    }

    public String getAcessoArquivo() {
        return acessoArquivo;
    }

    public void setAcessoArquivo(String acessoArquivo) {
        this.acessoArquivo = acessoArquivo;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acessoId != null ? acessoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acesso)) {
            return false;
        }
        Acesso other = (Acesso) object;
        if ((this.acessoId == null && other.acessoId != null) || (this.acessoId != null && !this.acessoId.equals(other.acessoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chamados.VO.Acesso[ acessoId=" + acessoId + " ]";
    }
    
}
