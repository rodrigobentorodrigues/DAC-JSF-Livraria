
package ifpb.ads.controladores;

import ifpb.ads.autor.Autor;
import ifpb.ads.servicos.ServicoAutor;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ControladorAutor implements Serializable{
    
    private Autor a = new Autor();
    private ServicoAutor servico = new ServicoAutor();
    private boolean editar = false;

    public Autor getA() {
        return a;
    }

    public void setA(Autor a) {
        this.a = a;
    }
    
    public List<Autor> getAutores() {
        return this.servico.todosAutores();
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    
    public String adicionarAutor(){
        this.servico.adicionar(a);
        this.a = new Autor();
        return null;
    }
    
    public String atualizarAutor(){
        this.servico.atualizar(a);
        this.a = new Autor();
        this.setEditar(false);
        return null;
    }

    public String removerAutor(Autor autor){
        this.servico.remover(autor);
        return null;
    }
    
    public String editarAutor(Autor autor){
        this.a = autor;
        this.setEditar(true);
        return null;
    } 
    
}
