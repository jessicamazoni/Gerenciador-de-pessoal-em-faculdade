package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelBean.AlunoBeans;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/dbfaculdade";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar!");
            throw new RuntimeException("Erro de conexão: "+ ex);
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro 1" + ex);
        }
    }

    public static void closeConnection(Connection con,PreparedStatement stnt) {
        closeConnection(con);
        try {
            if (stnt != null) {
                stnt.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro 2" + ex);
        }
    }

    public static void closeConnection(Connection con,PreparedStatement stnt,ResultSet rs) {

        closeConnection(con,stnt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro 3" + ex);
        }
    }

}
