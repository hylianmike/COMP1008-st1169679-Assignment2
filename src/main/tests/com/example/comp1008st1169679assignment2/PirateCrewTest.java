package com.example.comp1008st1169679assignment2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PirateCrewTest {

    private PirateCrew crew;

    @BeforeEach
    void setUp() {
        crew = new PirateCrew("Straw Hat Pirates", "Sunny");
        crew.add(new CrewMember("Luffy", 20, "Captain", 100_000_000, true, "Human-Human Fruit", "Punch", "Kick", "Headbutt"));
        crew.add(new CrewMember("Zoro", 25, "Fighter", 200_000_000, false, "Swordsmanship", "Slice", "Slice and Dice"));
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
    void getFlag(){
        assertEquals("img/flags/straw.png", crew.getFlag());
    }

    @Test
    void getShipLocation(){
        assertEquals("img/ships/sunny.png", crew.getShipLocation());
    }
}