package logic.components;

import exception.BadStatusException;

import java.util.ArrayList;

public class Monster {
    // fields
    private String name;
    private Status status;
    private Food food;
    private Potion potion;

    // methods
    public Monster(String name, Status status) {
        this.name = name;
        if (status.getHp() < 1) {
            try {
                status.setHp(1);
            } catch (BadStatusException e) {}
        }
        this.status = status;
        this.food = null;
        this.potion = null;
    }

    public void attack(Player player) {
        int totalDamage = this.status.getAttack() - player.getStatus().getDurability();
        try {
            if (totalDamage >= 0) {
                player.getStatus().setHp(Math.max((player.getStatus().getHp() - totalDamage), 0));
            }
        } catch(BadStatusException b) {}
    }
    public void magicAttack(Player player) {
        try {
            player.getStatus().setHp(Math.max((player.getStatus().getHp() - this.getStatus().getMagic()), 0));
        } catch (BadStatusException e) {}
    }

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

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }
}
