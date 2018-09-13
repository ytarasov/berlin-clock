package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.build.BerlinClockTimeBuilder;
import com.ubs.opsit.interviews.convert.BerlinClockTimeConverter;
import com.ubs.opsit.interviews.build.BerlinClockTimeHolder;
import com.ubs.opsit.interviews.parse.InputTimeFormatException;
import com.ubs.opsit.interviews.parse.InputTimeHolder;
import com.ubs.opsit.interviews.parse.InputTimeParser;
import com.ubs.opsit.interviews.print.BerlinClockTimePrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of TimeConverter interface for Berlin clock
 * @author Yurii Tarasov
 *
 */
public class CommonTimeConverter implements TimeConverter {

    private InputTimeParser inputTimeParser = new InputTimeParser();

    private BerlinClockTimeBuilder berlinClockTimeBuilder = new BerlinClockTimeBuilder();

    private BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter(berlinClockTimeBuilder.create());

    private BerlinClockTimePrinter berlinClockTimePrinter = new BerlinClockTimePrinter();

    private static final Logger LOG = LoggerFactory.getLogger(CommonTimeConverter.class);

    private static final String CONVERT_INFO_MESSAGE = "Convert input time to Berlin clock time format";

    private static final String CONVERT_ERROR_MESSAGE = "Error has been occurred during Berlin clock time converting. Reason: %s";

    @Override
    public String convertTime(String aTime) {
        try {
            LOG.info(CONVERT_INFO_MESSAGE);
            InputTimeHolder inputTimeHolder = inputTimeParser.parse(aTime);
            BerlinClockTimeHolder berlinClockTimeHolder = berlinClockTimeConverter.convertToBerlinClockTime(inputTimeHolder);
            return berlinClockTimePrinter.printBerlinClockTime(berlinClockTimeHolder);
        } catch (InputTimeFormatException e) {
            String errorMessage = String.format(CONVERT_ERROR_MESSAGE, e.getMessage());
            LOG.error(errorMessage);
            return errorMessage;
        }
     }

}
