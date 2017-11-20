package modelDao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    public boolean checkLogin(String tipo, int login, String senha) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        boolean check = false;

        try {

            stnt = con.prepareStatement("SELECT * FROM usuario WHERE  TIPO = ? and LOGIN = ? and SENHA = ?");
            stnt.setString(1, tipo);
            stnt.setInt(2, login);
            stnt.setString(3, senha);

            rs = stnt.executeQuery();

            if (rs.next()) {

                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }

        return check;
    }
}
