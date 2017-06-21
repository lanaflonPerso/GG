package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Reserver;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class ReserverDAO {
    public Reserver getReserverByClient(int id_client) {
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Reserver WHERE id_client = "+ id_client);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Reserver res = new Reserver();
                    res.setDate_debut(rs.getDate("date_debut"));
                    res.setDate_fin(rs.getDate("date_fin"));
                    res.setEst_paye(rs.getBoolean("est_paye"));
                    res.setId_chambre(rs.getInt("id_chambre"));
                    res.setId_client(rs.getInt("id_client"));
                    res.setMoyen_de_reservation(rs.getString("moyen_de_reservation"));
                    res.setNom_agence_voyage(rs.getString("nom_agence_voyage"));
                    
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
    public Reserver getReserverByChambre(int id_chambre) {
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Reserver WHERE id_chambre = "+ id_chambre);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Reserver res = new Reserver();
                    res.setDate_debut(rs.getDate("date_debut"));
                    res.setDate_fin(rs.getDate("date_fin"));
                    res.setEst_paye(rs.getBoolean("est_paye"));
                    res.setId_chambre(rs.getInt("id_chambre"));
                    res.setId_client(rs.getInt("id_client"));
                    res.setMoyen_de_reservation(rs.getString("moyen_de_reservation"));
                    res.setNom_agence_voyage(rs.getString("nom_agence_voyage"));
                    
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
