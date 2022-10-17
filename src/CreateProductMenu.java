import java.math.BigDecimal;

public class CreateProductMenu implements Menu {
    enum ProductBuildState {
        FINISHED(null, null, null),
        SALDO(FINISHED, "Saldo: ", (product1, input) -> product1.setSaldo(Integer.parseInt(input))),
        CATEGORY(SALDO, "Kategori: ", (product1, input) -> product1.setCategory(input)),
        PRICE(CATEGORY, "Pris: ", (product1, input) -> product1.setPrice(new BigDecimal(input))),
        PRODUCT_NAME(PRICE, "Ange produktnamn, pris, kategori samt saldo\nProduktnamn: ", (product1, input) ->
                product1.setProductName(input));
        private final ProductBuildState nextState;
        private final String menuText;
        private final ProductAction productAction;

        ProductBuildState(ProductBuildState nextState, String menuText, ProductAction productAction) {
            this.nextState = nextState;
            this.menuText = menuText;
            this.productAction = productAction;
        }
    }

    private final Product product = new Product();
    private ProductBuildState state = ProductBuildState.PRODUCT_NAME;

    @Override
    public Menu handleInput(String command) {
        state.productAction.invoke(product, command);
        state = state.nextState;
        if (state == ProductBuildState.FINISHED) {
            product.setProductId(Program.listOfProducts.size() + 1);
            Program.listOfProducts.add(product);
            Program.saveToFile(Program.listOfProducts);
            System.out.println("Added\n" + product);
            return new AddProduct();
        } else
            return this;
    }

    @Override
    public void printMenu() {
        System.out.print(state.menuText);

    }

    public interface ProductAction {
        void invoke(Product product, String input);
    }
}
