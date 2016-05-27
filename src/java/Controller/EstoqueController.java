/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DaoManagerHiber;
import Model.Estoque;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Luciano
 */
@ManagedBean
@SessionScoped
public class EstoqueController implements ControllerGenerico<Estoque, Long>{

    private Estoque estoque = null;
    
    @Override
    public void inserir(Estoque estoque) {
        DaoManagerHiber.getInstance().persist(estoque);
    }

    @Override
    public void deletar(Estoque estoque) {
        DaoManagerHiber.getInstance().delete(estoque);
    }

    @Override
    public List recuperarTodos() {
       return DaoManagerHiber.getInstance().recoverAll("from estoque");
    }

    @Override
    public Estoque recuperar(Long id) {
        return (Estoque)DaoManagerHiber.getInstance().recover(Estoque.class, id);
    }

    @Override
    public void alterar(Estoque estoque) {
        DaoManagerHiber.getInstance().update(estoque);
    }
    
}
