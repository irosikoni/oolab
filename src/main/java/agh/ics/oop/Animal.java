package agh.ics.oop;

// Mechanizm zapobiegający pojawieniu się dwóch zwierząt w tym samym miejscu można
// zaimplementować poprzez zaimplementowanie tablicy wartości bool,
// które będą mówić, czy na danym polu stoi już jakieś zwierze, czy nie
// i sprawdzaniu jej przed ruchem zwierzęcia.


public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;
    private IWorldMap map;

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public void setOrientation(MapDirection orientation) {
        this.orientation = orientation;
    }

    public IWorldMap getMap() {
        return map;
    }

    public void setMap(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map) {
        this.map = map;
        this.position = new Vector2d(0, 0);
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }
    public String toString() {
        return switch(orientation) {
            case NORTH -> "N";
            case EAST -> "E";
            case WEST -> "W";
            case SOUTH -> "S";
        };
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
                    if (map.canMoveTo(position.add(orientation.toUnitVector()))) {
                        position = position.add(orientation.toUnitVector());
                    }
                    break;
                case BACKWARD:
                    if (map.canMoveTo(position.subtract(orientation.toUnitVector()))) {
                        position = position.subtract(orientation.toUnitVector());
                    }
                    break;
            }
        }
    }


}
