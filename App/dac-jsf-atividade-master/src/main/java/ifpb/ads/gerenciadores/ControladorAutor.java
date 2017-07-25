
package ifpb.ads.gerenciadores;

import ifpb.ads.autor.Autor;
import ifpb.ads.autor.CPF;
import ifpb.ads.servicos.ServicoAutor;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean(eager=true)
public class ControladorAutor {
    
    private String nome;
    private String email;
    private CPF cpf;
    private ServicoAutor servico = new ServicoAutor();
    private List<Autor> autores;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }
    
    public String adicionarAutor(){
        Autor autor = new Autor();
        autor.setCpf(cpf);
        autor.setNome(nome);
        autor.setEmail(email);
        servico.adicionar(autor);
        nome = "";
        email = "";
        cpf = new CPF("");
        return null;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
    
    
}
