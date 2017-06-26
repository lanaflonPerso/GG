package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Commander;
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
public class CommanderDAO {
    public Commander getCommanderByMenu(int idMenu){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Commander WHERE id_menu = "+ idMenu);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Commander res = new Commander();
                    res.setDate_commande(rs.getDate("date_commande"));
                    res.setId_client(rs.getInt("id_client"));
                    res.setId_menu(rs.getInt("id_menu"));
                    res.setMontant(rs.getDouble("montant"));

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
    public ArrayList<Commander> getCommanderByClient(int idClient){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Commander WHERE id_client = "+ idClient);
		ResultSet rs = pr.executeQuery();
                ArrayList<Commander> tabCommander = new ArrayList<>();

		while (rs.next()){
                    Commander res = new Commander();
                    res.setDate_commande(rs.getDate("date_commande"));
                    res.setId_client(rs.getInt("id_client"));
                    res.setId_menu(rs.getInt("id_menu"));
                    res.setMontant(rs.getDouble("montant"));

                    connection.close();
		    db.CloseSSHConnection();
                    tabCommander.add(res);
		}
		return tabCommander;

            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }

        db.CloseSSHConnection();
        return null;
    }

    public double getMoyenneCommande(){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select AVG(montant) as moyenne from Commander");
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    double res = rs.getDouble("moyenne");

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
        return 0.0;
    }

    public double getMoyenneCommandeByDay(Date dateCommande){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select AVG(montant) from Commander WHERE date_commande = '" + dateCommande + "'");
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    double res = rs.getDouble("moyenne");

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
        return 0.0;
    }


    public double getMoyenneCommandeByWeek(Date dateDebut, Date dateFin){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select AVG(montant) from Commander WHERE date_commande BETWEEN '" + dateDebut + "' AND '" + dateFin + "'");
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    double res = rs.getDouble("moyenne");

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
        return 0.0;
    }
}
