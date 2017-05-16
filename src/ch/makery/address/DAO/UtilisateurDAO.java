package ch.makery.address.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.PreparedStatement;

import application.*;

public class UtilisateurDAO {
	public boolean login(String name, String mdp){
		
		MySQLSSHConnector db = new MySQLSSHConnector();
		try {
			Connection connection = db.connection_db();
			PreparedStatement pr = null;
			pr = (PreparedStatement) connection.prepareStatement("Select * from Utilisateur where"
					+ " nom_utilisateur = '" +name
					+ "' AND mot_de_passe = '"+mdp+"'");
			ResultSet rs = pr.executeQuery();
			
			if (rs.next()){
				return true;
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
}
