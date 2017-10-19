/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        stag.setResizable(false);
        stag.toBack();
        root = new StackPane();
        sc = new Scene(root, 600, 400);
        Label lb = new Label("hola");
        lb.setTranslateX(100);
        lb.setTranslateY(100);
        lb.setTranslateZ(200);
        lb.setStyle(STYLESHEET_MODENA);
        Button btn = new Button("enviar");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hola mundo");
            }
        });
        root.getChildren().add(lb);
        root.getChildren().add(btn);
        stag.setScene(sc);
        stag.show();
    }

    public static void run(String[] arg) {
        launch(arg);
    }
}
