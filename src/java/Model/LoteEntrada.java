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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Luciano
 */
@Entity(name = "LoteEntrada")
public class LoteEntrada {
    @Id
    @GeneratedValue
    private int Id;
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date Data;
    @OneToMany(mappedBy = "loteEntrada", targetEntity = ItemEntrada.class, cascade = CascadeType.ALL)
    private List<ItemEntrada> itensEntrada;

    public LoteEntrada(Date Data) {
        this.Data = Data;
    }

    public LoteEntrada() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }


    public List<ItemEntrada> getItensEntrada() {
        return itensEntrada;
    }

    public void setItensEntrada(List<ItemEntrada> itensEntrada) {
        this.itensEntrada = itensEntrada;
    }
    
    
}
