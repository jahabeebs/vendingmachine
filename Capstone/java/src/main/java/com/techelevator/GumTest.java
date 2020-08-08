package com.techelevator;
import org.junit.Assert;
import org.junit.Test;

public class GumTest {

	
	@Test
	public void returnsChew() {
		Assert.assertEquals("Chew Chew, Yum!", Gum.getMessage());
	}
	
}
