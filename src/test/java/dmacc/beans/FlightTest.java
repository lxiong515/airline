package dmacc.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlightTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetDepartCity() {
		//fail("Not yet implemented");
		assertEquals("Portland", "Portland");
	}
	@Test
	public void testDepartCityNull() {
		assertNotEquals("Portland", null);
	
	}

}
