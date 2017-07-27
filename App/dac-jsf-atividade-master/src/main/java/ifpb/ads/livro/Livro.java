package ifpb.ads.livro;

import ifpb.ads.autor.Autor;
import java.util.ArrayList;
import java.util.List;

public class Livro {

    private String descricao;
    private String ISBN;
    private String edicao;
    private List<Autor> autores;

    public Livro() {
        this.autores = new ArrayList<>();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
    
    public void adicionarAutor(Autor autor){
        this.autores.add(autor);
    }
    public void removerAutor(Autor autor){
        this.autores.remove(autor);
    }

    @Override
    public String toString() {
        return "Livro{" + "descricao=" + descricao + ", ISBN=" + ISBN + ", edicao=" + edicao + ", autores=" + autores + '}';
    }

}
