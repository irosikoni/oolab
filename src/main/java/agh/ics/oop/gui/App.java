package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class App extends Application{
    private IWorldMap map;
    private Vector2d[] positions;
    private GridPane gridPane = new GridPane();
    private ThrededSimulationEngine tEngine;
    @Override
    public void init(){
        this.map = new GrassField(10);
        this.positions = new Vector2d[]{new Vector2d(2, 2), new Vector2d(2, 4)};
        this.tEngine = new ThrededSimulationEngine(map, positions, this);
    }

    public void renderMap() throws FileNotFoundException {
        changeMap(gridPane, map);
    }

    public void changeMap(GridPane gridPane, IWorldMap map) throws FileNotFoundException {
        gridPane.getChildren().clear();
        gridPane.setGridLinesVisible(true);
        Vector2d lowerLeft = ((GrassField) map).getLowerLeft();
        Vector2d upperRight = ((GrassField) map).getUpperRight();

        int lx = lowerLeft.x;
        int ly = lowerLeft.y;
        int ry = upperRight.y;

        Label label1 = new Label("y/x");
        gridPane.add(label1, 0, 0, 1, 1);
        GridPane.setHalignment(label1, HPos.CENTER);
        gridPane.getColumnConstraints().add(new ColumnConstraints(30));
        gridPane.getRowConstraints().add(new RowConstraints(30));

        for (int p = 1; p<=(upperRight.x-lowerLeft.x + 1); p++) {
            Label label = new Label(Integer.toString(lx));
            gridPane.add(label, p, 0, 1, 1);
            GridPane.setHalignment(label, HPos.CENTER);
            lx++;
            gridPane.getColumnConstraints().add(new ColumnConstraints(30));
        }
        lx = lowerLeft.x;
        for (int q = 1; q<=(upperRight.y-lowerLeft.y + 1); q++) {
            Label label = new Label(Integer.toString(ry));
            gridPane.add(label, 0, q, 1, 1);
            GridPane.setHalignment(label, HPos.CENTER);
            ry--;
            gridPane.getRowConstraints().add(new RowConstraints(30));
        }
        ry = upperRight.y;
        gridPane.setGridLinesVisible(true);
        int ox = 1;
        int oy = 1;

        for (int j=upperRight.y; j>=lowerLeft.y; j--) {
            for (int i = lowerLeft.x; i <= upperRight.x; i++) {
                if (map.objectAt(new Vector2d(i, j)) != null) {
                    GuiElementBox newE = new GuiElementBox();
                    IMapElement o = (IMapElement) map.objectAt(new Vector2d(i, j));
                    gridPane.add(newE.GuiElementBox(o), ox, oy, 1, 1);
                }
                else{
                    Label label = new Label("");
                    gridPane.add(label, ox, oy, 1, 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                }

                ox++;
            }
            oy++;
            ox = 1;
        }
        gridPane.setGridLinesVisible(false);
        gridPane.setGridLinesVisible(true);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        try {
            TextField textField = new TextField();
            Button startBtn = new Button("Start");
            VBox vbox = new VBox(textField, startBtn);
            HBox hbox = new HBox(gridPane, vbox);
            Scene scene = new Scene(hbox, 600, 600);
            primaryStage.setScene(scene);
            primaryStage.show();
            startBtn.setOnAction(actionEvent -> {
                Thread newThread = new Thread(tEngine);
                MoveDirection[] directions = OptionsParser.parse(textField.getText().split(" "));
                tEngine.setMoves(directions);
                newThread.start();
            });

        } catch (IllegalArgumentException ex) {
            System.out.println(ex);

        }


    }
        public static void main(String[] args) {
        Application.launch(args);
    }
}
