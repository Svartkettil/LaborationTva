import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowProduct implements Menu{
    public void showProducts(ArrayList<Product> listOfProducts){
        listOfProducts.stream().forEach(System.out::println);
    }
    @Override
    public Menu handleInput(String command) {
        return new MainMenu();
    }

    @Override
    public void printMenu(ArrayList<Product> listOfProducts, Scanner sc) {
        System.out.println("""
                1: Visa alla produkter
                3: Tillbaks till huvudmenyn
                """);
        String choice = sc.nextLine();
        switch (choice) {
            case "1" -> showProducts(listOfProducts);
            case "2" -> new MainMenu();
            default -> printMenu(listOfProducts, sc);

        }
    }
}
