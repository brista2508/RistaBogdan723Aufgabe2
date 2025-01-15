import java.util.*;
import java.util.stream.Collectors;

public class Player {
    private String name;
    private int age;
    private String position;
    private double marketValue;

    public Player(String name, int age, String position, double marketValue) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.marketValue = marketValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public String toString() {
        return name + " (" + age + " Jahre, " + position + ", Marktwert: " + marketValue + "€)";
    }
}