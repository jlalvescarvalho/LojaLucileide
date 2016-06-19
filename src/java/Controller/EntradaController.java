/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DaoManagerHiber;
import Model.ItemEntrada;
import Model.LoteEntrada;
import Model.Produto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "EntradaBean")
@SessionScoped
public class EntradaController implements ControllerGenerico<LoteEntrada, Long>{

    private LoteEntrada loteEntrada;
    private List<ItemEntrada> ItensEntrada;
    
    
    public EntradaController() {
        this.loteEntrada = new LoteEntrada();
        this.ItensEntrada = new ArrayList<ItemEntrada>();
    }

    
    public LoteEntrada getLoteEntrada() {
        return loteEntrada;
    }

    public void setLoteEntrada(LoteEntrada loteEntrada) {
        this.loteEntrada = loteEntrada;
    }

    public List<ItemEntrada> getItensEntrada() {
        return ItensEntrada;
    }

    public void setItensEntrada(List<ItemEntrada> ItensEntrada) {
        this.ItensEntrada = ItensEntrada;
    }

   public void Adicionar(Produto produto){
        ItemEntrada item = null;
        for (ItemEntrada ie : ItensEntrada) {
            if(ie.getProduto().getId() == produto.getId()){
               item = ie;
               break;
           }
        }      
        
        if(item == null){
            ItemEntrada it = new ItemEntrada();
            it.setProduto(produto);
            it.setCodigo(produto.getCodigo());
            it.setNome(produto.getDescricao());
            it.setQuant(1);
            it.setValor(produto.getPreco());
            ItensEntrada.add(it);
        }else{
            item.setQuant(item.getQuant() + 1);
            item.setValor(produto.getPreco() * item.getQuant());
        }
       
    }
   
   public void RemoverItem(ItemEntrada itemEntrada){
        ItemEntrada item=null;
        for(ItemEntrada ie : ItensEntrada){
            if(ie.getProduto().getId() == itemEntrada.getProduto().getId())
                item = ie;
        }
        ItensEntrada.remove(item);
    }
    
    public void CarregarDados(Produto p){
        
    }
    
    
    @Override
    public void inserir(LoteEntrada t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void deletar(LoteEntrada t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<LoteEntrada> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from LoteEntrada");
    }

    @Override
    public LoteEntrada recuperar(Long id) {
        return (LoteEntrada)DaoManagerHiber.getInstance().recover(id);
    }

    @Override
    public void alterar(LoteEntrada t) {
        DaoManagerHiber.getInstance().update(t);
    }
    
    
}
