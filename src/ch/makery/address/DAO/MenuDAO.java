package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Menu;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class MenuDAO {
    public Menu getMenuById(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Menu WHERE id_menu = "+ id);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Menu res = new Menu();
                    res.setId_menu(rs.getInt("id_menu"));
                    res.setMontant(rs.getDouble("montant"));
                    res.setNom_menu(rs.getString("nom_menu"));

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
    public ArrayList<Menu> getAll(){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Menu");
		ResultSet rs = pr.executeQuery();
                ArrayList<Menu> tabMenu = new ArrayList<>();

		while (rs.next()){
                    Menu res = new Menu();
                    res.setId_menu(rs.getInt("id_menu"));
                    res.setMontant(rs.getDouble("montant"));
                    res.setNom_menu(rs.getString("nom_menu"));

                    connection.close();
		    db.CloseSSHConnection();
                    tabMenu.add(res);
		}
                return tabMenu;

            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }

        db.CloseSSHConnection();
        return null;
    }
    public boolean updateMontant(double montant, int idMenu){
        MySQLSSHConnector db = new MySQLSSHConnector();
        try {
            Connection connection = db.connection_db();
            PreparedStatement pr = null;
            pr = (PreparedStatement) connection.prepareStatement("UPDATE Menu SET montant = " + montant + " WHERE id_menu = " + idMenu);

            if(pr.executeUpdate() != 0){
                //Success
                System.out.println("Update Menu Success");
            }else {
                // Failed
                System.out.println("Update Menu Failed");
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
