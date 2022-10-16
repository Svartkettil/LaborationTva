import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface Menu {
    Menu handleInput(final String command);
    void printMenu(ArrayList<Product> listOfProducts, Scanner sc);
}
