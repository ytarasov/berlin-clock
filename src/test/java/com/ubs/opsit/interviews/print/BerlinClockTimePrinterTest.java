package com.ubs.opsit.interviews.print;

import com.ubs.opsit.interviews.build.BerlinClockTimeHolder;
import com.ubs.opsit.interviews.util.BerlinClockTimeHolderUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BerlinClockTimePrinterTest {
	
	private BerlinClockTimePrinter berlinClockTimePrinter = new BerlinClockTimePrinter();

	private BerlinClockTimeHolderUtil berlinClockTimeHolderUtil = new BerlinClockTimeHolderUtil();
	
	@Test
	public void printMidnightBerlinClockTimeTest() {
		BerlinClockTimeHolder berlinClockTimeHolder = berlinClockTimeHolderUtil.createLightOffBerlinClockTimeHolder();
		String result = berlinClockTimePrinter.printBerlinClockTime(berlinClockTimeHolder);
		assertEquals("O\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO", result);
	}

	@Test
	public void printMiddayBerlinClockTimeTest() {
		BerlinClockTimeHolder berlinClockTimeHolder =
				berlinClockTimeHolderUtil.createBerlinClockTimeHolder(true,2,2,0,0);
		String result = berlinClockTimePrinter.printBerlinClockTime(berlinClockTimeHolder);
		assertEquals("Y\r\nRROO\r\nRROO\r\nOOOOOOOOOOO\r\nOOOO", result);
	}

	@Test
	public void printBerlinClockTimeTest() {
		BerlinClockTimeHolder berlinClockTimeHolder =
				berlinClockTimeHolderUtil.createBerlinClockTimeHolder(true,3,2,7,1);
		String result = berlinClockTimePrinter.printBerlinClockTime(berlinClockTimeHolder);
		assertEquals("Y\r\nRRRO\r\nRROO\r\nYYRYYRYOOOO\r\nYOOO", result);
	}
	
}
