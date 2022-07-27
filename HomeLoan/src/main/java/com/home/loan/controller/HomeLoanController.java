package com.home.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.loan.model.HomeLoan;
import com.home.loan.service.HomeLoanService;


@RestController
public class HomeLoanController 
{
	private static final String DELETED = "Loan Details Deleted Successfully";
	
	private static final String SAVED = "Loan Details Saved Successfully";

	private static final String UPDATED = "Loan Details updated Successfully";


	
	@Autowired
	 HomeLoanService homeLoanService;
	
	@GetMapping("/health")
	 public String health() {
		 System.out.println("Test ting in the health url dgsfg ");
	     return "OK Health are fine kindly checks the  other end points";
	 }
	
	 @GetMapping("/listOfLoans")
	 public List<HomeLoan> getAllLoans() {
	     return homeLoanService.getAllLoans();
	 }
	 
	 
	 @PostMapping("/saveLoan")
	 public String saveLoan(@RequestBody HomeLoan loan) {
		 homeLoanService.addLoan(loan);
		return SAVED;
	 }
	 
	 @PutMapping("/updateLoan")
	 public String updateLoan(@RequestBody HomeLoan loan) {
		 homeLoanService.UpdateLoan(loan);
		return UPDATED;
	 }
	      
	 @DeleteMapping("/deleteLoan")
	 public String deleteLoan(@RequestParam Long id) {
		 homeLoanService.DeleteLoan(id);
		 
		 return DELETED;
	 }
	      
}
