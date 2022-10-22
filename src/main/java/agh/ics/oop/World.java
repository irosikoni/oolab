package agh.ics.oop;
import static java.lang.System.out;

public class World {
    static Direction[] change(String[] args) {
        int n = args.length;
        Direction directions[] = new Direction[n];
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
        Animal zwierze = new Animal();
        MoveDirection[] directions = OptionsParser.parse(args);
        for (MoveDirection dir : directions) {
            if (dir == null) break;
            zwierze.move(dir);
        }
        System.out.println(zwierze);

    }
}
