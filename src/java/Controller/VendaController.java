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

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "VendaController")
public class VendaController implements ControllerGenerico<LoteVenda, Long>{

    private LoteVenda venda;
    private List<ItemVenda> listaItens;
    
    public VendaController() {
       venda = new LoteVenda();
       
    }

    public LoteVenda getVenda() {
        return venda;
    }

    public void setVenda(LoteVenda venda) {
        this.venda = venda;
    }

    public List<ItemVenda> getListaItens() {
        if(listaItens == null){
            listaItens = new ArrayList<>();
        }
        return listaItens;
    }

    public void setListaItens(List<ItemVenda> listaItens) {
        this.listaItens = listaItens;
    }
    
    public void Adicionar(Produto produto){
        int posicaoEncontrada = -1;
        
        for (int i = 0; i < listaItens.size() && posicaoEncontrada < 0; i++) {
            ItemVenda itemTemp = listaItens.get(i);
           if(itemTemp.getProduto().getId() == produto.getId()){
               posicaoEncontrada = i;
           }
        }
        
        ItemVenda item = new ItemVenda();
        item.setProduto(produto);
        
        if(posicaoEncontrada < 0){
            item.setQuantidade(1);
            item.setValor(produto.getPreco());
            listaItens.add(item);
        }else{
            ItemVenda itemTemp = listaItens.get(posicaoEncontrada);
            item.setQuantidade(itemTemp.getQuantidade() + 1);
            item.setValor(produto.getPreco() * item.getQuantidade());
            listaItens.set(posicaoEncontrada, item);
            
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
