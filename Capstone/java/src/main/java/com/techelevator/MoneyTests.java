package com.techelevator;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MoneyTests {


	@Before
	public void setup() throws FileNotFoundException {
		Items.readFiles();
		Money.balance.multiply(new BigDecimal(0.00));
	}

	
	@Test
	public void feedMoneyTest() throws Exception {
		Money test = new Money();
		Money.feedMoney("$1 Bill");
		Assert.assertTrue(new BigDecimal(1.00).compareTo(Money.getBalance())==0);
		Money.feedMoney("$2 Bill");
		Assert.assertTrue(new BigDecimal(3.00).compareTo(Money.getBalance())==0);
		Money.feedMoney("$5 Bill");
		Assert.assertTrue(new BigDecimal(8.00).compareTo(Money.getBalance())==0);
	}
	@Test
	public void buyItemTest() throws Exception {		
		Money test2 = new Money();
		Money.feedMoney("$1 Bill");
		Money.feedMoney("$2 Bill");
		Money.buyItem("C2");
		Money.buyItem("C4");
		Assert.assertTrue(new BigDecimal(0.00).compareTo(Money.balance)==0);
	}
	
	@Test
	public void makeChangeTest() throws FileNotFoundException {
		Money test3 = new Money();
		Money.feedMoney("$2 Bill");
		Money.makeChange(Money.balance);
		Assert.assertTrue(new BigDecimal(0.00).compareTo(Money.balance)==0);
	}
	
	
	
}
