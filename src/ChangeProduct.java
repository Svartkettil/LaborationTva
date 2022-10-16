import java.util.ArrayList;
import java.util.Scanner;

public class ChangeProduct implements Menu{
    public void changeProductSaldo(Product product, Scanner sc){
        System.out.println(product);
        System.out.printf("Nuvarande saldo är: %s.\n", product.saldo());
        System.out.print("Skriv in nytt saldo: ");
        int newSaldo = sc.nextInt();
        product.setSaldo(newSaldo);
        System.out.printf("\nDet nya saldot är numera: %s\n", product.saldo());
    }

    @Override
    public Menu handleInput(String command) {
        return new MainMenu();
    }

    @Override
    public void printMenu(ArrayList<Product> listOfProducts, Scanner sc) {
        System.out.println("Skriv in produkt-id på den produkt du vill ändra");
        int choice = sc.nextInt();
        for (Product prod : listOfProducts) {
            if (choice == prod.productId())
                changeProductSaldo(prod, sc);
        }


    }
}
