/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Luciano
 */
@Entity(name = "Usuario")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue
    private int Id;
    
    private String Nome;
    private long Cpf;
    private String e_mail;
    private String login;
    private String senha;

    public Usuario(int Id, String Nome, long Cpf, String e_mail, String login, String senha) {
        this.Id = Id;
        this.Nome = Nome;
        this.Cpf = Cpf;
        this.e_mail = e_mail;
        this.login = login;
        this.senha = senha;
    }
    
    @Deprecated
    public Usuario() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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
    
    
}
