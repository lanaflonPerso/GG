package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Etage;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class EtageDAO {
    public Etage getEtageById(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Client WHERE id_client = "+ id);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Etage res = new Etage();
                    res.setId_etage(rs.getInt("id_etage"));
                    res.setNum_etage(rs.getInt("num_etage"));
                    
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
