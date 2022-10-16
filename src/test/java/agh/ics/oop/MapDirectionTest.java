package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {
    @Test
    void testNext() {
        assertSame(MapDirection.SOUTH, MapDirection.EAST.next());
        assertSame(MapDirection.NORTH, MapDirection.WEST.next());
        assertSame(MapDirection.WEST, MapDirection.SOUTH.next());
        assertSame(MapDirection.EAST, MapDirection.NORTH.next());
    }
    @Test
    void testPrevious() {
        assertSame(MapDirection.SOUTH, MapDirection.WEST.previous());
        assertSame(MapDirection.NORTH, MapDirection.EAST.previous());
        assertSame(MapDirection.WEST, MapDirection.NORTH.previous());
        assertSame(MapDirection.EAST, MapDirection.SOUTH.previous());
    }
}
