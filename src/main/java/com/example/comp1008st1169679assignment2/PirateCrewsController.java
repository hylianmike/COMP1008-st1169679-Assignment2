package com.example.comp1008st1169679assignment2;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
    private ListView<PirateCrew> crewListTwo;

    @FXML
    private ListView<CrewMember> pirateList;

    @FXML
    private Label shipLabel;

    @FXML
    private Label pirateInfoLabel;

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    private TextField nameField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField powerTextBox;

    @FXML
    private CheckBox devilFruitCheck;

    @FXML
    private Button addButton;

    @FXML
    private TextArea attacksTextBox;

    @FXML
    private TextField bountyField;

    @FXML
    private Label errorLabel;

    // creating all the pirate crews
    private PirateCrew strawHats = new PirateCrew("Straw Hat Pirates", "Thousand Sunny");
    private PirateCrew heartPirates = new PirateCrew("Heart Pirates", "Polar Tang");
    private PirateCrew whitebeardPirates = new PirateCrew("Whitebeard Pirates", "Moby Dick");
    private PirateCrew blackbeardPirates = new PirateCrew("Blackbeard Pirates", "Saber of Xebec");

    // making an array of the pirate crews to add to the ListView object
    private PirateCrew[] crews = new PirateCrew[]{strawHats, heartPirates, whitebeardPirates, blackbeardPirates};

    // overridden initialize method
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<String> roles = CrewMember.getValidRoles();
        for (int i = 0; i < roles.size(); i++) {
            roles.set(i, roles.get(i).substring(0, 1).toUpperCase() + roles.get(i).substring(1));
        }
        roleComboBox.setItems(FXCollections.observableList(roles));

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


        CrewMember law = new CrewMember("Trafalgar D. Law", 26, "Captain", 500_000_000, true, "Op-Op Fruit", "Injection Shot", "Gamma Knife", "Puncture Wille");
        CrewMember bepo = new CrewMember("Bepo", 22, "Navigator", 500, false, "Mink Powers", "Sulong Form");
        CrewMember penguin = new CrewMember("Penguin", 28, "Member", 80_000_000, false, "Martial Arts + Spears");
        CrewMember shachi = new CrewMember("Shachi", 27, "Member", 79_000_000, false, "Martial Arts + Swords");

        heartPirates.add(law);
        heartPirates.add(bepo);
        heartPirates.add(penguin);
        heartPirates.add(shachi);

        CrewMember newgate = new CrewMember("Edward Newgate", 72, "Captain", 5_046_000_000L, true, "Tremor-Tremor Fruit", "Sea Quake", "Helmet Splitter", "Island Shaking");
        CrewMember marco = new CrewMember("Marco", 45, "Doctor", 1_374_000_000, true, "Pheonix-Pheonix Fruit", "Undying Thistle", "Phenoix Brand", "Phoenix Pyreapple");
        CrewMember thatch = new CrewMember("Thatch", 46, "Chef", 500_000_000, false, "Swordsmanship");
        CrewMember izo = new CrewMember("Izo", 45, "Marksman", 510_000_000, false, "Dual Flintlock Pistols", "Bullet Slicing Rounds");
        CrewMember oden = new CrewMember("Kozuki Oden", 39, "Archaeologist", 1_000_000_000, false, "Oden: Two-Sword Style", "Paradise Waterfall", "Gun Modoki", "Paradise Totsuka");
        CrewMember jozu = new CrewMember("Jozu", 42, "Fighter", 700_000_000, true, "Diamond-Diamond Fruit", "Brilliant Punk");
        CrewMember vista = new CrewMember("Vista", 47, "Fighter", 650_000_000, false, "Two-Sword Style");

        whitebeardPirates.add(newgate);
        whitebeardPirates.add(marco);
        whitebeardPirates.add(oden);
        whitebeardPirates.add(jozu);
        whitebeardPirates.add(thatch);
        whitebeardPirates.add(vista);
        whitebeardPirates.add(izo);

        CrewMember teech = new CrewMember("Marshall D. Teech", 40, "Captain", 2_247_600_000L, true, "Dark-Dark Fruit", "Black Hole", "Liberation", "Black Vortex");
        CrewMember burgess = new CrewMember("Jesus Burgess", 29, "Helmsman", 150_000_000, false, "Brute Strength", "Shockwave Elbow");
        CrewMember augur = new CrewMember("Van Augur", 27, "Marksman", 300_000_000, false, "Senriku Rifle");
        CrewMember lafitte = new CrewMember("Laffitte", 41, "Navigator", 220_000_000, true, "Unknown Devil Fruit");
        CrewMember docQ = new CrewMember("Doc Q", 28, "Doctor", 350_000_000, false, "Double Sided Scythe");
        CrewMember shiryu = new CrewMember("Shiryu of the Rain", 44, "Fighter", 1_600_000_000, true, "Clear-Clear Fruit");

        blackbeardPirates.add(teech);
        blackbeardPirates.add(burgess);
        blackbeardPirates.add(augur);
        blackbeardPirates.add(lafitte);
        blackbeardPirates.add(docQ);
        blackbeardPirates.add(shiryu);

        crewList.setItems(FXCollections.observableArrayList(crews));
        crewListTwo.setItems(FXCollections.observableArrayList(crews));

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
                pirateImage.setImage(new Image(String.valueOf(getClass().getResource(newSelection.getCrew().get(0).getImageLocation()).toExternalForm())));
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
                pirateImage.setImage(new Image(String.valueOf(getClass().getResource(newSelection.getImageLocation()).toExternalForm())));
                pirateInfoLabel.setText(newSelection.getData());
            }
            catch (NullPointerException ignored){}
        });

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PirateCrew crew = crewListTwo.getSelectionModel().getSelectedItem();
                String[] attacks = attacksTextBox.getText().split(", ");
                try{
                    if (attacks[0].length() == 0)
                        crew.add(new CrewMember(nameField.getText(), Integer.parseInt(ageField.getText()), roleComboBox.getValue(), Integer.parseInt(bountyField.getText()), devilFruitCheck.isSelected(), powerTextBox.getText()));
                    else
                        crew.add(new CrewMember(nameField.getText(), Integer.parseInt(ageField.getText()), roleComboBox.getValue(), Integer.parseInt(bountyField.getText()), devilFruitCheck.isSelected(), powerTextBox.getText(), attacks));
                }
                catch (NullPointerException npe){
                    errorLabel.setVisible(true);
                    errorLabel.setText("An existing crew and\nrole MUST be selected");
                    return;
                }
                catch (NumberFormatException nfe){
                    errorLabel.setVisible(true);
                    errorLabel.setText("Age and Bounty fields MUST\nbe positive numerical values");
                    return;
                }
                catch (IllegalArgumentException ex){
                    errorLabel.setVisible(true);
                    errorLabel.setText(ex.getMessage());
                    return;
                }

                crew.getCrew().get(crew.getCrew().size() - 1).setImageLocation("img/people/blank.jpg");
                crewList.setItems(FXCollections.observableArrayList(crews));
                nameField.clear();
                ageField.clear();
                roleComboBox.getSelectionModel().selectFirst();
                devilFruitCheck.setSelected(false);
                powerTextBox.clear();
                attacksTextBox.clear();
                bountyField.clear();
                errorLabel.setVisible(false);
            }
        });
    }
}