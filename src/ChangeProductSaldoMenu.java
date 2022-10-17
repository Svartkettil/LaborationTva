public class ChangeProductSaldoMenu implements Menu {
    private final Product product;

    @Override
    public Menu handleInput(String command) {
        product.setSaldo(Integer.parseInt(command));
        System.out.printf("\nDet nya saldot är numera: %s\n", product.saldo());
        Program.saveToFile(Program.listOfProducts);
        return new MainMenu();
    }

    @Override
    public void printMenu() {
        System.out.println(product);
        System.out.printf("Nuvarande saldo är: %s.\n", product.saldo());
        System.out.print("Skriv in nytt saldo: ");

    }

    public ChangeProductSaldoMenu(Product product) {
        this.product = product;
    }
}
