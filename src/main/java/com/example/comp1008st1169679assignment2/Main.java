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
        stage.setTitle("One Piece Pirate Crews!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        CrewMember luffy = new CrewMember("Luffy", 19, true, "Gum Gum Fruit");
        System.out.println(luffy);
    }
}