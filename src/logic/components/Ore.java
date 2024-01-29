package logic.components;

public class Ore {
    //fields
    private String name;
    private int cost;

    // methods
    public Ore(String name,int cost) {
        setName(name);
        setCost(cost);
    }

    public boolean equals(Object o) {
        Ore ore = (Ore) o;
        return this.name == ore.getName() && this.cost == ore.getCost();
    }

    // getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if (cost < 1) {cost = 1;}
        this.cost = cost;
    }
}
