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
import javax.persistence.OneToOne;

/**
 *
 * @author Luciano
 */
@Entity(name = "Endereco")
public class Endereco implements Serializable{
    @Id
    @GeneratedValue
    private int Id;
    
    private String Rua;
    private int Num;
    private String PontReferen;
    private String Cidade;
    private String Bairro;
 
    public Endereco(int Id, String Rua, int Num, String PontReferen, String Cidade, String Bairro) {
        this.Id = Id;
        this.Rua = Rua;
        this.Num = Num;
        this.PontReferen = PontReferen;
        this.Cidade = Cidade;
        this.Bairro = Bairro;
    }
    
    public Endereco() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int Num) {
        this.Num = Num;
    }

    public String getPontReferen() {
        return PontReferen;
    }

    public void setPontReferen(String PontReferen) {
        this.PontReferen = PontReferen;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }
    
    
    
}
