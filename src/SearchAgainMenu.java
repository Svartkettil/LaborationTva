public class SearchAgainMenu implements Menu {
    @Override
    public Menu handleInput(String command) {
        switch (command) {
            case "ja":
                return new SearchProduct();
            case "nej":
                return new MainMenu();
            default:
                System.out.println("Skriv enbart \"ja\" eller \"nej\"");
                return this;
        }
    }

    @Override
    public void printMenu() {
        System.out.println("Vill du söka efter en ny produkt? ja/nej");

    }
}
