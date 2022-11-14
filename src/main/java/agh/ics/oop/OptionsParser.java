package agh.ics.oop;

public class OptionsParser {
    public static MoveDirection[] parse(String[] dirs) {
        int i = 0;
        MoveDirection[] directions = new MoveDirection[dirs.length];
        for (String dir : dirs) {
            switch(dir) {
                case "f", "forward":
                    directions[i] = MoveDirection.FORWARD;
                    i++;
                    break;
                case "b", "backward":
                    directions[i] = MoveDirection.BACKWARD;
                    i++;
                    break;
                case "l", "left":
                    directions[i] = MoveDirection.LEFT;
                    i++;
                    break;
                case "r", "right":
                    directions[i] = MoveDirection.RIGHT;
                    i++;
                    break;
                default:
                    throw new IllegalArgumentException(dir + " is not legal move specification");
            }
        }
        return directions;
    }
}
