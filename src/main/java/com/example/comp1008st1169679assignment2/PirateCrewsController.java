package com.example.comp1008st1169679assignment2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class PirateCrewsController implements Initializable {

    @FXML
    private ImageView luffyImage;

    @FXML
    private ImageView sanjiImage;

    @FXML
    private ImageView strawHatImage;

    @FXML
    private ImageView zoroImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CrewMember luffy = new CrewMember("Luffy", 19, "Captain", true, "Gum Gum Fruit");
        CrewMember zoro = new CrewMember("Zoro", 21, "Fighter", false, "Three-Sword Style");
        CrewMember sanji = new CrewMember("Sanji", 21, "Chef", false, "Black-Leg Style");
        PirateCrew strawHats = new PirateCrew("Straw Hat Pirates");
        strawHats.add(luffy);
        strawHats.add(zoro);
        strawHats.add(sanji);

        luffyImage.setImage(luffy.getImage());
        zoroImage.setImage(zoro.getImage());
        sanjiImage.setImage(sanji.getImage());
        strawHatImage.setImage(strawHats.getFlag());

        System.out.println(strawHats.toString());
    }
}
