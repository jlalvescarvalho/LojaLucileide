/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DaoManagerHiber;
import Model.Estoque;
import Model.Produto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "ProdutoBean")
@SessionScoped
public class ProdutoController implements ControllerGenerico<Produto, Long>{

    private Produto produtoSelected;
 
    public ProdutoController(){
        produtoSelected = new Produto();
    }
    public Produto getProdutoSelected() {
        return produtoSelected;
    }

    public void setProdutoSelected(Produto produtoSelected) {
        this.produtoSelected = produtoSelected;
    }
    
    @Override
    public void inserir(Produto p) {
        DaoManagerHiber.getInstance().persist(p);
        
        Estoque estoque = new Estoque();
        EstoqueController ec = new EstoqueController();
        
        estoque.setCodigo(p.getCodigo());
        estoque.setNome(p.getDescricao());
        estoque.setProduto(p);
        estoque.setQuant(0);
        ec.inserir(estoque);
    }

    @Override
    public void deletar(Produto p) {
        DaoManagerHiber.getInstance().delete(p);
    }

    @Override
    public Produto recuperar(Long id) {
       return (Produto)DaoManagerHiber.getInstance().recover("from produto where id="+id);
    }

    @Override
    public void alterar(Produto p) {
        DaoManagerHiber.getInstance().update(p);
    }

    @Override
    public List<Produto> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Produto");
    }
 
    
}
