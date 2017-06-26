package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Plat;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class PlatDAO {
    public Plat getPlatById(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Plat WHERE id_plat = "+ id);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Plat res = new Plat();
                    res.setId_plat(rs.getInt("id_plat"));
                    res.setMontant(rs.getDouble("montant"));
                    res.setNom_plat(rs.getString("nom_plat"));
                    
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
