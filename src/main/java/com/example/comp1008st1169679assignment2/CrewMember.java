package com.example.comp1008st1169679assignment2;

import javafx.scene.image.Image;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrewMember {

    private String name;
    private int age;
    private String role;
    private boolean devilFruit;
    private String power;
    private Image image;

    public CrewMember(String name, int age, String role, boolean devilFruit, String power) {
        setName(name);
        setAge(age);
        setRole(role);
        setDevilFruit(devilFruit);
        setPower(power);
        image = new Image(getClass().getResource(String.format("img/people/%s.png", name)).toExternalForm());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 1)
            this.name = name;
        else
            throw new IllegalArgumentException("Name must be at least two characters long");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0)
            this.age = age;
        else
            throw new IllegalArgumentException("Character must be born");
    }

    public boolean hasDevilFruit() {
        return devilFruit;
    }

    public void setDevilFruit(boolean devilFruit) {
        this.devilFruit = devilFruit;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        if (power.length() > 0)
            this.power = power;
        else
            throw new IllegalArgumentException("Any good pirate must have a power to sail the seas!");
    }

    @Override
    public String toString(){
        return String.format("Name: %s%nAge: %s%nRole: %s%nDevil Fruit: %s%nSpecial Power: %s%n", getName(), getAge(), getRole(), hasDevilFruit() ? "Yes" : "No", getPower());
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        List<String> validRoles = Arrays.asList("captain", "fighter", "navigator", "doctor", "chef", "marksman", "shipwright", "helmsman", "musician", "archaeologist");
        if (validRoles.contains(role.toLowerCase()))
            this.role = role;
        else
            throw new IllegalArgumentException("Role must be one of these: " + validRoles);
    }

    public Image getImage() {
        return image;
    }
}
