
package ifpb.ads.controladores;

import ifpb.ads.emprestimo.Emprestimo;
import ifpb.ads.emprestimo.LivroSituacao;
import ifpb.ads.livro.Livro;
import ifpb.ads.servicos.ServicoEmprestimo;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ControladorEmprestimo {
    
    private Emprestimo emprestimo = new Emprestimo();
    private Emprestimo emprestimoDevolucao = new Emprestimo();
    private Livro livro = new Livro();
    private Livro livroDevolucao = new Livro();
    private ServicoEmprestimo servico = new ServicoEmprestimo();
    private boolean realizarDevolucao = false;

    public boolean isRealizarDevolucao() {
        return realizarDevolucao;
    }

    public void setRealizarDevolucao(boolean realizarDevolucao) {
        this.realizarDevolucao = realizarDevolucao;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Livro getLivroDevolucao() {
        return livroDevolucao;
    }

    public void setLivroDevolucao(Livro livroDevolucao) {
        this.livroDevolucao = livroDevolucao;
    }

    public Emprestimo getEmprestimoDevolucao() {
        return emprestimoDevolucao;
    }

    public void setEmprestimoDevolucao(Emprestimo emprestimoDevolucao) {
        this.emprestimoDevolucao = emprestimoDevolucao;
    }
    
    public String cadastrarEmprestimo(){
        emprestimo.setLivro(livro);
        emprestimo.setSituacao(LivroSituacao.EMPRESTADO);
        if(this.servico.adicionar(emprestimo)){
            // Tratar
            System.out.println("Realizado com sucesso");
        } else {
            // Tratar
            System.out.println("Ja existe um emprestimo com esse ISBN");
        }
        emprestimo = new Emprestimo();
        livro = new Livro();
        return null;
    }
    
    public String devolucao(){
        emprestimoDevolucao.setLivro(livroDevolucao);
        emprestimoDevolucao.setSituacao(LivroSituacao.DEVOLVIDO);
        if(this.servico.remover(emprestimoDevolucao)){
            // Tratar
            System.out.println("Removido com sucesso!");
        } else {
            // Tratar
            System.out.println("Nao existe esse nome e ISBN no bd");
        }
        emprestimoDevolucao = new Emprestimo();
        livroDevolucao = new Livro();
        return null;
    }
    
    public void visualizarEmprestimo(){
        this.realizarDevolucao = false;
    }
    
    public void visualizarDevolucao(){
        this.realizarDevolucao = true;
    }
    
}
