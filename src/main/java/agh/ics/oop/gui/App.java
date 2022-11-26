package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
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
            gridPane.setGridLinesVisible(true);

            for (int x=lowerLeft.y; x<=upperRight.y)


//            Label label1 = new Label("*");
//            Label label2 = new Label("*");
//            Label label3 = new Label("*");
//            Label label4 = new Label("trawa");
//            Label label5 = new Label("Zwierzak");

//            gridPane.add(label1, 0, 0);
//            gridPane.add(label2, 1, 0, 2, 2);
//            gridPane.add(label3, 2, 0, 1, 1);
//            gridPane.add(label4, 0, 1, 1, 1);
//            gridPane.add(label5, 1, 1, 1, 1);
            Scene scene = new Scene(gridPane, 400, 400);
            primaryStage.show();
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
