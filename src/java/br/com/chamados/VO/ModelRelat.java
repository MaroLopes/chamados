/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.VO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mlopes
 */
@Entity
@Table(name = "model_relat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModelRelat.findAll", query = "SELECT m FROM ModelRelat m"),
    @NamedQuery(name = "ModelRelat.findByModelRelatId", query = "SELECT m FROM ModelRelat m WHERE m.modelRelatId = :modelRelatId"),
    @NamedQuery(name = "ModelRelat.findByModelRelatDesc", query = "SELECT m FROM ModelRelat m WHERE m.modelRelatDesc = :modelRelatDesc")})
public class ModelRelat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "model_relat_id")
    private Integer modelRelatId;
    @Size(max = 100)
    @Column(name = "model_relat_desc")
    private String modelRelatDesc;
    @OneToMany(mappedBy = "modelRelatModelRelatId")
    private List<Chamado> chamadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelRelatModelRelatId")
    private List<ModelRelatItens> modelRelatItensList;

    public ModelRelat() {
    }

    public ModelRelat(Integer modelRelatId) {
        this.modelRelatId = modelRelatId;
    }

    public Integer getModelRelatId() {
        return modelRelatId;
    }

    public void setModelRelatId(Integer modelRelatId) {
        this.modelRelatId = modelRelatId;
    }

    public String getModelRelatDesc() {
        return modelRelatDesc;
    }

    public void setModelRelatDesc(String modelRelatDesc) {
        this.modelRelatDesc = modelRelatDesc;
    }

    @XmlTransient
    public List<Chamado> getChamadoList() {
        return chamadoList;
    }

    public void setChamadoList(List<Chamado> chamadoList) {
        this.chamadoList = chamadoList;
    }

    @XmlTransient
    public List<ModelRelatItens> getModelRelatItensList() {
        return modelRelatItensList;
    }

    public void setModelRelatItensList(List<ModelRelatItens> modelRelatItensList) {
        this.modelRelatItensList = modelRelatItensList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modelRelatId != null ? modelRelatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModelRelat)) {
            return false;
        }
        ModelRelat other = (ModelRelat) object;
        if ((this.modelRelatId == null && other.modelRelatId != null) || (this.modelRelatId != null && !this.modelRelatId.equals(other.modelRelatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chamados.VO.ModelRelat[ modelRelatId=" + modelRelatId + " ]";
    }
    
}
