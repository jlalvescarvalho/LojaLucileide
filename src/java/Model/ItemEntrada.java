/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Luciano
 */
@Entity(name = "IntemEntrada")
public class ItemEntrada {
    @Id
    @GeneratedValue
    private int Id;
    private long Codigo;
    private String Nome;
    private int Quant;
    private double Valor;
    @OneToOne
    private Produto produto;

    public ItemEntrada(int Id, long Codigo, String Nome, double Valor) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Nome = Nome;
        this.Valor = Valor;
    }
    
    @Deprecated
    public ItemEntrada() {
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

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuant() {
        return Quant;
    }

    public void setQuant(int Quant) {
        this.Quant = Quant;
    }
    
    
}
