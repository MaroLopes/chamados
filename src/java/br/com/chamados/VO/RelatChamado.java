/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.VO;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mlopes
 */
@Entity
@Table(name = "relat_chamado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelatChamado.findAll", query = "SELECT r FROM RelatChamado r"),
    @NamedQuery(name = "RelatChamado.findByRelatChamadoId", query = "SELECT r FROM RelatChamado r WHERE r.relatChamadoId = :relatChamadoId"),
    @NamedQuery(name = "RelatChamado.findByRelatChamadoDesc", query = "SELECT r FROM RelatChamado r WHERE r.relatChamadoDesc = :relatChamadoDesc"),
    @NamedQuery(name = "RelatChamado.findByRelatChamadoInfo", query = "SELECT r FROM RelatChamado r WHERE r.relatChamadoInfo = :relatChamadoInfo")})
public class RelatChamado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "relat_chamado_id")
    private Integer relatChamadoId;
    @Basic(optional = false)
    @Column(name = "relat_chamado_desc")
    private String relatChamadoDesc;
    @Column(name = "relat_chamado_info")
    private String relatChamadoInfo;
    @JoinColumn(name = "chamado_chamado_id", referencedColumnName = "chamado_id")
    @ManyToOne(optional = false)
    private Chamado chamadoChamadoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relatChamadoRelatChamadoId")
    private Collection<RelatChamadoFotos> relatChamadoFotosCollection;

    public RelatChamado() {
    }

    public RelatChamado(Integer relatChamadoId) {
        this.relatChamadoId = relatChamadoId;
    }

    public RelatChamado(Integer relatChamadoId, String relatChamadoDesc) {
        this.relatChamadoId = relatChamadoId;
        this.relatChamadoDesc = relatChamadoDesc;
    }

    public Integer getRelatChamadoId() {
        return relatChamadoId;
    }

    public void setRelatChamadoId(Integer relatChamadoId) {
        this.relatChamadoId = relatChamadoId;
    }

    public String getRelatChamadoDesc() {
        return relatChamadoDesc;
    }

    public void setRelatChamadoDesc(String relatChamadoDesc) {
        this.relatChamadoDesc = relatChamadoDesc;
    }

    public String getRelatChamadoInfo() {
        return relatChamadoInfo;
    }

    public void setRelatChamadoInfo(String relatChamadoInfo) {
        this.relatChamadoInfo = relatChamadoInfo;
    }

    public Chamado getChamadoChamadoId() {
        return chamadoChamadoId;
    }

    public void setChamadoChamadoId(Chamado chamadoChamadoId) {
        this.chamadoChamadoId = chamadoChamadoId;
    }

    @XmlTransient
    public Collection<RelatChamadoFotos> getRelatChamadoFotosCollection() {
        return relatChamadoFotosCollection;
    }

    public void setRelatChamadoFotosCollection(Collection<RelatChamadoFotos> relatChamadoFotosCollection) {
        this.relatChamadoFotosCollection = relatChamadoFotosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relatChamadoId != null ? relatChamadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelatChamado)) {
            return false;
        }
        RelatChamado other = (RelatChamado) object;
        if ((this.relatChamadoId == null && other.relatChamadoId != null) || (this.relatChamadoId != null && !this.relatChamadoId.equals(other.relatChamadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chamados.VO.RelatChamado[ relatChamadoId=" + relatChamadoId + " ]";
    }
    
}
