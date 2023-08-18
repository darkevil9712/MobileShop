package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import dto.SanPham;
import util.DataConnection;

public class SanPhamDAO {
	public static List<SanPham> getListProducts(){
		List<SanPham> lstProduct = new ArrayList<SanPham>();
		try {
			Connection con = DataConnection.createConnection();
			String query = "SELECT MA_SAN_PHAM, TEN_SAN_PHAM, GIA, HINH FROM san_pham ORDER BY CRE_DT DESC limit 6";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				SanPham sanPham = new SanPham();
				sanPham.setMaHang(rs.getInt(1));
				sanPham.setTenSanPham(rs.getString(2));
				sanPham.setGia(rs.getInt(3));
				sanPham.setHinh(rs.getString(4));
				
				lstProduct.add(sanPham);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return lstProduct;
	}
}
