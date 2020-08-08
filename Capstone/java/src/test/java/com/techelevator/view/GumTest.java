package com.techelevator.view;
import org.junit.Assert;
import org.junit.Test;

import com.techelevator.Gum;

public class GumTest {

	
	@Test
	public void returnsChew() {
		Assert.assertEquals("Chew Chew, Yum!", Gum.getMessage());
	}
	
}
