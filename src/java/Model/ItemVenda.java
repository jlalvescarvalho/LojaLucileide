/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    private double ValorItem;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "Venda_id")
    private LoteVenda loteVenda;
    

    public ItemVenda(long Codigo, String Nome, double Valor, double ValorUnitario) {
        this.Codigo = Codigo;
        this.Descricao = Nome;
        this.ValorItem = Valor;
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

    public double getValorItem() {
        return ValorItem;
    }

    public void setValorItem(double ValorItem) {
        this.ValorItem = ValorItem;
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

    public LoteVenda getLoteVenda() {
        return loteVenda;
    }

    public void setLoteVenda(LoteVenda loteVenda) {
        this.loteVenda = loteVenda;
    }
    
    
}
