/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DaoManagerHiber;
import Model.ItemEntrada;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "ItemEntradaBean")
@SessionScoped
public class ItemEntradaController implements ControllerGenerico<ItemEntrada, Integer>{

    public ItemEntradaController() {
    }

    
    @Override
    public void inserir(ItemEntrada t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void deletar(ItemEntrada t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<ItemEntrada> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from ItemEntrada");
    }

    @Override
    public ItemEntrada recuperar(Integer id) {
        return (ItemEntrada)DaoManagerHiber.getInstance().recover("from ItemEntrada where id="+id);
    }

    @Override
    public void alterar(ItemEntrada t) {
        DaoManagerHiber.getInstance().update(t);
    }
    
}
