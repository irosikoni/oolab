package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.FileNotFoundException;


public class GuiElementBox {

    public VBox GuiElementBox(IMapElement mapElement) throws FileNotFoundException {
        Image image = mapElement.getImage();
        ImageView imageView = new ImageView(image);
        Label label = new Label(mapElement.getPosition().toString());
        imageView.setImage(image);
        imageView.setFitWidth(15);
        imageView.setFitHeight(15);
        label.setFont(Font.font(9));
        VBox vbox = new VBox(imageView, label);
        vbox.setAlignment(Pos.BASELINE_CENTER);
        vbox.setFillWidth(true);
        return vbox;
    }

}
