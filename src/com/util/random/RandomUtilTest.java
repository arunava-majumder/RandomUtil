package com.util.random;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RandomUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWordNotNullWithValidInputFile() {
		assertNotNull(RandomUtil.getRandomWord());
	}

	@Test
	public void testTwoWordsNotSame() {
		String str1 = RandomUtil.getRandomWord();
		String str2 = RandomUtil.getRandomWord();
		assertNotEquals(str1, str2);
	}

}
