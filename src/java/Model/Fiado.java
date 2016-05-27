/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Luciano
 */
@Entity(name = "Fiado")
public class Fiado implements Serializable{
    @Id
    @GeneratedValue
    private int Id;
    private double TotalDebito;

    public Fiado(int Id, double TotalDebito) {
        this.Id = Id;
        this.TotalDebito = TotalDebito;
    }

    public Fiado() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public double getTotalDebito() {
        return TotalDebito;
    }

    public void setTotalDebito(double TotalDebito) {
        this.TotalDebito = TotalDebito;
    }
    
    
    
}
