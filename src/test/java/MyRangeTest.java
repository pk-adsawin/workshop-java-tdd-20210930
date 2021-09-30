
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyRangeTest {
	@Test
	@DisplayName("ตัวแรกต้องเป็น [ (include)  โดยที่ [1,5], result=true")
	public void test01() {
		// Arange
		String input = "[1,5]";
		MyRange range = new MyRange(input);
		boolean result = range.startWithInclude();
		assertTrue(result);
	}

	@Test
	@DisplayName("ตัวแรกต้องเป็น [ (include) โดยที่ input = (1,5], result = false")
	public void case02() {
		// Arrange
		String input = "(1,5]";
		MyRange range = new MyRange(input);
		boolean result = range.startWithInclude();
		assertFalse(result);
	}

	@Test
	@DisplayName("ตัวเลขเริ่มต้น เป็น 1 input = [1,5], result = 1")
	public void case03() {
		String input = "[1,5]";
		MyRange range = new MyRange(input);
		int result = range.getStart();
		assertEquals(1, result);
	}

	@Test
	@DisplayName("ตัวเลขเริ่มต้น เป็น 1 input = (1,5], result = 2")
	public void case04() {
		String input = "(1,5]";
		MyRange range = new MyRange(input);
		int result = range.getStart();
		assertEquals(2, result);
	}
}
