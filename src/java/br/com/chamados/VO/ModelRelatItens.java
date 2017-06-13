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
@Table(name = "model_relat_itens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModelRelatItens.findAll", query = "SELECT m FROM ModelRelatItens m"),
    @NamedQuery(name = "ModelRelatItens.findByModelRelatItensId", query = "SELECT m FROM ModelRelatItens m WHERE m.modelRelatItensId = :modelRelatItensId"),
    @NamedQuery(name = "ModelRelatItens.findByModelRelatItensDesc", query = "SELECT m FROM ModelRelatItens m WHERE m.modelRelatItensDesc = :modelRelatItensDesc"),
    @NamedQuery(name = "ModelRelatItens.findByModelRelatItensExemplo", query = "SELECT m FROM ModelRelatItens m WHERE m.modelRelatItensExemplo = :modelRelatItensExemplo")})
public class ModelRelatItens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "model_relat_itens_id")
    private Integer modelRelatItensId;
    @Column(name = "model_relat_itens_desc")
    private String modelRelatItensDesc;
    @Column(name = "model_relat_itens_exemplo")
    private String modelRelatItensExemplo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelRelatItensModelRelatItensId")
    private Collection<ModelRelatFotos> modelRelatFotosCollection;
    @JoinColumn(name = "model_relat_model_relat_id", referencedColumnName = "model_relat_id")
    @ManyToOne(optional = false)
    private ModelRelat modelRelatModelRelatId;

    public ModelRelatItens() {
    }

    public ModelRelatItens(Integer modelRelatItensId) {
        this.modelRelatItensId = modelRelatItensId;
    }

    public Integer getModelRelatItensId() {
        return modelRelatItensId;
    }

    public void setModelRelatItensId(Integer modelRelatItensId) {
        this.modelRelatItensId = modelRelatItensId;
    }

    public String getModelRelatItensDesc() {
        return modelRelatItensDesc;
    }

    public void setModelRelatItensDesc(String modelRelatItensDesc) {
        this.modelRelatItensDesc = modelRelatItensDesc;
    }

    public String getModelRelatItensExemplo() {
        return modelRelatItensExemplo;
    }

    public void setModelRelatItensExemplo(String modelRelatItensExemplo) {
        this.modelRelatItensExemplo = modelRelatItensExemplo;
    }

    @XmlTransient
    public Collection<ModelRelatFotos> getModelRelatFotosCollection() {
        return modelRelatFotosCollection;
    }

    public void setModelRelatFotosCollection(Collection<ModelRelatFotos> modelRelatFotosCollection) {
        this.modelRelatFotosCollection = modelRelatFotosCollection;
    }

    public ModelRelat getModelRelatModelRelatId() {
        return modelRelatModelRelatId;
    }

    public void setModelRelatModelRelatId(ModelRelat modelRelatModelRelatId) {
        this.modelRelatModelRelatId = modelRelatModelRelatId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modelRelatItensId != null ? modelRelatItensId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModelRelatItens)) {
            return false;
        }
        ModelRelatItens other = (ModelRelatItens) object;
        if ((this.modelRelatItensId == null && other.modelRelatItensId != null) || (this.modelRelatItensId != null && !this.modelRelatItensId.equals(other.modelRelatItensId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chamados.VO.ModelRelatItens[ modelRelatItensId=" + modelRelatItensId + " ]";
    }
    
}
