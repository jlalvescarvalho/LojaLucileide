/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Luciano
 */
@Entity(name = "Cliente")
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue
    private int Id;
    
    private long Cpf_Cnpj;
    private String Nome;
    private String Apelido;
    private String Genero;
    private long Rg;
    @Temporal(value = TemporalType.DATE)
    private Date DtNasc;
    @OneToOne
    private Endereco endereco;

    public Cliente(int Id, long Cpf_Cnpj, String Nome, String Apelido, String Genero, long Rg, Date DtNasc) {
        this.Id = Id;
        this.Cpf_Cnpj = Cpf_Cnpj;
        this.Nome = Nome;
        this.Apelido = Apelido;
        this.Genero = Genero;
        this.Rg = Rg;
        this.DtNasc = DtNasc;
    }
    @Deprecated
    public Cliente() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    
}
