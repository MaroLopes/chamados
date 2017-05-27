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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mlopes
 */
@Entity
@Table(name = "model_relat_fotos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModelRelatFotos.findAll", query = "SELECT m FROM ModelRelatFotos m"),
    @NamedQuery(name = "ModelRelatFotos.findByModelRelatFotosId", query = "SELECT m FROM ModelRelatFotos m WHERE m.modelRelatFotosId = :modelRelatFotosId"),
    @NamedQuery(name = "ModelRelatFotos.findByModelRelatFotosDesc", query = "SELECT m FROM ModelRelatFotos m WHERE m.modelRelatFotosDesc = :modelRelatFotosDesc")})
public class ModelRelatFotos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "model_relat_fotos_id")
    private Integer modelRelatFotosId;
    @Column(name = "model_relat_fotos_desc")
    private String modelRelatFotosDesc;
    @Lob
    @Column(name = "model_relat_fotos_imagem")
    private byte[] modelRelatFotosImagem;
    @JoinColumn(name = "model_relat_itens_model_relat_itens_id", referencedColumnName = "model_relat_itens_id")
    @ManyToOne(optional = false)
    private ModelRelatItens modelRelatItensModelRelatItensId;

    public ModelRelatFotos() {
    }

    public ModelRelatFotos(Integer modelRelatFotosId) {
        this.modelRelatFotosId = modelRelatFotosId;
    }

    public Integer getModelRelatFotosId() {
        return modelRelatFotosId;
    }

    public void setModelRelatFotosId(Integer modelRelatFotosId) {
        this.modelRelatFotosId = modelRelatFotosId;
    }

    public String getModelRelatFotosDesc() {
        return modelRelatFotosDesc;
    }

    public void setModelRelatFotosDesc(String modelRelatFotosDesc) {
        this.modelRelatFotosDesc = modelRelatFotosDesc;
    }

    public byte[] getModelRelatFotosImagem() {
        return modelRelatFotosImagem;
    }

    public void setModelRelatFotosImagem(byte[] modelRelatFotosImagem) {
        this.modelRelatFotosImagem = modelRelatFotosImagem;
    }

    public ModelRelatItens getModelRelatItensModelRelatItensId() {
        return modelRelatItensModelRelatItensId;
    }

    public void setModelRelatItensModelRelatItensId(ModelRelatItens modelRelatItensModelRelatItensId) {
        this.modelRelatItensModelRelatItensId = modelRelatItensModelRelatItensId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modelRelatFotosId != null ? modelRelatFotosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModelRelatFotos)) {
            return false;
        }
        ModelRelatFotos other = (ModelRelatFotos) object;
        if ((this.modelRelatFotosId == null && other.modelRelatFotosId != null) || (this.modelRelatFotosId != null && !this.modelRelatFotosId.equals(other.modelRelatFotosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chamados.VO.ModelRelatFotos[ modelRelatFotosId=" + modelRelatFotosId + " ]";
    }
    
}
