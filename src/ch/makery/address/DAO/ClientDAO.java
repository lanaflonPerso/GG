package ch.makery.address.DAO;

import application.MySQLSSHConnector;
import ch.makery.address.model.Client;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class ClientDAO {
    public boolean insertClient(Client client){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("INSERT INTO Client(nom_client, prenom_client, num_tel_client, email_client) VALUES (" +
                        client.getNom_client() + ", " + 
                        client.getPrenom_client() + ", " +
                        client.getNum_tel_client() + ", " +
                        client.getEmail_client() + ")");
                if(pr.executeUpdate() != 0){
                    //Success
                    System.out.println("Insert Client Success");
                }else {
                    // Failed
                    System.out.println("Insert Client Failed");
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
    
    public Client getClientById(int id){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Client WHERE id_client = "+ id);
		ResultSet rs = pr.executeQuery();

		if (rs.next()){
                    Client res = new Client();
                    res.setId_client(rs.getInt("id_client"));
                    res.setNom_client(rs.getString("nom_client"));
                    res.setPrenom_client(rs.getString("prenom_client"));
                    res.setEmail_client(rs.getString("email_client"));
                    res.setNum_tel_client(rs.getInt("num_tel_client"));
                    
                    System.out.println(res.getNom_client());
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
