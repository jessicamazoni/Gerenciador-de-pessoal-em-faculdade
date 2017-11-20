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
import modelBean.VerificarBeans;

public class VerificarDAO {
     ConnectionFactory con;
    
     public List<VerificarBeans> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        
        List<VerificarBeans> verificars = new ArrayList<VerificarBeans>();
        
        try {
            stnt = con.prepareStatement("select idC, cidade from campus order by idC");
            rs = stnt.executeQuery();
            
            while(rs.next()){
                
               VerificarBeans verificar = new VerificarBeans();
                
                verificar.setIdC(rs.getInt("idC"));
                verificar.setCampus(rs.getString("cidade"));
                verificars.add(verificar);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        
        return verificars;
    }
   
      public List<VerificarBeans> read2(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        
        List<VerificarBeans> verificars = new ArrayList<VerificarBeans>();
        
        try {
            stnt = con.prepareStatement("select id, nome from profissao order by id");
            rs = stnt.executeQuery();
            
            while(rs.next()){
                
               VerificarBeans verificar = new VerificarBeans();
                
                verificar.setIdP(rs.getInt("id"));
                verificar.setNome(rs.getString("nome"));
                verificars.add(verificar);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        
        return verificars;
    }
   
     public List<VerificarBeans> read3(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        
        List<VerificarBeans> verificars = new ArrayList<VerificarBeans>();
        
        try {
            stnt = con.prepareStatement("select id, nome from curso order by nome");
            rs = stnt.executeQuery();
            
            while(rs.next()){
                
               VerificarBeans verificar = new VerificarBeans();
                
                verificar.setIdCu(rs.getInt("id"));
                verificar.setNome1(rs.getString("nome"));
                verificars.add(verificar);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        
        return verificars;
    }
     
     public List<VerificarBeans> read4(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        
        List<VerificarBeans> verificars = new ArrayList<VerificarBeans>();
        
        try {
            stnt = con.prepareStatement("select id, nome from disciplinas order by nome");
            rs = stnt.executeQuery();
            
            while(rs.next()){
                
               VerificarBeans verificar = new VerificarBeans();
                
                verificar.setIdDis(rs.getInt("id"));
                verificar.setNome2(rs.getString("nome"));
                verificars.add(verificar);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        
        return verificars;
    }
}
