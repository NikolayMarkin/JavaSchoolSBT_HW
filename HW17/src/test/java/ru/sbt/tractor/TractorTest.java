package ru.sbt.tractor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TractorTest {
    private static final int FIELD_HEIGHT = 5;
    private static final int FIELD_WIDTH = 5;

    Field field = new Field(FIELD_HEIGHT, FIELD_WIDTH);

    @Mock
    Position position;

    Tractor tractor;

    @Before
    public void setUp() {
        tractor = new Tractor(position, field, Orientation.NORTH);
    }

    @Test
    public void turnClockwiseTest() {
        tractor.turnClockwise();
        assertEquals(Orientation.EAST, tractor.getOrientation());

        tractor.turnClockwise();
        assertEquals(Orientation.SOUTH, tractor.getOrientation());

        tractor.turnClockwise();
        assertEquals(Orientation.WEST, tractor.getOrientation());

        tractor.turnClockwise();
        assertEquals(Orientation.NORTH, tractor.getOrientation());
    }

    @Test
    public void getCoordinatesTest() {
        tractor.getPositionX();
        verify(position).getX();

        tractor.getPositionY();
        verify(position).getY();
    }

    @Test
    public void moveForwardsTest() {
        Tractor tractor = new Tractor(new Position(0, 0), field, Orientation.NORTH);

        tractor.moveForwards();
        assertEquals(1, tractor.getPositionY());

        tractor.turnClockwise();
        tractor.moveForwards();
        assertEquals(1, tractor.getPositionX());
    }

    @Test(expected = TractorInDitchException.class)
    public void moveForwardsTestOutOfFieldYRange() {
        Tractor tractor = new Tractor(new Position(0, 0), field, Orientation.NORTH);

        for (int i = 0; i < FIELD_HEIGHT + 1; i++) {
            tractor.moveForwards();
        }
    }

    @Test(expected = TractorInDitchException.class)
    public void moveForwardsTestOutOfFieldXRange() {
        Tractor tractor = new Tractor(new Position(0, 0), field, Orientation.EAST);

        for (int i = 0; i < FIELD_WIDTH + 1; i++) {
            tractor.moveForwards();
        }
    }

    @Test(expected = TractorInDitchException.class)
    public void moveForwardsTestOutOfFieldXZeroRange() {
        Tractor tractor = new Tractor(new Position(0, 0), field, Orientation.WEST);
        tractor.moveForwards();
    }

    @Test(expected = TractorInDitchException.class)
    public void moveForwardsTestOutOfFieldYZeroRange() {
        Tractor tractor = new Tractor(new Position(0, 0), field, Orientation.SOUTH);
        tractor.moveForwards();
    }
}