package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2) {
    };
    public String toString() {
        return position.toString() + ", " + orientation.toString();
    }
    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }
    public void move(MoveDirection direction) {
        if (direction != null) {
            switch (direction) {
                case RIGHT:
                    orientation = orientation.next();
                    break;
                case LEFT:
                    orientation = orientation.previous();
                    break;
                case FORWARD:
                    if (position.add(orientation.toUnitVector()).precedes(new Vector2d(4, 4)) && position.add(orientation.toUnitVector()).follows(new Vector2d(0, 0))) {
                        position = position.add(orientation.toUnitVector());
                    }
                    break;
                case BACKWARD:
                    if (position.subtract(orientation.toUnitVector()).follows(new Vector2d(0, 0)) && position.subtract(orientation.toUnitVector()).precedes(new Vector2d(4, 4))) {
                        position = position.subtract(orientation.toUnitVector());
                    }
                    break;
            }
        }
    }


}
