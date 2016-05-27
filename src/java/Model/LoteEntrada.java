/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    
    private long Codigo;
    private int Quant;
    @Temporal(value = TemporalType.DATE)
    private Date Data;

    public LoteEntrada(int Id, long Codigo, int Quant, Date Data) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Quant = Quant;
        this.Data = Data;
    }
    @Deprecated
    public LoteEntrada() {
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

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getQuant() {
        return Quant;
    }

    public void setQuant(int Quant) {
        this.Quant = Quant;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }
    
    
}
