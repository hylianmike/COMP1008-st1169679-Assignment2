package com.example.comp1008st1169679assignment2;

import java.util.ArrayList;

public class PirateCrew {

    private String name;
    private ArrayList<CrewMember> crew;

    public PirateCrew(String name){
        if (name.toLowerCase().endsWith("pirates") && name.split(" ").length > 1){
            this.name = name;
        }
        crew = new ArrayList<>();
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
}
