package assignment1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class PieGeneratorTest {

	@Test
	public void testSum() {
		PieGenerator p = new PieGenerator();

		int[] nullArray = null;
		assertEquals(0, p.sum(nullArray));

		int[] emptyArray = {};
		assertEquals(0, p.sum(emptyArray));

		int[] taxi = {10, 70, 20, 90};
		assertEquals(190, p.sum(taxi));

		int[] largeArray = new int[1000];
		for(int i=0; i < largeArray.length; i++) {
			largeArray[i] = i+1;
		}

		assertEquals(1000*1001/2, p.sum(largeArray));

	}

	@Test
	public void testHighestIndex() {
		PieGenerator p = new PieGenerator();

		int[] nullArray = null;
		assertEquals(-1, p.highestIndex(nullArray));

		int[] emptyArray = {};
		assertEquals(-1, p.highestIndex(emptyArray));

		int[] taxi = {10, 70, 20, 90, 20, 90};
		assertEquals(3, p.highestIndex(taxi));

		int[] largeArray = new int[1000];
		for(int i=0; i < largeArray.length; i++) {
			largeArray[i] = i+1;
		}

		assertEquals(999, p.highestIndex(largeArray));

		for(int i=0; i < largeArray.length; i++) {
			largeArray[i] = -i;
		}

		assertEquals(0, p.highestIndex(largeArray));
	}

	@Test
	public void testSmallestIndex() {
		PieGenerator p = new PieGenerator();

		int[] nullArray = null;
		assertEquals(-1, p.smallestIndex(nullArray));

		int[] emptyArray = {};
		assertEquals(-1, p.smallestIndex(emptyArray));

		int[] taxi = {10, 70, 20, 90, 20, 90};
		assertEquals(0, p.smallestIndex(taxi));

		int[] taxi2 = {50, 70, 20, 90, 20, 90};
		assertEquals(2, p.smallestIndex(taxi2));

		int[] largeArray = new int[1000];
		for(int i=0; i < largeArray.length; i++) {
			largeArray[i] = i+1;
		}

		assertEquals(0, p.smallestIndex(largeArray));

		for(int i=0; i < largeArray.length; i++) {
			largeArray[i] = -i;
		}

		assertEquals(999, p.smallestIndex(largeArray));
	}

	@Test
	public void testMySort() {
		PieGenerator p = new PieGenerator();

		int[] nullArray = null;
		p.mySort(nullArray); //should not throw NullPointerException

		int[] emptyArray = {};
		p.mySort(emptyArray); //should not throw NullPointerException

		int[] taxi = {10, 70, 20, 90, 20, 90};
		p.mySort(taxi);

		assertNotNull(taxi);
		assertEquals("[10, 20, 20, 70, 90, 90]", Arrays.toString(taxi));

		int[] taxi2 = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};
		p.mySort(taxi2);

		assertNotNull(taxi2);
		assertEquals("[10, 20, 30, 40, 50, 60, 70, 80, 90, 100]", Arrays.toString(taxi2));
	}

	@Test
	public void testRemoveItem() {
		PieGenerator p = new PieGenerator();

		int[] nullArray = null;
		int[] a = p.removeItem(nullArray, 0); //should not throw NullPointerException
		assertNull(a);

		int[] emptyArray = {};
		int[] b = p.removeItem(emptyArray, 0); //should not throw NullPointerException
		assertNotNull(b);
		assertEquals("[]", Arrays.toString(b));

		int[] taxi = {10, 70, 20, 90, 20, 90};
		int[] c = p.removeItem(taxi, 0);
		assertEquals("[70, 20, 90, 20, 90]", Arrays.toString(c));

		int[] d = p.removeItem(c, 4);
		assertEquals("[70, 20, 90, 20]", Arrays.toString(d));

		int[] e = p.removeItem(d, 4);
		assertEquals("[70, 20, 90, 20]", Arrays.toString(e)); //unchanged because 4 is out of bounds for array d

		int[] f = p.removeItem(d, -1);
		assertEquals("[70, 20, 90, 20]", Arrays.toString(f)); //unchanged because 4 is out of bounds for array d
	}

}
