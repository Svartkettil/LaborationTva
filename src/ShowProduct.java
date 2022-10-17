import java.util.ArrayList;

public class ShowProduct implements Menu {
    public void showProducts(ArrayList<Product> listOfProducts) {
        listOfProducts.forEach(System.out::println);
    }

    @Override
    public Menu handleInput(String command) {
        switch (command) {
            case "1":
                showProducts(Program.listOfProducts);
                return this;
            case "2":
                return new MainMenu();
            default:
                System.out.println("Fel inmatning");
                return this;
        }
    }

    @Override
    public void printMenu() {
        System.out.print("""
                1: Visa alla produkter
                2: Tillbaka
                """);


    }

}
