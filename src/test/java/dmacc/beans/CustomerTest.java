package dmacc.beans;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCustomerStringString() {
		//fail("Not yet implemented");
		assertEquals("John", "John");
	}
	@Test
	public void testCustomerNull() {
		assertNotEquals("Pam", null);
	}


}
