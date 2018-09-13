package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.build.BerlinClockTimeBuilderTest;
import com.ubs.opsit.interviews.convert.BerlinClockTimeConverterTest;
import com.ubs.opsit.interviews.parse.InputTimeParserTest;
import com.ubs.opsit.interviews.print.BerlinClockTimePrinterTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({InputTimeParserTest.class,
					 BerlinClockTimeBuilderTest.class,
		             BerlinClockTimeConverterTest.class,
					 BerlinClockTimePrinterTest.class})
public class BerlinClockTests {
}
