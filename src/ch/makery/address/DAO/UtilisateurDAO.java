package ch.makery.address.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import application.*;
import ch.makery.address.model.Utilisateur;

public class UtilisateurDAO {
	public Utilisateur login(String name, String mdp){
		
		MySQLSSHConnector db = new MySQLSSHConnector();
		try {
			Connection connection = db.connection_db();
			PreparedStatement pr = null;
			pr = (PreparedStatement) connection.prepareStatement("Select * from Utilisateur where" + 
                            " nom_utilisateur = '" + name + 
                            "' AND mot_de_passe = '" + mdp + "'");
			ResultSet rs = pr.executeQuery();
			
			
			if (rs.next()){
				Utilisateur user = new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				connection.close();
				
				db.CloseSSHConnection();
				return user;
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
