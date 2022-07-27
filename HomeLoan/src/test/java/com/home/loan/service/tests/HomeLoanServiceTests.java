package com.home.loan.service.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.home.loan.model.HomeLoan;
import com.home.loan.repository.HomeLoanRepository;
import com.home.loan.service.HomeLoanService;

@ExtendWith(MockitoExtension.class)
public class HomeLoanServiceTests {

	@InjectMocks
	HomeLoanService homeLoanService;

	@Mock
	HomeLoanRepository homeLoanRepository;


	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAllLoans() {
		List<HomeLoan> homeLoanMockList = getListOfHomeLoan();

		when(homeLoanService.getAllLoans()).thenReturn(homeLoanMockList);
		List<HomeLoan> homeLoanLists = homeLoanService.getAllLoans();
		assertEquals(homeLoanLists.size(), 2);

	}

	@Test
	public void testAddLoan() {
		HomeLoan homeLoan = getHomeLoan();
		doNothing().when(homeLoanService).addLoan(homeLoan);
		verify(homeLoanService, times(1)).addLoan(homeLoan);
		
	}
	
	@Test
	public void testUpdateLoan() {
		HomeLoan homeLoan = getHomeLoan();
		doNothing().when(homeLoanService).UpdateLoan(homeLoan);
		verify(homeLoanService, times(1)).UpdateLoan(homeLoan);
		
	}

	@Test
	public void testDeleteLoan() {
		doNothing().when(homeLoanService).DeleteLoan(2l);
		verify(homeLoanService, times(1)).DeleteLoan(2l);
		
	}

	private HomeLoan getHomeLoan() {
		HomeLoan homeLoan = new HomeLoan();
		homeLoan.setLastName("K");
		homeLoan.setFirstName("Madhesan");
		homeLoan.setLoanNumber("");
		homeLoan.setMobileNumber("7010836356");
		homeLoan.setReqLoanAmount(50000000l);
		homeLoan.setReqTenureMonths(84l);
		homeLoan.setEmail("sakthipower21@gmail.com");

		return homeLoan;
	}

	private List<HomeLoan> getListOfHomeLoan() {
		List<HomeLoan> homeLaonList = new ArrayList<HomeLoan>();
		HomeLoan homeloan = new HomeLoan();
		HomeLoan homeloan1 = new HomeLoan();

		homeloan.setFirstName("Sakthivel");
		homeloan1.setFirstName("Madhesan");
		homeloan1.setLoanNumber("SAKT2207252222");
		homeloan.setLoanNumber("MADH2207252242");
		homeLaonList.add(homeloan);
		homeLaonList.add(homeloan1);
		return homeLaonList;

	}

}
