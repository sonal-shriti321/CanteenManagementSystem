package com.example.cms;



import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Orders, Integer>{

//	List<Orders> customerOrders(int cusId);
//	List<Orders> vendorOrders(int venId);;
}
