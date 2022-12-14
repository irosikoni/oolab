package agh.ics.oop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected Vector2d lowerLeft;
    protected Vector2d upperRight;
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected MapBoundary mapB = new MapBoundary();

    public List<Animal> getAnimals() {
        return animals.values().stream().toList();
    }

    public abstract Vector2d getLowerLeft();

    public abstract Vector2d getUpperRight();

    public String toString() {
        return new MapVisualizer(this).draw(getLowerLeft(), getUpperRight());
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (animals.containsKey(position));
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (isOccupied(position)) {
            return animals.get(position);
        }
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!animals.containsKey(position));
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();

        if (canMoveTo(animalPosition)) {
            animals.put(animalPosition, animal);
            mapB.addVector(animalPosition);
            animal.addObserver(this);
            return true;
        }
        else {
            throw new IllegalArgumentException(animalPosition.toString() + "is not empty");

        }
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if(!newPosition.equals(oldPosition)) {
            mapB.positionChanged(oldPosition, newPosition);
            Animal a = animals.remove(oldPosition);
            animals.put(newPosition, a);
        }
    }
}