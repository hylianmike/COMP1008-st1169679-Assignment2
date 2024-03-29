package com.example.comp1008st1169679assignment2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrewMemberTest {

    private CrewMember pirate;

    @BeforeEach
    void setUp() {
        pirate = new CrewMember("Luffy", 20, "Captain", 100_000_000, true, "Human-Human Fruit", "Punch", "Kick", "Headbutt");
    }

    @Test
    void setBounty() {
        pirate.setBounty(500);
        assertEquals(500, pirate.getBounty());
    }

    @Test
    void setBountyInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            pirate.setBounty(-1);
        });
    }

    @Test
    void setName() {
        pirate.setName("A Real One");
        assertEquals("A Real One", pirate.getName());
    }

    @Test
    void setNameInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            pirate.setName(" B ");
        });
    }

    @Test
    void setAge() {
        pirate.setAge(22);
        assertEquals(22, pirate.getAge());
    }

    @Test
    void setAgeInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            pirate.setAge(-1);
        });
    }

    @Test
    void setDevilFruitFalse() {
        pirate.setDevilFruit(false);
        assertFalse(pirate.hasDevilFruit());
    }

    @Test
    void setDevilFruitTrue() {
        pirate.setDevilFruit(true);
        assertTrue(pirate.hasDevilFruit());
    }

    @Test
    void setPower() {
        pirate.setPower("Swordsman");
        assertEquals("Swordsman", pirate.getPower());
    }

    @Test
    void setPowerInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            pirate.setPower("    ");
        });
    }

    @Test
    void testToString() {
        assertEquals(pirate.getName(), pirate.toString());
    }

    @Test
    void getData() {
        String moves = "";
        for (String attack : pirate.getAttacks()) {
            moves += attack + "\n";
        }
        assertEquals(String.format("Age: %s%nRole: %s%nBounty: %n%,d Berries%n%n%s%n~Notable Attacks~%n%s", pirate.getAge(), pirate.getRole(), pirate.getBounty(), String.format("Devil Fruit Power:%n%s", pirate.getPower()), moves), pirate.getData());
    }

    @Test
    void getDataNoDevilFruit() {
        pirate.setDevilFruit(false);
        String moves = "";
        for (String attack : pirate.getAttacks()) {
            moves += attack + "\n";
        }
        assertEquals(String.format("Age: %s%nRole: %s%nBounty: %n%,d Berries%n%n%s%n~Notable Attacks~%n%s", pirate.getAge(), pirate.getRole(), pirate.getBounty(), String.format("Fighting Style:%n%s", pirate.getPower()), moves), pirate.getData());
    }

    @Test
    void getDataNoAttacks() {
        pirate.setAttacks();
        String moves = "";
        for (String attack : pirate.getAttacks()) {
            moves += attack + "\n";
        }
        assertEquals(String.format("Age: %s%nRole: %s%nBounty: %n%,d Berries%n%n%s%n~Notable Attacks~%n%s", pirate.getAge(), pirate.getRole(), pirate.getBounty(), pirate.hasDevilFruit() ? String.format("Devil Fruit Power:%n%s", pirate.getPower()) : String.format("Fighting Style:%n%s", pirate.getPower()), "None As Of Yet"), pirate.getData());
    }


    @Test
    void setRole() {
        pirate.setRole("Navigator");
        assertEquals("Navigator", pirate.getRole());
    }

    @Test
    void setRoleInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            pirate.setRole("Accountant");
        });
    }

    @Test
    void setAttacks() {
        pirate.setAttacks("Left Hook", "Right Kick");
        assertEquals("[Left Hook, Right Kick]", pirate.getAttacks().toString());
    }

    @Test
    void setAttacksInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            pirate.setAttacks("Punchy", "   ");
        });
    }

    @Test
    void setImageConstructor() {
        pirate = new CrewMember("Zoro", 25, "Fighter", 200_000_000, false, "Swordsmanship", "Slice", "Slice and Dice");
        assertEquals("img/people/zoro.png", pirate.getImageLocation());
    }

    @Test
    void setImageLocation(){
        pirate.setImageLocation("img/people/blank.jpg");
        assertEquals("img/people/blank.jpg", pirate.getImageLocation());
    }

    @Test
    void setImageLocationInvalid(){
        assertThrows(IllegalArgumentException.class, () -> {
            pirate.setImageLocation("blank.jpg");
        });
    }
}