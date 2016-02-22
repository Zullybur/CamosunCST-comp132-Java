
package comp132lab01;
import java.lang.Math;
/*
 * @author MattCasiro
 * @version 1.0
 * Created: 2016/01/12
 */

/*
 * Unmodified Output: "The object's position after 
 * 10.0 seconds is 0.0 m."
 * 
 * Modified Output: "The object's position after
 * 10.0 seconds is -490.5 m."
 */

public class Calculator {
    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double gravity = -9.81; // Earth's gravity in m/s^2
        double initialVelocity = 0.0;
        double fallingTime = 10.0;
        double initialPosition = 0.0;
        double finalPosition = 0.0;
        
        // Get and output distance traveled
        finalPosition = getDistance(gravity, fallingTime, initialVelocity,
                initialPosition);
        System.out.println("The object's position after " + fallingTime +
                " seconds is " + finalPosition + " m.");
    }
    
    // Calculate distance travelled
    public static double getDistance(double A, double T, double Vi, double Xi){
        /*
         * Distance as a function of time formula:
         * X(t) = (1/2)AT^2 + TVi + Xi
         * A = acceleration rate
         * T = time
         * Vi = initial velocity
         * Xi = initial position
         */
        return (0.5 * A * Math.pow(T, 2)) + (T * Vi) + Xi;
    }
    
}
