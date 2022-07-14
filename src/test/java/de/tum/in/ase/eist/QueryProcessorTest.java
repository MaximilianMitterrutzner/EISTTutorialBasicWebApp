package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class QueryProcessorTest {

	private final QueryProcessor queryProcessor = new QueryProcessor();

	@Test
	void testEmptyStringIfCannotProcessQuery() {
		assertEquals("", queryProcessor.process("test"));
	}

	@Test
	void testKnowsAboutShakespeare() {
		String actual = queryProcessor.process("Shakespeare");
		if (!actual.contains("playwright")) {
			fail("The QueryProcessor does not know about Shakespeare.");
		}
	}

	@Test
	void testLargest() {
		String actual = queryProcessor.process("87cffa10: which of the following numbers is the largest: 792, 57, 14, 468");
		if (!actual.contains("792")) {
			fail("The QueryProcessor does not know the largest.");
		}
	}

	@Test
	void testPlus() {
		String actual = queryProcessor.process("31dee650: what is 12 plus 7");
		if (!actual.contains("19")) {
			fail("The QueryProcessor does not know plus.");
		}
	}

	@Test
	void testSquareCube() {
		String actual = queryProcessor.process("7a075720: which of the following numbers is both a square and a cube: 46656, 996, 354, 531441");
		System.out.println("|" + actual + "|");
		if(!actual.contains("46656")
		|| !actual.contains("531441")) {
			fail("The QueryProcessor does not know square cube.");
		}
	}

	@Test
	void testFibo() {
		String actual = queryProcessor.process("297e18d0: what is the 17th number in the Fibonacci sequence");
		if(!actual.contains("1597")) {
			System.out.println(actual);
			fail("The QueryProcessor does not know fibo.");
		}
	}

	@Test
	void testPower() {
		String actual = queryProcessor.process("2032c9a0: what is 5 to the power of 4");
		if(!actual.contains("625")) {
			System.out.println(actual);
			fail("The QueryProcessor does not know fibo.");
		}
	}

	@Test
	void isNotCaseSensitive() {
		String actual = queryProcessor.process("shakespeare");
		if (!actual.contains("playwright")) {
			fail("Your QueryProcessor should not be case sensitive.");
		}
	}

}
