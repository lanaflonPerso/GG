package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Metier;
import ch.makery.address.model.Service;
import ch.makery.address.model.Service_employe;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author maxim
 */
public class ServiceEmployeDAO {
	
	public HashMap<String,Integer> getNombreEmpService(){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select count(emp.id_employe), ser.nom_service"
				+ " from Employe emp JOIN Metier m ON m.id_metier =emp.id_metier"
				+ " JOIN Appartenir a ON a.id_metier = m.id_metier"
				+ " JOIN Service_employe ser ON ser.id_service_employe = a.id_service_employe "
				+ " GROUP BY ser.id_service_employe");
		ResultSet rs = pr.executeQuery();
		HashMap<String,Integer> list = new HashMap<>();
		while(rs.next()){
					
                    list.put(rs.getString(2),rs.getInt(1));
                    
		}
		connection.close();	
        db.CloseSSHConnection();
		return list;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
            db.CloseSSHConnection();
          return null;
    }
    public Service_employe getServiceEmployeById(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Service_employe WHERE id_service_employe = " + id);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Service_employe res = new Service_employe();
                    res.setId_service_employe(rs.getInt("id__service_employe"));
                    res.setNom_service(rs.getString("nom_service"));
                    
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
    public Service_employe getServiceEmployeByMetier(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Appartenir NATURAL JOIN Service_employe WHERE id_metier = " + id);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Service_employe res = new Service_employe();
                    res.setId_service_employe(rs.getInt("id__service_employe"));
                    res.setNom_service(rs.getString("nom_service"));
                    
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
