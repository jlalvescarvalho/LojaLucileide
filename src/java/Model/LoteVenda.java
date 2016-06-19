/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Luciano
 */
@Entity(name = "LoteVenda")
public class LoteVenda {
    
    @Id
    @GeneratedValue
    private int Id;
    @Column
    private Date Data;
    @Column
    private String FormaPag;
    @Column
    private double ValorVenda;
    @OneToOne
    private Cliente cliente;
    @OneToMany
    private List<ItemVenda> itensVenda;

    public LoteVenda(Date Data, String FormaPag, double ValorVenda, Cliente cliente, List<ItemVenda> itensVenda) {
        this.Data = Data;
        this.FormaPag = FormaPag;
        this.ValorVenda = ValorVenda;
        this.cliente = cliente;
        this.itensVenda = itensVenda;
    }

    

   
   public LoteVenda() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Date getData() {
        return new Date();
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorVenda() {
        return ValorVenda;
    }

    public void setValorVenda(double ValorVenda) {
        this.ValorVenda = ValorVenda;
    }
    
    public String getFormaPag() {
        return FormaPag;
    }

    public void setFormaPag(String FormaPag) {
        this.FormaPag = FormaPag;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }
    
    
    
}
