package marketplace;

import java.util.ArrayList;

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
            userIdThatBought.remove(userIdThatBought.indexOf(id));
        }
    }

    public void showAllUsers() {
        if(userIdThatBought.size() > 0)  {
            for(int userId : userIdThatBought) {
                System.out.println("Product " + name + " was bought by user with id " + userId);
            }
        } else {
            System.out.println("There are no user that was bought it");
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
