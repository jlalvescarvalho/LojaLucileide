/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Luciano
 */
@Table(name = "Produto")
@Entity
public class Produto{
    
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "Codigo")
    private long Codigo;
    @Column(name = "Descrição")
    private String Descricao;
    @Column(name = "Marca")
    private String Marca;
    @Column(name = "Preco")
    private double preco;
    private int Estoque;
    

    public Produto(long Codigo, String Descricao, String Marca, double preco, int Estoque) {
        this.Codigo = Codigo;
        this.Descricao = Descricao;
        this.Marca = Marca;
        this.preco = preco;
        this.Estoque = Estoque;
    }

    
    
    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCodigo() {
        return Codigo;
    }

    public void setCodigo(long Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return Estoque;
    }

    public void setEstoque(int Estoque) {
        this.Estoque = Estoque;
    }

    
   
}