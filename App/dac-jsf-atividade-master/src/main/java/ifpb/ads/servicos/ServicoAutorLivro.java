
package ifpb.ads.servicos;

import ifpb.ads.autor.Autor;
import ifpb.ads.dao.AutorLivroDAO;
import ifpb.ads.livro.Livro;

public class ServicoAutorLivro {

    private AutorLivroDAO dao = new AutorLivroDAO();
    
    public boolean adicionar(Livro livro, Autor autor){
        return dao.adicionar(livro, autor);
    }
    
    public boolean remover(Livro livro){
        return dao.remover(livro);
    }
    
}
