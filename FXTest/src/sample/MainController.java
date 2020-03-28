package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import javax.swing.*;
import java.awt.*;

public class MainController {


    public Label helloWorld;

    public void sayHelloWorld(ActionEvent actionEvent) {
        helloWorld.setText("Hello World!");
    }
}
