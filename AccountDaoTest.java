package com.capgemini.wallet.tcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

import com.capgemini.wallet.bean.Account;
import com.capgemini.wallet.dao.AccountDao;
import com.capgemini.wallet.exception.WalletException;

class AccountDaoTest {
	AccountDao dao=new AccountDao();
	@Test
	public void testCreateAccount() throws WalletException {
		Account acOpen=new Account();
		acOpen.setAccNo(10123);
		acOpen.setName("Mayank");
		acOpen.setAge(20);
		acOpen.setMobileNo("9803538343");
		acOpen.setBalance(5000);
		acOpen.setPin(3434);
		boolean result=dao.createAccount(acOpen);
		assertTrue(result);
	}
	@Test
	public void testCheckBalance() throws WalletException
	{
		Account acOpen=new Account();
		int expected_result=100000;
		int actual_result=dao.checkBalance(9);
		assertEquals(expected_result,actual_result);
	}
	@Test
	public void testAddBalance() throws WalletException
	{
		boolean result=dao.addBalance(101,2000);
		assertTrue(result);
	}
	//@Test
	public void testFundTransfer() throws WalletException
	{
		boolean result=dao.fundTransfer(101,1,500,1234);
		assertTrue(result);
	}
	
}
