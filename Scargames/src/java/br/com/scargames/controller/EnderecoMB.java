package br.com.scargames.controller;

import br.com.scargames.domain.Endereco;
import br.com.scargames.services.EnderecoService;
import br.com.scargames.util.UtilMessages;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "enderecoMB")
@SessionScoped
public class EnderecoMB implements Serializable{

    private Endereco endereco;
    private List<Endereco> enderecos;
    
    public EnderecoMB() {
        this.listar();
    }
    
    public void listar(){
        EnderecoService service = new EnderecoService();
        enderecos = service.listar();
    }
    
    public String novo(){
        endereco = new Endereco();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        EnderecoService service = new EnderecoService();
        if (service.inserir(endereco)){
            UtilMessages.messageInfo("Endereco cadastrada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar a endereco!");
            return null;
        }
    }
    
    public String alterar(){
        EnderecoService service = new EnderecoService();
        if (service.alterar(endereco)){
            UtilMessages.messageInfo("Endereco alterado com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao alterar o endereco!");
            return null;
        }
    }
    
    public String carregarDados(Endereco endereco){
        this.endereco = endereco;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String excluir(Endereco endereco){
        EnderecoService service = new EnderecoService();
        if (service.excluir(endereco)){
            UtilMessages.messageInfo("Endereco excluído com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao excluir a endereco!");
            return null;
        }
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    
}
