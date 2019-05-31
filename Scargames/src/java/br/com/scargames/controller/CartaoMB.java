package br.com.scargames.controller;

import br.com.scargames.domain.Bandeira;
import br.com.scargames.domain.Cartao;
import br.com.scargames.domain.Usuario;
import br.com.scargames.services.CartaoService;
import br.com.scargames.util.UtilMessages;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "cartaoMB")
@SessionScoped
public class CartaoMB implements Serializable{

    private Cartao cartao;
    private List<Cartao> cartoes;
    private Date currentDate = new Date();
    
    public CartaoMB() {
        this.listar();
    }
    
    public void listar(){
        CartaoService service = new CartaoService();
        cartoes = service.listar();
    }
    
    public String novo(){
        cartao = new Cartao();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        CartaoService service = new CartaoService();
        if (service.inserir(cartao)){
            UtilMessages.messageInfo("Cartao cadastrada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar a cartao!");
            return null;
        }
    }
    
    public String alterar(){
        CartaoService service = new CartaoService();
        if (service.alterar(cartao)){
            UtilMessages.messageInfo("Cartao alterada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao alterar a cartao!");
            return null;
        }
    }
    
    public String carregarDados(Cartao cartao){
        this.cartao = cartao;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String excluir(Cartao cartao){
        CartaoService service = new CartaoService();
        if (service.excluir(cartao)){
            UtilMessages.messageInfo("Cartao excluída com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao excluir a cartao!");
            return null;
        }
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartaos(List<Cartao> cartaos) {
        this.cartoes = cartaos;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
    
}
