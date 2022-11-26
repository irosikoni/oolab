package agh.ics.oop;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {


    TreeSet<Vector2d> setX = new TreeSet<Vector2d>(new MapBoundaryComparatorX());
    TreeSet<Vector2d> setY = new TreeSet<Vector2d>(new MapBoundaryComparatorY());
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if(!newPosition.equals(oldPosition)) {
            setX.remove(oldPosition);
            setY.remove(oldPosition);
            setX.add(newPosition);
            setY.add(newPosition);
        }
    }

    void addVector(Vector2d newPosition) {
        setX.add(newPosition);
        setY.add(newPosition);
    }
}

