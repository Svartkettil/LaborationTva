import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) throws IOException {
        listOfProducts = readFromFile();
        Scanner sc = new Scanner(System.in);
        Menu menu = new MainMenu();

        while (menu != null) {
            menu.printMenu();
            try {
                menu = menu.handleInput(sc.nextLine());
            }
            catch (Throwable t){
                System.out.println("Felaktig inmatning");
            }
        }
    }

    static ArrayList<Product> readFromFile() throws IOException {

        return new Gson().fromJson(Files.readString(Path.of("src/products.json")), new TypeToken<ArrayList<Product>>() {
        }.getType());
    }

    static void saveToFile(ArrayList<Product> listOfProducts) {
        Gson gson = new Gson();


        String allInformation = gson.toJson(listOfProducts);

        try {
            Files.writeString(Path.of("src/products.json"), allInformation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static ArrayList<Product> listOfProducts;

}


