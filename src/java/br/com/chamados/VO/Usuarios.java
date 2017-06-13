/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.VO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tarcio
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByIdUser", query = "SELECT u FROM Usuarios u WHERE u.idUser = :idUser")
    , @NamedQuery(name = "Usuarios.findByNomeUser", query = "SELECT u FROM Usuarios u WHERE u.nomeUser = :nomeUser")
    , @NamedQuery(name = "Usuarios.findByLoginUser", query = "SELECT u FROM Usuarios u WHERE u.loginUser = :loginUser")
    , @NamedQuery(name = "Usuarios.findBySenhaUser", query = "SELECT u FROM Usuarios u WHERE u.senhaUser = :senhaUser")
    , @NamedQuery(name = "Usuarios.findByEmailUser", query = "SELECT u FROM Usuarios u WHERE u.emailUser = :emailUser")
    , @NamedQuery(name = "Usuarios.findByStatusUser", query = "SELECT u FROM Usuarios u WHERE u.statusUser = :statusUser")
    , @NamedQuery(name = "Usuarios.findByDataCreate", query = "SELECT u FROM Usuarios u WHERE u.dataCreate = :dataCreate")
    , @NamedQuery(name = "Usuarios.findByUserCreate", query = "SELECT u FROM Usuarios u WHERE u.userCreate = :userCreate")
    , @NamedQuery(name = "Usuarios.findByDataUpdate", query = "SELECT u FROM Usuarios u WHERE u.dataUpdate = :dataUpdate")
    , @NamedQuery(name = "Usuarios.findByUserUpdate", query = "SELECT u FROM Usuarios u WHERE u.userUpdate = :userUpdate")
    , @NamedQuery(name = "Usuarios.findByPermissaoUser", query = "SELECT u FROM Usuarios u WHERE u.permissaoUser = :permissaoUser")
    , @NamedQuery(name = "Usuarios.findByGestorUser", query = "SELECT u FROM Usuarios u WHERE u.gestorUser = :gestorUser")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome_user")
    private String nomeUser;
    @Size(max = 45)
    @Column(name = "login_user")
    private String loginUser;
    @Size(max = 50)
    @Column(name = "senha_user")
    private String senhaUser;
    @Size(max = 45)
    @Column(name = "email_user")
    private String emailUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status_user")
    private boolean statusUser;
    @Column(name = "data_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCreate;
    @Size(max = 45)
    @Column(name = "user_create")
    private String userCreate;
    @Column(name = "data_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUpdate;
    @Size(max = 45)
    @Column(name = "user_update")
    private String userUpdate;
    @Size(max = 45)
    @Column(name = "permissao_user")
    private String permissaoUser;
    @Size(max = 45)
    @Column(name = "gestor_user")
    private String gestorUser;

    public Usuarios() {
    }

    public Usuarios(Integer idUser) {
        this.idUser = idUser;
    }

    public Usuarios(Integer idUser, String nomeUser, boolean statusUser) {
        this.idUser = idUser;
        this.nomeUser = nomeUser;
        this.statusUser = statusUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
     
    public void capturarLogin() {
        loginUser = loginUser.toUpperCase();
    }

    public String getSenhaUser() {
        return senhaUser;
    }

    public void setSenhaUser(String senhaUser) {
        this.senhaUser = senhaUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public boolean getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(boolean statusUser) {
        this.statusUser = statusUser;
    }

    public Date getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Date dataCreate) {
        this.dataCreate = dataCreate;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public Date getDataUpdate() {
        return dataUpdate;
    }

    public void setDataUpdate(Date dataUpdate) {
        this.dataUpdate = dataUpdate;
    }

    public String getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }

    public String getPermissaoUser() {
        return permissaoUser;
    }

    public void setPermissaoUser(String permissaoUser) {
        this.permissaoUser = permissaoUser;
    }

    public String getGestorUser() {
        return gestorUser;
    }

    public void setGestorUser(String gestorUser) {
        this.gestorUser = gestorUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chamados.VO.Usuarios[ idUser=" + idUser + " ]";
    }
    
}
