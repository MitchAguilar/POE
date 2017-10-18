/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class FrameVisual extends Application {

    Scene sc;
    StackPane root;

    public void Modules() {

    }

    @Override
    public void start(Stage stag) throws Exception {
        stag.setTitle("Relojes");
        root = new StackPane();
        sc = new Scene(root, 600, 400);

        Label lb = new Label("hola");
        root.getChildren().add(lb);
        stag.setScene(sc);
        stag.show();
    }
//    public static void main(String[] arg){
//        launch(arg);
//    }
}
