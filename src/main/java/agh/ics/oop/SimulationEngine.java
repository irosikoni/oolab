package agh.ics.oop;

public class SimulationEngine implements IEngine {

    private MoveDirection[] moves;
    private IWorldMap map;
    private Vector2d[] startPositions;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] startPositions) {
        this.map = map;
        this.moves = moves;
        this.startPositions = startPositions;
    }

    public void placeAnimals() {
        for (Vector2d s : startPositions) {
            map.place(new Animal(map, s));
        }
    }


    @Override
    public void run() {
        placeAnimals();
        int i = 0;
        while (i < moves.length) {
            for (Animal a : ((GrassField) map).getAnimals()) {
                if (i == moves.length) break;
                a.move(moves[i]);
                i++;
            }
        }
    }
}
