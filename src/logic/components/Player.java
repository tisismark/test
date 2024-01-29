package logic.components;

import exception.BadStatusException;

import java.util.ArrayList;

public class Player {
    // fields
    private String name;
    private Status status;
    private int energy;
    private int money;
    private ArrayList<Food> foods;
    private ArrayList<Potion> potions;
    private ArrayList<Ore> ores;

    // methods
    public Player(String name, Status status) {
        setName(name);
        if (status.getHp() < 1) {
            try {
                status.setHp(1);
            } catch (BadStatusException e) {}
        }
        setStatus(status);
        setEnergy(10);
        setMoney(100);
        setFoods(new ArrayList<Food>());
        setPotions(new ArrayList<Potion>());
        setOres(new ArrayList<Ore>());
    }
    public Player(String name, Status status, int energy, int money) {
        setName(name);
        if (status.getHp() < 1) {
            try {
                status.setHp(1);
            } catch (BadStatusException e) {}
        }
        setStatus(status);
        setEnergy(energy);
        setMoney(money);
        setFoods(new ArrayList<Food>());
        setPotions(new ArrayList<Potion>());
        setOres(new ArrayList<Ore>());
    }
    public boolean buyOre(Ore ore) {
        if (this.money >= ore.getCost()) {
            this.money -= ore.getCost();
            this.ores.add(ore);
            return true;
        }
        return false;
    }
    public void drinkPotion(int index) {
        try {
            if (index >= 0 && (index <= (potions.size() - 1))) {
                status.addStatus(potions.get(index).getIncreasingStatus());
                potions.remove(index);
            }
        } catch (BadStatusException b) {}
    }
    public void eatFood(int index) {
        if (index >= 0 && (index <= (foods.size() - 1))) {
            energy += foods.get(index).getEnergy();
            foods.remove(index);
        }
    }
    public void sellPotion(int index) {
        if (index >= 0 && (index <= (potions.size() - 1))) {
            money += potions.get(index).getPrice();
            potions.remove(index);
        }
    }
    public void sellFood(int index) {
        if (index >= 0 && (index <= (foods.size() - 1))) {
            money += foods.get(index).getPrice();
            foods.remove(index);
        }
    }
    public void attack(Monster monster) {
        int totalDamage = this.status.getAttack() - monster.getStatus().getDurability();
        try {
            if (totalDamage >= 0) {
                monster.getStatus().setHp(Math.max((monster.getStatus().getHp() - totalDamage), 0));
            }
        } catch(BadStatusException b) {}
    }
    public void magicAttack(Monster monster) {
        try {
            monster.getStatus().setHp(Math.max((monster.getStatus().getHp() - this.getStatus().getMagic()), 0));
        } catch (BadStatusException e) {}
    }

    // getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if (energy < 0) {energy = 0;}
        this.energy = energy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money < 0) {money = 0;}
        this.money = money;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public ArrayList<Ore> getOres() {
        return ores;
    }

    public void setOres(ArrayList<Ore> ores) {
        this.ores = ores;
    }
}
