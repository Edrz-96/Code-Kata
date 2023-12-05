package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	@Test
	public void addSimpleTest() {
		assertEquals(2, StringCalculator.add("1,1"));
	}

	@Test
	public void addIsEmptyTest() {
		assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public void addMultipleInteger() {
		assertEquals(30, StringCalculator.add("1,22,3,4,"));
	}

//	3
//	i
	@Test
	public void addNewLineTest() {
		assertEquals(6, StringCalculator.add("1\n2,3"));
	}

//	5
//	i
	@Test
	public void addExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			assertEquals(0, StringCalculator.add("-1, -2"));
		});
	}

//	6
//  i
	@Test
	public void addIgnoreOneThousand() {
		assertEquals(5, StringCalculator.add("1015,2,3"));

	}

// 7,8,9
	@Test
	public void addCustomDelimeterTest() {
		assertEquals(6, StringCalculator.add("//;\n1,2;3"));
	}

	@Test
	public void addAdditionalDelimterTest() {
		assertEquals(6, StringCalculator.add("//[|||]\n1|||2|||3"));

	}

}
