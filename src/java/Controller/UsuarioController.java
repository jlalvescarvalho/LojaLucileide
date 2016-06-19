/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DaoManagerHiber;
import Model.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Luciano
 */
@ManagedBean
@SessionScoped
public class UsuarioController implements ControllerGenerico<Usuario, Long>{

    private Usuario usuario = null;
    
    
    @Override
    public void inserir(Usuario usuario) {
        DaoManagerHiber.getInstance().persist(usuario);
    }

    @Override
    public void deletar(Usuario usuario) {
        DaoManagerHiber.getInstance().delete(usuario);
    }

    @Override
    public List<Usuario> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from usuario");
    }

    @Override
    public Usuario recuperar(Long id) {
        return (Usuario)DaoManagerHiber.getInstance().recover(id);
    }

    @Override
    public void alterar(Usuario usuario) {
        DaoManagerHiber.getInstance().update(usuario);
    }
    
}
