package com.ubs.opsit.interviews.util;

import com.ubs.opsit.interviews.build.BerlinClockTimeHolder;
import com.ubs.opsit.interviews.build.Color;
import com.ubs.opsit.interviews.build.Lamp;

import java.util.stream.IntStream;

/**
 * Class util for creation of Berlin Clock model instances
 * @author Yurii Tarasov
 *
 */
public class BerlinClockTimeHolderUtil {

    public BerlinClockTimeHolder createBerlinClockTimeHolder(boolean isTopLampLightOn,
                                                             int topHourLightOnLampRowNumber,
                                                             int bottomHourLightOnLampRowNumber,
                                                             int topMinuteLightOnLampRowNumber,
                                                             int bottomMinuteLightOnLampRowNumber) {
        BerlinClockTimeHolder berlinClockTimeHolder = createLightOffBerlinClockTimeHolder();
        berlinClockTimeHolder.getTopLamp().setLightOn(isTopLampLightOn);
        fillLampRowLightOn(berlinClockTimeHolder.getTopHourLampRow(), topHourLightOnLampRowNumber);
        fillLampRowLightOn(berlinClockTimeHolder.getBottomHourLampRow(), bottomHourLightOnLampRowNumber);
        fillLampRowLightOn(berlinClockTimeHolder.getTopMinuteLampRow(), topMinuteLightOnLampRowNumber);
        fillLampRowLightOn(berlinClockTimeHolder.getBottomMinuteLampRow(), bottomMinuteLightOnLampRowNumber);
        return berlinClockTimeHolder;
    }

    public BerlinClockTimeHolder createLightOffBerlinClockTimeHolder() {
        BerlinClockTimeHolder berlinClockTimeHolder = new BerlinClockTimeHolder();

        berlinClockTimeHolder.setTopLamp(createLamp(Color.YELLOW));
        berlinClockTimeHolder.setTopHourLampRow(createTopHourLampRow());
        berlinClockTimeHolder.setBottomHourLampRow(createBottomHourLampRow());
        berlinClockTimeHolder.setTopMinuteLampRow(createTopMinuteLampRow());
        berlinClockTimeHolder.setBottomMinuteLampRow(createBottomMinuteLampRow());

        return berlinClockTimeHolder;
    }

    public Lamp[] createTopHourLampRow() {
        Lamp[] topHourLampRow = {createLamp(Color.RED), createLamp(Color.RED), createLamp(Color.RED),
                createLamp(Color.RED)};
        return topHourLampRow;
    }

    public Lamp[] createBottomHourLampRow() {
        Lamp[] bottomHourLampRow = {createLamp(Color.RED), createLamp(Color.RED), createLamp(Color.RED),
                createLamp(Color.RED)};
        return bottomHourLampRow;
    }

    public Lamp[] createTopMinuteLampRow() {
        Lamp[] topMinuteLampRow = {createLamp(Color.YELLOW), createLamp(Color.YELLOW), createLamp(Color.RED),
                createLamp(Color.YELLOW), createLamp(Color.YELLOW), createLamp(Color.RED), createLamp(Color.YELLOW),
                createLamp(Color.YELLOW), createLamp(Color.RED), createLamp(Color.YELLOW), createLamp(Color.YELLOW)};
        return topMinuteLampRow;
    }

    public Lamp[] createBottomMinuteLampRow() {
        Lamp[] bottomMinuteLampRow = {createLamp(Color.YELLOW), createLamp(Color.YELLOW), createLamp(Color.YELLOW),
                createLamp(Color.YELLOW)};
        return bottomMinuteLampRow;
    }

    public Lamp createLamp(Color color) {
        Lamp lamp = new Lamp();
        lamp.setColor(color);
        return lamp;
    }

    private void fillLampRowLightOn(Lamp[] topHourLampRow, int lightOnLampRowNumber) {
        IntStream.range(0, topHourLampRow.length).forEach(i -> {
            if(i < lightOnLampRowNumber) {
                topHourLampRow[i].setLightOn(true);
            } else {
                topHourLampRow[i].setLightOn(false);
            }
        });
    }

}
