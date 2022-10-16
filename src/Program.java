import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

//Jag hann tyvärr inte lyckas lösa alla småfel i menyorienteringen men alla funktioner bör fungera iaf.
//Hade gjort en del annorlunda om jag fick börja om.
public class Program {
    public static void main(String[] args) throws IOException {
        ArrayList<Product> listOfProducts = readFromFile();
        saveToFile(listOfProducts);
        Scanner sc = new Scanner(System.in);
        Menu menu = new MainMenu();

        while (menu != null) {
            menu.printMenu(listOfProducts, sc);
            menu = menu.handleInput(sc.nextLine());
        }
    }

    /*public static List<Product> loadCSVFile() throws IOException {
        String homeFolder = System.getProperty("user.home");
        Path filePath = Path.of(homeFolder, "products.txt");

        Pattern pattern = Pattern.compile(",");

        try (Stream<String> lines = Files.lines(filePath)) {

            List<Product> fileOfProducts = lines.map(line -> {
                String[] arr = pattern.split(line);
                return new Product(
                        Integer.parseInt(arr[0]),
                        arr[1],
                        new BigDecimal(arr[2]),
                        arr[3]);
            }).toList();
            fileOfProducts.forEach(System.out::println);
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    static ArrayList<Product> readFromFile() throws IOException {

        return new Gson().fromJson(Files.readString(Path.of("src/products.json")), new TypeToken<ArrayList<Product>>() {
        }.getType());
    }

    static void saveToFile(ArrayList<Product> listOfProducts) {
        Gson gson = new Gson();


//        products.add(new Product(1, "Blått Garn", new BigDecimal(129), "Yarn"));
//        products.add(new Product(2, "Grönt Garn", new BigDecimal(129), "Yarn"));
//        products.add(new Product(3, "Rött Garn", new BigDecimal(129), "Yarn"));
//        products.add(new Product(4, "Grått Garn", new BigDecimal(119), "Yarn"));
//        products.add(new Product(5, "Vitt Garn", new BigDecimal(119), "Yarn"));

        String allInformation = gson.toJson(listOfProducts);

        try {
            Files.writeString(Path.of("src/products.json"), allInformation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}


