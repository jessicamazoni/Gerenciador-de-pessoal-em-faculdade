package modelDao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelBean.FuncionarioBeans;

public class FuncionarioDAO {

    ConnectionFactory con;

    public boolean create(FuncionarioBeans a) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;

        try {
            stnt = con.prepareStatement("INSERT INTO funcionario(nome,data,sexo,rg,endereco,prof) VALUES(?,?,?,?,?,?)");
            stnt.setString(1, a.getNome());
            stnt.setString(2, a.getData());
            stnt.setString(3, a.getSexo());
            stnt.setLong(4, a.getRg());
            stnt.setInt(5, a.getId_prof());
            stnt.setString(6, a.getEndereco());

            stnt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt);
        }
        if (stnt.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public FuncionarioBeans Pesquisar(String nome) throws Exception {
        con = new ConnectionFactory();

        FuncionarioBeans objFun = null;
        String SQL = "select * from funcionario where nome LIKE %nome%";
        PreparedStatement ps = con.getConnection().prepareStatement(SQL);
        ps.setString(1, "%" + nome + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            objFun = new FuncionarioBeans();
            objFun.setId(rs.getLong("id"));
            objFun.setNome(rs.getString("nome"));
            objFun.setData(rs.getString("data"));
            objFun.setSexo(rs.getString("sexo"));
            objFun.setRg(rs.getLong("rg"));
            objFun.setId_prof(rs.getInt("prof"));
            objFun.setEndereco(rs.getString("endereco"));
        }
        return objFun;
    }

    public boolean Editar(FuncionarioBeans objFun) throws Exception {
        con = new ConnectionFactory();
        String SQL = "update funcionario set nome = ?, data = ?,  sexo = ?, rg = ?,prof = ?,endereco =? where id = ?";
        PreparedStatement ps = con.getConnection().prepareStatement(SQL);
        ps.setString(1, objFun.getNome());
        ps.setString(2, objFun.getData());
        ps.setString(3, objFun.getSexo());
        ps.setLong(4, objFun.getRg());
        ps.setInt(5, objFun.getId_prof());
        ps.setString(6, objFun.getEndereco());
        ps.setLong(7, objFun.getId());
        if (ps.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Excluir(long idalu) throws Exception {
        con = new ConnectionFactory();
        String SQL = "delete from funcionario where id = ?";
        PreparedStatement ps = con.getConnection().prepareStatement(SQL);
        ps.setLong(1, idalu);
        if (ps.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public List<FuncionarioBeans> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;

        List<FuncionarioBeans> funcionarios = new ArrayList<FuncionarioBeans>();

        try {
            stnt = con.prepareStatement("select*from funcionario");
            rs = stnt.executeQuery();

            while (rs.next()) {

                FuncionarioBeans funcionario = new FuncionarioBeans();

                funcionario.setId(rs.getLong("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setData(rs.getString("data"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setRg(rs.getLong("rg"));
                funcionario.setId_prof(rs.getInt("prof"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }

        return funcionarios;
    }

    public List<FuncionarioBeans> readBuscar(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;

        List<FuncionarioBeans> funcionarios = new ArrayList<FuncionarioBeans>();

        try {
            stnt = con.prepareStatement("select*from funcionario where nome LIKE ?");
            stnt.setString(1, "%" + nome + "%");
            rs = stnt.executeQuery();

            while (rs.next()) {

                FuncionarioBeans funcionario = new FuncionarioBeans();

                funcionario.setId(rs.getLong("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setData(rs.getString("data"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setRg(rs.getLong("rg"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setId_prof(rs.getInt("prof"));
                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }

        return funcionarios;
    }

}
