package logic.components;

public class Potion {
    // fields
    private String name;
    private int price;
    private Status increasingStatus;

    // methods
    public Potion(String name, int price, Status increasingStatus) {
        setName(name);
        setPrice(price);
        setIncreasingStatus(increasingStatus);
    }
    public boolean equals(Object o) {
        Potion potion = (Potion) o;
        return this.name == potion.getName() && this.price == potion.getPrice() && this.increasingStatus == potion.getIncreasingStatus();
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
        if (price < 1) {price = 1;}
        this.price = price;
    }

    public Status getIncreasingStatus() {
        return increasingStatus;
    }

    public void setIncreasingStatus(Status increasingStatus) {
        this.increasingStatus = increasingStatus;
    }
}
