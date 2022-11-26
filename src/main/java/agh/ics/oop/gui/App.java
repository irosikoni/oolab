package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void init(){}

    @Override
    public void start(Stage primaryStage) throws Exception{

        try {
            String[] params = this.getParameters().getUnnamed().toArray(new String[0]);
            MoveDirection[] directions = OptionsParser.parse(this.getParameters().getRaw().toArray(new String[0]));
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            MapVisualizer mapVisualizer = new MapVisualizer(map);
            Vector2d lowerLeft = ((GrassField) map).getLowerLeft();
            Vector2d upperRight = ((GrassField) map).getUpperRight();

            GridPane gridPane = new GridPane();


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
//                gridPane.getColumnConstraints().add(new ColumnConstraints(upperRight.x-lowerLeft.x + 1));
//                gridPane.getRowConstraints().add(new RowConstraints(upperRight.y-lowerLeft.y + 1));
                GridPane.setHalignment(label, HPos.CENTER);
                ry--;
                gridPane.getRowConstraints().add(new RowConstraints(30));
            }
            ry = upperRight.y;

            int ox = 1;
            int oy = 1;

            for (int j=upperRight.y; j>=lowerLeft.y; j--) {
                for (int i = lowerLeft.x; i <= upperRight.x; i++) {
                    String objectRepresentation = "";
                    if (map.objectAt(new Vector2d(i, j)) != null) {
                        objectRepresentation = map.objectAt(new Vector2d(i, j)).toString();
                    }
                    Label label = new Label(objectRepresentation);
                    gridPane.add(label, ox, oy, 1, 1);

                    GridPane.setHalignment(label, HPos.CENTER);
                    ox++;
                }
                oy++;
                ox = 1;
            }
            gridPane.setGridLinesVisible(true);
            Scene scene = new Scene(gridPane, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);

        }


    }
        public static void main(String[] args) {
        Application.launch(args);
    }
}
