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
    

    @Temporal(value = TemporalType.DATE)
    private Date Data;

    public BuilderEntrada(Date Data) {
        this.Data = Data;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    
    
    public LoteEntrada builderEntrada(){
        return new LoteEntrada(this.Data);
    }
}
