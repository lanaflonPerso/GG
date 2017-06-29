package ch.makery.address.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import application.MySQLSSHConnector;
import ch.makery.address.model.Notoriete;

public class NotorieteDAO {
	
	public ArrayList<Notoriete> getNotoriete(){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * From Notoriete");
		ResultSet rs = pr.executeQuery();
		ArrayList<Notoriete> list = new ArrayList<>();
		while(rs.next()){
					Notoriete n = new Notoriete();
					n.setNote(rs.getInt(3));
					n.setIdNotoriete(rs.getInt(1));
					n.setNom(rs.getString(2));
					
                    list.add(n);
                    
		}
		connection.close();	
        db.CloseSSHConnection();
		return list;
			
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                db.CloseSSHConnection();
		e.printStackTrace();
            }
            
            db.CloseSSHConnection();
          return null;
    }

}
