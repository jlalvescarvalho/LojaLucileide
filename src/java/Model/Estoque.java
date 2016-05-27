/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Luciano
 */
@Entity(name = "Estoque")
public class Estoque implements Serializable{
    @Id
    @GeneratedValue
    private int Id;
    
    private long Codigo;
    private String Nome;
    private int Quant;
    @OneToMany
    private List<Produto> produto;

    public Estoque(int Id, long Codigo, String Nome, int Quant) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Nome = Nome;
        this.Quant = Quant;
    }
    
    @Deprecated
    public Estoque() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public long getCodigo() {
        return Codigo;
    }

    public void setCodigo(long Codigo) {
        this.Codigo = Codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getQuant() {
        return Quant;
    }

    public void setQuant(int Quant) {
        this.Quant = Quant;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
    
    
}
