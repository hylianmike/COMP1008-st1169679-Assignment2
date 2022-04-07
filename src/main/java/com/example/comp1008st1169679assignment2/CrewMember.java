package com.example.comp1008st1169679assignment2;

import javafx.scene.image.Image;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrewMember {

    // instance variables for name, age, role, bounty, whether they have a devil fruit or not, method of combat, notable attacks, and image
    private String name;
    private int age;
    private String role;
    private long bounty;
    private boolean devilFruit;
    private String power;
    private ArrayList<String> attacks;
    private String imageLocation;

    /**
     *
     * Constructor for a pirate
     * @param name Name of the pirate
     * @param age Age of the pirate
     * @param role Role that the pirate plays in the crew
     * @param bounty Government issued bounty of the pirate
     * @param devilFruit Whether the pirate has a devil fruit ability or not
     * @param power The pirate's method of combat
     * @param moves Any notable attacks that the pirate uses
     */
    public CrewMember(String name, int age, String role, long bounty, boolean devilFruit, String power, String... moves) {
        // set the attacks to a new ArrayList
        attacks = new ArrayList<>();
        setName(name);
        setAge(age);
        setRole(role);
        setBounty(bounty);
        setDevilFruit(devilFruit);
        setPower(power);
        setAttacks(moves);
        // create the image resource link based off the name parameter
        imageLocation = String.format("img/people/%s.png", this.name.split(" ")[name.split(" ").length - 1].toLowerCase());
    }

    /**
     * Getter for the bounty instance variable
     * @return the value of the pirate's bounty instance variable
     */
    public long getBounty() {
        return bounty;
    }

    /**
     * Setter for the bounty instance variable
     * @param bounty Must be at least 0 to be added
     */
    public void setBounty(long bounty) {
        if (bounty >= 0)
            this.bounty = bounty;
        else
            throw new IllegalArgumentException("Bounty cannot be negative.");
    }

    public String getName() {
        return name;
    }

    /**
     * Setter for the name instance variable
     * @param name Must be at least 2 characters long
     */
    public void setName(String name) {
        name = name.trim();
        if (name.length() > 1)
            this.name = name;
        else
            throw new IllegalArgumentException("Name must be at least two characters long");
    }

    public int getAge() {
        return age;
    }

    /**
     * Setter for the age instance variable
     * @param age Cannot be less than or equal to zero
     */
    public void setAge(int age) {
        if (age > 0)
            this.age = age;
        else
            throw new IllegalArgumentException("Character must be born");
    }

    public boolean hasDevilFruit() {
        return devilFruit;
    }

    /**
     * Setter for the devilFruit instance variable
     * @param devilFruit true if they do, false if they don't
     */
    public void setDevilFruit(boolean devilFruit) {
        this.devilFruit = devilFruit;
    }

    public String getPower() {
        return power;
    }

    /**
     * Setter for the power instance variable
     * @param power Must be at least one character long. What good is a pirate if they can't fight?
     */
    public void setPower(String power) {
        power = power.trim();
        if (power.length() > 0)
            this.power = power;
        else
            throw new IllegalArgumentException("Any good pirate must have a power to sail the seas!");
    }

    /**
     * Overridden toString() method
     * @return Just the name instance variable. No need for anything fancy
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Method to get all the information about the pirate. Kind of like your usual toString() method
     * @return a String containing all information pertaining to the pirate
     */
    public String getData(){
        String moves = "";
        for (String attack : attacks) {
            moves += attack + "\n";
        }
        return String.format("Name: %s%nAge: %s%nRole: %s%nBounty: %n%,d Berries%n%n" +
                "%s%n~Notable Attacks~%n%s",
                name, age, role, bounty, devilFruit ? String.format("Devil Fruit Power:%n%s", power) : String.format("Fighting Style:%n%s", power), moves);
    }

    public String getRole() {
        return role;
    }

    /**
     * Setter for the role instance variable
     * @param role Must be one of these choices: "Captain", "Fighter", "Navigator", "Doctor", "Chef", "Marksman", "Shipwright", "Helmsman", "Musician", "Archaeologist", "Other"
     */
    public void setRole(String role) {
        if (getValidRoles().contains(role.toLowerCase()))
            this.role = role;
        else
            throw new IllegalArgumentException("Role must be one of these: " + getValidRoles());
    }

    public void setImageLocation(String imageLocation) {
        imageLocation = imageLocation.trim();
        if (imageLocation.startsWith("img/people/"))
            this.imageLocation = imageLocation;
        else
            throw new IllegalArgumentException("File path must be in the img/peoples directory");
    }

    public static List<String> getValidRoles() {
        return Arrays.asList("captain", "fighter", "navigator", "doctor", "chef", "marksman", "shipwright", "helmsman", "musician", "archaeologist", "other");
    }

    /**
     * Getter for the image instance variable
     * @return The image for the pirate in question
     */
    public String getImageLocation() {
        return imageLocation;
    }

    /**
     * Setter for the attacks instance variable
     * @param attacks As many notable named-attacks that the pirate may use as Strings
     */
    public void setAttacks(String... attacks) {
        this.attacks.clear();
        for (String move : attacks) {
            move = move.trim();
            if(move.length() > 1)
                this.attacks.add(move);
            else
                throw new IllegalArgumentException("All attack names must be at least 2 characters");
        }
    }

    public ArrayList<String> getAttacks() {
        return attacks;
    }
}
