/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Luciano
 */
@Entity(name = "ItemVenda")
public class ItemVenda {
    @Id
    @GeneratedValue
    private int Id;
    
    private int Item;
    private long Codigo;
    private String Nome;
    private double Valor;

    public ItemVenda(int Id, int Item, long Codigo, String Nome, double Valor) {
        this.Id = Id;
        this.Item = Item;
        this.Codigo = Codigo;
        this.Nome = Nome;
        this.Valor = Valor;
    }
    
    @Deprecated
    public ItemVenda() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getItem() {
        return Item;
    }

    public void setItem(int Item) {
        this.Item = Item;
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
    
    
}
