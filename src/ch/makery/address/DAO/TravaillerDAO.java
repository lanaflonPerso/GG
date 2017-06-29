package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Etage;
import ch.makery.address.model.Travailler;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
@SuppressWarnings("unused")
public class TravaillerDAO {
    public Travailler getTravaillerByEmploye(int idEmploye){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Travailler WHERE id_employe = "+ idEmploye);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Travailler res = new Travailler();
                    res.setId_etage(rs.getInt("id_etage"));
                    res.setId_employe(rs.getInt("id_employe"));

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

    public ArrayList<Travailler> getTravaillerByEtage(int idEtage){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Travailler WHERE id_etage = "+ idEtage);
		ResultSet rs = pr.executeQuery();
                ArrayList<Travailler> tabTravailler = new ArrayList<>();

		if (rs.next()){
                    Travailler res = new Travailler();
                    res.setId_etage(rs.getInt("id_etage"));
                    res.setId_employe(rs.getInt("id_employe"));

                    connection.close();
		    db.CloseSSHConnection();
                    tabTravailler.add(res);
		}
                return tabTravailler;

            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }

        db.CloseSSHConnection();
        return null;
    }
}
