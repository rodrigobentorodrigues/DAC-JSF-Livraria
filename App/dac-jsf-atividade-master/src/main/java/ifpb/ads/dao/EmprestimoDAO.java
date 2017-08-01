package ifpb.ads.dao;

import ifpb.ads.fabricas.ConFactory;
import ifpb.ads.emprestimo.Emprestimo;
import ifpb.ads.emprestimo.LivroSituacao;
import ifpb.ads.interfaces.Dao;
import ifpb.ads.livro.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class EmprestimoDAO implements Dao<Emprestimo>{
    
    private Connection con;

    public EmprestimoDAO() {
    }

    public boolean adicionar(Emprestimo e) {
        try {
            this.con = ConFactory.getConnection();
            String sql = "INSERT INTO emprestimo (nomeCliente, data, situacao, isbn) VALUES (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, e.getNomeDoCliente());
            Date d = Date.valueOf(e.getDataDoEmprestimo());
            stmt.setDate(2, d);
            stmt.setString(3, e.getSituacao().name());
            stmt.setString(4, e.getLivro().getISBN());
            int n = stmt.executeUpdate();
            stmt.close();
            this.con.close();
            return n > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean remover(Emprestimo e) {
        try {
            this.con = ConFactory.getConnection();
            String sql = "DELETE FROM emprestimo WHERE isbn = ? AND nomeCliente = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, e.getLivro().getISBN());
            stmt.setString(2, e.getNomeDoCliente());
            int n = stmt.executeUpdate();
            stmt.close();
            this.con.close();
            return n > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean atualizar(Emprestimo e) {
        try {
            this.con = ConFactory.getConnection();
            String sql = "UPDATE emprestimo SET data = ?, situacao = ? WHERE isbn = ? AND nomeCliente = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, Date.valueOf(e.getDataDoEmprestimo()));
            stmt.setString(2, e.getSituacao().name());
            stmt.setString(3, e.getLivro().getISBN());
            stmt.setString(4, e.getNomeDoCliente());
            int n = stmt.executeUpdate();
            stmt.close();
            this.con.close();
            return n > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public List<Emprestimo> listarTodos(){
        try {
            this.con = ConFactory.getConnection();
            String sql = "SELECT * FROM emprestimo";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Emprestimo> auxiliar = new ArrayList<>();
            while(rs.next()){
                Emprestimo e = new Emprestimo();
                Livro l = new Livro();
                l.setISBN(rs.getString("isbn"));
                e.setNomeDoCliente(rs.getString("nomeCliente"));
                e.setDataDoEmprestimo(rs.getDate("data").toLocalDate());
                e.setSituacao(LivroSituacao.valueOf(rs.getString("situacao")));
                e.setLivro(l);
                auxiliar.add(e);
            }
            stmt.close();
            rs.close();
            this.con.close();
            return auxiliar;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    
}
