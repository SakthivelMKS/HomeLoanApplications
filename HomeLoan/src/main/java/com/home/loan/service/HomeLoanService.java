package com.home.loan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.home.loan.model.HomeLoan;
import com.home.loan.repository.HomeLoanRepository;
import com.home.loan.util.HomeLoanUtil;

@Component
@Service
public class HomeLoanService {
	
	@Autowired    
	private HomeLoanRepository homeLoanRepository;  
	
	@Autowired    
	private HomeLoanUtil homeLoanUtil;
	
	public List<HomeLoan> getAllLoans()  
	{    
	List<HomeLoan> listOfLoans = new ArrayList();
	listOfLoans=(List<HomeLoan>) homeLoanRepository.findAll();
	return listOfLoans;    
	}    
	
	public void addLoan(HomeLoan loan)  
	{    
		HomeLoanUtil.setLoanNumber(loan);
		homeLoanRepository.save(loan);    
	}    
	
	public void DeleteLoan(Long id)  
	{    
		homeLoanRepository.deleteById(id);
	}  
	
	
	public void UpdateLoan(HomeLoan loan)  
	{    
		HomeLoanUtil.setUpdateTime(loan);
		homeLoanRepository.save(loan)  ; 
	}  

}
