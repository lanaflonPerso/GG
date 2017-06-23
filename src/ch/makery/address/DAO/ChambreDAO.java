package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Chambre;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class ChambreDAO {
    public Chambre getChambreById(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Client WHERE id_client = "+ id);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Chambre res = new Chambre();
                    res.setId_chambre(rs.getInt("id_chambre"));
                    res.setId_etage(rs.getInt("id_etage"));
                    res.setNb_lits(rs.getInt("nb_lits"));
                    res.setNumero_chambre(rs.getInt("numero_chambre"));
                    
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
    
    public ArrayList<Chambre> getChambresByEtage(int idEtage){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Chambre WHERE id_etage = "+ idEtage);
		ResultSet rs = pr.executeQuery();
                ArrayList<Chambre> tabChambre = new ArrayList<>();
		if (rs.next()){
                    Chambre res = new Chambre();
                    res.setId_chambre(rs.getInt("id_chambre"));
                    res.setId_etage(rs.getInt("id_etage"));
                    res.setNb_lits(rs.getInt("nb_lits"));
                    res.setNumero_chambre(rs.getInt("numero_chambre"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    tabChambre.add(res);
		}
                return tabChambre;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
}
