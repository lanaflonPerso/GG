package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Demander;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class DemanderDAO {
    public ArrayList<Demander> getDemanderByPlat(int idPlat){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Demander WHERE id_plat = "+ idPlat);
		ResultSet rs = pr.executeQuery();
                ArrayList<Demander> tabDemander = new ArrayList<>();

		while (rs.next()){
                    Demander res = new Demander();
                    res.setDate_demande(rs.getDate("date_demande"));
                    res.setId_plat(rs.getInt("id_plat"));
                    res.setId_client(rs.getInt("id_client"));
                    res.setMontant(rs.getDouble("montant"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    tabDemander.add(res);
		}
		return tabDemander;
                
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
    
    public ArrayList<Demander> getDemanderByClient(int idClient){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Demander WHERE id_client = "+ idClient);
		ResultSet rs = pr.executeQuery();
                ArrayList<Demander> tabDemander = new ArrayList<>();

		while (rs.next()){
                    Demander res = new Demander();
                    res.setDate_demande(rs.getDate("date_demande"));
                    res.setId_plat(rs.getInt("id_plat"));
                    res.setId_client(rs.getInt("id_client"));
                    res.setMontant(rs.getDouble("montant"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    tabDemander.add(res);
		}
		return tabDemander;
                
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
}
