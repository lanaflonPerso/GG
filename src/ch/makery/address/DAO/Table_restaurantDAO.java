package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Table_restaurant;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class Table_restaurantDAO {
    public Table_restaurant getTableById(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Table_restaurant WHERE id_table = " + id);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Table_restaurant res = new Table_restaurant();
                    res.setId_table(rs.getInt("id_table"));
                    res.setNb_place(rs.getInt("nb_places"));
                    res.setNumero_table(rs.getInt("numero_table"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    return res;
		}
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
    public Table_restaurant getTableByNum(int num){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Table_restaurant WHERE numero_table = " + num);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Table_restaurant res = new Table_restaurant();
                    res.setId_table(rs.getInt("id_table"));
                    res.setNb_place(rs.getInt("nb_places"));
                    res.setNumero_table(rs.getInt("numero_table"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    return res;
		}
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
    public boolean updateTable(Table_restaurant table){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("UPDATE table_restaurant SET numero_table = " + table.getNumero_table() + ", nb_places = " + table.getNb_place() + " WHERE id_table = " + table.getId_table());
                
                if(pr.executeUpdate() != 0){
                    //Success
                    System.out.println("Update Table Success");
                }else {
                    // Failed
                    System.out.println("Update Table Failed");
                }
                
                connection.close();
				
                    db.CloseSSHConnection();
                    return true;
                    
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
                return false;
            }
           
    }
    public boolean supprTable(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("DELETE TABLE FROM Table_restaurant WHERE id_table = " + id);
                
                if(pr.executeUpdate() != 0){
                    //Success
                    System.out.println("Delete Table Success");
                }else {
                    // Failed
                    System.out.println("Delete Table Failed");
                }
                
                connection.close();
				
                    db.CloseSSHConnection();
                    return true;
                    
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
                return false;
            }
           
    }
    public ArrayList<Table_restaurant> getAll(){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Table_restaurant");
		ResultSet rs = pr.executeQuery();
                ArrayList<Table_restaurant> tabTable = new ArrayList<>();
                
		if (rs.next()){
                    Table_restaurant res = new Table_restaurant();
                    res.setId_table(rs.getInt("id_table"));
                    res.setNb_place(rs.getInt("nb_places"));
                    res.setNumero_table(rs.getInt("numero_table"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    tabTable.add(res);
		}
                return tabTable;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
}
