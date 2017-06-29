package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Reserver;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public void suuppReserverByDate(String date1 , String date2) {
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("DELETE FROM Reserver where date_debut ='"
				+ date1+"' and date_fin ='"+date2+"'");
		System.out.println(pr.asSql());
		pr.executeUpdate();
                    
                    connection.close();	
                    db.CloseSSHConnection();
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
            db.CloseSSHConnection();
          return;
    }
        
    
    public void insertReserverByClient(int id_client, int id_chambre, String date1, String date2) {
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("INSERT INTO `Hotel`.`Reserver` "+
											"(`date_debut`, "+
											"`date_fin`, "+
											"`est_paye`, "+
											"`id_client`, "+
											"`id_chambre`) "+
											"VALUES "+
											"('"+date1+"', '"+
											date2+"', "+
											"0, "+
											id_client+", "+
											id_chambre+")");
		System.out.println(pr.asSql());
		pr.executeUpdate();
		connection.close();
        db.CloseSSHConnection();
		return;
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
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
    
    public int getReserverByDate(String date) {
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select count(*) as taux from Reserver WHERE date_debut <= '"+date+"'"
				+ " and date_fin >= '"+date+"'");
		ResultSet rs = pr.executeQuery();
		if (rs.next()){
                    
			int i = rs.getInt(1);
			System.out.println(i);
                    connection.close();	
                    db.CloseSSHConnection();
                    return i;
		}
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
            db.CloseSSHConnection();
          return 0;
    }
    
    public ArrayList<Reserver> getReserverByDate(String date1 , String date2) {
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Reserver WHERE date_debut >= '"+date1+"'"
				+ " and date_fin <= '"+date2+"'");
		System.out.println(pr.asSql());
		ResultSet rs = pr.executeQuery();
		ArrayList<Reserver> res = new ArrayList<>();
		while (rs.next()){
              Reserver r = new Reserver();      
			r.setDate_debut(rs.getDate(1));
			r.setDate_fin(rs.getDate(2));
			r.setId_chambre(rs.getInt(7));
			r.setId_client(rs.getInt(6));
			res.add(r);
                    
		}
		connection.close();	
        db.CloseSSHConnection();
        return res;	
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
            db.CloseSSHConnection();
          return null;
    }
}
