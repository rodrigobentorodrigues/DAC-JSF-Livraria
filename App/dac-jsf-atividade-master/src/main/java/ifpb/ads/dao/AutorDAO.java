
package ifpb.ads.dao;

import ifpb.ads.fabricas.ConFactory;
import ifpb.ads.autor.Autor;
import ifpb.ads.autor.CPF;
import ifpb.ads.interfaces.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO implements Dao<Autor>{
    
    private Connection con;

    public AutorDAO() {}

    @Override
    public boolean adicionar(Autor a) {
        try {
            this.con = ConFactory.getConnection();
            String sql = "INSERT INTO autor (cpf, nome, email) VALUES (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, a.getCpf().getValor());
            stmt.setString(2, a.getNome());
            stmt.setString(3, a.getEmail());
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
    public boolean remover(Autor a) {
        try {
            this.con = ConFactory.getConnection();
            String sql = "DELETE FROM autor WHERE cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, a.getCpf().getValor());
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
    public boolean atualizar(Autor a) {
        try {
            this.con = ConFactory.getConnection();
            String sql = "UPDATE autor SET nome = ?, email = ? WHERE cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getEmail());
            stmt.setString(3, a.getCpf().getValor());
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
    public List<Autor> listarTodos(){
        try {
            this.con = ConFactory.getConnection();
            String sql = "SELECT * FROM autor";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Autor> auxiliar = new ArrayList<>();
            while(rs.next()){
                Autor a = new Autor();
                CPF cpf = new CPF(rs.getString("cpf"));
                a.setCpf(cpf);
                a.setNome(rs.getString("nome"));
                a.setEmail(rs.getString("email"));
                auxiliar.add(a);
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
