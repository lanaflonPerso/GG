package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Appartenir;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class AppartenirDAO {
    public Appartenir getAppartenirByMetier(int idMetier){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Appartenir WHERE id_metier = "+ idMetier);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Appartenir res = new Appartenir();
                    res.setId_metier(rs.getInt("id_metier"));
                    res.setId_service_employer(rs.getInt("id_service_employe"));
                    
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
    
    public ArrayList<Appartenir> getAppartenirByService(int idService){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Travailler WHERE id_service_employe = "+ idService);
		ResultSet rs = pr.executeQuery();
                ArrayList<Appartenir> tabAppartenir = new ArrayList<>();
                
		if (rs.next()){
                    Appartenir res = new Appartenir();
                    res.setId_metier(rs.getInt("id_metier"));
                    res.setId_service_employer(rs.getInt("id_service_employe"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    tabAppartenir.add(res);
		}
                return tabAppartenir;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
}
