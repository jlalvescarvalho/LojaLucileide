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
@Entity(name = "loteVenda")
public class LoteVenda {
    @Id
    @GeneratedValue
    private int Id;
    
    private long Codigo;
    @Temporal(value = TemporalType.DATE)
    private Date Data;
    private String Fiado_Avista;

    public LoteVenda(int Id, long Codigo, Date Data, String Fiado_Avista) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Data = Data;
        this.Fiado_Avista = Fiado_Avista;
    }
    
    @Deprecated
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

    public String getFiado_Avista() {
        return Fiado_Avista;
    }

    public void setFiado_Avista(String Fiado_Avista) {
        this.Fiado_Avista = Fiado_Avista;
    }
    
    
}
