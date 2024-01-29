package logic.components;

import exception.BadStatusException;

public class Status {
    private int hp;
    private int durability;
    private int attack;
    private int magic;

    // methods
    public Status(int hp, int durability, int attack, int magic) throws BadStatusException {
            setHp(hp);
            setDurability(durability);
            setAttack(attack);
            setMagic(magic);

    }
    public boolean equals(Object o) {
        Status status = (Status) o;
        return ((this.hp == status.getHp()) && (this.durability == status.getDurability()) && (this.attack == status.getAttack()) && (this.magic == status.getMagic()));
    }
    public void addStatus(Status another) throws BadStatusException {
        setHp(this.hp + another.getHp());
        setDurability(this.durability + another.getDurability());
        setAttack(this.attack + another.getAttack());
        setMagic(this.magic + another.getMagic());
    }

    // getter setter
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) throws BadStatusException {
        if (hp < 0) {
            this.hp = 0;
            throw new BadStatusException();
        } else {
            this.hp = hp;
        }
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) throws BadStatusException {
        if (durability < 0) {
            this.durability = 0;
            throw new BadStatusException();
        } else {
            this.durability = durability;
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) throws BadStatusException {
        if (attack < 0) {
            this.attack = 0;
            throw new BadStatusException();
        } else {
            this.attack = attack;
        }
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) throws BadStatusException {
        if (magic < 0) {
            this.magic = 0;
            throw new BadStatusException();
        } else {
            this.magic = magic;
        }
    }
}
