//package agh.ics.oop;
//import org.junit.jupiter.api.Test;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class AnimalMapTest {
//
//    IWorldMap[] MAPS = {new RectangularMap(10, 5), new RectangularMap(5, 5), new RectangularMap(8, 6)};
//
//    Vector2d[][] POSITIONS = {{new Vector2d(2, 2), new Vector2d(3, 4)},
//            {new Vector2d(1, 4), new Vector2d(1, 1), new Vector2d(2, 1)},
//            {new Vector2d(1, 2), new Vector2d(0, 0), new Vector2d(3, 3), new Vector2d(0, 0)}
//    };
//    String[][] DIRECTIONS = { {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f" },
//                              {"b", "f", "f", "l", "r", "f", "f", "f", "l", "l" },
//                              {"r", "f", "b", "f", "f", "l", "l", "f", "f", "f", "f", "f", "r", "f", "l", "f", "f", "f", "f", "f", "f", "l", "f", "f", "f"},
//                              {"fajny napis", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f" },
//                              {"b", "f", "bardzo fajny napis", "l", "r", "f", "f", "f", "l", "l" }
//    };
//
//    String[][] ORIENTATIONS = {{"S", "N"},
//            {"S", "E", "W" },
//            {"N", "N", "S" }
//    };
//
//    Vector2d[][] FINISH_POSITIONS = {{new Vector2d(2, 0), new Vector2d(3, 4)},
//            {new Vector2d(0, 3), new Vector2d(2, 2), new Vector2d(2, 3)},
//            {new Vector2d(4, 4), new Vector2d(0, 5), new Vector2d(2, 0)}
//
//    };
//
//    @Test
//    public void testMap1() {
//        MoveDirection[] directions = OptionsParser.parse(DIRECTIONS[0]);
//        IWorldMap map = MAPS[0];
//        IEngine engine = new SimulationEngine(directions, map, POSITIONS[0]);
//        engine.run();
//        int i = 0;
//        for (Animal animal : ((RectangularMap) map).getAnimals()) {
//            assertEquals(animal.toString(), ORIENTATIONS[0][i]);
//            assertTrue(animal.isAt(FINISH_POSITIONS[0][i]));
//            i++;
//        }
//    }
//
//    @Test
//    public void testMap2() {
//        MoveDirection[] directions = OptionsParser.parse(DIRECTIONS[1]);
//        IWorldMap map = MAPS[1];
//        IEngine engine = new SimulationEngine(directions, map, POSITIONS[1]);
//        engine.run();
//        int i = 0;
//        for (Animal animal : ((RectangularMap) map).getAnimals()) {
//            assertEquals(animal.toString(), ORIENTATIONS[1][i]);
//            assertTrue(animal.isAt(FINISH_POSITIONS[1][i]));
//            i++;
//        }
//    }
//
//    @Test
//    public void testMap3() {
//        MoveDirection[] directions = OptionsParser.parse(DIRECTIONS[2]);
//        IWorldMap map = MAPS[2];
//        IEngine engine = new SimulationEngine(directions, map, POSITIONS[2]);
//        engine.run();
//        int i = 0;
//        for (Animal animal : ((RectangularMap) map).getAnimals()) {
//            assertEquals(animal.toString(), ORIENTATIONS[2][i]);
//            assertTrue(animal.isAt(FINISH_POSITIONS[2][i]));
//            i++;
//        }
//    }
//
//    @Test
//    public void testMap4() {
//        try {
//            MoveDirection[] directions = OptionsParser.parse(DIRECTIONS[3]);
//        } catch (IllegalArgumentException ex) {
//            assertEquals(DIRECTIONS[3][0] + " is not legal move specification", ex.getMessage());
//        }
//    }
//    @Test
//    public void testMap5() {
//        try {
//            MoveDirection[] directions = OptionsParser.parse(DIRECTIONS[4]);
//        } catch (IllegalArgumentException ex) {
//            assertEquals(DIRECTIONS[4][2] + " is not legal move specification", ex.getMessage());
//        }
//    }
//
//}

