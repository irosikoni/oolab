package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import static java.lang.System.out;

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

    public static void main(String[] args) throws Exception {
        Application.launch(App.class, args);

//        try {
//            MoveDirection[] directions = OptionsParser.parse(args);
//            IWorldMap map = new GrassField(10);
//            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 4)};
//            IEngine engine = new SimulationEngine(directions, map, positions);
//            engine.run();
//            MapVisualizer mapVisualizer = new MapVisualizer(map);
//            Application.launch(App.class, args);
//            System.out.println(map);
//        } catch (IllegalArgumentException ex) {
//            System.out.println(ex);
//
//        }
    }
}
