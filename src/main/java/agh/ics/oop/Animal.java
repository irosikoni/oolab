package agh.ics.oop;

// Mechanizm zapobiegający pojawieniu się dwóch zwierząt w tym samym miejscu można
// zaimplementować poprzez zaimplementowanie tablicy wartości bool,
// które będą mówić, czy na danym polu stoi już jakieś zwierze, czy nie
// i sprawdzaniu jej przed ruchem zwierzęcia.


import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement, IPositionChangeObserver{
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;
    private IWorldMap map;

    private List<IPositionChangeObserver> observers = new ArrayList<IPositionChangeObserver>();
    @Override
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
    @Override
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
                        Vector2d newPosition = position.add(orientation.toUnitVector());
                        this.positionChanged(position, newPosition);
                        position = newPosition;
                    }
                    break;
                case BACKWARD:
                    if (map.canMoveTo(position.subtract(orientation.toUnitVector()))) {
                        Vector2d newPosition = position.subtract(orientation.toUnitVector());
                        this.positionChanged(position, newPosition);
                        position = newPosition;
                    }
                    break;
            }
        }
    }

    void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver o : observers) {
            o.positionChanged(oldPosition, newPosition);
        }
    }
    @Override
    public Image getImage() throws FileNotFoundException {
        return switch (orientation) {
            case NORTH -> new Image(new FileInputStream("src/main/resources/up.png"));
            case SOUTH -> new Image(new FileInputStream("src/main/resources/down.png"));
            case WEST -> new Image(new FileInputStream("src/main/resources/left.png"));
            case EAST -> new Image(new FileInputStream("src/main/resources/right.png"));
        };
    }


}
