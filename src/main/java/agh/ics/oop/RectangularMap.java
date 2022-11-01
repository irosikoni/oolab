package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap  implements IWorldMap{
    private Vector2d lowerLeft;
    private Vector2d upperRight;

    private List<Animal> animals = new ArrayList<>();

    public List<Animal> getAnimals() {
        return animals;
    }

    public RectangularMap(int width, int height) {

        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width-1, height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {

        return position.precedes(upperRight) && position.follows(lowerLeft) && !isOccupied(position);

    }

    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();

        if (canMoveTo(animalPosition)) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal a : animals) {
            if (a.isAt(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal a : animals) {
            if (a.isAt(position)) return a;
        }
        return null;
    }

    public String toString() {
        return new MapVisualizer(this).draw(lowerLeft, upperRight);
    }

}
