package ifpb.ads.emprestimo;

import ifpb.ads.livro.Livro;
import java.time.LocalDate;

public class Emprestimo {

    private LocalDate dataDoEmprestimo;
    private String nomeDoCliente;
    private LivroSituacao situacao;
    private Livro livro;

    public Emprestimo(LivroSituacao situacao) {
        this.dataDoEmprestimo = LocalDate.now();
        this.situacao = situacao;
    } 
    
    public Emprestimo(){
        this.dataDoEmprestimo = LocalDate.now();
    }

    public LocalDate getDataDoEmprestimo() {
        return dataDoEmprestimo;
    }

    public void setDataDoEmprestimo(LocalDate dataDoEmprestimo) {
        this.dataDoEmprestimo = dataDoEmprestimo;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public LivroSituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(LivroSituacao situacao) {
        this.situacao = situacao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "dataDoEmprestimo=" + dataDoEmprestimo + ", nomeDoCliente=" + nomeDoCliente + ", situacao=" + situacao + ", livro=" + livro + '}';
    }
    
}
