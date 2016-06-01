/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Builder;

import Model.Cliente;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "bCliente")
@RequestScoped
public class BuilderCliente {
    
    private long Cpf_Cnpj;
    private String Nome;
    private String Apelido;
    private String Genero;
    private long Rg;
    private Date DtNasc;

    public BuilderCliente(long Cpf_Cnpj, String Nome, String Apelido, String Genero, long Rg, Date DtNasc) {
        this.Cpf_Cnpj = Cpf_Cnpj;
        this.Nome = Nome;
        this.Apelido = Apelido;
        this.Genero = Genero;
        this.Rg = Rg;
        this.DtNasc = DtNasc;
    }

    public BuilderCliente() {
    }
    

    public long getCpf_Cnpj() {
        return Cpf_Cnpj;
    }

    public void setCpf_Cnpj(long Cpf_Cnpj) {
        this.Cpf_Cnpj = Cpf_Cnpj;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getApelido() {
        return Apelido;
    }

    public void setApelido(String Apelido) {
        this.Apelido = Apelido;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public long getRg() {
        return Rg;
    }

    public void setRg(long Rg) {
        this.Rg = Rg;
    }

    public Date getDtNasc() {
        return DtNasc;
    }

    public void setDtNasc(Date DtNasc) {
        this.DtNasc = DtNasc;
    }
    
    public Cliente builderCliente(){
        return new Cliente(this.Cpf_Cnpj, this.Nome, this.Apelido, this.Genero, this.Rg, this.DtNasc);
    }
}
