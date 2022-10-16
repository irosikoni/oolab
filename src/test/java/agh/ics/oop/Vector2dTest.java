package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    Vector2d checkVector1 = new Vector2d(-1, 5);
    Vector2d checkVector2 = new Vector2d(-4, -3);
    Vector2d checkVector3 = new Vector2d(-1, 5);
    Vector2d checkVector4 = new Vector2d(10, 10);

    @Test
    void testEquals() {
        assertEquals(checkVector1, checkVector3);
    }
    @Test
    void testToString() {
        assertEquals("(-1, 5)", checkVector1.toString());
        assertEquals("(-4, -3)", checkVector2.toString());
    }
    @Test
    void testPrecedes() {
        assertTrue(checkVector1.precedes(checkVector2));
        assertFalse(checkVector2.precedes(checkVector1));
    }
    @Test
    void testFollows() {
        assertTrue(checkVector4.follows(checkVector2));
        assertFalse(checkVector2.follows(checkVector4));
    }
    @Test
    void testUpperRight() {
        assertSame(checkVector4.upperRight(checkVector2), new Vector2d(10, 10));
        assertNotSame(checkVector4.upperRight(checkVector2), new Vector2d(-4, -3));
    }
    @Test
    void testLowerLeft() {
        assertNotSame(checkVector4.lowerLeft(checkVector2), new Vector2d(10, 10));
        assertEquals(checkVector4.lowerLeft(checkVector2), new Vector2d(-4, -3));
    }
    @Test
    void testAdd() {
        assertNotSame(checkVector2.add(checkVector3), new Vector2d(10, 10));
        assertSame(checkVector2.add(checkVector3), new Vector2d(-5, 2));
    }
    @Test
    void testSubtract() {
        assertSame(checkVector2.subtract(checkVector3), new Vector2d(-3, -8));
        assertNotSame(checkVector2.subtract(checkVector3), new Vector2d(-5, 2));
    }
    @Test
    void testOpposite() {
        assertNotSame(checkVector2.opposite(), new Vector2d(-3, -4));
        assertSame(checkVector3.opposite(), new Vector2d(1, -5));
    }

}
