package com.example.cms;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {
	@Autowired
	VendorService service;
	@CrossOrigin(origins = "http://localhost:4200/")
	@RequestMapping("/showVendor")
	public List<Vendor> showVendor() throws ClassNotFoundException, SQLException{
		return service.showVendor();
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@RequestMapping("/vendorAuthenticate/{user}/{pwd}")
	public String autneticateion(@PathVariable String user, @PathVariable String pwd) {
		return service.authenticate(user, pwd);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/vendor/{id}")
	public ResponseEntity<Vendor> get(@PathVariable int id) {
		try {
		Vendor vendor = service.search(id);
		return new ResponseEntity<Vendor>(vendor,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/searchByvendorUsername/{user}")
	public ResponseEntity<Vendor> searchByVendorUser(@PathVariable String user) {
		try {
		Vendor vendor = service.searchByVendorUserName(user);
		return new ResponseEntity<Vendor>(vendor,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		}
	} 
	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@RequestMapping("/vendor/{username}")
//	public ResponseEntity<Vendor> get(@PathVariable String username) {
//		try {
//		Vendor vendor = service.searchByVendorUserName(username);
//		return new ResponseEntity<Vendor>(vendor,HttpStatus.OK);
//		} catch(NoSuchElementException e) {
//			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
//		}
//	}
	
	
	

}



	
	
	

	
