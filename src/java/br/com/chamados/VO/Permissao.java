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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tarcio
 */
@Entity
@Table(name = "permissao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permissao.findAll", query = "SELECT p FROM Permissao p")
    , @NamedQuery(name = "Permissao.findByIdPermissao", query = "SELECT p FROM Permissao p WHERE p.idPermissao = :idPermissao")
    , @NamedQuery(name = "Permissao.findByNomePermissao", query = "SELECT p FROM Permissao p WHERE p.nomePermissao = :nomePermissao")
    , @NamedQuery(name = "Permissao.findByLocalPermissao", query = "SELECT p FROM Permissao p WHERE p.localPermissao = :localPermissao")
    , @NamedQuery(name = "Permissao.findByStatusPermissao", query = "SELECT p FROM Permissao p WHERE p.statusPermissao = :statusPermissao")
    , @NamedQuery(name = "Permissao.findByComentarioPermissao", query = "SELECT p FROM Permissao p WHERE p.comentarioPermissao = :comentarioPermissao")})
public class Permissao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_permissao")
    private Integer idPermissao;
    @Size(max = 45)
    @Column(name = "nome_permissao")
    private String nomePermissao;
    @Size(max = 45)
    @Column(name = "local_permissao")
    private String localPermissao;
    @Column(name = "status_permissao")
    private Boolean statusPermissao;
    @Size(max = 100)
    @Column(name = "comentario_permissao")
    private String comentarioPermissao;

    public Permissao() {
    }

    public Permissao(Integer idPermissao) {
        this.idPermissao = idPermissao;
    }

    public Integer getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(Integer idPermissao) {
        this.idPermissao = idPermissao;
    }

    public String getNomePermissao() {
        return nomePermissao;
    }

    public void setNomePermissao(String nomePermissao) {
        this.nomePermissao = nomePermissao;
    }

    public String getLocalPermissao() {
        return localPermissao;
    }

    public void setLocalPermissao(String localPermissao) {
        this.localPermissao = localPermissao;
    }

    public Boolean getStatusPermissao() {
        return statusPermissao;
    }

    public void setStatusPermissao(Boolean statusPermissao) {
        this.statusPermissao = statusPermissao;
    }

    public String getComentarioPermissao() {
        return comentarioPermissao;
    }

    public void setComentarioPermissao(String comentarioPermissao) {
        this.comentarioPermissao = comentarioPermissao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermissao != null ? idPermissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permissao)) {
            return false;
        }
        Permissao other = (Permissao) object;
        if ((this.idPermissao == null && other.idPermissao != null) || (this.idPermissao != null && !this.idPermissao.equals(other.idPermissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chamados.VO.Permissao[ idPermissao=" + idPermissao + " ]";
    }
    
}
