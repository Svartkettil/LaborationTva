import java.math.BigDecimal;
import java.util.List;

public class SearchProductPriceMenu implements Menu {
    private BigDecimal minimumPrice = null;

    @Override
    public Menu handleInput(String command) {
        if (minimumPrice == null) {
            minimumPrice = new BigDecimal(command);
            return this;
        }
        BigDecimal maximumPrice = new BigDecimal(command);
        List<Product> searchResult = Program.listOfProducts.stream()
                .filter(product -> minimumPrice.intValue() <= product.price().intValue() &&
                        maximumPrice.intValue() >= product.price().intValue())
                .toList();
        if (searchResult.isEmpty())
            System.out.println("Couldn't find it me good lord, would you fancy a scone?");
        else
            searchResult.forEach(System.out::println);
        return new SearchAgainMenu();
    }

    @Override
    public void printMenu() {
        if (minimumPrice == null) {
            System.out.print("Enter minimum price: ");
        } else {
            System.out.print("Enter maximum price: ");
        }


    }
}
