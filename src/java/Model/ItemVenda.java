/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Luciano
 */
@Entity(name = "ItemVenda")
public class ItemVenda {
    @Id
    @GeneratedValue
    private int Id;
   
    private long Codigo;
    private String Descricao;
    private int Quantidade;
    private double ValorUnitario;
    private double Valor;
    @ManyToOne
    private Produto produto;
    

    public ItemVenda(int Id, int Item, long Codigo, String Nome, double Valor, double ValorUnitario) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Descricao = Nome;
        this.Valor = Valor;
        this.ValorUnitario = ValorUnitario;
    }
    
    
    public ItemVenda() {
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

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Nome) {
        this.Descricao = Nome;
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


    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public double getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitario(double ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }
    
    
}
