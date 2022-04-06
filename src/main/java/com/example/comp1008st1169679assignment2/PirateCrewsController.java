package com.example.comp1008st1169679assignment2;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PirateCrewsController implements Initializable {

    @FXML
    private ImageView flagImage;

    @FXML
    private ImageView pirateImage;

    @FXML
    private ListView<PirateCrew> crewList;

    @FXML
    private ListView<CrewMember> pirateList;

    // overridden initialize method
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // creating all the individual pirates
        CrewMember luffy = new CrewMember("Monkey D. Luffy", 19, "Captain", 1_500_000_000, true, "Gum Gum Fruit (Rubber Man)", "Gum-Gum Pistol", "Red Hawk", "King-Kong Gun");
        CrewMember zoro = new CrewMember("Roronoa Zoro", 21, "Fighter", 320_000_000, false, "Three-Sword Style", "Iai Death Lion Song", "Purgatory Onigiri", "Asura: Dead Man's Game");
        CrewMember sanji = new CrewMember("Vinsmoke Sanji", 21, "Chef", 330_000_000, false, "Black-Leg Style", "Concassé", "Anti-Manner Kick Course", "Hell Memories");
        CrewMember law = new CrewMember("Trafalgar Law", 26, "Captain", 500_000_000, true, "Op-Op Fruit", "Injection Shot", "Gamma Knife", "Pucture Wille");

        // creating all the pirate crews
        PirateCrew strawHats = new PirateCrew("Straw Hat Pirates", "Thousand Sunny");
        PirateCrew heartPirates = new PirateCrew("Heart Pirates", "Polar Tang");

        // adding the pirates to their respective crews
        strawHats.add(luffy);
        strawHats.add(zoro);
        strawHats.add(sanji);
        heartPirates.add(law);

        // making an array of the pirate crews to add to the ListView object
        PirateCrew[] crews = new PirateCrew[]{strawHats, heartPirates};
        crewList.setItems(FXCollections.observableArrayList(crews));

        // this will run whenever a different item is selected in the list of crews
        crewList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldSelection, newSelection) -> {
            try{
                // set the flag ImageView to the corresponding jolly roger
                flagImage.setImage(newSelection.getFlag());
                // set the list of pirates to be that of the selected crew
                pirateList.setItems(FXCollections.observableList(newSelection.getCrew()));
                // set the image of the pirate to the first one in the list
                pirateImage.setImage(new Image(String.valueOf(getClass().getResource(newSelection.getCrew().get(0).getImage()).toExternalForm())));
            }
            catch (NullPointerException ignored){}
        });

        // this will run whenever a different item is selected in the list of pirates
        pirateList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldSelection, newSelection) -> {
            try{
                // set the image to the pirate object that is selected
                pirateImage.setImage(new Image(String.valueOf(getClass().getResource(newSelection.getImage()).toExternalForm())));
            }
            catch (NullPointerException ignored){}
        });
    }
}

//         image = new Image(getClass().getResource(String.format("img/people/%s.png", name.split(" ")[name.split(" ").length - 1].toLowerCase())).toExternalForm());
