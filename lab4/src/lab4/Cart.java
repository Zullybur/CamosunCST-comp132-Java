package lab4;
import java.text.NumberFormat;

/**
 *
 * @author scarruthers
 */
public class Cart {
    private Item[] cart;        // an array of Items
    private int itemCount;      // total number of items in the cart
    private double totalPrice;  // total price of items in the cart
    private int capacity;       // current cart capacity

    /**
     * Creates a shopping cart that can hold 5 items.
     */
    public Cart()
    {
        cart = new Item[5];
        itemCount = 0;
        totalPrice = 0;
        capacity = 5;
    }

    /**
     * Adds an item to the shopping cart, if the cart is full, do nothing.
     *
     * @param  itemName name of the item
     * @param  price purchase price of one of the item
     * @param  quantity amount of the item to add to cart
     */
    public void addToCart(String itemName, double price, int quantity)
    {
        if(itemCount < capacity){
            cart[itemCount] = new Item(itemName, price, quantity);
            totalPrice = totalPrice + cart[itemCount].getPrice() * 
                    cart[itemCount].getQuantity();
            System.out.println("Successfully added: " + 
                    cart[itemCount].getName());
            
            itemCount = itemCount+1;
        }
    }

    /**
     * Returns the contents of the cart together with summary information.
     *
     * @return String representation of the contents of the cart
     */
    @Override
    public String toString()
    {
	NumberFormat fmt = NumberFormat.getCurrencyInstance();

	String contents = "\nShopping Cart\n";
	contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n";

	for (int i = 0; i < itemCount; i++){
	    contents += cart[i].toString() + "\n";
        }
	contents += "\nTotal Price: " + fmt.format(totalPrice);
	contents += "\n";

	return contents;
    }
    
    /**
     * Returns the total cost of the items in the cart
     *
     * @return Total price for the contents of the cart
     */
    public double getTotal() {
        return totalPrice;
    }
}
