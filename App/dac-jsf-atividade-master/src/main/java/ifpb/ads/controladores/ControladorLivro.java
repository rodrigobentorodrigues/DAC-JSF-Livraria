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
//    private List<Livro> todosLivros = new ArrayList<>();
    private boolean mostrarTodosAutores = true;
    private boolean autorCadastrado = false;
    private boolean editando = false;

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

    public boolean isAutorCadastrado() {
        return autorCadastrado;
    }

    public void setAutorCadastrado(boolean autorCadastrado) {
        this.autorCadastrado = autorCadastrado;
    }

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

    public List<Livro> getTodosLivros() {
        return this.servicoLivro.listarTodosLivros();
    }
    
    public List<Autor> getAutoresAuxiliar() {
        return autoresAuxiliar;
    }

    public List<Autor> getAutores() {
        return servicoAutor.todosAutores();
    }

    public String adicionarAutor(Autor autor) {
        this.autorCadastrado = true;
        this.autoresSelecionados.add(autor);
        this.autoresAuxiliar.remove(autor);
        return null;
    }

    public String cadastrarLivro() {
        if (servicoLivro.adicionar(livro)) {
            for (Autor auxiliar : autoresSelecionados) {
                servicoAutorLivro.adicionar(livro, auxiliar);
            }
        }
        livro = new Livro();
        this.autoresSelecionados = new ArrayList<>();
        this.autoresAuxiliar = servicoAutor.todosAutores();
        this.mostrarTodosAutores = true;
        this.autorCadastrado = false;
        return null;
    }

    public String mostrarAutores() {
        this.mostrarTodosAutores = false;
        this.autoresAuxiliar = this.servicoAutor.todosAutores();
        return null;
    }

    public String removerLivro(Livro livro) {
        this.servicoLivro.remover(livro);
        return null;
    }
    
    public String editarLivro(Livro l){
        this.livro = l;
        this.editando = true;
        return null;
    }
    
    public String atualizarLivro(){               
        this.servicoLivro.atualizar(livro);
        this.livro = new Livro();
        this.editando = false;
        return null;
    }

}
