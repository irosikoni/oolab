package agh.ics.oop;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    IWorldMap[] MAPS = {new RectangularMap(10, 5), new RectangularMap(5, 5), new RectangularMap(8, 6)};

    Vector2d[][] POSITIONS = {{new Vector2d(2, 2), new Vector2d(3, 4)},
            {new Vector2d(1, 4), new Vector2d(1, 1), new Vector2d(2, 1)},
            {new Vector2d(1, 2), new Vector2d(0, 0), new Vector2d(3, 3), new Vector2d(0, 0)}
    };
    String[][] DIRECTIONS = {{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f" },
            {"b", "f", "f", "l", "r", "f", "f", "f", "l", "l" },
            {"b", "f", "f", "l", "r", "f", "f", "f", "l", "l" }
    };

    String[][] ORIENTATIONS = {{"S", "N" },
            {"S", "E", "W" },
            {"N", "N", "S" }
    };

    Vector2d[][] FINISH_POSITIONS = {{new Vector2d(2, 0), new Vector2d(3, 4)},
            {new Vector2d(0, 3), new Vector2d(2, 2), new Vector2d(2, 3)},
            {new Vector2d(4, 4), new Vector2d(0, 5), new Vector2d(2, 0)}

    };

    @Test
    public void testMap() {
        for (int t = 0; t < MAPS.length; t++) {
            MoveDirection[] directions = OptionsParser.parse(DIRECTIONS[t]);
            IWorldMap map = MAPS[t];
            IEngine engine = new SimulationEngine(directions, map, POSITIONS[t]);
            engine.run();
            int i = 0;
            for (Animal animal : ((RectangularMap) map).getAnimals()) {
                assertTrue(animal.toString() == ORIENTATIONS[t][i]);
                assertTrue(animal.isAt(FINISH_POSITIONS[t][i]));
            }
        }
    }
}

