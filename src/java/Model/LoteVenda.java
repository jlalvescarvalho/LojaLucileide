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
    private long Codigo;
    @Temporal(value = TemporalType.DATE)
    private Date Data;
    @Column
    private String Fiado;
    @Column
    private String Avista;
    
    @OneToOne
    private Cliente cliente;
    @OneToMany
    private List<ItemVenda> itensVenda;

    
   public LoteVenda() {
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

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public String getFiado() {
        return Fiado;
    }

    public void setFiado(String Fiado) {
        this.Fiado = Fiado;
    }

    public String getAvista() {
        return Avista;
    }

    public void setAvista(String Avista) {
        this.Avista = Avista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    
    
}
