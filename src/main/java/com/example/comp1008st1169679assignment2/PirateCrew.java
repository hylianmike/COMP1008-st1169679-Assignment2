package com.example.comp1008st1169679assignment2;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class PirateCrew {

    // name, list of pirates (crew) and jolly roger
    private String name, ship;
    private ArrayList<CrewMember> crew;
    private String flag;
    private String shipLocation;

    /**
     * constructor for a Pirate Crew object. creates a new ArrayList for the crew. the parameter is used to render the image for the flag as well
     * @param name must end with "Pirates" and have a name before of at least 2 characters.
     */
    public PirateCrew(String name, String ship){
        setName(name);
        setShip(ship);
        crew = new ArrayList<>();
        flag = String.format("img/flags/%s.png", this.name.toLowerCase().substring(0, name.indexOf(" ")));
        shipLocation = String.format("img/ships/%s.png", this.ship.split(" ")[ship.split(" ").length - 1].toLowerCase());
    }

    /**
     * Setter for the members of the crew
     * @param crew - ArrayList of CrewMembers to be set to the object
     */
    public void setCrew(ArrayList<CrewMember> crew) {
        this.crew = crew;
    }

    /**
     * Setter for the flag instance variable
     * @param flag - file path to the flag image, must start with "img/flags/"
     */
    public void setFlag(String flag) {
        flag = flag.trim();
        if (flag.startsWith("img/flags/"))
            this.flag = flag;
        else
            throw new IllegalArgumentException("Flag file path must be in the \"img/flags\" directory");
    }

    /**
     * Setter for the image location of the ship image
     * @param shipLocation - file path for ship image, must start with "img/ships/"
     */
    public void setShipLocation(String shipLocation) {
        shipLocation = shipLocation.trim();
        if (shipLocation.startsWith("img/ships/"))
            this.shipLocation = shipLocation;
        else
            throw new IllegalArgumentException("Flag file path must be in the \"img/ships\" directory");

    }

    /**
     * Getter for the ship location
     * @return the file path to the corresponding ship image
     */
    public String getShipLocation() {
        return shipLocation;
    }

    /**
     * Setter for the name instance variable
     * @param name - name of the pirate crew. must be called the "______ pirates", where the blank can be filled with anything
     */
    public void setName(String name) {
        name = name.trim();
        if (name.toLowerCase().endsWith("pirates") && name.split(" ").length > 1){
            this.name = name;
        }
        else
            throw new IllegalArgumentException("Crew name must end with \"Pirates\" and have a name before of at least 2 characters.");
    }

    /**
     * Getter for the ship name
     * @return the name of the ship of the crew
     */
    public String getShip() {
        return ship;
    }

    /**
     * Setter for the ship instance variable
     * @param ship - name of the pirate ship. Must be at least 2 characters long
     */
    public void setShip(String ship) {
        ship = ship.trim();
        if (ship.length() > 1){
            this.ship = ship;
        }
        else
            throw new IllegalArgumentException("Ship name must be at least 2 characters.");
    }

    /**
     * Getter for the name of the crew
     * @return the name of the crew
     */
    public String getName() {
        return name;
    }

    /**
     * Overridden toString() method
     * @return the object's name instance variable
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Method to add a crewmate to the crew
     * @param member will be added to the object's crew instance variable
     */
    public void add(CrewMember member){
        crew.add(member);
    }

    /**
     * method to get the flag image location
     * @return the file location of the flag image
     */
    public String getFlag() {
        return flag;
    }

    /**
     * method to get the crew ArrayList
     * @return the ArrayList of CrewMembers for the specified Pirate Crew
     */
    public ArrayList<CrewMember> getCrew() {
        return crew;
    }

    /**
     * Method to get the total bounty of the notable crew members
     * @return the sum of all bounties from the crew
     */
    public long getTotalBounty(){
        long totalBounty = 0;
        for (CrewMember pirate : crew) {
            totalBounty += pirate.getBounty();
        }
        return totalBounty;
    }
}
