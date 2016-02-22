package lab4;
import java.text.NumberFormat;

/**
 *
 * @author Matthew Casiro
 */
public class Item {
    private String name; // name of the item
    private double price; // cost of the item
    private int quantity;  // how many of the item

    /**
     * Creates an item with a name, price, and quantity purchased
     *
     * @param itemName
     * @param itemPrice
     * @param numPurchased
     */
    public Item (String itemName, double itemPrice, int numPurchased)
    {
        name = itemName;
        price = itemPrice;
        quantity = numPurchased;
    }

    /**
     * Returns the contents of the cart together with summary information.
     *
     * @return String representation of the contents of the cart
     */
    @Override
        public String toString ()
    {
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	String item;
	if (name.length() >= 8)
	    item = name + "\t";
	else
	    item = name + "\t\t";
	return (item + "   " + fmt.format(price) + "\t    " + quantity 
		+ "\t\t" + fmt.format(price*quantity));
    }

    /**
     * Returns the cost of an item.
     *
     * @return price of current item
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Returns the name of an item.
     *
     * @return name of current item
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the quantity of an item in the cart.
     *
     * @return quantity of current item added to cart
     */
    public int getQuantity()
    {
        return quantity;
    }   

}
