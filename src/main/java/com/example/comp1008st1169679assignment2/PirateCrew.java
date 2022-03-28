package com.example.comp1008st1169679assignment2;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class PirateCrew {

    // name, list of pirates (crew) and jolly roger
    private String name;
    private ArrayList<CrewMember> crew;
    private Image flag;

    /**
     * constructor for a Pirate Crew object. creates a new ArrayList for the crew. the parameter is used to render the image for the flag as well
     * @param name must end with "Pirates" and have a name before of at least 2 characters.
     */
    public PirateCrew(String name){
        if (name.toLowerCase().endsWith("pirates") && name.split(" ").length > 1){
            this.name = name;
        }
        crew = new ArrayList<>();
        flag = new Image(getClass().getResource(String.format("img/flags/%s.png", name.toLowerCase().substring(0, name.indexOf(" ")))).toExternalForm());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCrew(ArrayList<CrewMember> crew) {
        this.crew = crew;
    }

    public void setFlag(Image flag) {
        this.flag = flag;
    }

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
     * method to get the flag image
     * @return the image of the object (The crew's jolly roger)
     */
    public Image getFlag() {
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
