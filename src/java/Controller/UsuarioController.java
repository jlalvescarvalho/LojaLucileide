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
@ManagedBean(name = "UsuarioBean")
@SessionScoped
public class UsuarioController implements ControllerGenerico<Usuario, Long>{

    private Usuario usuario;

    public UsuarioController() {
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Usuario recuperarUser(String login, String senha){
        List<Usuario> lista = DaoManagerHiber.getInstance().recover("from Usuario where login="+login+" and senha="+senha);
        if(lista.size() >= 0){
            return lista.get(0);
        }
        return null;
    }
    
    @Override
    public void inserir(Usuario t) {
        DaoManagerHiber.getInstance().persist(t);
    }
    
    @Override
    public void deletar(Usuario t) {
        DaoManagerHiber.getInstance().delete(t);
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
    public void alterar(Usuario t) {
        DaoManagerHiber.getInstance().update(t);
    }
    
}
