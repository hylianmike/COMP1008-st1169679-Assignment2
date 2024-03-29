package com.example.comp1008st1169679assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("pirate-crew-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        // set the title to be for one piece pirate crews
        stage.setTitle("One Piece Pirate Crews!");
        stage.setScene(scene);
        stage.show();
    }

    // main method that launches the scene and controller
    public static void main(String[] args) {
        launch();
    }
}