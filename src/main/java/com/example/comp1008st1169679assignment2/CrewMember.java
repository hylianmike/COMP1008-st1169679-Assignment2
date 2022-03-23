package com.example.comp1008st1169679assignment2;

public class CrewMember {

    private String name;
    private int age;
    private boolean devilFruit;
    private String power;

    public CrewMember(String name, int age, boolean devilFruit, String power) {
        setName(name);
        setAge(age);
        setDevilFruit(devilFruit);
        setPower(power);
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
        return String.format("Name: %s%nAge: %s%nDevil Fruit: %s%nSpecial Power: %s%n", getName(), getAge(), hasDevilFruit() ? "Yes" : "No", getPower());
    }
}
