
package ifpb.ads.servicos;

import ifpb.ads.autor.Autor;
import ifpb.ads.dao.AutorDAO;
import ifpb.ads.interfaces.Dao;
import java.util.List;

public class ServicoAutor {

    private Dao dao = new AutorDAO();
    
    public boolean adicionar(Autor autor){
        return dao.adicionar(autor);
    }
    
    public boolean atualizar(Autor autor){
        return dao.atualizar(autor);
    }
    
    public boolean remover(Autor autor){
        return dao.remover(autor);
    }
    
    public List<Autor> todosAutores(){
        return dao.listarTodos();
    }
    
}
