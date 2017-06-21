package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Employe;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class EmployeDAO {
    public Employe getEmployeById(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Employe WHERE id_employe = "+ id);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Employe res = new Employe();
                    res.setId_employe(rs.getInt("id_employe"));
                    res.setNom(rs.getString("nom"));
                    res.setPrenom(rs.getString("prenom"));
                    res.setId_metier(rs.getInt("id_metier"));
                    
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
    public Employe getEmployeByName(String nom){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Employe WHERE nom = '" + nom + "'");
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Employe res = new Employe();
                    res.setId_employe(rs.getInt("id_employe"));
                    res.setNom(rs.getString("nom"));
                    res.setPrenom(rs.getString("prenom"));
                    res.setId_metier(rs.getInt("id_metier"));
                    
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
