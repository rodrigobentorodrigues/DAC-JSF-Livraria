package ifpb.ads.servicos;

import ifpb.ads.dao.EmprestimoDAO;
import ifpb.ads.emprestimo.Emprestimo;
import ifpb.ads.interfaces.Dao;
import java.util.List;

public class ServicoEmprestimo {

    private Dao dao = new EmprestimoDAO();

    public boolean adicionar(Emprestimo emprestimo) {
        List<Emprestimo> emprestimos = listarTodos();
        boolean condicaoSalvar = true;
        for (Emprestimo x : emprestimos) {
            if (x.getLivro().getISBN().equals(emprestimo.getLivro().getISBN())) {
                condicaoSalvar = false;
            }
        }
        if (condicaoSalvar) {
            return this.dao.adicionar(emprestimo);
        } else {
            return false;
        }

    }

    public boolean atualizar(Emprestimo emprestimo) {
        return this.dao.atualizar(emprestimo);
    }

    public boolean remover(Emprestimo emprestimo) {
        return this.dao.remover(emprestimo);
    }

    public List<Emprestimo> listarTodos() {
        return this.dao.listarTodos();
    }

}
