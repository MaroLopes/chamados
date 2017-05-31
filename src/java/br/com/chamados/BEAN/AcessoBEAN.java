/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.BEAN;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mlopes
 */
@ManagedBean (name="acessoBean")
@SessionScoped
public class AcessoBEAN implements java.io.Serializable {
    
    private String local = "dashboard.xhtml";
    private String cabecalho = "Home";

    /**
     * Creates a new instance of AcessoBEAN
     */
    public AcessoBEAN() {
        local = "dashboard.xhtml";
        cabecalho = "Home";
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(String cabecalho) {
        this.cabecalho = cabecalho;
    }
    
    public void chamaTela(String loc, String cab){
        
        setLocal(loc);
        setCabecalho(cab);
        
    }
    
}
