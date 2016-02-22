package comp132lab02;

/**
 *
 * @author MattCasiro
 * @created Jan 20 2016
 * @purpose Calculate and compare properties of two spheres
 */
public class Sphere {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // S = 4 * PI * r^2 (validate with PI * d^2)
        // V = (4 * PI / 3) * r^3 (validate with PI / 6 * d^3)
        // areaRatio = surfaceAreaOne / surfaceAreaTwo
        
        // Create sphere 1 and calculate surface area and volume
        int sphereRadius1 = 10;
        double surfaceArea1 = 4 * Math.PI * Math.pow(sphereRadius1, 2);
        double volume1 = 4 * Math.PI / 3 * Math.pow(sphereRadius1, 3);
        
        // Create sphere 2 and calculate surface area and volume
        int sphereRadius2 = 15;
        double surfaceArea2 = 4 * Math.PI * Math.pow(sphereRadius2, 2);
        double volume2 = 4 * Math.PI / 3 * Math.pow(sphereRadius2, 3);
        
        // Display data for spheres
        System.out.println("Sphere 1:\n"
                + "\tRadius: " + sphereRadius1 + "\n"
                + "\tSurface Area: " + surfaceArea1 + "\n"
                + "\tVolume: " + volume1 + "\n");
        
        System.out.println("Sphere 2:\n"
                + "\tRadius: " + sphereRadius2 + "\n"
                + "\tSurface Area: " + surfaceArea2 + "\n"
                + "\tVolume: " + volume2 + "\n");
        
        // Calculate and display ratios
        double surfaceAreaRatio = surfaceArea1 / surfaceArea2;
        double volumeRatio = volume1 / volume2;
        
        System.out.println("Surface Area Ratio (SA1:SA2): " + surfaceAreaRatio + "\n"
                + "Volume Ratio (V1:V2): " + volumeRatio + "\n");

       }
    
}
