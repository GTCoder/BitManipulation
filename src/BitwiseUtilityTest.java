


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BitwiseUtilityTest {
	private BitwiseUtility myBitwiseUtility;

	@Before
	public void initialize() {
		this.myBitwiseUtility = new BitwiseUtility();
	}

	@Test
	public void testGetBit() {
		int num = 0;

		num = 0;
		assertEquals(false, this.myBitwiseUtility.getBit(num, 0));

		num = 1;
		assertEquals(true, this.myBitwiseUtility.getBit(num, 0));

		num = 5;
		assertEquals(true, this.myBitwiseUtility.getBit(num, 0));
		assertEquals(false, this.myBitwiseUtility.getBit(num, 1));
		assertEquals(true, this.myBitwiseUtility.getBit(num, 2));
	}

	@Test
	public void testSetBit() {
		int num = 0;

		num = 0;
		assertEquals(1, this.myBitwiseUtility.setBit(num, 0));
		assertEquals(2, this.myBitwiseUtility.setBit(num, 1));
		assertEquals(4, this.myBitwiseUtility.setBit(num, 2));
		assertEquals(
				5,
				this.myBitwiseUtility.setBit(
						this.myBitwiseUtility.setBit(num, 0), 2));

		num = 7;
		assertEquals(7, this.myBitwiseUtility.setBit(num, 1));
	}

	@Test
	public void testClearBits() {
		int num = 0;

		// Test clearLowBits()
		num = 15; // 1111
		assertEquals(14, this.myBitwiseUtility.clearLowBits(num, 0)); // 1110
		assertEquals(12, this.myBitwiseUtility.clearLowBits(num, 1)); // 1100

		// Test clearHighBits()
		num = 15; // 1111
		assertEquals(0, this.myBitwiseUtility.clearHighBits(num, 0)); // 0000
		assertEquals(1, this.myBitwiseUtility.clearHighBits(num, 1)); // 0001
		assertEquals(3, this.myBitwiseUtility.clearHighBits(num, 2)); // 0011
		
		// Test clearBits()
		num = 15; // 1111
		assertEquals(8, this.myBitwiseUtility.clearBits(num, 2, 0)); // 1000
	}
}
