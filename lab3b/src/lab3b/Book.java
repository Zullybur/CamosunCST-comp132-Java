package lab3b;

/**
 * @author: Book.java
 */
public class Book {

    /**
     * global variable to store the title of the book
     */
    private String title;

    /**
     * global variable to store the author of the book
     */
    private String author;

    /**
     * global variable to store the number of pages in a book
     */
    private int pages;

    /**
     * global variable to store the price of the book
     */
    private double price;
    
    /**
     * global variable to assign a unique number to each book
     */
    private int bookNum;
    /**
     * global variable to track the number of books created
     */
    private static int numBooks = 0;


    public Book() {
        incrementNumBooks();
        title = "";
        author = "";
        pages = -1;
        price = -1;
        bookNum = numBooks;
    }
    
    public Book(String thetitle, String theAuthor) {
        incrementNumBooks();
        title = thetitle;
        author = theAuthor;
        pages = -1;
        price = -1;
        bookNum = numBooks;

    }
    /**
     * getTitle
     * 
     * Description: Return the book's title
     * @return title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * setTitle
     * 
     * Description: Sets the book's title
     * @param theTitle
     */
    public void setTitle(String theTitle) {
        title = theTitle;
    }
    
    /**
     * getAuthor
     * 
     * Description: Return the book's author
     * @return author
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * setAuthor
     * 
     * Description: Sets the book's author
     * @param theAuthor
     */
    public void setAuthor(String theAuthor) {
        author = theAuthor;
    }
    
    /**
     * getPages
     * 
     * Description: Return the book's page count
     * @return pages
     */
    public int getPages() {
        return pages;
    }
    
    /**
     * setPages
     * 
     * Description: Sets the book's number of pages
     * @param numPages
     */
    public void setPages(int numPages) {
        pages = numPages;
    }
    
    /**
     * getPrice
     * 
     * Description: Return the book's price
     * @return price
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * setPrice
     * 
     * Description: Sets the book's price
     * @param bookPrice
     */
    public void setPrice(double bookPrice) {
        price = bookPrice;
    }
    
    /**
     * getNumOfBooks
     * 
     * Description: Returns the number of books created
     * @return numOfBooks
     */
    public static int getNumBooks() {
        return numBooks;
    }
    
    private void incrementNumBooks() {
        numBooks += 1;
    }
    /**
     * toString
     * 
     * Description: Display some information about a particular book
     * @return the output string
     */
    @Override
    public String toString() {
        return bookNum + ":\n"
                + "\tTitle: " + title + "\n"
                + "\tAuthor: " + author + "\n"
                + "\tPages: " + pages + "\n"
                + "\tPrice: $" + price + "\n";
    }

}
