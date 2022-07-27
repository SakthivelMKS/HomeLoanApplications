package com.home.loan.controller.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.home.loan.controller.HomeLoanController;
import com.home.loan.model.HomeLoan;
import com.home.loan.service.HomeLoanService;

@ExtendWith(MockitoExtension.class)
public class HomeLoanControllerTests {

	@InjectMocks
	HomeLoanController homeLoanController;
	
	@Mock
	HomeLoanService homeLoanService;
	
	
	private static final String DELETED = "Loan Details Deleted Successfully";

	private static final String SAVED = "Loan Details Saved Successfully";

	private static final String UPDATED = "Loan Details updated Successfully";

	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testGetAllLoans() {
		List<HomeLoan> homeLoanMockList = getListOfHomeLoan();
		when(homeLoanController.getAllLoans()).thenReturn(homeLoanMockList);
		List<HomeLoan> homeLoanLists = homeLoanController.getAllLoans();
		assertThat(homeLoanLists.size()).isEqualTo(2);

	}

	@Test
	public void testSaveLoan() {
		HomeLoan homeLoan = getHomeLoan();
		String result = homeLoanController.saveLoan(homeLoan);
		assertEquals(SAVED,result);
	}

	@Test
	public void testUpdateLoan() {
		HomeLoan homeLoan = getHomeLoan();
		String result = homeLoanController.updateLoan(homeLoan);
		assertThat(UPDATED).isEqualTo(result);
	}

	@Test
	public void testDeleteLoan() {
		Long id = 1l;
		String result = homeLoanController.deleteLoan(id);
		assertThat(DELETED).isEqualTo(result);

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
