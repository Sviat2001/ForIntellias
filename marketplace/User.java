package marketplace;

import java.util.ArrayList;

public class User {
    static int currentId = 0;
    int id;
    String firstName;
    String lastName;
    int amountOfMoney;
    ArrayList<Integer> userIdThatBought;
    User(String firstName, String lastName, int amountOfMoney) {
        this.id = currentId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
    }

    public void showUserInfo() {
        System.out.println("   Id: " + id + "   First name: " + firstName + "   Last name: "
                + lastName + "   Ammount of money: " + amountOfMoney);
    }

    public boolean buyProduct(Product product) {
        try{
            if(amountOfMoney - product.getPrice() >= 0) {
                amountOfMoney -= product.getPrice();
                product.buyingThisProduct(id);
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
