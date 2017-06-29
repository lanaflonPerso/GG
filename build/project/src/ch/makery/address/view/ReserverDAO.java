package ch.makery.address.view;

import application.MySQLSSHConnector;
import ch.makery.address.model.Reserver;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
class ReserverDAO {
    public ArrayList<Reserver> getReserverByClient(int idClient){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Reserver WHERE id_client = " + idClient);
		ResultSet rs = pr.executeQuery();
                ArrayList<Reserver> tabReserver = new ArrayList<>();

		while (rs.next()){
                    Reserver res = new Reserver();
                    res.setId_chambre(rs.getInt("id_chambre"));
                    res.setId_client(rs.getInt("id_client"));
                    res.setDate_debut(rs.getDate("date_debut"));
                    res.setDate_fin(rs.getDate("date_fin"));
                    res.setEst_paye(rs.getBoolean("est_paye"));
                    res.setMoyen_de_reservation(rs.getString("moyen_de_reservation"));
                    res.setNom_agence_voyage(rs.getString("nom_agence_voyage"));
                            
                    connection.close();
		    db.CloseSSHConnection();
                    tabReserver.add(res);
		}
                return tabReserver;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
    public ArrayList<Reserver> getReserverByChambre(int idChambre){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Reserver WHERE id_chambre = " + idChambre + " ORDER BY date_fin ASC");
		ResultSet rs = pr.executeQuery();
                ArrayList<Reserver> tabReserver = new ArrayList<>();

		while (rs.next()){
                    Reserver res = new Reserver();
                    res.setId_chambre(rs.getInt("id_chambre"));
                    res.setId_client(rs.getInt("id_client"));
                    res.setDate_debut(rs.getDate("date_debut"));
                    res.setDate_fin(rs.getDate("date_fin"));
                    res.setEst_paye(rs.getBoolean("est_paye"));
                    res.setMoyen_de_reservation(rs.getString("moyen_de_reservation"));
                    res.setNom_agence_voyage(rs.getString("nom_agence_voyage"));
                            
                    connection.close();
		    db.CloseSSHConnection();
                    tabReserver.add(res);
		}
                return tabReserver;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
}
