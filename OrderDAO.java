package com.example.cms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO {

	@Autowired  
    JdbcTemplate jdbc;  
	
	public Orders searchByOrderId(int ordId) {
		String cmd = "select * from Orders where ord_id=?";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {ordId}, new RowMapper<Orders>() {

			
			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setOrd_id(rs.getInt("ORD_ID"));
				orders.setCus_id(rs.getInt("CUS_ID"));
				orders.setVen_Id(rs.getInt("VEN_ID"));
				orders.setWal_source(rs.getString("WAL_SOURCE"));
				orders.setMen_id(rs.getInt("MEN_ID"));
				orders.setOrd_date(rs.getDate("ORD_DATE"));
				orders.setOrd_quantity(rs.getInt("ord_quantity"));
				orders.setOrd_billamount(rs.getDouble("ORD_BILLAMOUNT"));
				orders.setOrd_status(rs.getString("ORD_STATUS"));
				orders.setOrd_comments(rs.getString("ORD_COMMENTS"));
				return orders;
			}
			
		});
		return ordersList.get(0);
	}
	
	public String updateStatus(int ordId,String ordStatus) {
		String cmd = "Update Orders set ORD_STATUS=? WHERE ord_Id=?";
		jdbc.update(cmd, new Object[] {ordStatus,ordId});
		return "Order Accepted...";
	}
	
	
	public List<Orders> showVendorPendingOrders(int venId) {
		String cmd = "select * from Orders where ORD_STATUS='PENDING' AND ven_id=?";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {venId}, new RowMapper<Orders>() {

			
			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setOrd_id(rs.getInt("ORD_ID"));
				orders.setCus_id(rs.getInt("CUS_ID"));
				orders.setVen_Id(rs.getInt("VEN_ID"));
				orders.setWal_source(rs.getString("WAL_SOURCE"));
				orders.setMen_id(rs.getInt("MEN_ID"));
				orders.setOrd_date(rs.getDate("ORD_DATE"));
				orders.setOrd_quantity(rs.getInt("ord_quantity"));
				orders.setOrd_billamount(rs.getDouble("ORD_BILLAMOUNT"));
				orders.setOrd_status(rs.getString("ORD_STATUS"));
				orders.setOrd_comments(rs.getString("ORD_COMMENTS"));
				return orders;
			}
			
		});
		return ordersList;
	}
	
	public List<Orders> showVendorOrders(int venId) {
		String cmd = "select * from Orders where ven_id=?";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {venId}, new RowMapper<Orders>() {

			
			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setOrd_id(rs.getInt("ORD_ID"));
				orders.setCus_id(rs.getInt("CUS_ID"));
				orders.setVen_Id(rs.getInt("VEN_ID"));
				orders.setWal_source(rs.getString("WAL_SOURCE"));
				orders.setMen_id(rs.getInt("MEN_ID"));
				orders.setOrd_date(rs.getDate("ORD_DATE"));
				orders.setOrd_quantity(rs.getInt("ord_quantity"));
				orders.setOrd_billamount(rs.getDouble("ORD_BILLAMOUNT"));
				orders.setOrd_status(rs.getString("ORD_STATUS"));
				orders.setOrd_comments(rs.getString("ORD_COMMENTS"));
				return orders;
			}
			
		});
		return ordersList;
	}
	
	public List<Orders> showCustomerOrders(int custId) {
		String cmd = "select * from Orders where  cus_id=?";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {custId}, new RowMapper<Orders>() {

			
			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setOrd_id(rs.getInt("ORD_ID"));
				orders.setCus_id(rs.getInt("CUS_ID"));
				orders.setVen_Id(rs.getInt("VEN_ID"));
				orders.setWal_source(rs.getString("WAL_SOURCE"));
				orders.setMen_id(rs.getInt("MEN_ID"));
				orders.setOrd_date(rs.getDate("ORD_DATE"));
				orders.setOrd_quantity(rs.getInt("ord_quantity"));
				orders.setOrd_billamount(rs.getDouble("ORD_BILLAMOUNT"));
				orders.setOrd_status(rs.getString("ORD_STATUS"));
				orders.setOrd_comments(rs.getString("ORD_COMMENTS"));
				return orders;
			}
			
		});
		return ordersList;
	}
	public List<Orders> showCustomerPendingOrders(int custId) {
		String cmd = "select * from Orders where ORD_STATUS='PENDING' AND cus_id=?";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {custId}, new RowMapper<Orders>() {

			
			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setOrd_id(rs.getInt("ORD_ID"));
				orders.setCus_id(rs.getInt("CUS_ID"));
				orders.setVen_Id(rs.getInt("VEN_ID"));
				orders.setWal_source(rs.getString("WAL_SOURCE"));
				orders.setMen_id(rs.getInt("MEN_ID"));
				orders.setOrd_date(rs.getDate("ORD_DATE"));
				orders.setOrd_quantity(rs.getInt("ord_quantity"));
				orders.setOrd_billamount(rs.getDouble("ORD_BILLAMOUNT"));
				orders.setOrd_status(rs.getString("ORD_STATUS"));
				orders.setOrd_comments(rs.getString("ORD_COMMENTS"));
				return orders;
			}
			
		});
		return ordersList;
	}
}
