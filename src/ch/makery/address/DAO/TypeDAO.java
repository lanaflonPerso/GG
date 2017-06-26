package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Type;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class TypeDAO {
    public Type getTypeById(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Type WHERE id_type = "+ id);
		ResultSet rs = pr.executeQuery();
                
                if (rs.next()){
                    Type res = new Type();
                    res.setId_type(rs.getInt("id_type"));
                    res.setNom_type(rs.getString("nom_type"));
                    
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
