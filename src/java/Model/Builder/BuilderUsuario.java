/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Builder;

import Model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "bUsuario")
@RequestScoped
public class BuilderUsuario {
    
    private String Nome;
    private long Cpf;
    private String e_mail;
    private String login;
    private String senha;

    public BuilderUsuario(String Nome, long Cpf, String e_mail, String login, String senha) {
        this.Nome = Nome;
        this.Cpf = Cpf;
        this.e_mail = e_mail;
        this.login = login;
        this.senha = senha;
    }

    public BuilderUsuario() {
    }
    

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public long getCpf() {
        return Cpf;
    }

    public void setCpf(long Cpf) {
        this.Cpf = Cpf;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Usuario builderUsuario(){
        return new Usuario(this.Nome, this.Cpf, this.e_mail, this.login, this.senha);
    }
}
