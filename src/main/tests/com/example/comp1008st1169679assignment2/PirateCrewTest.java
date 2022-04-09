package com.example.comp1008st1169679assignment2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PirateCrewTest {

    private PirateCrew crew;
    private CrewMember luffy = new CrewMember("Luffy", 20, "Captain", 100_000_000, true, "Human-Human Fruit", "Punch", "Kick", "Headbutt");
    private CrewMember zoro = new CrewMember("Zoro", 25, "Fighter", 200_000_000, false, "Swordsmanship", "Slice", "Slice and Dice");

    @BeforeEach
    void setUp() {
        crew = new PirateCrew("Straw Hat Pirates", "Sunny");
        crew.add(luffy);
        crew.add(zoro);
    }

    @Test
    void setName() {
        crew.setName("Heart Pirates");
        assertEquals("Heart Pirates", crew.getName());
    }

    @Test
    void setNameInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            crew.setName("Heart");
        });
    }

    @Test
    void setNameInvalidTwo() {
        assertThrows(IllegalArgumentException.class, () -> {
            crew.setName("pirates");
        });
    }

    @Test
    void setShip() {
        crew.setShip("Another");
        assertEquals("Another", crew.getShip());
    }

    @Test
    void setShipInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            crew.setShip(" A  ");
        });
    }

    @Test
    void testToString() {
        assertEquals("Straw Hat Pirates", crew.toString());
    }

    @Test
    void add() {
        crew.add(new CrewMember("Nami", 20, "Navigator", 50_000_000, false, "Climatact"));
        assertEquals(3, crew.getCrew().size());
    }

    @Test
    void getTotalBounty() {
        assertEquals(300_000_000, crew.getTotalBounty());
    }

    @Test
    void setFlag(){
        crew.setFlag("img/flags/heart.png");
        assertEquals("img/flags/heart.png", crew.getFlag());
    }

    @Test
    void setFlagInvalid(){
        assertThrows(IllegalArgumentException.class, () -> {
            crew.setFlag("heart.png");
        });
    }

    @Test
    void setShipLocation(){
        crew.setShipLocation("img/ships/tang.png");
        assertEquals("img/ships/tang.png", crew.getShipLocation());
    }

    @Test
    void setShipLocationInvalid(){
        assertThrows(IllegalArgumentException.class, () -> {
            crew.setShipLocation("tang.png");
        });
    }

    @Test
    void setCrew(){
        crew.setCrew(new ArrayList<>(List.of(new CrewMember[]{zoro, luffy})));
        assertEquals(new ArrayList<>(List.of(new CrewMember[]{zoro, luffy})), crew.getCrew());
    }
}