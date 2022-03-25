package com.example.comp1008st1169679assignment2;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class PirateCrewsController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CrewMember luffy = new CrewMember("Luffy", 19, "Captain", true, "Gum Gum Fruit");
        CrewMember zoro = new CrewMember("Zoro", 20, "Fighter", false, "Three-Sword Style");
        PirateCrew strawHats = new PirateCrew("Straw Hat Pirates");
        strawHats.add(luffy);
        strawHats.add(zoro);
        System.out.println(strawHats.toString());
    }
}
