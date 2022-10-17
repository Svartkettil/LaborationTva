public class ChangeProduct implements Menu {

    @Override
    public Menu handleInput(String command) {
        int choice = Integer.parseInt(command);
        for (Product prod : Program.listOfProducts) {
            if (choice == prod.productId())
                return new ChangeProductSaldoMenu(prod);
        }
        return new MainMenu();
    }

    @Override
    public void printMenu() {
        System.out.println("Skriv in produkt-id på den produkt du vill ändra");
    }
}
