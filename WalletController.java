package com.example.cms;

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
public class WalletController {

	@Autowired
	private WalletService walletService;
	@CrossOrigin(origins = "http://localhost:4200/")
	@RequestMapping("/showCustomerWallet/{id}")
	public List<Wallet> getCustomerWallet(@PathVariable int id) {
		return walletService.showCustomerWallets(id);
	}
	@CrossOrigin(origins = "http://localhost:4200/")
	@RequestMapping("/wallet/{id}")
	public ResponseEntity<Wallet> get(@PathVariable int id) {
		try {
		Wallet wallet = walletService.search(id);
		return new ResponseEntity<Wallet>(wallet,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Wallet>(HttpStatus.NOT_FOUND);
		}
	}
}
