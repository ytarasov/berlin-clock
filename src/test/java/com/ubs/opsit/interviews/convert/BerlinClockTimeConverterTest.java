package com.ubs.opsit.interviews.convert;

import com.ubs.opsit.interviews.build.BerlinClockTimeHolder;
import com.ubs.opsit.interviews.build.Color;
import com.ubs.opsit.interviews.parse.InputTimeHolder;
import com.ubs.opsit.interviews.util.BerlinClockTimeHolderUtil;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BerlinClockTimeConverterTest {

    private BerlinClockTimeConverter berlinClockTimeConverter;

    private BerlinClockTimeHolderUtil berlinClockTimeHolderUtil = new BerlinClockTimeHolderUtil();

    @Before
    public void init() {
        BerlinClockTimeHolder berlinClockTimeHolderMock = createBerlinClockTimeHolderMock();
        this.berlinClockTimeConverter = new BerlinClockTimeConverter(berlinClockTimeHolderMock);
    }

    @Test
    public void convertBerlinClockSecondsTest() {
        InputTimeHolder inputTimeHolder = createInputTimeHolder(13, 27, 45);
        BerlinClockTimeHolder berlinClockTimeHolder = berlinClockTimeConverter.convertToBerlinClockTime(inputTimeHolder);
        assertEquals(Color.YELLOW, berlinClockTimeHolder.getTopLamp().getColor());
    }

    @Test
    public void convertBerlinClockTopHourRowTest() {
        InputTimeHolder inputTimeHolder = createInputTimeHolder(13, 27, 45);
        BerlinClockTimeHolder berlinClockTimeHolder = berlinClockTimeConverter.convertToBerlinClockTime(inputTimeHolder);
        assertTrue(berlinClockTimeHolder.getTopHourLampRow()[1].isLightOn());
    }

    @Test
    public void convertBerlinClockBottomHourRowTest() {
        InputTimeHolder inputTimeHolder = createInputTimeHolder(13, 27, 45);
        BerlinClockTimeHolder berlinClockTimeHolder = berlinClockTimeConverter.convertToBerlinClockTime(inputTimeHolder);
        assertTrue(berlinClockTimeHolder.getBottomHourLampRow()[2].isLightOn());
    }

    @Test
    public void convertBerlinClockTopMinuteRowTest() {
        InputTimeHolder inputTimeHolder = createInputTimeHolder(13, 27, 45);
        BerlinClockTimeHolder berlinClockTimeHolder = berlinClockTimeConverter.convertToBerlinClockTime(inputTimeHolder);
        assertTrue(berlinClockTimeHolder.getTopMinuteLampRow()[4].isLightOn());
    }

    @Test
    public void convertBerlinClockBottomMinuteRowTest() {
        InputTimeHolder inputTimeHolder = createInputTimeHolder(13, 27, 45);
        BerlinClockTimeHolder berlinClockTimeHolder = berlinClockTimeConverter.convertToBerlinClockTime(inputTimeHolder);
        assertTrue(berlinClockTimeHolder.getBottomMinuteLampRow()[1].isLightOn());
    }

    private InputTimeHolder createInputTimeHolder(int hour, int minute, int second) {
        InputTimeHolder inputTimeHolder = new InputTimeHolder();
        inputTimeHolder.setHour(hour);
        inputTimeHolder.setMinute(minute);
        inputTimeHolder.setSecond(second);
        return inputTimeHolder;
    }

    private BerlinClockTimeHolder createBerlinClockTimeHolderMock() {
        BerlinClockTimeHolder berlinClockTimeHolderMock = mock(BerlinClockTimeHolder.class);

        when(berlinClockTimeHolderMock.getTopLamp()).thenReturn(berlinClockTimeHolderUtil.createLamp(Color.YELLOW));
        when(berlinClockTimeHolderMock.getTopHourLampRow()).thenReturn(berlinClockTimeHolderUtil.createTopHourLampRow());
        when(berlinClockTimeHolderMock.getBottomHourLampRow()).thenReturn(berlinClockTimeHolderUtil.createBottomHourLampRow());
        when(berlinClockTimeHolderMock.getTopMinuteLampRow()).thenReturn(berlinClockTimeHolderUtil.createTopMinuteLampRow());
        when(berlinClockTimeHolderMock.getBottomMinuteLampRow()).thenReturn(berlinClockTimeHolderUtil.createBottomMinuteLampRow());

        return berlinClockTimeHolderMock;
    }

}
