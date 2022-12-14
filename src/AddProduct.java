public class AddProduct extends Program implements Menu {
    @Override
    public Menu handleInput(String command) {
        switch (command) {
            case "ja":
                return new CreateProductMenu();
            case "nej":
                return new MainMenu();
            default:
                System.out.println("Skriv enbart \"ja\" eller \"nej\"");
                return this;
        }
    }

    @Override
    public void printMenu() {
        System.out.println("Vill du lägga till en ny produkt? ja/nej");
    }
}
