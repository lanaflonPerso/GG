package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Prix;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class PrixDAO {
    public Prix getPrixByMontant(double montant){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Prix WHERE montant = " + montant);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Prix res = new Prix();
                    res.setMontant(rs.getDouble("montant"));
                    res.setTva(rs.getDouble("tva"));
                    
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
