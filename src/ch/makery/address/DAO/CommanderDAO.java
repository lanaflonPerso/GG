package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Commander;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class CommanderDAO {
    public Commander getCommanderByMenu(int idMenu){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Commander WHERE id_menu = "+ idMenu);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Commander res = new Commander();
                    res.setDate_commande(rs.getDate("date_commande"));
                    res.setId_client(rs.getInt("id_client"));
                    res.setId_menu(rs.getInt("id_menu"));
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
