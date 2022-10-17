public class SearchProduct implements Menu {
    @Override
    public Menu handleInput(String command) {
        switch (command) {
            case "1":
                return new SearchProductCommonMenu();
            case "2":
                return new SearchProductPriceMenu();
            case "3":
                return new MainMenu();
            default:
                System.out.println("Ej godkänd inmatning");
        }
        return this;
    }

    @Override
    public void printMenu() {
        System.out.println("""
                Hur vill du genomföra din sökning?
                1. Vanlig sökning
                2. Sök efter prisintervall
                3. Tillbaka""");
    }
}
