/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Builder;

import Model.Cliente;
import Model.ItemVenda;
import Model.LoteVenda;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



/**
 *
 * @author Luciano
 */
@ManagedBean(name = "bVenda")
@RequestScoped
public class BuilderVenda {
   
    private Date Data;
    private String FormaPag;
    private double ValorVenda;
    private Cliente cliente;
    private List<ItemVenda> itensVenda;

    public BuilderVenda(Date Data, String FormaPag, double ValorVenda, Cliente cliente, List<ItemVenda> itensVenda) {
        this.Data = Data;
        this.FormaPag = FormaPag;
        this.ValorVenda = ValorVenda;
        this.cliente = cliente;
        this.itensVenda = itensVenda;
    }

    public BuilderVenda() {
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public String getFormaPag() {
        return FormaPag;
    }

    public void setFormaPag(String FormaPag) {
        this.FormaPag = FormaPag;
    }

    public double getValorVenda() {
        return ValorVenda;
    }

    public void setValorVenda(double ValorVenda) {
        this.ValorVenda = ValorVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }
    
    public LoteVenda builderVenda(){
        return new LoteVenda(this.Data, this.FormaPag, this.ValorVenda, this.cliente, this.itensVenda);
    }
    
}
