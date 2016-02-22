/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3b;

/**
 *
 * @author
 */
public class Lab3b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

		Book book1 = new Book();
		Book book2 = new Book("learning Php, MySQL and JavaScript", "Nixon");

		book1.setTitle("The Shining");
		book1.setPages(450);
		book1.setAuthor("George");

		book1.setPages(256);
		book2.setPages(1024);

		book1.setPrice(256.25);
		book2.setPrice(52.23);

		/**
		 * print out the books information
		 */
		System.out.println("Total # of books: "+Book.getNumBooks());

                System.out.println("Book " + book1.toString());

		System.out.println("Book " + book2.toString());

		System.out.println();
	}
}

/* sample output:
     Total Number of books: 2
     Book 1: Title: The Shining   author: George   pages: 256   price: $256.25
     Book 2: Title: learning Php, MySQL and JavaScript   author: Nixon   pages: 1024   price: $52.23
*/
