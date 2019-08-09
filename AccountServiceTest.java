package com.capgemini.wallet.testcases;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.capgemini.wallet.bean.Account;
import com.capgemini.wallet.dao.AccountDao;
import com.capgemini.wallet.exception.WalletException;
public class AccountServiceTest {
	
	AccountDao dao=new AccountDao();
	Account acOpen=new Account();
	@Test
	public void testStoreIntoMap() throws WalletException {
		
		acOpen.setName("Mayank");
		acOpen.setAge(20);
		acOpen.setPin(3434);
		acOpen.setBalance(5000);
		acOpen.setMobileNo("9803538343");
		boolean result=dao.storeIntoMap(acOpen);
		assertTrue(result);
	}
	@Test
	public void testCheckBalance() throws WalletException
	{
		int expected_result=5000;
		HashMap<Long,Account >map = new HashMap<>();
		Account acOpen = new Account();
		acOpen.setAccNo(1001);
		acOpen.setAge(20);
		acOpen.setPin(3434);
		acOpen.setBalance(5000);
		acOpen.setMobileNo("9803538343");	
		map.put(1001l, acOpen);
		dao.setAccountMap(map);
		int actual_result=dao.checkBalance(1001l);
		assertEquals(expected_result,actual_result);
	}
	@Test
	public void testAddBalance() throws WalletException
	{
		HashMap<Long,Account >map = new HashMap();
		Account acOpen = new Account();
		acOpen.setAccNo(1001);
		acOpen.setAge(20);
		acOpen.setPin(3434);
		acOpen.setBalance(5000);
		acOpen.setMobileNo("9803538343");	
		map.put(1001l, acOpen);
		dao.setAccountMap(map);
		boolean result=dao.addBalance(1001l,5000);
		assertTrue(result);
	}
	@Test
	public void testFundTransfer() throws WalletException
	{
		HashMap<Long,Account >map = new HashMap<>();
		Account acOpen = new Account();
		acOpen.setAccNo(1001);
		acOpen.setAge(20);
		acOpen.setPin(3434);
		acOpen.setBalance(5000);
		acOpen.setMobileNo("9803538343");	
		map.put(1001l, acOpen);
		dao.setAccountMap(map);
		//Account2 Creation
		Account acOpen2 = new Account();
		acOpen2.setAccNo(1002);
		acOpen2.setAge(22);
		acOpen2.setPin(4871);
		acOpen2.setBalance(3000);
		acOpen2.setMobileNo("9988664784");
		map.put(1002l, acOpen2);
		dao.setAccountMap(map);
		boolean result=dao.fundTransfer(1001l,1002l,1000,3434);
		assertTrue(result);
	}
}
