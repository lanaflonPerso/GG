package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Composer;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class ComposerDAO {
    public ArrayList<Composer> getComposerByMenu(int idMenu){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Composer WHERE id_menu = " + idMenu);
		ResultSet rs = pr.executeQuery();
                ArrayList<Composer> tabComposer = new ArrayList<>();
                
		if (rs.next()){
                    Composer res = new Composer();
                    res.setId_menu(rs.getInt("id_menu"));
                    res.setId_plat(rs.getInt("id_plat"));
                    res.setMontant(rs.getDouble("montant"));
                    res.setMontant_prix(rs.getDouble("montant_Prix"));
                    
                    connection.close();
		    db.CloseSSHConnection();
                    tabComposer.add(res);
		}
		return tabComposer;
                
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
        db.CloseSSHConnection();
        return null;
    }
    public boolean insertComposer(Composer composer){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("INSERT INTO Composer(id_menu, montant, id_plat, montant_Prix) VALUES ("+
                        composer.getId_menu() + ", " +
                        composer.getMontant() + ", " +
                        composer.getId_plat() + ", " +
                        composer.getMontant_prix() + ")");
                
                if(pr.executeUpdate() != 0){
                    //Success
                    System.out.println("Insert Composer Success");
                }else {
                    // Failed
                    System.out.println("Insert Composer Failed");
                }
                
                connection.close();
				
                    db.CloseSSHConnection();
                    return true;
                    
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
                return false;
            }
    }
}
