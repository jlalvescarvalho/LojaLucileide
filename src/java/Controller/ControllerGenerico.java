/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import static javafx.scene.input.KeyCode.G;

/**
 *
 * @author Luciano
 * @param <T>
 * @param <G>
 */
public interface ControllerGenerico<T,G>{
    
    public void inserir(T t);
    public void deletar(T t);
    public List<T> recuperarTodos();
    public T recuperar(G id);
    public void alterar(T t);
}
