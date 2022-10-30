package agh.ics.oop;
import java.net.SocketOption;
import java.sql.SQLOutput;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class World {
    static Direction[] change(String[] args) {
        int n = args.length;
        Direction[] directions = new Direction[n];
        for (int i = 0; i < n; i++) {
            Direction message = switch (args[i]) {
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "r" -> Direction.RIGHT;
                case "l" -> Direction.LEFT;
                default -> Direction.UNKNOWN;
            };
            directions[i] = message;
        }
        return directions;
    }

    static void run(Direction[] args) {
        for (Direction move : args) {
            String message = switch (move) {
                case FORWARD -> "do przodu";
                case BACKWARD -> "do tyłu";
                case RIGHT -> "w prawo";
                case LEFT -> "w lewo";
                case UNKNOWN -> "nieznana komenda";
            };
            out.println("Zwierzak idzie " + message);

        }
    }

    public static void main(String[] args) {
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map);



    }
}
