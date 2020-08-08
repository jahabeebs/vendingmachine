package com.techelevator;
import org.junit.Assert;
import org.junit.Test;

public class ChipsTest {

	
	@Test
	public void returnsCrunch() {
		Assert.assertEquals("Crunch Crunch, Yum!", Chips.getMessage());
	}
	
}
