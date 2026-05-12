package io;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

class StringUtilsTests {
	
	private static final Pattern REGEX = Pattern.compile("[ )]");
	
	@Test
	void testNoPatternInString() {
		assertEquals(-1, StringUtils.indexOfPattern("toto", REGEX));
	}
	
	@Test
	void testPatternAtStart() {
		assertEquals(0, StringUtils.indexOfPattern(" toto", REGEX));
		assertEquals(0, StringUtils.indexOfPattern(")toto", REGEX));
	}
	
	@Test
	void testPatternAtTheEnd() {
		assertEquals(4, StringUtils.indexOfPattern("toto ", REGEX));
		assertEquals(4, StringUtils.indexOfPattern("toto)", REGEX));
	}
	
	@Test
	void testPatternInTheMiddle() {
		assertEquals(4, StringUtils.indexOfPattern("toto tata", REGEX));
		assertEquals(4, StringUtils.indexOfPattern("toto)tata", REGEX));
	}

	@Test
	void testIndexOfPatternFromIndexNoMore() {
		assertEquals(-1, StringUtils.indexOfPattern("toto tata", REGEX, 5));
		assertEquals(-1, StringUtils.indexOfPattern("to)totata", REGEX, 3));
	}
	
	@Test
	void testIndexOfPatternFromIndexAtIndex() {
		assertEquals(4, StringUtils.indexOfPattern("toto tata", REGEX, 4));
		assertEquals(2, StringUtils.indexOfPattern("to)totata", REGEX, 2));
	}
}
