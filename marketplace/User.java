package marketplace;

import java.util.ArrayList;

public class User {
    static int currentId = 0;
    int id;
    String firstName;
    String lastName;
    int amountOfMoney;
    ArrayList<Integer> productIdThatBought = new ArrayList<Integer>();
    User(String firstName, String lastName, int amountOfMoney) {
        this.id = currentId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
    }

    public void showAllProducts() {
        if(productIdThatBought.size() > 0) {
            for(int productId : productIdThatBought) {
                System.out.println("User " + firstName + " bought product with id " + productId);
            }
        } else {
            System.out.println("There are no products bought by this user");
        }
    }

    public void showUserInfo() {
        System.out.println("   Id: " + id + "   First name: " + firstName + "   Last name: "
                + lastName + "   Ammount of money: " + amountOfMoney);
    }

    public boolean buyProduct(Product product) {
        try{
            if(amountOfMoney - product.getPrice() >= 0) {
                productIdThatBought.add(product.getId());
                amountOfMoney -= product.getPrice();
                System.out.println("Successful buying product " + product.getName() + " by user " + firstName);
            } else {
                throw new NotEnoughFunds();
            }
        }catch(Exception exception) {
            System.out.println("Exception: " + exception.toString());
            return false;
        }
        return true;
    }

    public void deleteProduct(int id) {
        while(productIdThatBought.indexOf(id) != -1) {
            productIdThatBought.remove(productIdThatBought.indexOf(id));
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }
}
