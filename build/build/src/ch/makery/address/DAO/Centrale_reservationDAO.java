package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Centrale_reservation;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class Centrale_reservationDAO {
    public Centrale_reservation getCentraleById(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Centrale_reservation WHERE id_centrale_reservation = " + id);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Centrale_reservation res = new Centrale_reservation();
                    res.setId_centrale_reservation(rs.getInt("id_centrale_reservation"));
                    res.setNom_centrale_reservation(rs.getString("nom_centrale_reservation"));
                    res.setLien_url(rs.getString("lien_url"));
                    
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
    public ArrayList<Centrale_reservation> getAll(){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Centrale_reservation");
		ResultSet rs = pr.executeQuery();
                ArrayList<Centrale_reservation> tabCentrales = new ArrayList<>();
                
		while (rs.next()){
                    Centrale_reservation res = new Centrale_reservation();
                    res.setId_centrale_reservation(rs.getInt("id_centrale_reservation"));
                    res.setNom_centrale_reservation(rs.getString("nom_centrale_reservation"));
                    res.setLien_url(rs.getString("lien_url"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    tabCentrales.add(res);
		}
                return tabCentrales;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
}
