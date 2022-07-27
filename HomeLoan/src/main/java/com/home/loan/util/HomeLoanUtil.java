package com.home.loan.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.home.loan.model.HomeLoan;

@Component
public class HomeLoanUtil {

	private static final String DATETIMEFORMATTER = "yyMMddHHmmss";

	private static StringBuffer getRandomnumber() {
		StringBuffer random = new StringBuffer();

		Random r = new Random();
		int randomInt = r.nextInt(10000) + 1;
		System.out.println(randomInt);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATETIMEFORMATTER);
		LocalDateTime now = LocalDateTime.now();
		String currentDateTime = dtf.format(now);
		random.append(randomInt).append(currentDateTime);
		return random;
	}

	public static void setLoanNumber(HomeLoan homeloan) {
		StringBuffer loanNmumber = new StringBuffer();
		String fourChar = homeloan.getFirstName().substring(0, 4);
		StringBuffer randonumber = null;
		try {
			randonumber = getRandomnumber();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loanNmumber.append(fourChar).append(randonumber);
		System.out.println(loanNmumber.toString());
		java.util.Date date = new java.util.Date();
		System.out.println(new Timestamp(date.getTime()));
		homeloan.setCreatedTime(new Timestamp(date.getTime()));
		homeloan.setUpdatedTime(new Timestamp(date.getTime()));
		homeloan.setLoanNumber(loanNmumber.toString());
	}

	public static void setUpdateTime(HomeLoan homeloan) {
		java.util.Date date = new java.util.Date();
		homeloan.setUpdatedTime(new Timestamp(date.getTime()));
	}

}
