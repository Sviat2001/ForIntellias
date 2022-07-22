package marketplace;

import java.util.ArrayList;
import java.util.Scanner;

public class MarketPlace {
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
                case 5:
                    buyProduct();
                    break;
                case 6:
                    showUserProductsById();
                    break;
                case 7:
                    showProductUsersById();
                    break;
                case 8:
                    deleteProductById();
                    break;
                case 9:
                    deleteUserById();
                    break;
                case 10:
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
        System.out.println("5. Buy product");
        System.out.println("6. Display list of all id products by user id");
        System.out.println("7. Display list of all id users by product id");
        System.out.println("8. Delete product by id");
        System.out.println("9. Delete user by id");
        System.out.println("10. Exit");
    }

    public void addProduct() {
        System.out.println("Please enter name : ");
        String name = scanner.next();
        System.out.println("Please enter price : ");
        int price = scanner.nextInt();
        if(name != null) {
            products.add(new Product(name, price));
        } else {
            System.out.println("Error. Null String");
        }
    }

    public void addUser() {
        System.out.println("Please enter first name : ");
        String firstName = scanner.next();
        System.out.println("Please enter last name : ");
        String lastName = scanner.next();
        System.out.println("Please enter amount of money : ");
        int amountOfMoney = scanner.nextInt();
        if(firstName != null || lastName != null) {
            users.add(new User(firstName, lastName, amountOfMoney));
        } else {
            System.out.println("Error. Null String");
        }
    }

    public void buyProduct() {
        System.out.println("Please enter user id : ");
        int userId = scanner.nextInt();
        System.out.println("Please enter product id : ");
        int productId = scanner.nextInt();

        Product buffer = null;
        for(Product product : products) {
            if(product.getId() == productId) {
                buffer = product;
                break;
            }
        }

        if(buffer != null) {
            for (User user : users) {
                if (user.getId() == userId) {
                    if (user.buyProduct(buffer)) {
                        buffer.buyingThisProduct(userId);
                    }
                }
            }
        } else {
            System.out.println("Incorrect product id!");
        }
    }

    public void deleteProductById() {
        Product buffer = null;
        System.out.println("Please enter product id : ");
        int productId = scanner.nextInt();

        for(Product product : products) {
            if(product.getId() == productId) {
                buffer = product;
            }
        }

        if(buffer != null) {
            products.remove(buffer);

            for(User user : users) {
                user.deleteProduct(productId);
            }
        } else {
            System.out.println("There are no products with id " + productId);
        }

    }

    public void deleteUserById() {
        System.out.println("Please enter user id : ");
        int userId = scanner.nextInt();
        User buffer = null;

        for(User user : users) {
            if(user.getId() == userId) {
                buffer = user;
            }
        }

        if(buffer != null) {
            users.remove(buffer);

            for(Product product : products) {
                product.deleteUser(userId);
            }
        } else {
            System.out.println("There are no users with id " + userId);
        }
    }

    public void showUserProductsById() {
        System.out.println("Please enter user id : ");
        int userId = scanner.nextInt();

        for(User user : users) {
            if(user.getId() == userId) {
                user.showAllProducts();
            }
        }
    }

    public void showProductUsersById() {
        System.out.println("Please enter product id : ");
        int productId = scanner.nextInt();

        for(Product product : products) {
            if(product.getId() == productId) {
                product.showAllUsers();
            }
        }
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
