
package ifpb.ads.interfaces;

import java.util.List;

public interface Dao<T>{
    
    boolean adicionar(T o);
    boolean atualizar(T o);
    boolean remover(T o);
    List<T> listarTodos();
    
}
