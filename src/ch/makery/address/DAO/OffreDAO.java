package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Offre;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class OffreDAO {
    public Offre getCentraleById(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Offre WHERE id_offre = " + id);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Offre res = new Offre();
                    res.setId_offre(rs.getInt("id_offre"));
                    res.setId_chambre(rs.getInt("id_chambre"));
                    res.setId_centrale_reservation(rs.getInt("id_centrale_reservation"));
                    res.setId_agence_voyage(rs.getInt("id_agence_voyage"));
                    res.setLien_url(rs.getString("lien_url"));
                    res.setDesc_offre(rs.getString("desc_offre"));
                    res.setNb_visites(rs.getInt("nb_visites"));
                    
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
    public ArrayList<Offre> getOffresByChambre(int idChambre){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Offre WHERE id_chambre = " + idChambre);
		ResultSet rs = pr.executeQuery();
                ArrayList<Offre> tabOffres = new ArrayList<>();
                
		while (rs.next()){
                    Offre res = new Offre();
                    res.setId_offre(rs.getInt("id_offre"));
                    res.setId_chambre(rs.getInt("id_chambre"));
                    res.setId_centrale_reservation(rs.getInt("id_centrale_reservation"));
                    res.setId_agence_voyage(rs.getInt("id_agence_voyage"));
                    res.setLien_url(rs.getString("lien_url"));
                    res.setDesc_offre(rs.getString("desc_offre"));
                    res.setNb_visites(rs.getInt("nb_visites"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    tabOffres.add(res);
		}
                return tabOffres;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
    public ArrayList<Offre> getOffresByAgence(int idAgence){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Offre WHERE id_agence_voyage = " + idAgence);
		ResultSet rs = pr.executeQuery();
                ArrayList<Offre> tabOffres = new ArrayList<>();
                
		while (rs.next()){
                    Offre res = new Offre();
                    res.setId_offre(rs.getInt("id_offre"));
                    res.setId_chambre(rs.getInt("id_chambre"));
                    res.setId_centrale_reservation(rs.getInt("id_centrale_reservation"));
                    res.setId_agence_voyage(rs.getInt("id_agence_voyage"));
                    res.setLien_url(rs.getString("lien_url"));
                    res.setDesc_offre(rs.getString("desc_offre"));
                    res.setNb_visites(rs.getInt("nb_visites"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    tabOffres.add(res);
		}
                return tabOffres;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
    public ArrayList<Offre> getOffresByCentrale(int idCentrale){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Offre WHERE id_centrale_reservation = " + idCentrale);
		ResultSet rs = pr.executeQuery();
                ArrayList<Offre> tabOffres = new ArrayList<>();
                
		while (rs.next()){
                    Offre res = new Offre();
                    res.setId_offre(rs.getInt("id_offre"));
                    res.setId_chambre(rs.getInt("id_chambre"));
                    res.setId_centrale_reservation(rs.getInt("id_centrale_reservation"));
                    res.setId_agence_voyage(rs.getInt("id_agence_voyage"));
                    res.setLien_url(rs.getString("lien_url"));
                    res.setDesc_offre(rs.getString("desc_offre"));
                    res.setNb_visites(rs.getInt("nb_visites"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    tabOffres.add(res);
		}
                return tabOffres;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
    public ArrayList<Offre> getAll(){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Offre");
		ResultSet rs = pr.executeQuery();
                ArrayList<Offre> tabOffres = new ArrayList<>();
                
		while (rs.next()){
                    Offre res = new Offre();
                    res.setId_offre(rs.getInt("id_offre"));
                    res.setId_chambre(rs.getInt("id_chambre"));
                    res.setId_centrale_reservation(rs.getInt("id_centrale_reservation"));
                    res.setId_agence_voyage(rs.getInt("id_agence_voyage"));
                    res.setLien_url(rs.getString("lien_url"));
                    res.setDesc_offre(rs.getString("desc_offre"));
                    res.setNb_visites(rs.getInt("nb_visites"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    tabOffres.add(res);
		}
                return tabOffres;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
}
