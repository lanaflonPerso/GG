package ch.makery.address.DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import application.MySQLSSHConnector;
import ch.makery.address.model.Service;

public class ServiceDAO {
	
	public List<Service> getService(){
        MySQLSSHConnector db = new MySQLSSHConnector();
            try {
                Connection connection = db.connection_db();
		PreparedStatement pr = null;
		pr = (PreparedStatement) connection.prepareStatement("Select * from Service");
		ResultSet rs = pr.executeQuery();
		ArrayList<Service> list = new ArrayList<>();
		while(rs.next()){
					Service sr = new Service();
                    sr.setId_service(rs.getInt(1));
                    sr.setNom_service(rs.getString(2));
                    sr.setMontant(rs.getDouble(3));
                    list.add(sr);
                    
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
	
