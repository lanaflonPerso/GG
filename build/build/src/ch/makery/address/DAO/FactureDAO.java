package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Facture;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class FactureDAO {
    public Facture getFactureById(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Facture WHERE id_facture = " + id);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Facture res = new Facture();
                    res.setId_facture(rs.getInt("id_facture"));
                    res.setId_client(rs.getInt("id_client"));
                    res.setMontant(rs.getDouble("montant"));
                    res.setMoyen_payement(rs.getString("moyen_paiement"));
                    
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
    public ArrayList<Facture> getFactureByClient(int idClient){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Facture WHERE id_client = "+ idClient);
		ResultSet rs = pr.executeQuery();
                ArrayList<Facture> tabFacture = new ArrayList<>();

		while (rs.next()){
                    Facture res = new Facture();
                    res.setId_facture(rs.getInt("id_facture"));
                    res.setId_client(rs.getInt("id_client"));
                    res.setMontant(rs.getDouble("montant"));
                    res.setMoyen_payement(rs.getString("moyen_paiement"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    tabFacture.add(res);
		}
                return tabFacture;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
}
