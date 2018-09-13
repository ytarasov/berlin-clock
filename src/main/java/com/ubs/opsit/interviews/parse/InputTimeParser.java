package com.ubs.opsit.interviews.parse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser for input time with HH:mm:ss format
 * @author Yurii Tarasov
 *
 */
public class InputTimeParser {

    private static final String PARSE_INFO_MESSAGE = "Parsing input time...";

    private static final String INVALID_HOUR_VALUE_ERROR_MESSAGE = "Invalid hour value outside the allowed range %d";

    private static final String INVALID_MINUTE_VALUE_ERROR_MESSAGE = "Invalid minute value outside the allowed range %d";

    private static final String INVALID_SECOND_VALUE_ERROR_MESSAGE = "Invalid second value outside the allowed range %d";

    private static final String WRONG_INPUT_TIME_FORMAT_ERROR_MESSAGE = "Wrong format for input time %s";

    private static final String INPUT_TIME_FORMAT = "^(\\d{2}):(\\d{2}):(\\d{2})$";

    private final Pattern pattern = Pattern.compile(INPUT_TIME_FORMAT);

    private static final Logger LOG = LoggerFactory.getLogger(InputTimeParser.class);

    /**
     * Parse input time to holder with hour, minute and second values
     * @param aTime - input time in format HH:mm:ss
     * @return - holder with hour, minute and second values
     * @throws InputTimeFormatException -
     *                  Produced during wrong input time processing
     */
    public InputTimeHolder parse(String aTime) throws InputTimeFormatException {
        LOG.debug(PARSE_INFO_MESSAGE);

        InputTimeHolder inputTimeHolder = new InputTimeHolder();

        Matcher matcher = pattern.matcher(aTime);
        if (!matcher.find()) {
            throw new InputTimeFormatException(String.format(WRONG_INPUT_TIME_FORMAT_ERROR_MESSAGE, aTime));
        }

        int hour = Integer.valueOf(matcher.group(1));
        int minute = Integer.valueOf(matcher.group(2));
        int second = Integer.valueOf(matcher.group(3));

        if (hour > 24) {
            throw new InputTimeFormatException(String.format(INVALID_HOUR_VALUE_ERROR_MESSAGE, hour));
        }
        if (minute > 60) {
            throw new InputTimeFormatException(String.format(INVALID_MINUTE_VALUE_ERROR_MESSAGE, minute));
        }
        if (second > 60) {
            throw new InputTimeFormatException(String.format(INVALID_SECOND_VALUE_ERROR_MESSAGE, second));
        }

        inputTimeHolder.setHour(hour);
        inputTimeHolder.setMinute(minute);
        inputTimeHolder.setSecond(second);

        return inputTimeHolder;
    }

}
