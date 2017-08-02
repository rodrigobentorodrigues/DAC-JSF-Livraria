package ifpb.ads.servicos;

import ifpb.ads.autor.Autor;
import ifpb.ads.dao.AutorDAO;
import ifpb.ads.interfaces.Dao;
import java.util.List;

public class ServicoAutor {

    private Dao dao = new AutorDAO();

    public boolean adicionar(Autor autor) {
        List<Autor> autores = todosAutores();
        boolean condicaoSalvar = true;
        for (Autor aux : autores) {
            if (aux.getCpf().getValor().equals(autor.getCpf().getValor())) {
                condicaoSalvar = false;
            }
        }        
        if (condicaoSalvar) {
            return dao.adicionar(autor);
        } else {
            return false;
        }
    }

    public boolean atualizar(Autor autor) {
        return dao.atualizar(autor);
    }

    public boolean remover(Autor autor) {
        return dao.remover(autor);
    }

    public List<Autor> todosAutores() {
        return dao.listarTodos();
    }

}
