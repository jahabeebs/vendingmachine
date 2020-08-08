package com.techelevator.view;
import org.junit.Assert;
import org.junit.Test;

import com.techelevator.Drink;

public class DrinkTest {

	
	@Test
	public void returnsGlug() {
		Assert.assertEquals("Glug glug, Yum!", Drink.getMessage());
	}
	
}
