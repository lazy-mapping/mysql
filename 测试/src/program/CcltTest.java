package program;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CcltTest {
	 private static Cclt calculator = new Cclt();

	@Before
	public void setUp() throws Exception {
		  calculator.clear();
	}

	@Test
	public void testAdd() {
		   calculator.add(2);
	        calculator.add(3);
	        assertEquals(5, calculator.getResult());

	}

	@Test
	public void testSubstract() {
		calculator.add(10);
        calculator.substract(2);
        assertEquals(8, calculator.getResult());
	}

	@Test
	public void testSquare() {
		calculator.add(10);
        calculator.square(2);
        assertEquals(20, calculator.getResult());
	}

	@Test
	public void testDivide() throws Exception {
		calculator.add(8);
        calculator.divide(2);
        assertEquals(4, calculator.getResult());
	}

}
