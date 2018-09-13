package com.ubs.opsit.interviews.convert;

import com.ubs.opsit.interviews.build.BerlinClockTimeHolder;
import com.ubs.opsit.interviews.build.Lamp;
import com.ubs.opsit.interviews.parse.InputTimeHolder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

/**
 * Class converter of input time to Berlin clock time model(holder)
 * @author Yurii Tarasov
 *
 */
public class BerlinClockTimeConverter {

    private BerlinClockTimeHolder berlinClockTimeHolder;

    private static final Logger LOG = LoggerFactory.getLogger(BerlinClockTimeConverter.class);

    private static final String CONVERT_BERLIN_CLOCK_TIME_MESSAGE = "Converting to Berlin clock model time holder...";

    /** Constructor for BerlinClockTimeConverter
     * @param berlinClockTimeHolder - empty(light off) instance of Berlin clock model
     */
    public BerlinClockTimeConverter(BerlinClockTimeHolder berlinClockTimeHolder) {
        this.berlinClockTimeHolder = berlinClockTimeHolder;
    }

    /**
     * Convert input time stored in InputTimeHolder to Berlin clock model instance
     * @param inputTimeHolder - holder with values of hour, minute and second
     * @return updated BerlinClockTimeHolder instance
     */
    public BerlinClockTimeHolder convertToBerlinClockTime(InputTimeHolder inputTimeHolder) {
        LOG.debug(CONVERT_BERLIN_CLOCK_TIME_MESSAGE);
        Lamp topLamp = berlinClockTimeHolder.getTopLamp();
        Lamp[] topHourRowLamps = berlinClockTimeHolder.getTopHourLampRow();
        Lamp[] bottomHourRowLamps = berlinClockTimeHolder.getBottomHourLampRow();
        Lamp[] topMinuteRowLamps = berlinClockTimeHolder.getTopMinuteLampRow();
        Lamp[] bottomMinuteRowLamps = berlinClockTimeHolder.getBottomMinuteLampRow();

        int hours = inputTimeHolder.getHour();
        int minutes = inputTimeHolder.getMinute();
        int seconds = inputTimeHolder.getSecond();

        topLamp.setLightOn(seconds % 2 == 0);

        setTime(topHourRowLamps, hours / 5);
        setTime(bottomHourRowLamps, hours % 5);
        setTime(topMinuteRowLamps, minutes / 5);
        setTime(bottomMinuteRowLamps, minutes % 5);

        return berlinClockTimeHolder;
    }

    private void setTime(Lamp[] rowLamps, int lightOnLampNumber) {
        IntStream.range(0, rowLamps.length).forEach(i -> {
            boolean isLightOn = false;
            if (i < lightOnLampNumber) {
                isLightOn = true;
            }
            rowLamps[i].setLightOn(isLightOn);
        });
    }

}
