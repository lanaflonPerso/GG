package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Equipement;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class EquipementDAO {
    public Equipement getEquipementById(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Equipement WHERE id_equipement = "+ id);
		ResultSet rs = pr.executeQuery();
                
                if (rs.next()){
                    Equipement res = new Equipement();
                    res.setId_equipement(rs.getInt("id_equipement"));
                    res.setNom_equipement(rs.getString("nom_equipement"));
                    res.setId_type(rs.getInt("id_type"));
                    
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
