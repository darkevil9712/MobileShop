package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dto.User;
import util.DataConnection;

public class UserDAO {
	// rất nhiều hàm liên quan tới SQL của bảng USER
	public static int register(User user) {
		int result = 0;
		try {
			Connection con = DataConnection.createConnection();
			String query = "INSERT INTO USER (NAME, EMAIL, PHONE, PASSWORD) VALUES(? , ? , ? , MD5(?))";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPhone());
			pst.setString(4, user.getPassword());
			
			result = pst.executeUpdate();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
}
