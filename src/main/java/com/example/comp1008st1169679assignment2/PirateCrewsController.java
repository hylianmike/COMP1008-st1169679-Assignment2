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
    private PirateCrew strawHatPirates = new PirateCrew("Straw Hat Pirates", "Thousand Sunny");
    private PirateCrew heartPirates = new PirateCrew("Heart Pirates", "Polar Tang");
    private PirateCrew whitebeardPirates = new PirateCrew("Whitebeard Pirates", "Moby Dick");
    private PirateCrew blackbeardPirates = new PirateCrew("Blackbeard Pirates", "Saber of Xebec");
    private PirateCrew spadePirates = new PirateCrew("Spade Pirates", "Piece of Spadille");
    private PirateCrew redHairPirates = new PirateCrew("Red Hair Pirates", "The Red Force");

    // making an array of the pirate crews to add to the ListView object
    private PirateCrew[] crews = new PirateCrew[]{strawHatPirates, heartPirates, whitebeardPirates, blackbeardPirates, spadePirates, redHairPirates};

    // overridden initialize method
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // setting the combo box to the valid roles
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

        CrewMember law = new CrewMember("Trafalgar D. Law", 26, "Captain", 500_000_000, true, "Op-Op Fruit", "Injection Shot", "Gamma Knife", "Puncture Wille");
        CrewMember bepo = new CrewMember("Bepo", 22, "Navigator", 500, false, "Mink Powers", "Sulong Form");
        CrewMember penguin = new CrewMember("Penguin", 28, "Member", 80_000_000, false, "Martial Arts + Spears");
        CrewMember shachi = new CrewMember("Shachi", 27, "Member", 79_000_000, false, "Martial Arts + Swords");

        CrewMember newgate = new CrewMember("Edward Newgate", 72, "Captain", 5_046_000_000L, true, "Tremor-Tremor Fruit", "Sea Quake", "Helmet Splitter", "Island Shaking");
        CrewMember marco = new CrewMember("Marco", 45, "Doctor", 1_374_000_000, true, "Pheonix-Pheonix Fruit", "Undying Thistle", "Phenoix Brand", "Phoenix Pyreapple");
        CrewMember thatch = new CrewMember("Thatch", 46, "Chef", 500_000_000, false, "Swordsmanship");
        CrewMember izo = new CrewMember("Izo", 45, "Marksman", 510_000_000, false, "Dual Flintlock Pistols", "Bullet Slicing Rounds");
        CrewMember oden = new CrewMember("Kozuki Oden", 39, "Archaeologist", 1_000_000_000, false, "Oden: Two-Sword Style", "Paradise Waterfall", "Gun Modoki", "Paradise Totsuka");
        CrewMember jozu = new CrewMember("Jozu", 42, "Fighter", 700_000_000, true, "Diamond-Diamond Fruit", "Brilliant Punk");
        CrewMember vista = new CrewMember("Vista", 47, "Fighter", 650_000_000, false, "Two-Sword Style");

        CrewMember teech = new CrewMember("Marshall D. Teech", 40, "Captain", 2_247_600_000L, true, "Dark-Dark Fruit", "Black Hole", "Liberation", "Black Vortex");
        CrewMember burgess = new CrewMember("Jesus Burgess", 29, "Helmsman", 150_000_000, false, "Brute Strength", "Shockwave Elbow");
        CrewMember augur = new CrewMember("Van Augur", 27, "Marksman", 300_000_000, false, "Senriku Rifle");
        CrewMember lafitte = new CrewMember("Laffitte", 41, "Navigator", 220_000_000, true, "Unknown Devil Fruit");
        CrewMember docQ = new CrewMember("Doc Q", 28, "Doctor", 350_000_000, false, "Double Sided Scythe");
        CrewMember shiryu = new CrewMember("Shiryu of the Rain", 44, "Fighter", 1_600_000_000, true, "Clear-Clear Fruit");

        CrewMember ace = new CrewMember("Portgas D. Ace", 20, "Captain", 550_000_000, true, "Flame-Flame Fruit", "Fire Fist", "Firefly", "Flame Emperor");
        CrewMember deuce = new CrewMember("Masked Deuce", 21, "Doctor", 100_000_000, false, "Strategic Combat");
        CrewMember mihal = new CrewMember("Mihal", 39, "Marksman", 80_000_000, false, "Single Rifle");
        CrewMember skull = new CrewMember("Skull", 28, "Member", 90_000_000, false, "Swordsmanship");

        CrewMember shanks = new CrewMember("Shanks", 39, "Captain", 4_048_900_000L, false, "Haki Mastery");
        CrewMember benn = new CrewMember("Benn Beckman", 50, "Fighter", 2_000_000_000, false, "Long-Rifle");
        CrewMember yasopp = new CrewMember("Yasopp", 47, "Marksman", 1_400_000_000, false, "All Firearms");
        CrewMember roux = new CrewMember("Lucky Roux", 35, "Fighter", 1_800_000_000, false, "Unknown");

        // adding the pirates to their respective crews
        strawHatPirates.add(luffy);
        strawHatPirates.add(zoro);
        strawHatPirates.add(nami);
        strawHatPirates.add(usopp);
        strawHatPirates.add(sanji);
        strawHatPirates.add(chopper);
        strawHatPirates.add(robin);
        strawHatPirates.add(franky);
        strawHatPirates.add(brook);
        strawHatPirates.add(jimbei);

        heartPirates.add(law);
        heartPirates.add(bepo);
        heartPirates.add(penguin);
        heartPirates.add(shachi);

        whitebeardPirates.add(newgate);
        whitebeardPirates.add(marco);
        whitebeardPirates.add(oden);
        whitebeardPirates.add(jozu);
        whitebeardPirates.add(thatch);
        whitebeardPirates.add(vista);
        whitebeardPirates.add(izo);

        blackbeardPirates.add(teech);
        blackbeardPirates.add(burgess);
        blackbeardPirates.add(augur);
        blackbeardPirates.add(lafitte);
        blackbeardPirates.add(docQ);
        blackbeardPirates.add(shiryu);

        spadePirates.add(ace);
        spadePirates.add(deuce);
        spadePirates.add(mihal);
        spadePirates.add(skull);

        redHairPirates.add(shanks);
        redHairPirates.add(benn);
        redHairPirates.add(yasopp);
        redHairPirates.add(roux);

        // set the array of crews to both ListViews
        crewList.setItems(FXCollections.observableArrayList(crews));
        crewListTwo.setItems(FXCollections.observableArrayList(crews));

        // this will run whenever a different item is selected in the list of crews
        crewList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldSelection, newSelection) -> {
            try{
                // turn the ship label on and set it to the ship's name
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
            // ignore any null pointer exception
            catch (NullPointerException ignored){}
        });

        // this will run whenever a different item is selected in the list of pirates
        pirateList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldSelection, newSelection) -> {
            try{
                // set the image and text box to the pirate object that is selected
                pirateImage.setImage(new Image(String.valueOf(getClass().getResource(newSelection.getImageLocation()).toExternalForm())));
                pirateInfoLabel.setText(newSelection.getData());
            }
            // ignore any null pointer exception
            catch (NullPointerException ignored){}
        });

        // this will run when the Add To Crew button is pressed
        addButton.setOnAction(event -> {
            // set the crew to be added to from the list view
            PirateCrew crew = crewListTwo.getSelectionModel().getSelectedItem();
            // get the attacks from the text area, and split between the comma and space
            String[] attacks = attacksTextBox.getText().split(", ");
            try{
                // if there are no attacks, then don't add them in the constructor
                if (attacks[0].length() == 0)
                    crew.add(new CrewMember(nameField.getText(), Integer.parseInt(ageField.getText()), roleComboBox.getValue(), Long.parseLong(bountyField.getText()), devilFruitCheck.isSelected(), powerTextBox.getText()));
                // otherwise, use the full constructor
                else
                    crew.add(new CrewMember(nameField.getText(), Integer.parseInt(ageField.getText()), roleComboBox.getValue(), Integer.parseInt(bountyField.getText()), devilFruitCheck.isSelected(), powerTextBox.getText(), attacks));
            }
            // catch a null value from the crew or combo box
            catch (NullPointerException npe){
                errorLabel.setVisible(true);
                errorLabel.setText("An existing crew and\nrole MUST be selected");
                return;
            }
            // catch a non-numerical value from the age or bounty text fields
            catch (NumberFormatException nfe){
                errorLabel.setVisible(true);
                errorLabel.setText("Age and Bounty fields MUST\nbe positive numerical values");
                return;
            }
            // catch a constructor thrown illegal argument exception, and show it to the user
            catch (IllegalArgumentException ex){
                errorLabel.setVisible(true);
                errorLabel.setText(ex.getMessage());
                return;
            }
            // set the image location to the default blank image
            crew.getCrew().get(crew.getCrew().size() - 1).setImageLocation("img/people/blank.jpg");
            // add the new pirate to the selected crew
            crewList.setItems(FXCollections.observableArrayList(crews));
            // clear all input fields
            nameField.clear();
            ageField.clear();
            roleComboBox.getSelectionModel().selectFirst();
            devilFruitCheck.setSelected(false);
            powerTextBox.clear();
            attacksTextBox.clear();
            bountyField.clear();
            errorLabel.setVisible(false);
        });
    }
}