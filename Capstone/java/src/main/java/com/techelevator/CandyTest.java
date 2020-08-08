package com.techelevator;
import org.junit.Assert;
import org.junit.Test;

public class CandyTest {

	
	@Test
	public void returnsMunch() {
		Assert.assertEquals("Munch Munch, Yum!", Candy.getMessage());
	}
	
}
