package com.ubs.opsit.interviews.print;

import com.ubs.opsit.interviews.build.BerlinClockTimeHolder;
import com.ubs.opsit.interviews.build.Color;
import com.ubs.opsit.interviews.build.Lamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Class for custom printing(in one String) of Berlin clock time
 * @author Yurii Tarasov
 *
 */
public class BerlinClockTimePrinter {

    private static final String LIGHT_OFF_LAMP_PRINT_VALUE = "O";

    private static final String RED_COLOR_LAMP_PRINT_VALUE = "R";

    private static final String YELLOW_COLOR_LAMP_PRINT_VALUE = "Y";

    private static final Logger LOG = LoggerFactory.getLogger(BerlinClockTimePrinter.class);

    /**
     * Convert Berlin clock model instance to string
     * @param berlinClockTimeHolder - Berlin clock model instance with information about some time
     * @return - result string with the display of all the lamps on
     */
    public String printBerlinClockTime(BerlinClockTimeHolder berlinClockTimeHolder) {
        LOG.debug("Printing to one string format...");
        StringBuilder outputFormatTimeBuilder = new StringBuilder();
        outputFormatTimeBuilder.append(convertLampToLine(berlinClockTimeHolder.getTopLamp()));
        outputFormatTimeBuilder.append(System.lineSeparator());
        outputFormatTimeBuilder.append(convertRowLampsToLine(berlinClockTimeHolder.getTopHourLampRow()));
        outputFormatTimeBuilder.append(System.lineSeparator());
        outputFormatTimeBuilder.append(convertRowLampsToLine(berlinClockTimeHolder.getBottomHourLampRow()));
        outputFormatTimeBuilder.append(System.lineSeparator());
        outputFormatTimeBuilder.append(convertRowLampsToLine(berlinClockTimeHolder.getTopMinuteLampRow()));
        outputFormatTimeBuilder.append(System.lineSeparator());
        outputFormatTimeBuilder.append(convertRowLampsToLine(berlinClockTimeHolder.getBottomMinuteLampRow()));
        return outputFormatTimeBuilder.toString();
    }

    private String convertRowLampsToLine(Lamp[] lamps) {
        return Arrays.stream(lamps).map(l -> convertLampToLine(l)).collect(Collectors.joining());
    }

    private String convertLampToLine(Lamp lamp) {
        if (lamp.isLightOn()) {
            return lamp.getColor() == Color.RED ? RED_COLOR_LAMP_PRINT_VALUE : YELLOW_COLOR_LAMP_PRINT_VALUE;
        } else {
            return LIGHT_OFF_LAMP_PRINT_VALUE;
        }
    }

}
