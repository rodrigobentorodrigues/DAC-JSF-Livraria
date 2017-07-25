
package ifpb.ads.fabricas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactory {
    
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://host-banco:5432/livraria";
            // URL para local
//            String url = "jdbc:postgresql://localhost:5432/livraria";
            String usuario = "postgres";
            String senha = "12345";
            // Senha para local
//            String senha = "123";
            con = DriverManager.getConnection(url, usuario, senha);
            return con;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }
    
}
