/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Builder;

import Model.Produto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "bProduto")
@RequestScoped
public class BuilderProduto {

    private long Codigo;
    private String Descricao;
    private String Marca;
    private double preco;
    private int Estoque;


    public BuilderProduto() {
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


    public Produto builderProduto(){ 
       return new Produto(this.Codigo, this.Descricao, this.Marca, this.preco, this.Estoque);
}
}
