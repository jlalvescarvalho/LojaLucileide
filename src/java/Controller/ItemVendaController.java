/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DaoManagerHiber;
import Model.ItemVenda;
import Model.LoteVenda;
import java.util.ArrayList;
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
    
    private List<ItemVenda> lista;
    private List<ItemVenda> todosOsItens;
    private double ValorTotal= 0;

    public ItemVendaController() {
        this.todosOsItens = new ArrayList<>();
    }
    
    public void filtarItens(int id){
        todosOsItens = DaoManagerHiber.getInstance().recover("from ItemVenda");
        lista = new ArrayList<ItemVenda>();
        for(int i = 0; i < todosOsItens.size(); i++) {
             if(todosOsItens.get(i).getLoteVenda().getId() == id){
                 lista.add(todosOsItens.get(i));
             }
        }
        ValorTotal = 0;
        for(ItemVenda item : lista){
            ValorTotal = ValorTotal + item.getValorItem();
        }
    }

    public List<ItemVenda> getLista() {
        return lista;
    }
    

    public void setLista(List<ItemVenda> lista) {
        this.lista = lista;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }
    
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
