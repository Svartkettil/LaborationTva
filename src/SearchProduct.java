import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class SearchProduct implements Menu{
    public void searchProducts(ArrayList<Product> listOfProducts){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ange sökord: ");
        String searchVariable = sc.nextLine().toLowerCase();
        List<Product> searchResult = resultOfSearch(listOfProducts, searchVariable);
        printSearchResult(searchResult);
    }
    public void searchProductsByPrice(ArrayList<Product> listOfProducts){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ange minimumpris: ");
        BigDecimal lowerNumberSearch = new BigDecimal(sc.nextLine());
        System.out.print("Ange maxpris: ");
        BigDecimal higherNumberSearch = new BigDecimal(sc.nextLine());
        List<Product> searchResult = resultOfSearchByPrice(listOfProducts, lowerNumberSearch, higherNumberSearch);
        printSearchResult(searchResult);
    }

    private List<Product> resultOfSearchByPrice(ArrayList<Product> listOfProducts, BigDecimal firstPrice,
                                                BigDecimal secondPrice) {
        return listOfProducts.stream()
                .filter(product -> firstPrice.intValue() <= product.price().intValue() &&
                secondPrice.intValue()  >= product.price().intValue())
                .toList();
    }

    private static void printSearchResult(List<Product> searchResult) {
        if (searchResult.isEmpty())
            System.out.println("Couldn't find it me good lord, would you fancy a scone?");
        else
            searchResult.forEach(System.out::println);
    }

    private static List<Product> resultOfSearch(ArrayList<Product> listOfProducts, String searchVariable) {
        return listOfProducts.stream()
                .filter(product -> searchVariable.equals(String.valueOf(product.productId())) ||
                        searchVariable.equals(product.productName().toLowerCase()) ||
                        product.productName().toLowerCase().contains(searchVariable) ||
                        searchVariable.equals(product.category().toLowerCase()) ||
                        searchVariable.equals(String.valueOf(product.price())))
                                .toList();

    }

    @Override
    public Menu handleInput(String command) {
        return new MainMenu();
    }

    @Override
    public void printMenu(ArrayList<Product> listOfProducts, Scanner sc) {
        System.out.println("""
                Hur vill du genomföra din sökning?
                1. Vanlig sökning
                2. Sök efter prisintervall""");
        String choice = sc.nextLine();
        switch (choice){
            case "1" -> searchProducts(listOfProducts);
            case "2" -> searchProductsByPrice(listOfProducts);
            default -> System.out.println("Ej godkänd inmatning");
        }

        askSearchAgain(listOfProducts, sc);
    }
    public void askSearchAgain(ArrayList<Product> listOfProducts, Scanner sc){
        System.out.println("Vill du söka efter en ny produkt? ja/nej");
        String answer = sc.nextLine().toLowerCase();
        switch(answer){
            case "ja":
                printMenu(listOfProducts, sc);
                break;
            case "nej":
                new MainMenu();
                break;
            default:
                System.out.println("Skriv enbart \"ja\" eller \"nej\"");
                askSearchAgain(listOfProducts, sc);
        }

    }
}
