package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Service;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class ServiceDAO {
    public Service getService(){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Service");
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Service res = new Service();
                    res.setId_service(rs.getInt("id__service"));
                    res.setNom_service(rs.getString("nom_service"));
                    res.setMontant(rs.getDouble("montant"));

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
