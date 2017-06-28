package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Utiliser;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class UtiliserDAO {
    public ArrayList<Utiliser> getUtiliserByClient(int idClient){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Utiliser WHERE id_client = " + idClient);
		ResultSet rs = pr.executeQuery();
                ArrayList<Utiliser> tabUtiliser = new ArrayList<>();
                
		while (rs.next()){
                    Utiliser res = new Utiliser();
                    res.setId_client(rs.getInt("id_client"));
                    res.setId_service(rs.getInt("id_service"));
                    res.setMontant(rs.getDouble("montant"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    tabUtiliser.add(res);
		}
                return tabUtiliser;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
    public ArrayList<Utiliser> getUtiliserByService(int idService){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Utiliser WHERE id_service = " + idService);
		ResultSet rs = pr.executeQuery();
                ArrayList<Utiliser> tabUtiliser = new ArrayList<>();
                
		while (rs.next()){
                    Utiliser res = new Utiliser();
                    res.setId_client(rs.getInt("id_client"));
                    res.setId_service(rs.getInt("id_service"));
                    res.setMontant(rs.getDouble("montant"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    tabUtiliser.add(res);
		}
                return tabUtiliser;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
}
