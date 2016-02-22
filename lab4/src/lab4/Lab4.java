package lab4;
import java.text.NumberFormat;
import java.util.Scanner;
import java.lang.Object;

/**
 *
 * @author Matthew Casiro
 */
public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String itemName;
        int quantity;
        double price;

        Scanner scan = new Scanner(System.in);
        Cart cart =  new Cart();
        Register cashRegister = new Register();

        System.out.println ("Welcome to Shopper's Paradise");
        System.out.println ();

        System.out.print ("Enter the name of the first item: ");
        itemName = scan.nextLine();
        while (!itemName.equals("q") && !itemName.equals("Q"))
        {
                System.out.print ("Enter the quantity: ");
                quantity = getQuantity();
                System.out.print ("Enter the price: ");
                price = getPrice();

                cart.addToCart(itemName, price, quantity);

                System.out.print ("Enter the name of the next item "+
                        "or Q to quit: ");
                itemName = scan.nextLine();
        }

        System.out.println();
        System.out.println (cart);
        System.out.println();

        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        System.out.println ("Please pay... " + fmt.format(cart.getTotal()));

        System.out.print("Cash Tendered:  ");
        Double amountReceived = scan.nextDouble();
        System.out.println("Your change is: " +
            fmt.format(cashRegister.change(cart.getTotal(), amountReceived))+
            " (rounded to nearest quarter)");
        System.out.println(cashRegister.toString());
    }
    
    /**
     * User input validation for quantity of items purchased.
     * 
     * @return A positive, whole integer value
     */
    private static int getQuantity() {
        double quantity = 0.0;
        Scanner scan = new Scanner(System.in);
        quantity = scan.nextDouble();
        scan.nextLine();
        while (quantity < 0 || (quantity % 1) != 0) {
            System.out.println("Quantity must be a whole, positive number. "+
                    "Please try again:");
            quantity = scan.nextDouble();
            scan.nextLine();
        }
        return (int)quantity;
    }
    /**
     * User input validation for price of item purchased.
     * 
     * @return A positive double value
     */
    private static double getPrice() {
        double price = 0.0;
        Scanner scan = new Scanner(System.in);
        price = scan.nextDouble();
        scan.nextLine();
        while (price < 0) {
            System.out.println("Price must be a positive . Please try again:");
            price = scan.nextDouble();
            scan.nextLine();
        }
        return price;
    }
}
