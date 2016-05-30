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
    @Column(name = "Nome")
    private String Nome;
    @Column(name = "Descrição")
    private String Descricao;
    @Column(name = "Marca")
    private String Marca;
    @Column(name = "Preco")
    private double preco= 0.0;

    public Produto(int id, long Codigo, String Nome, String Descricao, String Marca, double preco) {
        this.id = id;
        this.Codigo = Codigo;
        this.Nome = Nome;
        this.Descricao = Descricao;
        this.Marca = Marca;
        this.preco = preco;
    }

    @Deprecated
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

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
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
    
   
}