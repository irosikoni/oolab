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
        assertFalse(checkVector1.precedes(checkVector2));
        assertTrue(checkVector2.precedes(checkVector1));
    }
    @Test
    void testFollows() {
        assertTrue(checkVector4.follows(checkVector2));
        assertFalse(checkVector2.follows(checkVector4));
    }
    @Test
    void testUpperRight() {
        assertEquals(checkVector4.upperRight(checkVector2), new Vector2d(10, 10));
        assertNotEquals(checkVector4.upperRight(checkVector2), new Vector2d(-4, -3));
    }
    @Test
    void testLowerLeft() {
        assertNotEquals(checkVector4.lowerLeft(checkVector2), new Vector2d(10, 10));
        assertEquals(checkVector4.lowerLeft(checkVector2), new Vector2d(-4, -3));
    }
    @Test
    void testAdd() {
        assertNotEquals(checkVector2.add(checkVector3), new Vector2d(10, 10));
        assertEquals(checkVector2.add(checkVector3), new Vector2d(-5, 2));
    }
    @Test
    void testSubtract() {
        assertEquals(checkVector2.subtract(checkVector3), new Vector2d(-3, -8));
        assertNotEquals(checkVector2.subtract(checkVector3), new Vector2d(-5, 2));
    }
    @Test
    void testOpposite() {
        assertNotEquals(checkVector2.opposite(), new Vector2d(-3, -4));
        assertEquals(checkVector3.opposite(), new Vector2d(1, -5));
    }

}
