/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DaoManagerHiber;
import Model.Estoque;
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
public class EntradaController implements ControllerGenerico<LoteEntrada, Integer> {

    private LoteEntrada loteEntrada;
    private List<ItemEntrada> ItensEntrada;
    private List<Estoque> listaEstoque;
    private ItemEntrada entrada;

    public EntradaController() {
        this.loteEntrada = new LoteEntrada();
        this.entrada = new ItemEntrada();
        this.ItensEntrada = new ArrayList<>();
        this.listaEstoque = new ArrayList<>();
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

    public ItemEntrada getEntrada() {
        return entrada;
    }

    public void setEntrada(ItemEntrada entrada) {
        this.entrada = entrada;
    }

    public void Adicionar(Produto produto) {
        ItemEntrada item = null;
        for (ItemEntrada iv : ItensEntrada) {
            if (iv.getProduto().getId() == produto.getId()) {
                item = iv;
                break;
            }
        }

        if (item == null) {
            ItemEntrada it = new ItemEntrada();
            it.setProduto(produto);
            it.setQuant(1);
            it.setNome(produto.getDescricao());
            it.setCodigo(produto.getCodigo());
            ItensEntrada.add(it);

        } else {
            item.setQuant(item.getQuant() + 1);

        }

    }

    public void AdicionarAoEstoque(Produto produto) {
        Estoque et = null;
        List<Estoque> itensEstocados = DaoManagerHiber.getInstance().recover("from Estoque");
        for(Estoque e: itensEstocados){
            if(e.getProduto().getId() == produto.getId()){
                et = e;
                break;
            }
        }
        et.setQuant(et.getQuant() + 1);
        EstoqueController ec = new EstoqueController();
        ec.alterar(et);
    }

    public void RemoverItem(ItemEntrada itemEntrada) {
        ItemEntrada item = null;
        Estoque e = null;
        for (ItemEntrada ie : ItensEntrada) {
            if (ie.getProduto().getId() == itemEntrada.getProduto().getId()) {
                item = ie;
            }
        }
        ItensEntrada.remove(item);
        

    }
    public void removerEstoque(ItemEntrada itemEntrada){
        Estoque et = null;
        List<Estoque> itensEstocados = DaoManagerHiber.getInstance().recover("from Estoque");
        for(Estoque e: itensEstocados){
            if(e.getProduto().getId() == itemEntrada.getProduto().getId()){
                et = e;
                break;
            }
        }
        et.setQuant(et.getQuant() - 1);
        EstoqueController ec = new EstoqueController();
        ec.alterar(et);
    }

    public void CarregarDados() {
        loteEntrada.setData(new Date());
    }

    public LoteEntrada recuperarUltimaEntrada() {
        List<LoteEntrada> entradas = this.recuperarTodos();
        return entradas.get(entradas.size() - 1);
    }

    public void FinalizarEntrada() {
        loteEntrada.setData(new Date());
        this.inserir(loteEntrada);
        
        for (ItemEntrada item : ItensEntrada) {
            item.setLoteEntrada(recuperarUltimaEntrada());

            ItemEntradaController itE = new ItemEntradaController();
            itE.inserir(item);
        }

        this.ItensEntrada = new ArrayList<ItemEntrada>();
        this.loteEntrada = new LoteEntrada();
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
    public LoteEntrada recuperar(Integer id) {
        return (LoteEntrada) DaoManagerHiber.getInstance().recover(id);
    }

    @Override
    public void alterar(LoteEntrada t) {
        DaoManagerHiber.getInstance().update(t);
    }

}
