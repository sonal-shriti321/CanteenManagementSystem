package com.example.cms;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class VendorService {
    
	@Autowired
	VendorDAO dao;
	@Autowired
    private VendorRepository repo;
	public List<Vendor> showVendor() throws ClassNotFoundException, SQLException{
		return dao.showVendor();
	}
	public String authenticate(String user,String pwd) {
		return dao.authenticate(user, pwd);
	}
	public Vendor search(int venId) {
		return repo.findById(venId).get();
	}
	public Vendor searchByVendorUserName(String username) {
		return dao.searchByVendorUserName(username);
	}
	
	
}
