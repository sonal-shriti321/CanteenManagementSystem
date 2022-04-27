package com.example.cms;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private OrderService service;
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/acceptOrRejectOrder/{ordId}/{venId}/{status}")
	public String acceptOrReject(@PathVariable int ordId,@PathVariable int venId, 
			@PathVariable String status) {
		return service.acceptOrRejectOrder(ordId, venId, status);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/placeOrder")
	public String add(@RequestBody Orders orders) {
		return service.placeOrder(orders);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/customerPendingOrders/{cid}")
	public List<Orders> customerPendingOrders(@PathVariable int cid) {
		return service.showCustomerPendingOrders(cid);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/customerOrders/{cid}")
	public List<Orders> customerOrders(@PathVariable int cid) {
		return service.showCustomerOrders(cid);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/vendorPendingOrders/{vid}")
	public List<Orders> vendorPendingOrders(@PathVariable int vid) {
		return service.showVendorPendingOrders(vid);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/vendorOrders/{vid}")
	public List<Orders> vendorOrders(@PathVariable int vid) {
		return service.showVendorOrders(vid);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/showorders")
	public List<Orders> list() {
		return service.showOrders();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	
	@RequestMapping("/order/{id}")
	public ResponseEntity<Orders> get(@PathVariable int id) {
		try {
		Orders orders = service.search(id);
		return new ResponseEntity<Orders>(orders,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
		}
	}
}
