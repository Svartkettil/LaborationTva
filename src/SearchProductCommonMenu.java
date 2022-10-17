import java.util.List;

public class SearchProductCommonMenu implements Menu {
    @Override
    public Menu handleInput(String command) {
        String lowerCommand = command.toLowerCase();
        List<Product> searchResult = Program.listOfProducts.stream()
                .filter(product -> lowerCommand.equals(String.valueOf(product.productId())) ||
                        product.productName().toLowerCase().contains(lowerCommand) ||
                        lowerCommand.equals(product.category().toLowerCase()) ||
                        lowerCommand.contains(product.productName().toLowerCase()) ||
                        lowerCommand.equals(String.valueOf(product.price())))
                .toList();
        if (searchResult.isEmpty())
            System.out.println("Couldn't find it me good lord, would you fancy a scone?");
        else
            searchResult.forEach(System.out::println);
        return new SearchAgainMenu();
    }

    @Override
    public void printMenu() {
        System.out.print("Ange sökord: ");

    }
}
