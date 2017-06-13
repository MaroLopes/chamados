/*
 * Arquivo de configuração de login
 */
package br.com.chamados.BEAN;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Tarcio
 */
@ManagedBean (name="loginBean")
@SessionScoped

public class LoginBEAN {
    private String local = "login.xhtml";
    private String usuario;
    private String senha;
    private String email;
    private String codigoRenovarSenha;

    /**
     * Creates a new instance of LoginBEAN
     */
    public LoginBEAN() {
        local = "login.xhtml";
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigoRenovarSenha() {
        return codigoRenovarSenha;
    }

    public void setCodigoRenovarSenha(String codigoRenovarSenha) {
        this.codigoRenovarSenha = codigoRenovarSenha;
    }
    
    public void save() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Bem vindo " + usuario + " ao MTT Sistemas"));
    }
}
