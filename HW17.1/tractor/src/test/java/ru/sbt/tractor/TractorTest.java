package ru.sbt.tractor;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static ru.sbt.tractor.TractorCommands.Forward;
import static ru.sbt.tractor.TractorCommands.TurnClockwise;

/**
 * @author Ben
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TractorTest extends TestCase {

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
    public void testShouldMoveForward(){
        tractor.move(Forward);
        assertEquals(0, tractor.getPositionX());
        assertEquals(1, tractor.getPositionY());
    }

    @Test
    public void testShouldTurn(){
        tractor.move(TurnClockwise);
        assertEquals(Orientation.EAST, tractor.getOrientation());
        tractor.move(TurnClockwise);
        assertEquals(Orientation.SOUTH, tractor.getOrientation());
        tractor.move(TurnClockwise);
        assertEquals(Orientation.WEST, tractor.getOrientation());
        tractor.move(TurnClockwise);
        assertEquals(Orientation.NORTH, tractor.getOrientation());
    }

    @Test
    public void testShouldTurnAndMoveInTheRightDirection(){
        tractor.move(TurnClockwise);
        tractor.move(Forward);
        assertEquals(1, tractor.getPositionX());
        assertEquals(0, tractor.getPositionY());
        tractor.move(TurnClockwise);
        tractor.move(Forward);
        assertEquals(1, tractor.getPositionX());
        assertEquals(-1, tractor.getPositionY());
        tractor.move(TurnClockwise);
        tractor.move(Forward);
        assertEquals(0, tractor.getPositionX());
        assertEquals(-1, tractor.getPositionY());
        tractor.move(TurnClockwise);
        tractor.move(Forward);
        assertEquals(0, tractor.getPositionX());
        assertEquals(0, tractor.getPositionY());
    }

    @Test
    public void testShouldThrowExceptionIfFallsOffPlateau(){
        tractor.move(Forward);
        tractor.move(Forward);
        tractor.move(Forward);
        tractor.move(Forward);
        tractor.move(Forward);
        try{
            tractor.move(Forward);
            fail("Tractor was expected to fall off the plateau");
        }catch(TractorInDitchException expected){
        }
    }
}
