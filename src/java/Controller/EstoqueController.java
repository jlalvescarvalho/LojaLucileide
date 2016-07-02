/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DaoManagerHiber;
import Model.Estoque;
import Model.Produto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "EstoqueBean")
@SessionScoped
public class EstoqueController implements ControllerGenerico<Estoque, Integer>{

    private Estoque estoque;
    
    public EstoqueController() {
        this.estoque = new Estoque();
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }   
   
    @Override
    public void inserir(Estoque estoque) {
        DaoManagerHiber.getInstance().persist(estoque);
    }

    @Override
    public void deletar(Estoque estoque) {
        DaoManagerHiber.getInstance().delete(estoque);
    }

    @Override
    public List<Estoque> recuperarTodos() {
       return DaoManagerHiber.getInstance().recover("from Estoque");
    }

    @Override
    public Estoque recuperar(Integer id) {
        return (Estoque)DaoManagerHiber.getInstance().recover(id);
    }

    @Override
    public void alterar(Estoque estoque) {
        DaoManagerHiber.getInstance().update(estoque);
    }
    
}
