package agh.ics.oop;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    String[][] BASIC_TESTS = {  {"f", "f", "l", "l", "f"},
                                {"right",  "forward", "left", "forward"},
                                {"backward", "backward", "l", "f"}
                                };
    String[] BASIC_RESULT = {"(2, 3), Południe", "(3, 3), Północ", "(1, 0), Zachód"};
    Vector2d[] BASIC_POSITION = {new Vector2d(2, 3), new Vector2d(3, 3), new Vector2d(1, 0)};

    MoveDirection[][] BASIC_DIRECTIONS = { {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD},
                                           {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD},
                                           {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.FORWARD}
                                };

    String[][] BAD_MAP_TESTS = { {"f", "f", "f", "r", "f"},
                                 {"forward", "forward", "f", "f", "b", "b", "backward", "b", "backward", "f", "f", "r"},
                                 {"r", "f", "l", "f", "l", "f", "f", "l", "f", "f", "r", "f", "f"}

    };
    String[] BAD_MAP_RESULT = {"(3, 4), Wschód", "(2, 2), Wschód", "(0, 1), Zachód"};
    Vector2d[] BAD_MAP_POSITION = {new Vector2d(3, 4), new Vector2d(2, 2), new Vector2d(0, 1)};
    MoveDirection[][] BAD_MAP_DIRECTIONS = { {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD},
                                             {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT},
                                             {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD}
    };

    String[][] BAD_STRING_TESTS = { {"f", "f", "krzysiek", "l", "l", "pula", "f"},
                                    {"c", "right", "nowy", "forward", "left", "n", "forward"},
                                    {"nic nic", "backward", "backward", "l", "f", "pusto"}
    };
    String[] BAD_STRING_RESULT = {"(2, 3), Południe", "(3, 3), Północ", "(1, 0), Zachód"};
    Vector2d[] BAD_STRING_POSITION = {new Vector2d(2, 3), new Vector2d(3, 3), new Vector2d(1, 0)};
    MoveDirection[][] BAD_STRING_DIRECTIONS = { {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD, null, null},
                                                {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, null, null, null},
                                                {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.FORWARD, null, null}
    };

    // Testy sprawdzające, czy przy poprawnych danych, które nie uwzględniają wyjść poza tablice
    // ani dodatkowych niewłaściwych stringów zwierzak porusza się prawidłowo, tzn. jego końcowa
    // pozycja i orientacja są właściwe
    @Test
    void testBasic() {
        for (int i = 0; i < 3; i++) {
            Animal zwierzak = new Animal();
            MoveDirection[] directions = OptionsParser.parse(BASIC_TESTS[i]);
            for (MoveDirection dir : directions) {
                if (dir == null) break;
                zwierzak.move(dir);
            }
            assertTrue(Arrays.equals(directions, BASIC_DIRECTIONS[i]));
            assertTrue(zwierzak.isAt(BASIC_POSITION[i]));
            assertTrue(zwierzak.toString().equals(BASIC_RESULT[i]));

        }
    };

    //Testy sprawdzające, czy jeśli podamy ruchy, które w teorii wyprowadzają zwierzaka za mape,
    // to czy zwierzak pozostanie w jej środku
    @Test
    void testBadMap() {
        for (int i = 0; i < 3; i++) {
            Animal zwierzak = new Animal();
            MoveDirection[] directions = OptionsParser.parse(BAD_MAP_TESTS[i]);
            for (MoveDirection dir : directions) {
                if (dir == null) break;
                zwierzak.move(dir);
            }
            assertTrue(Arrays.equals(directions, BAD_MAP_DIRECTIONS[i]));
            assertTrue(zwierzak.isAt(BAD_MAP_POSITION[i]));
            assertTrue(zwierzak.toString().equals(BAD_MAP_RESULT[i]));

        }
    };
    //Testy sprawdzające, czy przy podaniu złych stringów do tablicy, zwierzak wciąż
    //będzie poruszał się prawidłowo
    @Test
    void testBadString() {
        for (int i = 0; i < 3; i++) {
            Animal zwierzak = new Animal();
            MoveDirection[] directions = OptionsParser.parse(BAD_STRING_TESTS[i]);
            for (MoveDirection dir : directions) {
                if (dir == null) break;
                zwierzak.move(dir);
            }
            assertTrue(Arrays.equals(directions, BAD_STRING_DIRECTIONS[i]));
            assertTrue(zwierzak.isAt(BAD_STRING_POSITION[i]));
            assertTrue(zwierzak.toString().equals(BAD_STRING_RESULT[i]));

        }
    };

};
