package lab4;

/**
 *
 * @author Matthew Casiro
 */
public class Register {
    private final int[] currency = {10000, 5000, 2000, 1000, 500, 200, 100, 25};
    private int[] payout = new int[8];
    private double changeDue;
    private int remaining;

    /**
     * Constructor sets default values to zero.
     */
    public Register() {
        changeDue = 0;
        remaining = 0;
        for (int i = 0; i < 8; i++) {
            payout[i] = 0;
        }
    }

    /**
     * Returns amount of change due.
     * 
     * @param amountDue total purchase price of all items in cart
     * @param amountReceived amount of cash received from customer
     * @return Double value of change due back rounded to nearest quarter
     */
    public double change(double amountDue, double amountReceived) {
        changeDue = amountReceived - amountDue;

        // Round to the nearest quarter
        changeDue = Math.round(changeDue*100) + 12;
        changeDue = (int)(changeDue / 25) * 25;
        changeDue /= 100;

        remaining = (int)(Math.round(changeDue * 100));
        
        // Calculate change broken down into currency
        for (int i = 0; i < 8; i++) {
            payout[i] = remaining / currency[i];
            remaining = remaining % currency[i];
        }
        
        return changeDue;
    }

    /**
     * Returns string of change due broken down by currency
     * 
     * @return string representation of change due by denomination
     */
    @Override
    public String toString() {
        String theString = "Cash Payout:\n";
        String addThis = "";
        for (int i = 0; i < 8; i++) {
            theString += (payout[i] > 0) ? "$" + currency[i] / 100.0 + ":\t" +
                    payout[i] + "\n" : "";
        }
        return theString;   
    }
}
