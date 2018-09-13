package com.ubs.opsit.interviews.parse;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputTimeParserTest {

	private InputTimeParser inputTimeParser = new InputTimeParser();
	
	@Test
	public void parseHourTest() throws InputTimeFormatException {
		InputTimeHolder inputTimeHolder = inputTimeParser.parse("16:53:29");
		assertEquals(16, inputTimeHolder.getHour());
	}

	@Test
	public void parseMinuteTest() throws InputTimeFormatException {
		InputTimeHolder inputTimeHolder = inputTimeParser.parse("12:19:21");
		assertEquals(19, inputTimeHolder.getMinute());
	}

	@Test
	public void parseSecondTest() throws InputTimeFormatException {
		InputTimeHolder inputTimeHolder = inputTimeParser.parse("07:33:42");
		assertEquals(42, inputTimeHolder.getSecond());
	}

	@Test
	public void parseWrongHourTest() {
		try {
			inputTimeParser.parse("54:53:29");
		} catch (InputTimeFormatException e) {
			assertEquals(e.getMessage(), "Invalid hour value outside the allowed range 54");
		}
	}

	@Test
	public void parseWrongMinuteTest() {
		try {
			inputTimeParser.parse("05:77:29");
		} catch (InputTimeFormatException e) {
			assertEquals(e.getMessage(), "Invalid minute value outside the allowed range 77");
		}
	}

	@Test
	public void parseWrongSecondTest() {
		try {
			inputTimeParser.parse("22:03:82");
		} catch (InputTimeFormatException e) {
			assertEquals(e.getMessage(), "Invalid second value outside the allowed range 82");
		}
	}
	
}
