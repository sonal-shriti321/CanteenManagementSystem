package com.example.cms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {

	@Autowired  
    JdbcTemplate jdbc;  
	public Customer searchByCustomerUserName(String user) {
		String cmd= "select * from Customer where Cus_UserName=?";
	
		List<Customer> customerList = jdbc.query(cmd, new Object[]{user}, new RowMapper() {
			
			
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
				Customer customer= new Customer();
				customer.setCusId(rs.getInt("cus_id"));
				customer.setCusName(rs.getString("cus_name"));
				customer.setCusUsername(rs.getString("cus_username"));
				customer.setCusPassword(rs.getString("cus_password"));
				customer.setCusPhnNo(rs.getString("cus_phn_no"));
				customer.setCusEmail(rs.getString("cus_email"));
				return customer;
				
			}
		});
				return customerList.get(0);
	}
	public String authenticate(String user,String pwd) {
		String cmd = "select count(*) cnt from Customer where Cus_UserName=? "
				+ " AND Cus_Password=?";
		List str=jdbc.query(cmd,new Object[] {user,pwd}, new RowMapper() {

			
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getInt("cnt");
			}
			
		});
		return str.get(0).toString();
	}
}
