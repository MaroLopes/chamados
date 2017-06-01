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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mlopes
 */
@Entity
@Table(name = "relat_chamado_fotos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelatChamadoFotos.findAll", query = "SELECT r FROM RelatChamadoFotos r"),
    @NamedQuery(name = "RelatChamadoFotos.findByRelatChamadoFotosId", query = "SELECT r FROM RelatChamadoFotos r WHERE r.relatChamadoFotosId = :relatChamadoFotosId"),
    @NamedQuery(name = "RelatChamadoFotos.findByRelatChamadoFotosDesc", query = "SELECT r FROM RelatChamadoFotos r WHERE r.relatChamadoFotosDesc = :relatChamadoFotosDesc")})
public class RelatChamadoFotos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "relat_chamado_fotos_id")
    private Integer relatChamadoFotosId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "relat_chamado_fotos_desc")
    private String relatChamadoFotosDesc;
    @Lob
    @Column(name = "relat_chamado_fotos_imagem")
    private byte[] relatChamadoFotosImagem;
    @JoinColumn(name = "relat_chamado_relat_chamado_id", referencedColumnName = "relat_chamado_id")
    @ManyToOne(optional = false)
    private RelatChamado relatChamadoRelatChamadoId;

    public RelatChamadoFotos() {
    }

    public RelatChamadoFotos(Integer relatChamadoFotosId) {
        this.relatChamadoFotosId = relatChamadoFotosId;
    }

    public RelatChamadoFotos(Integer relatChamadoFotosId, String relatChamadoFotosDesc) {
        this.relatChamadoFotosId = relatChamadoFotosId;
        this.relatChamadoFotosDesc = relatChamadoFotosDesc;
    }

    public Integer getRelatChamadoFotosId() {
        return relatChamadoFotosId;
    }

    public void setRelatChamadoFotosId(Integer relatChamadoFotosId) {
        this.relatChamadoFotosId = relatChamadoFotosId;
    }

    public String getRelatChamadoFotosDesc() {
        return relatChamadoFotosDesc;
    }

    public void setRelatChamadoFotosDesc(String relatChamadoFotosDesc) {
        this.relatChamadoFotosDesc = relatChamadoFotosDesc;
    }

    public byte[] getRelatChamadoFotosImagem() {
        return relatChamadoFotosImagem;
    }

    public void setRelatChamadoFotosImagem(byte[] relatChamadoFotosImagem) {
        this.relatChamadoFotosImagem = relatChamadoFotosImagem;
    }

    public RelatChamado getRelatChamadoRelatChamadoId() {
        return relatChamadoRelatChamadoId;
    }

    public void setRelatChamadoRelatChamadoId(RelatChamado relatChamadoRelatChamadoId) {
        this.relatChamadoRelatChamadoId = relatChamadoRelatChamadoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relatChamadoFotosId != null ? relatChamadoFotosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelatChamadoFotos)) {
            return false;
        }
        RelatChamadoFotos other = (RelatChamadoFotos) object;
        if ((this.relatChamadoFotosId == null && other.relatChamadoFotosId != null) || (this.relatChamadoFotosId != null && !this.relatChamadoFotosId.equals(other.relatChamadoFotosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chamados.VO.RelatChamadoFotos[ relatChamadoFotosId=" + relatChamadoFotosId + " ]";
    }
    
}
