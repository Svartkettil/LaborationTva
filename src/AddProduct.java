import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;


public class AddProduct extends Program implements Menu {

    public static void addProduct(ArrayList<Product> listOfProducts, Scanner sc) {
            int newProductId = listOfProducts.size() + 1;
            System.out.printf("Produkt-id: %s\n", newProductId);
            System.out.print("Produktnamn: ");
            String newProductName = sc.nextLine();
            System.out.print("Pris: ");
            BigDecimal newProductPrice = new BigDecimal(sc.nextLine());
            System.out.print("Kategori: ");
            String newProductCategory = sc.nextLine();
            System.out.print("Saldo: ");
            int newProductSaldo = sc.nextInt();
            listOfProducts
                    .add(new Product(newProductId, newProductName, newProductPrice, newProductCategory, newProductSaldo));
            saveToFile(listOfProducts);
        /*newProduct.stream().
                map(product -> new Product(sc.nextInt(), sc.next(), new BigDecimal(sc.nextInt()), sc.next()))
                .toList();*/
    }

    @Override
    public Menu handleInput(String command) {
        return new MainMenu();
    }

    @Override
    public void printMenu(ArrayList<Product> listOfProducts, Scanner sc) {
        System.out.println("Ange produktnamn, pris, kategori samt saldo");
        addProduct(listOfProducts, sc);
        askAddAgain(listOfProducts, sc);
    }
    public void askAddAgain(ArrayList<Product> listOfProducts, Scanner sc) {
        System.out.println("Vill du lägga till en ny produkt? ja/nej");
        String answer = sc.nextLine().toLowerCase();
        switch (answer) {
            case "ja":
                printMenu(listOfProducts, sc);
                break;
            case "nej":
                new MainMenu();
                break;
            default:
                System.out.println("Skriv enbart \"ja\" eller \"nej\"");
                askAddAgain(listOfProducts, sc);
        }
    }
}
