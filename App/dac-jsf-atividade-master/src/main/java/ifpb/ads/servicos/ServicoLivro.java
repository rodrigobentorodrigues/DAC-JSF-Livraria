
package ifpb.ads.servicos;

import ifpb.ads.dao.LivroDAO;
import ifpb.ads.interfaces.Dao;
import ifpb.ads.livro.Livro;
import java.util.List;

public class ServicoLivro {

    private Dao dao = new LivroDAO();
    
    public boolean adicionar(Livro livro){
        return dao.adicionar(livro);
    }
    
    public boolean atualizar(Livro livro){
        return dao.atualizar(livro);
    }
    
    public boolean remover(Livro livro){
        return dao.remover(livro);
    }
    
    public List<Livro> listarTodosLivros(){
        return dao.listarTodos();
    }

    
}
