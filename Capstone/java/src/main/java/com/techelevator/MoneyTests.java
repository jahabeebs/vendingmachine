package com.techelevator;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class MoneyTests {
	
//	@Test
//	public void feedMoneyTest() throws Exception {
//		Money test = new Money();
//		test.feedMoney("$1 Bill");
//		Assert.assertTrue(new BigDecimal(1.00).compareTo(test.balance)==0);
//		test.feedMoney("$2 Bill");
//		Assert.assertTrue(new BigDecimal(3.00).compareTo(test.balance)==0);
//		test.feedMoney("$5 Bill");
//		Assert.assertTrue(new BigDecimal(8.00).compareTo(test.balance)==0);
//	}
	@Test
	public void buyItemTest() throws Exception {
		Money test2 = new Money();
		test2.feedMoney("$2 Bill");
		test2.buyItem("C1");
		System.out.println(test2.getBalance());
	}
	
	
	
	
}
