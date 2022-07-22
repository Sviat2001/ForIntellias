package marketplace;

import java.util.*;

public class Product {
    static int currentId = 0;
    int id;
    String name;
    int price;
    ArrayList<Integer> userIdThatBought = new ArrayList<Integer>();

    Product(String name, int price) {
        this.id = currentId++;
        this.name = name;
        this.price = price;
    }

    public void buyingThisProduct(int id) {
        userIdThatBought.add(id);
    }

    public void deleteUser(int id) {
        while(userIdThatBought.indexOf(id) != -1) {
            userIdThatBought.remove(id);
        }
    }

    public void showProductInfo() {
        System.out.println("Id: " + id + "\tName: " + name + "\tPrice: " + price);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
