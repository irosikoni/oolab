package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap {

    protected Map<Vector2d, Grass> grass = new HashMap<>();
    public GrassField(int grassLimit) {
        placeGrass(grassLimit);
    }

    private void placeGrass(int grassLimit) {
        Random rand = new Random();
        int grassMaxCord = (int) Math.sqrt(10 * grassLimit) + 1;

        while (grass.size() < grassLimit) {
            int randX = rand.nextInt(grassMaxCord);
            int randY = rand.nextInt(grassMaxCord);
            Vector2d grassPosition = new Vector2d(randX, randY);
            if (objectAt(grassPosition) == null) {
                grass.put(grassPosition, new Grass(grassPosition));
                mapB.addVector(grassPosition);
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return grass.containsKey(position) || super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object o = super.objectAt(position);
        if (o != null) {
            return o;
        }
        return grass.get(position);
    }

    @Override
    public Vector2d getLowerLeft() {
        return mapB.setX.first().lowerLeft(mapB.setY.first());
    }

    @Override
    public Vector2d getUpperRight() {
        return mapB.setX.last().upperRight(mapB.setY.last());
    }

    public List<Grass> getGrass() {
        return grass.values().stream().toList();
    }
}