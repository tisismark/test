package logic.components;

import java.util.Objects;

public class Food {
    // fields
    private String name;
    private int price;
    private int energy;
    
    // methods
    public Food(String name, int price, int energy) {
        setName(name);
        setPrice(price);
        setEnergy(energy);
    }

    public boolean equals(Object o) {
        Food food = (Food) o;
        return this.name == food.getName() && this.price == food.getPrice() && this.energy == food.getEnergy();
    }

    // getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 1) {
            price = 1;
        }
        this.price = price;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if (energy < 1) {
            energy = 1;
        }
        this.energy = energy;
    }
}
