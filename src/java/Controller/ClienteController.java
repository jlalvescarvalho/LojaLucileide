/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import Model.DaoManagerHiber;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "ClienteBean")
@SessionScoped
public class ClienteController implements ControllerGenerico<Cliente, Integer>{

    private Cliente clienteSelected;

    public ClienteController() {
        clienteSelected = new Cliente();
    }
   
    public Cliente getClienteSelected() {
        return clienteSelected;
    }

    public void setClienteSelected(Cliente clienteSelected) {
        this.clienteSelected = clienteSelected;
    }

   
    
    @Override
    public void inserir(Cliente c) {
        DaoManagerHiber.getInstance().persist(c);
    }

    @Override
    public void deletar(Cliente c) {
        DaoManagerHiber.getInstance().delete(c);
    }

    @Override
    public List<Cliente> recuperarTodos() {
       return DaoManagerHiber.getInstance().recover("from Cliente");
    }

    @Override
    public Cliente recuperar(Integer id) {
       return (Cliente)DaoManagerHiber.getInstance().recover(id);
       
    }
    
    public Cliente recuperarCliente(){
        List<Cliente> lista = DaoManagerHiber.getInstance().recover("from Cliente where id="+clienteSelected.getId());
        for(int i=0; i < lista.size(); i++){
            if(lista.size() >= 0){
                return lista.get(0);
            }
        }
        return null;
    }

    @Override
    public void alterar(Cliente c) {
        DaoManagerHiber.getInstance().update(c);
    }
    
}
