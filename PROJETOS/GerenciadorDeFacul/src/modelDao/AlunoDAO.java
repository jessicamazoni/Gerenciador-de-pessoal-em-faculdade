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
import modelBean.AlunoBeans;

public class AlunoDAO {

    ConnectionFactory con;

    public boolean create(AlunoBeans a) throws Exception {

        Connection cone = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;

        try {
            stnt = cone.prepareStatement("INSERT INTO ALUNO(nome,sexo,data,rg,curso,endereco,id_campus) VALUES(?,?,?,?,?,?,?)");
            stnt.setString(1, a.getNome());
            stnt.setString(2, a.getSexo());
            stnt.setString(3, a.getData());
            stnt.setLong(4, a.getRg());
            stnt.setInt(5, a.getCurso());
            stnt.setString(6, a.getEndereco());
            stnt.setInt(7, a.getId_campus());

            stnt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar!" + ex);
        } finally {
            ConnectionFactory.closeConnection(cone,stnt);
        }
        if (stnt.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public AlunoBeans Pesquisar(String nome) throws Exception {
        con = new ConnectionFactory();

        AlunoBeans objAlu = null;
        String SQL = "select * from ALUNO where nome LIKE %nome%";
        PreparedStatement ps = con.getConnection().prepareStatement(SQL);
        ps.setString(1, "%" + nome + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            objAlu = new AlunoBeans();
            objAlu.setId(rs.getInt("id"));
            objAlu.setNome(rs.getString("nome"));
            objAlu.setSexo(rs.getString("sexo"));
            objAlu.setData(rs.getString("data"));
            objAlu.setRg(rs.getLong("rg"));
            objAlu.setCurso(rs.getInt("curso"));
            objAlu.setEndereco(rs.getString("endereco"));
            objAlu.setId_campus(rs.getInt("id_campus"));
        }
        return objAlu;
    }

    public boolean Editar(AlunoBeans objAlu) throws Exception {
        con = new ConnectionFactory();
        String SQL = "update ALUNO set nome = ?, sexo = ?, data = ?, rg = ?,curso = ?,endereco =? ,id_campus = ? where id = ?";
        PreparedStatement ps = con.getConnection().prepareStatement(SQL);
        ps.setString(1, objAlu.getNome());
        ps.setString(2, objAlu.getSexo());
        ps.setString(3, objAlu.getData());
        ps.setLong(4, objAlu.getRg());
        ps.setInt(5, objAlu.getCurso());
        ps.setString(6, objAlu.getEndereco());//n usei o P
        ps.setInt(7, objAlu.getId_campus());
        ps.setLong(8, objAlu.getId());
        if (ps.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Excluir(long idalu) throws Exception {
        con = new ConnectionFactory();
        String SQL = "delete from ALUNO where id = ?";
        PreparedStatement ps = con.getConnection().prepareStatement(SQL);
        ps.setLong(1, idalu);
        if (ps.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public List<AlunoBeans> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;

        List<AlunoBeans> alunos = new ArrayList<AlunoBeans>();

        try {
            stnt = con.prepareStatement("select*from aluno");
            rs = stnt.executeQuery();

            while (rs.next()) {

                AlunoBeans aluno = new AlunoBeans();

                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSexo(rs.getString("sexo"));
                aluno.setData(rs.getString("data"));
                aluno.setRg(rs.getLong("rg"));
                aluno.setCurso(rs.getInt("curso"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setId_campus(rs.getInt("id_campus"));
                alunos.add(aluno);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con,stnt,rs);
        }

        return alunos;
    }

    public List<AlunoBeans> readBuscar(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;

        List<AlunoBeans> alunos = new ArrayList<AlunoBeans>();

        try {
            stnt = con.prepareStatement("select*from aluno where nome LIKE ?");
            stnt.setString(1, "%" + nome + "%");
            rs = stnt.executeQuery();

            while (rs.next()) {

                AlunoBeans aluno = new AlunoBeans();

                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSexo(rs.getString("sexo"));
                aluno.setData(rs.getString("data"));
                aluno.setRg(rs.getLong("rg"));
                aluno.setCurso(rs.getInt("curso"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setId_campus(rs.getInt("id_campus"));
                alunos.add(aluno);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con,stnt,rs);
        }

        return alunos;
    }

}
