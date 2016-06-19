/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DaoManagerHiber;
import Model.ItemVenda;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "itemBean")
@SessionScoped
public class ItemVendaController implements ControllerGenerico<ItemVenda, Integer>{

    @Override
    public void inserir(ItemVenda t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void deletar(ItemVenda t) {
       DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<ItemVenda> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from ItemVenda");
    }

    @Override
    public ItemVenda recuperar(Integer id) {
        return (ItemVenda)DaoManagerHiber.getInstance().recover("from ItemVenda where id="+id);
    }

    @Override
    public void alterar(ItemVenda t) {
        DaoManagerHiber.getInstance().update(t);
    }

    
    
}
