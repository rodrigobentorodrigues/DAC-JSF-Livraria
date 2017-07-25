
package ifpb.ads.interfaces;

import ifpb.ads.autor.Autor;
import java.util.List;

public interface DaoAutor {

    boolean adicionar(Autor autor);
    boolean atualizar(Autor autor);
    boolean remover(Autor autor);
    List<Autor> listarTodos();

    
}
