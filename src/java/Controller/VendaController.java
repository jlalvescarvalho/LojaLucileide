/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import Model.DaoManagerHiber;
import Model.Estoque;
import Model.ItemVenda;
import Model.LoteVenda;
import Model.Produto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "VendaController")
@SessionScoped
public class VendaController implements ControllerGenerico<LoteVenda, Integer>{

    private LoteVenda venda;
    private Estoque estoque;
    private List<ItemVenda> listaItens;

    
    public VendaController() {
       this.venda = new LoteVenda();
       this.estoque = new Estoque();
       this.listaItens = new ArrayList<ItemVenda>();

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
            it.setValorItem(produto.getPreco());
            it.setDescricao(produto.getDescricao());
            it.setValorUnitario(produto.getPreco());
            it.setCodigo(produto.getCodigo());
            listaItens.add(it);
            venda.setValorVenda(venda.getValorVenda()+produto.getPreco());
        }else{
            item.setQuantidade(item.getQuantidade() + 1);
            item.setValorItem(produto.getPreco() * item.getQuantidade());
            venda.setValorVenda(venda.getValorVenda() + produto.getPreco());
        }
       
    }
    
    public void RemoverItem(ItemVenda itemVenda){
        ItemVenda item=null;
        for(ItemVenda iv : listaItens){
            if(iv.getProduto().getId() == itemVenda.getProduto().getId())
                item = iv;
        }
        listaItens.remove(item);
        venda.setValorVenda(venda.getValorVenda() - item.getValorItem());
    }
    
    public void CarregarDados(){
        venda.setData(new Date());
        
        
    }
    public LoteVenda recuperarUltimaVenda(){
        List<LoteVenda> vendas = this.recuperarTodos();
       return vendas.get(vendas.size()-1);
    }     
    public void FinalizarVenda(){
            Cliente c = ClienteController.clienteSelected;
            venda.setData(new Date());
            venda.setCliente(c);
            inserir(venda);
            
            for(ItemVenda item: listaItens){
                item.setLoteVenda(recuperarUltimaVenda());
                
                ItemVendaController itControl = new ItemVendaController();
                itControl.inserir(item);
            }
            DescontarDoEstoque(listaItens);
                        
            this.listaItens = new ArrayList<>();
            this.venda = new LoteVenda();
            this.venda.setValorVenda(0.0);
           
    }
    
    public void DescontarDoEstoque(List<ItemVenda> listaItens){
        Estoque e = null;
        
        for(int i= 0; i < listaItens.size(); i++){
        List<Estoque> lista =  DaoManagerHiber.getInstance().recover("from Estoque where produto_id = "+listaItens.get(i).getProduto().getId());
        if(lista.size() >= 0){
            e = lista.get(0);
            e.setQuant(e.getQuant() - listaItens.get(i).getQuantidade());
            EstoqueController ec = new EstoqueController();
            ec.alterar(e);
        }
        
        
        }
        
        
    }
    
    public List<Produto> listarProdutos(){
        return DaoManagerHiber.getInstance().recover("from Produto");
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
        return DaoManagerHiber.getInstance().recover("from LoteVenda");
    }

    @Override
    public LoteVenda recuperar(Integer id) {
        return (LoteVenda)DaoManagerHiber.getInstance().recover(id);
    }

    @Override
    public void alterar(LoteVenda t) {
        DaoManagerHiber.getInstance().update(t);
    }
    
}
