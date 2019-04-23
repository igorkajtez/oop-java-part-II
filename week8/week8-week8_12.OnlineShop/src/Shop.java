
import java.util.Scanner;

public class Shop {
    private Storehouse store;
    private Scanner reader;

    public Shop(Storehouse store, Scanner reader) {
        this.store = store;
        this.reader = reader;
    }

    public void manage(String customer) {
        ShoppingBasket basket = new ShoppingBasket();
        System.out.println("Welcome to our shop " + customer);
        System.out.println("below is our sale offer:");

        for (String product : this.store.products()) {
            System.out.println( product );
        }

        while (true) {
            System.out.print("what do you want to buy (press enter to pay):");
            String product = this.reader.nextLine();
            
            if (product.isEmpty()) {
                break;
            }
            
            if(this.store.stock(product) > 0){
                this.store.take(product);
                basket.add(product, this.store.price(product));
            }  
        }

        System.out.println("your purchases are:");
        basket.print();
        System.out.println("basket price: " + basket.price());
    }

}
