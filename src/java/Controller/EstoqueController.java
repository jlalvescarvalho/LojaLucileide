/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DaoManagerHiber;
import Model.Estoque;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "EstoqueBean")
@SessionScoped
public class EstoqueController implements ControllerGenerico<Estoque, Long>{

    private Estoque estoque;
    private Estoque PSelected;

    public EstoqueController() {
        this.estoque = new Estoque();
    }

    
    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Estoque getPSelected() {
        return PSelected;
    }

    public void setPSelected(Estoque PSelected) {
        this.PSelected = PSelected;
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
       return DaoManagerHiber.getInstance().recoverAll("from Estoque");
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
