package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Platform;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable {

    private MoveDirection[] moves;
    private IWorldMap map;
    private Vector2d[] startPositions;
    private App observer;
    private int moveDelay = 300;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] startPositions, App observer) {
        this.map = map;
        this.moves = moves;
        this.startPositions = startPositions;
        this.observer = observer;
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
            Platform.runLater(() -> {
                try {
                    observer.renderMap();
                    Thread.sleep(moveDelay);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });


        }
    }

}
