package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Manger;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxime
 */
@SuppressWarnings("unused")
public class MangerDAO {
    public ArrayList<Manger> getMangerByClient(int idClient){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Manger WHERE id_client = "+ idClient);
		ResultSet rs = pr.executeQuery();
                ArrayList<Manger> tabManger = new ArrayList<>();

		while (rs.next()){
                    Manger res = new Manger();
                    res.setId_client(rs.getInt("id_client"));
                    res.setId_table(rs.getInt("id_table"));
                    res.setNb_couverts(rs.getInt("nb_couverts"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    tabManger.add(res);
		}
                return tabManger;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
    public Manger getMangerByTable(int idTable){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Manger WHERE id_table = "+ idTable);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Manger res = new Manger();
                    res.setId_client(rs.getInt("id_client"));
                    res.setId_table(rs.getInt("id_table"));
                    res.setNb_couverts(rs.getInt("nb_couverts"));
                    
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
    public boolean supprManger(int idTable, int idClient){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("DELETE FROM Manger WHERE id_client = " + idClient + " AND id_table = " + idTable);
                
                if(pr.executeUpdate() != 0){
                    //Success
                    System.out.println("Delete Manger Success");
                }else {
                    // Failed
                    System.out.println("Delete Manger Failed");
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
}
