/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DaoManagerHiber;
import Model.ItemVenda;
import Model.LoteVenda;
import Model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "VendaController")
@SessionScoped
public class VendaController implements ControllerGenerico<LoteVenda, Long>{

    private LoteVenda venda;
    private List<ItemVenda> listaItens;
    
    public VendaController() {
       venda = new LoteVenda();
       listaItens = new ArrayList<ItemVenda>();
    }

    public LoteVenda getVenda() {
        return venda;
    }

    public void setVenda(LoteVenda venda) {
        this.venda = venda;
    }

    public List<ItemVenda> getListaItens() {
        
        return listaItens;
    }

    public void setListaItens(List<ItemVenda> listaItens) {
        this.listaItens = listaItens;
    }
    
    public void Adicionar(Produto produto){
        ItemVenda item = null;
        for (ItemVenda iv : listaItens) {
            if(iv.getProduto().getId() == produto.getId()){
               item = iv;
               break;
           }
        }      
        
        if(item == null){
            ItemVenda it = new ItemVenda();
            it.setProduto(produto);
            it.setQuantidade(1);
            it.setValor(produto.getPreco());
            listaItens.add(it);
        }else{
            item.setQuantidade(item.getQuantidade() + 1);
            item.setValor(produto.getPreco() * item.getQuantidade());
        }
        
    }
    
    public List<Produto> listarProdutos(){
        return DaoManagerHiber.getInstance().recoverAll("from Produto");
    }
    
    @Override
    public void inserir(LoteVenda t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void deletar(LoteVenda t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<LoteVenda> recuperarTodos() {
        return DaoManagerHiber.getInstance().recoverAll("from LoteVenda");
    }

    @Override
    public LoteVenda recuperar(Long id) {
        return (LoteVenda)DaoManagerHiber.getInstance().recover(LoteVenda.class, id);
    }

    @Override
    public void alterar(LoteVenda t) {
        DaoManagerHiber.getInstance().update(t);
    }
    
}
