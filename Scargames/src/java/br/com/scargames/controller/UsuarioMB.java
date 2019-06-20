package br.com.scargames.controller;

import br.com.scargames.domain.Cidade;
import br.com.scargames.domain.Endereco;
import br.com.scargames.domain.Usuario;
import br.com.scargames.domain.Usuario;
import br.com.scargames.services.UsuarioService;
import br.com.scargames.services.UsuarioService;
import br.com.scargames.util.UtilMessages;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.primefaces.PrimeFaces;

@ManagedBean(name = "usuarioMB")
@SessionScoped
public class UsuarioMB implements Serializable{

    private Usuario usuario;
    private Endereco endereco;
    private List<Endereco> enderecos = new ArrayList<>();
    private List<Usuario> usuarios;
    private String email;
    private String senha;
    private String nome;
    private String cpf;
    private String telefone;
    private char sexo;
    private Date dataNascimento;
    
    public UsuarioMB() {
        this.listar();
        endereco = new Endereco();
    }
    
    public void inicializarHibernate(){
        UsuarioService service = new UsuarioService();
        service.inicializarHibernate();
    }
    
    public void listar(){
        UsuarioService service = new UsuarioService();
        usuarios = service.listar();
    }
    
    public String novo(){
        usuario = new Usuario();
        return "new.xhtml?faces-redirect=true";
    }
    
    public void inserirEnd(){
        //endereco = new Endereco();
        if(enderecos.add(endereco)){
            PrimeFaces current = PrimeFaces.current();
            current.executeScript("PF('dlg1').hide();");
        }else{
            System.out.println("ERRO");
        }
    }
    
    public void listarEnderecos(){
        
    }
    
    public String inserir(){
        UsuarioService service = new UsuarioService();
        if (service.inserir(usuario)){
            UtilMessages.messageInfo("Usuario cadastrada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar a usuario!");
            return null;
        }
    }
    
    public String alterar(){
        UsuarioService service = new UsuarioService();
        if (service.alterar(usuario)){
            UtilMessages.messageInfo("Usuario alterada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao alterar a usuario!");
            return null;
        }
    }
    
    public String carregarDados(Usuario usuario){
        this.usuario = usuario;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String excluir(Usuario usuario){
        UsuarioService service = new UsuarioService();
        if (service.excluir(usuario)){
            UtilMessages.messageInfo("Usuario excluída com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao excluir a usuario!");
            return null;
        }
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String cancelarEnd(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String autenticar(){
        UsuarioService service = new UsuarioService();
        usuario = new Usuario(email, senha);
        if (service.autenticar(usuario)){
            return "/private/index.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Dados inválidos!");
            return null;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
