
package ifpb.ads.dao;

import ifpb.ads.autor.Autor;
import ifpb.ads.fabricas.ConFactory;
import ifpb.ads.livro.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AutorLivroDAO {
    
    private Connection con;

    public AutorLivroDAO() {
    }

    public boolean adicionar(Livro l, Autor a) {
        try {
            this.con = ConFactory.getConnection();
            String sql = "INSERT INTO livroAutor (cpf, isbn) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, a.getCpf().getValor());
            stmt.setString(2, l.getISBN());
            int n = stmt.executeUpdate();
            stmt.close();
            this.con.close();
            return n > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean remover(Livro l) {
        try {
            this.con = ConFactory.getConnection();
            String sql = "DELETE FROM livroAutor WHERE isbn = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, l.getISBN());
            int n = stmt.executeUpdate();
            stmt.close();
            this.con.close();
            return n > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
//    public List<Emprestimo> listarTodos(){
//        try {
//            String sql = "SELECT * FROM livroAutor";
//            PreparedStatement stmt = con.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery();
//            List<Emprestimo> auxiliar = new ArrayList<>();
//            while(rs.next()){
//                Emprestimo e = new Emprestimo();
//                Livro l = new Livro();
//                l.setISBN(rs.getString("isbn"));
//                e.setNomeDoCliente(rs.getString("nomeCliente"));
//                e.setDataDoEmprestimo(rs.getDate("data").toLocalDate());
//                e.setSituacao(LivroSituacao.valueOf(rs.getString("situacao")));
//                e.setLivro(l);
//                auxiliar.add(e);
//            }
//            return auxiliar;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
    
}
