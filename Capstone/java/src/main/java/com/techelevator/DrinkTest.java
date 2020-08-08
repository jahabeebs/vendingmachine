package com.techelevator;
import org.junit.Assert;
import org.junit.Test;

public class DrinkTest {

	
	@Test
	public void returnsGlug() {
		Assert.assertEquals("Glug glug, Yum!", Drink.getMessage());
	}
	
}
