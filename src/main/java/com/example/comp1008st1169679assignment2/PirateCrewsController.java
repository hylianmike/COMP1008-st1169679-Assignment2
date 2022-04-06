package com.example.comp1008st1169679assignment2;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    private ImageView shipImage;

    @FXML
    private ListView<PirateCrew> crewList;

    @FXML
    private ListView<CrewMember> pirateList;

    @FXML
    private Label shipLabel;

    @FXML
    private Label pirateInfoLabel;

    // overridden initialize method
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // creating all the individual pirates
        CrewMember luffy = new CrewMember("Monkey D. Luffy", 19, "Captain", 1_500_000_000, true, "Gum-Gum Fruit", "Gum-Gum Pistol", "Red Hawk", "King-Kong Gun");
        CrewMember zoro = new CrewMember("Roronoa Zoro", 21, "Fighter", 320_000_000, false, "Three-Sword Style", "Iai Death Lion Song", "Purgatory Onigiri", "Asura: Dead Man's Game");
        CrewMember nami = new CrewMember("Nami", 20, "Navigator", 66_000_000, false, "Sorcery Climate-Baton", "Thunder Lance Tempo", "Mirage Tempo", "Zeus Breeze Tempo");
        CrewMember usopp = new CrewMember("Usopp", 19, "Marksman", 200_000_000, false, "Kabuto Giant Slingshot", "Green Star: Devil", "Impact Wolf", "Usopp Golden Pound");
        CrewMember sanji = new CrewMember("Vinsmoke Sanji", 21, "Chef", 330_000_000, false, "Black-Leg Style", "Concassé", "Anti-Manner Kick Course", "Hell Memories");
        CrewMember chopper = new CrewMember("Tony Tony Chopper", 17, "Doctor", 100, true, "Human-Human Fruit", "Guard Point", "Kung-Fu Point", "Monster Point");
        CrewMember robin = new CrewMember("Nico Robin", 30, "Archaeologist", 130_000_000, true, "Flow-Flower Fruit", "Delphinium", "Gigantesco Mano", "Demonio Fleur");
        CrewMember franky = new CrewMember("Franky", 36, "Shipwright", 94_000_000, false, "Cyborg Body", "Franky Radical Beam", "Weapon's Left", "Franky Fireball");
        CrewMember brook = new CrewMember("Brook", 90, "Musician", 83_000_000, true, "Revive-Revive Fruit", "Dawn Song Strike", "Three-Pace Hum:\nNotch Slash", "Soul Parade");
        CrewMember jimbei = new CrewMember("Jimbei", 46, "Helmsman", 438_000_000, false, "Fish-Man Karate", "Murasame Spear Wave", "Vagabond Drill","Demon Brick Fist");

        CrewMember law = new CrewMember("Trafalgar Law", 26, "Captain", 500_000_000, true, "Op-Op Fruit", "Injection Shot", "Gamma Knife", "Puncture Wille");

        // creating all the pirate crews
        PirateCrew strawHats = new PirateCrew("Straw Hat Pirates", "Thousand Sunny");
        PirateCrew heartPirates = new PirateCrew("Heart Pirates", "Polar Tang");

        // adding the pirates to their respective crews
        strawHats.add(luffy);
        strawHats.add(zoro);
        strawHats.add(nami);
        strawHats.add(usopp);
        strawHats.add(sanji);
        strawHats.add(chopper);
        strawHats.add(robin);
        strawHats.add(franky);
        strawHats.add(brook);
        strawHats.add(jimbei);

        heartPirates.add(law);

        // making an array of the pirate crews to add to the ListView object
        PirateCrew[] crews = new PirateCrew[]{strawHats, heartPirates};
        crewList.setItems(FXCollections.observableArrayList(crews));

        // this will run whenever a different item is selected in the list of crews
        crewList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldSelection, newSelection) -> {
            try{
                shipLabel.setVisible(true);
                shipLabel.setText(newSelection.getShip());
                // set the flag ImageView to the corresponding jolly roger
                flagImage.setImage(new Image(getClass().getResource(newSelection.getFlag()).toExternalForm()));
                // set the list of pirates to be that of the selected crew
                pirateList.setItems(FXCollections.observableList(newSelection.getCrew()));
                // set the image of the pirate to the first one in the list
                pirateImage.setImage(new Image(String.valueOf(getClass().getResource(newSelection.getCrew().get(0).getImage()).toExternalForm())));
                pirateInfoLabel.setVisible(true);
                pirateInfoLabel.setText(newSelection.getCrew().get(0).getData());
                // set the ship ImageView to the corresponding pirate ship
                shipImage.setImage(new Image(getClass().getResource(newSelection.getShipLocation()).toExternalForm()));
            }
            catch (NullPointerException ignored){}
        });

        // this will run whenever a different item is selected in the list of pirates
        pirateList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldSelection, newSelection) -> {
            try{
                // set the image to the pirate object that is selected
                pirateImage.setImage(new Image(String.valueOf(getClass().getResource(newSelection.getImage()).toExternalForm())));
                pirateInfoLabel.setText(newSelection.getData());
            }
            catch (NullPointerException ignored){}
        });
    }
}

//         image = new Image(getClass().getResource(String.format("img/people/%s.png", name.split(" ")[name.split(" ").length - 1].toLowerCase())).toExternalForm());
