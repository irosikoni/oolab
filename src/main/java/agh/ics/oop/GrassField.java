package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField implements IWorldMap {

    private int grassOnMap;
    private final int grassUpperBound = (int) Math.sqrt(grassOnMap * 10);
    private List<Grass> grass = new ArrayList<>();
    private final Vector2d grassLowerLeft = new Vector2d(0, 0);
    private final Vector2d grassUpperRight = new Vector2d(grassUpperBound, grassUpperBound);
    private Vector2d lowerLeft = new Vector2d(2147483647, 2147483647);
    private Vector2d upperRight = new Vector2d(0, 0);

    private List<Animal> animals = new ArrayList<>();

    public List<Animal> getAnimals() {
        return animals;
    }

    GrassField(int grassOnMap) {
        this.grassOnMap = grassOnMap;
    }

    public List<Grass> getGrass() {
        return grass;
    }

    public void placeGrass() {
        Random rand = new Random();
        int counter = 0;

        while (counter < grassOnMap) {
            int randX = rand.nextInt(grassUpperBound);
            int randY = rand.nextInt(grassUpperBound);
            Vector2d grassPosition = new Vector2d(randX, randY);
            if (!isOccupiedGrass(grassPosition)) {
                grass.add(new Grass(grassPosition));
                if (grassPosition.precedes(lowerLeft)){
                    lowerLeft = grassPosition;
                }
                if (grassPosition.follows(upperRight)){
                    upperRight = grassPosition;
                }
                counter++;
            }
        }
    }

    public boolean isOccupiedGrass(Vector2d position) {
        for (Grass g : grass) {
            if (g.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {

        return !isOccupied(position);

    }

    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();

        if (canMoveTo(animalPosition)) {
            animals.add(animal);
            if (animalPosition.precedes(lowerLeft)){
                lowerLeft = animalPosition;
            }
            if (animalPosition.follows(upperRight)){
                upperRight = animalPosition;
            }
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
