package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    RectangularMap rectangularMap = new RectangularMap(10, 10);

    @Test
    public void testIsOccupied() {
        Animal a1 = new Animal(rectangularMap, new Vector2d(2, 2));
        Animal a2 = new Animal(rectangularMap, new Vector2d(9, 9));

        rectangularMap.place(a1);
        rectangularMap.place(a2);

        assertTrue(rectangularMap.isOccupied(a1.getPosition()));
        assertTrue(rectangularMap.isOccupied(a2.getPosition()));
        assertFalse(rectangularMap.isOccupied(new Vector2d(5, 5)));
    }

    @Test
    public void testCanMoveTo() {
        Animal a1 = new Animal(rectangularMap, new Vector2d(2, 2));
        Animal a2 = new Animal(rectangularMap, new Vector2d(9, 9));

        rectangularMap.place(a1);
        rectangularMap.place(a2);

        assertFalse(rectangularMap.canMoveTo(a1.getPosition()));
        assertFalse(rectangularMap.canMoveTo(a2.getPosition()));
        assertFalse(rectangularMap.canMoveTo(new Vector2d(-1, -1)));
        assertFalse(rectangularMap.canMoveTo(new Vector2d(10, 10)));
        assertTrue(rectangularMap.canMoveTo(new Vector2d(1, 1)));

    }

    @Test
    public void testObjectAt() {
        Animal a1 = new Animal(rectangularMap, new Vector2d(2, 2));
        Animal a2 = new Animal(rectangularMap, new Vector2d(9, 9));

        rectangularMap.place(a1);
        rectangularMap.place(a2);

        assertEquals(a1, rectangularMap.objectAt(new Vector2d(2, 2)));
        assertEquals(a2, rectangularMap.objectAt(new Vector2d(9, 9)));
        assertNull(rectangularMap.objectAt(new Vector2d(8, 8)));
    }

    @Test
    public void testPlace() {
        Vector2d pos = new Vector2d(2, 2);
        Animal a1 = new Animal(rectangularMap, pos);
        rectangularMap.place(a1);

        assertTrue(
                !rectangularMap.canMoveTo(pos)
                        && rectangularMap.isOccupied(pos)
                        && a1.equals(rectangularMap.objectAt(pos)));
    }

}