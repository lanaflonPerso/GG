package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Metier;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class MetierDAO {
    public Metier getMetierById(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Metier WHERE id_metier = " + id);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Metier res = new Metier();
                    res.setId_metier(rs.getInt("id_metier"));
                    res.setNom_metier(rs.getString("nom_metier"));
                    
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
}
