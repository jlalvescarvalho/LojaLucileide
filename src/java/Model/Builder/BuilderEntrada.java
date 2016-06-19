/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Builder;

import Model.LoteEntrada;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "bEntrada")
@RequestScoped
public class BuilderEntrada {
    
    private long Codigo;
    private int Quant;
    @Temporal(value = TemporalType.DATE)
    private Date Data;
    private String Descricao;

    public BuilderEntrada(long Codigo, int Quant, Date Data, String Descricao) {
        this.Codigo = Codigo;
        this.Quant = Quant;
        this.Data = Data;
        this.Descricao = Descricao;
    }
    
    

    public long getCodigo() {
        return Codigo;
    }

    public void setCodigo(long Codigo) {
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

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
    
    public LoteEntrada builderEntrada(){
        return new LoteEntrada(this.Quant, this.Codigo, this.Quant, this.Data, this.Descricao);
    }
}
