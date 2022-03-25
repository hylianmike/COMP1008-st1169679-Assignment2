package com.example.comp1008st1169679assignment2;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class PirateCrew {

    private String name;
    private ArrayList<CrewMember> crew;
    private Image flag;

    public PirateCrew(String name){
        if (name.toLowerCase().endsWith("pirates") && name.split(" ").length > 1){
            this.name = name;
        }
        crew = new ArrayList<>();
        flag = new Image(getClass().getResource(String.format("img/flags/%s.png", name.toLowerCase().substring(0, name.indexOf(" ")))).toExternalForm());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String members = "";
        for (CrewMember member : crew) {
            members += member.toString() + "\n";
        }
        return name + "\n---------------------------------\n" + members;
    }

    public void add(CrewMember member){
        crew.add(member);
    }

    public Image getFlag() {
        return flag;
    }
}
