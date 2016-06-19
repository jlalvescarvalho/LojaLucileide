/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginController {
    
    private Usuario usuarioLogado = null;
    private UsuarioController UsuarioController = null;

    public LoginController() {
        
        HttpSession session = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true));
        
        UsuarioController =(UsuarioController)session.getAttribute("controleUsuario");
        
        if(UsuarioController == null){
            UsuarioController = new UsuarioController();
            session.setAttribute("UsuarioController", UsuarioController);
        }
    }
  
    public String realizarLogin(String login, String senha){
        logarUsuario(login, senha);
        
        if(usuarioLogado == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atenção!", "Usuario Não Cadastrado!"));
            return "/index.xhtml";
        }else if(usuarioLogado != null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bem Vindo! "+usuarioLogado.getNome()));
            return "/PDV.xhtml";
        }
        
        return null;
    }
    
    public void logarUsuario(String login, String senha){
     Usuario u = UsuarioController.recuperarUser(login, senha);
      if(u != null){
          FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            session.setAttribute("usuario", u);
        usuarioLogado = u;
      }else{
          usuarioLogado=null;
      }
    }
    
  

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
  
    public void sair(){
        
               this.usuarioLogado=null;
        ((HttpSession)(FacesContext.getCurrentInstance().getExternalContext().getSession(true))).removeAttribute("usuario");
        
        
        
    }

    
}
