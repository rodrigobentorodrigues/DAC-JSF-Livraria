package ifpb.ads.controladores;

import ifpb.ads.autor.Autor;
import ifpb.ads.livro.Livro;
import ifpb.ads.servicos.ServicoAutor;
import ifpb.ads.servicos.ServicoAutorLivro;
import ifpb.ads.servicos.ServicoLivro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ControladorLivro implements Serializable {

    private Livro livro = new Livro();
    private final ServicoLivro servicoLivro = new ServicoLivro();
    private final ServicoAutor servicoAutor = new ServicoAutor();
    private final ServicoAutorLivro servicoAutorLivro = new ServicoAutorLivro();
    private List<Autor> autoresAuxiliar = servicoAutor.todosAutores();
    private List<Autor> autoresSelecionados = new ArrayList<>();
    boolean mostrarTodosAutores = true;

    public boolean isMostrarTodosAutores() {
        return mostrarTodosAutores;
    }

    public void setMostrarTodosAutores(boolean mostrarTodosAutores) {
        this.mostrarTodosAutores = mostrarTodosAutores;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Autor> getAutoresAuxiliar() {
        return autoresAuxiliar;
    }

    public void setAutoresAuxiliar(List<Autor> autoresAuxiliar) {
        this.autoresAuxiliar = autoresAuxiliar;
    }

    public List<Autor> getAutores() {
        return servicoAutor.todosAutores();
    }

    public String adicionarAutor(Autor autor) {
        this.autoresSelecionados.add(autor);
        this.autoresAuxiliar.remove(autor);
        return null;
    }

    public String cadastrarLivro() {
        servicoLivro.adicionar(livro);
        for (Autor auxiliar : autoresSelecionados) {
            servicoAutorLivro.adicionar(livro, auxiliar);
        }
        livro = new Livro();
        autoresSelecionados = new ArrayList<>();
        autoresAuxiliar = servicoAutor.todosAutores();
        mostrarTodosAutores = true;
        return null;
    }
    
    public String mostrarAutores(){
        this.mostrarTodosAutores = false;
        return null;
    }

}
