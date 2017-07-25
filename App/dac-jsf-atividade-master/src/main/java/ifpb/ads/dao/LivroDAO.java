package ifpb.ads.dao;

import ifpb.ads.fabricas.ConFactory;
import ifpb.ads.interfaces.Dao;
import ifpb.ads.livro.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO implements Dao<Livro>{
    
    private Connection con;

    public LivroDAO() {
    }

    @Override
    public boolean adicionar(Livro l) {
        try {
            this.con = ConFactory.getConnection();
            String sql = "INSERT INTO livro (isbn, descricao, edicao) VALUES (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, l.getISBN());
            stmt.setString(2, l.getDescricao());
            stmt.setString(3, l.getEdicao());
            int n = stmt.executeUpdate();
            stmt.close();
            this.con.close();
            return n > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remover(Livro l) {
        try {
            String sql = "DELETE FROM livro WHERE isbn = ?";
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

    @Override
    public boolean atualizar(Livro l) {
        try {
            this.con = ConFactory.getConnection();
            String sql = "UPDATE livro SET isbn = ?, descricao = ?, edicao = ? WHERE isbn = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, l.getISBN());
            stmt.setString(2, l.getDescricao());
            stmt.setString(3, l.getEdicao());
            stmt.setString(4, l.getISBN());
            int n = stmt.executeUpdate();
            stmt.close();
            this.con.close();
            return n > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public List<Livro> listarTodos(){
        try {
            this.con = ConFactory.getConnection();
            String sql = "SELECT * FROM livro";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Livro> auxiliar = new ArrayList<>();
            while(rs.next()){
                Livro l = new Livro();
                l.setISBN(rs.getString("isbn"));
                l.setDescricao(rs.getString("descricao"));
                l.setEdicao(rs.getString("edicao"));
                auxiliar.add(l);
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
