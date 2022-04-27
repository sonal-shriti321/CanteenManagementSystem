package com.example.cms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class VendorDAO {

	@Autowired  
    JdbcTemplate jdbc;  
	
	public List<Vendor> showVendor() throws ClassNotFoundException, SQLException {
		
		String cmd = "select * from Vendor";
		
		List<Vendor> vendorList = jdbc.query(cmd, new RowMapper<Vendor>() {
			
			private int venId;
			private String venName;
			private String venPhnNo;
			private String venUsername;
			private String venPassword;
			private String venEmail;
		
            
			public Vendor mapRow(ResultSet rs, int arg1) throws SQLException {
				Vendor vendor = new Vendor();
				vendor.setVenId(rs.getInt("ven_id"));
				vendor.setVenName(rs.getString("ven_name"));
				vendor.setVenPhnNo(rs.getString("ven_phn_no"));
				vendor.setVenUsername(rs.getString("ven_username"));
				vendor.setVenPassword(rs.getString("ven_password"));
				vendor.setVenEmail(rs.getString("ven_email"));
				
				return vendor;
				// TODO Auto-generated method stub
				
			}
			
		});
		
		return vendorList;

}
	
	public String authenticate(String user,String pwd) {
		String cmd = "select count(*) cnt from Vendor where ven_username=? "
				+ " AND ven_password=?";
		List str=jdbc.query(cmd,new Object[] {user,pwd}, new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getInt("cnt");
			}
			
		});
		return str.get(0).toString();
	}
	
	public Vendor searchByVendorUserName(String user) {
		String cmd= "select * from Vendor where ven_username=?";
	
		List<Vendor> vendorList = jdbc.query(cmd, new Object[]{user}, new RowMapper() {
			
			
			public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException{
				Vendor vendor= new Vendor();
				vendor.setVenId(rs.getInt("ven_id"));
				vendor.setVenName(rs.getString("ven_name"));
				vendor.setVenPhnNo(rs.getString("ven_Phn_No"));
				vendor.setVenUsername(rs.getString("ven_Username"));
				vendor.setVenPassword(rs.getString("ven_Password"));
				vendor.setVenEmail(rs.getString("ven_Email"));
				return vendor;
				
			}
		});
				return vendorList.get(0);
	}
	
	private int venId;
	private String venName;
	private String venPhnNo;
	private String venUsername;
	private String venPassword;
	private String venEmail;

}


