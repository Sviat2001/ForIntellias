package marketplace;

import java.util.ArrayList;
import java.util.Scanner;

public class MarketPlace {
    int currentProductId;
    int currentUserId;
    ArrayList<Product> products = new ArrayList<Product>();
    ArrayList<User> users = new ArrayList<User>();
    Scanner scanner = new Scanner(System.in);

    static public void main(String[] args) {
        MarketPlace test = new MarketPlace();
        test.menu();
    }

    public void menu() {
        boolean exitFlag = false;
        while(true) {
            showMenu();

            int number = scanner.nextInt();
            switch(number) {
                case 1:
                    addUser();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    showUsers();
                    break;
                case 4:
                    showProducts();
                    break;
                case 9:
                    exitFlag = true;
                    break;
                default:
                    System.out.println("Incorrect number! Please try again");
                    break;

            }
            if(exitFlag) {
                break;
            }

        }
        scanner.close();
    }

    public void showMenu() {
        System.out.println("\nMenu: ");
        System.out.println("1. Add user");
        System.out.println("2. Add product");
        System.out.println("3. Display list of all users");
        System.out.println("4. Display list of all products");
    }

    public void addProduct() {
        System.out.println("Please enter name : ");
        String name = scanner.next();
        System.out.println("Please enter price : ");
        int price = scanner.nextInt();
        products.add(new Product(name, price));
    }

    public void addUser() {
        System.out.println("Please enter first name : ");
        String firstName = scanner.next();
        System.out.println("Please enter last name : ");
        String lastName = scanner.next();
        System.out.println("Please enter amount of money : ");
        int amountOfMoney = scanner.nextInt();
        System.out.println("Please enter amount of money : ");
        users.add(new User(firstName, lastName, amountOfMoney));
    }

    public void showProducts() {
        System.out.println("\nProducts");
        for(Product product : products) {
            product.showProductInfo();
        }
    }

    public void showUsers() {
        System.out.println("\nUsers");
        for(User user : users) {
            user.showUserInfo();
        }
    }
}
