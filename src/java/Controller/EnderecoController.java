/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DaoManagerHiber;
import Model.Endereco;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Luciano
 */
@ManagedBean
@SessionScoped
public class EnderecoController implements ControllerGenerico<Endereco, Long>{

    private Endereco endereco = null;
    
    @Override
    public void inserir(Endereco endereco) {
        DaoManagerHiber.getInstance().persist(endereco);
    }

    @Override
    public void deletar(Endereco endereco) {
        DaoManagerHiber.getInstance().delete(endereco);
    }

    @Override
    public List<Endereco> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from endereco");
    }

    @Override
    public Endereco recuperar(Long id) {
        return (Endereco)DaoManagerHiber.getInstance().recover(id);
    }

    @Override
    public void alterar(Endereco endereco) {
        DaoManagerHiber.getInstance().update(endereco);
    }
    
}
