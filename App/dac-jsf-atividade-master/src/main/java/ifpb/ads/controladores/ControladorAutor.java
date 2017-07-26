
package ifpb.ads.controladores;

import ifpb.ads.autor.Autor;
import ifpb.ads.servicos.ServicoAutor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(eager=true)
@SessionScoped
public class ControladorAutor {
    
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
        return servico.todosAutores();
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    
    public String adicionarAutor(){
        servico.adicionar(a);
        a = new Autor();
        return null;
    }
    
    public String atualizarAutor(){
        servico.atualizar(a);
        a = new Autor();
        setEditar(false);
        return null;
    }

    public String removerAutor(Autor autor){
        servico.remover(autor);
        return null;
    }
    
    public String editarAutor(Autor autor){
        a = autor;
        setEditar(true);
        return null;
    } 
    
}
