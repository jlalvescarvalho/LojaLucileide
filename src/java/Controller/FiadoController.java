/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DaoManagerHiber;
import Model.Fiado;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "Fiado")
@SessionScoped
public class FiadoController implements ControllerGenerico<Fiado, Long>{

    private Fiado fiado = null;
    
    @Override
    public void inserir(Fiado fiado) {
        DaoManagerHiber.getInstance().persist(fiado);
    }

    @Override
    public void deletar(Fiado fiado) {
        DaoManagerHiber.getInstance().delete(fiado);
    }

    @Override
    public List recuperarTodos() {
        return DaoManagerHiber.getInstance().recoverAll("from fiado");
    }

    @Override
    public Fiado recuperar(Long id) {
        return (Fiado)DaoManagerHiber.getInstance().recover(Fiado.class, id);
    }

    @Override
    public void alterar(Fiado fiado) {
        DaoManagerHiber.getInstance().update(fiado);
    }
    
}
