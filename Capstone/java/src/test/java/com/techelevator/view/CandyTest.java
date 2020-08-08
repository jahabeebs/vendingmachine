package com.techelevator.view;
import org.junit.Assert;
import org.junit.Test;

import com.techelevator.Candy;

public class CandyTest {

	
	@Test
	public void returnsMunch() {
		Assert.assertEquals("Munch Munch, Yum!", Candy.getMessage());
	}
	
}
