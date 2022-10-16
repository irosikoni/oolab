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
        out.println("Start");
        Direction dir[] = change(args);
        run(dir);
        out.println("Stop");
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        System.out.println(position1.subtract(position2));
        System.out.println(position1.upperRight(position2));
        System.out.println(position1.lowerLeft(position2));
        System.out.println(position1.opposite());
        System.out.println(position1.equals(position2));
        System.out.println(MapDirection.NORTH.toString());
        System.out.println(MapDirection.NORTH.next());
        System.out.println(MapDirection.NORTH.previous());
        System.out.println(MapDirection.NORTH.toUnitVector());

    }
}
