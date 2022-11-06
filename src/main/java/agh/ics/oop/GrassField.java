package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {

    protected List<Grass> grass = new ArrayList<>();

    GrassField(int grassLimit) {
        placeGrass(grassLimit);
    }

    private void placeGrass(int grassLimit) {
        Random rand = new Random();
        int grassMaxCoord = (int) Math.sqrt(10 * grassLimit) + 1;

        while (grass.size() < grassLimit) {
            int randX = rand.nextInt(grassMaxCoord);
            int randY = rand.nextInt(grassMaxCoord);
            Vector2d grassPosition = new Vector2d(randX, randY);
            if (objectAt(grassPosition) == null) {
                grass.add(new Grass(grassPosition));
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Grass g : grass) {
            if (g.getPosition().equals(position)) {
                return true;
            }
        }
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object o = super.objectAt(position);
        if (o != null) {
            return o;
        }
        for (Grass g : grass) {
            if (g.getPosition().equals(position)) {
                return g;
            }
        }
        return null;
    }

    @Override
    public Vector2d getLowerLeft() {
        lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        for (Animal a : animals) {
            lowerLeft = lowerLeft.lowerLeft(a.getPosition());
        }

        for (Grass g : grass) {
            lowerLeft = lowerLeft.lowerLeft(g.getPosition());
        }

        return lowerLeft;
    }

    @Override
    public Vector2d getUpperRight() {
        upperRight = new Vector2d(0, 0);

        for (Animal a : animals) {
            upperRight = upperRight.upperRight(a.getPosition());
        }

        for (Grass g : grass) {
            upperRight = upperRight.upperRight(g.getPosition());
        }

        return upperRight;
    }

    public List<Grass> getGrass() {
        return grass;
    }
}