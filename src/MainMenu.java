import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu extends Program implements Menu {
        enum Options {
            AddProduct("1", "Lägg till produkt", new AddProduct()),
            ShowProducts("2", "Visa produkter", new ShowProduct()),
            Search("3", "Sök", new SearchProduct()),
            ChangeSaldo("4", "Ändra Saldo", new ChangeProduct()),
            Quit("e", "Avsluta", null);

            private final String commandKey;
            private final String optionDescription;
            private final Menu nextMenu;

            Options(final String commandKey, final String optionDescription, final Menu nextMenu) {
                this.commandKey = commandKey;
                this.optionDescription = optionDescription;
                this.nextMenu = nextMenu;
            }

        }
    @Override
    public Menu handleInput (String command){
        for (final Options options : Options.values()) {
            if (options.commandKey.equals("e"))
                System.out.println("Hej då!");
            if (options.commandKey.equals(command.toLowerCase())) {
                return options.nextMenu;
            }
        }
        return this;
    }
    @Override
    public void printMenu(ArrayList<Product> listOfProducts, Scanner sc) {
        System.out.println("Välkommen till Stick o Brinn!");
        System.out.println("========");
        for (final Options options : Options.values()) {
            System.out.println(String.format("%s. %s", options.commandKey, options.optionDescription));
        }
    }
}
