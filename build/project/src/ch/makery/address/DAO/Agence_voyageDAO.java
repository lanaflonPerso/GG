package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Agence_voyage;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class Agence_voyageDAO {
    public Agence_voyage getCentraleById(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Agence_voyage WHERE id_agence_voyage = " + id);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Agence_voyage res = new Agence_voyage();
                    res.setId_agence_voyage(rs.getInt("id_agence_voyage"));
                    res.setNom_agence_voyage(rs.getString("nom_agence_voyage"));
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
    public ArrayList<Agence_voyage> getAll(){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Agence_voyage");
		ResultSet rs = pr.executeQuery();
                ArrayList<Agence_voyage> tabAgences = new ArrayList<>();
                
		while (rs.next()){
                    Agence_voyage res = new Agence_voyage();
                    res.setId_agence_voyage(rs.getInt("id_agence_voyage"));
                    res.setNom_agence_voyage(rs.getString("nom_agence_voyage"));
                    res.setLien_url(rs.getString("lien_url"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    tabAgences.add(res);
		}
                return tabAgences;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
}
