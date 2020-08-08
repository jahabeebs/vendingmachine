package com.techelevator.view;
import org.junit.Assert;
import org.junit.Test;

import com.techelevator.Chips;

public class ChipsTest {

	
	@Test
	public void returnsCrunch() {
		Assert.assertEquals("Crunch Crunch, Yum!", Chips.getMessage());
	}
	
}
