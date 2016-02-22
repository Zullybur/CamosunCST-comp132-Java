
package lab3a;

/**
 * 
 * @author Matthew Casiro
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student natasha = new Student();
        Student tony = new Student();

        // set up Natasha's information        
        natasha.setName("Natasha Romanoff");
        natasha.setClassYear(1);
        natasha.setAge(18);
        natasha.setMajor("Computer Science");
        natasha.printInfo();

        // set up Apu's information
        tony.setName("Tony Stark");
        tony.setClassYear(2);
        tony.setAge(19);
        tony.setMajor("Engineering");
        tony.printInfo();

        /*  AFTER YOU ADD THE increaseYear METHOD TO
         Student.java, UNCOMMENT THE LINES BELOW TO
         TEST IT
         */
        
        //make Natasha a sophomore
        natasha.increaseYear(1);
        
        //make Tony a senior
        tony.increaseYear(2);
        
        //natasha.printInfo();
        tony.printInfo();
    }

}
