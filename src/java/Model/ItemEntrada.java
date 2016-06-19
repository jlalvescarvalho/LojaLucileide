/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Luciano
 */
@Entity(name = "ItemEntrada")
public class ItemEntrada {
    @Id
    @GeneratedValue
    private int Id;
    private long Codigo;
    private String Nome;
    private int Quant;
    @OneToOne
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "Entrada_id")
    private LoteEntrada loteEntrada;

    public ItemEntrada(int Id, long Codigo, String Nome) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Nome = Nome;
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

    public LoteEntrada getLoteEntrada() {
        return loteEntrada;
    }

    public void setLoteEntrada(LoteEntrada loteEntrada) {
        this.loteEntrada = loteEntrada;
    }

    
    
}
