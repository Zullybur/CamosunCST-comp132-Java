/*
 * Flip a picture on the horizontal axis and add image effects
 */
package lab8;

import java.util.ArrayList;
import java.util.List;
import media.*;
import java.util.Scanner;

/**
 * Created: Feb 26 2016.
 * @author Matthew Casiro
 */
public class Lab8 {


    public static void main(String[] args) {
        drawCollage();
    }
    /**
     * Lab 8 code - create picture collage with effects using multiple images
     */
    private static void drawCollage() {
        Picture tmp;
        // Create list of pics to accomodate scaleability in size
        List<Picture> picList = new ArrayList<>();
        tmp = new Picture("/Users/MattCasiro/OneDrive/Camosun/comp132/labs/lab8/src/india01.jpg");
        picList.add(tmp);
        tmp = new Picture("/Users/MattCasiro/OneDrive/Camosun/comp132/labs/lab8/src/india02.jpg");
        picList.add(tmp);
        tmp = new Picture("/Users/MattCasiro/OneDrive/Camosun/comp132/labs/lab8/src/hawaii01.jpg");
        picList.add(tmp);
        tmp = new Picture("/Users/MattCasiro/OneDrive/Camosun/comp132/labs/lab8/src/hawaii02.jpg");
        picList.add(tmp);
        tmp = new Picture("/Users/MattCasiro/OneDrive/Camosun/comp132/labs/lab8/src/hawaii03.jpg");
        picList.add(tmp);
        // Convert list to array to send standard output to makeCollage
        Picture[] pics = new Picture[picList.size()];
        pics = picList.toArray(pics);
        
        Picture canvas = new Picture("/Users/MattCasiro/OneDrive/Camosun/comp132/labs/lab8/src/1kCanvas.jpg");
        canvas.makeCollage(pics);
        canvas.write("/Users/MattCasiro/OneDrive/Camosun/comp132/labs/lab8/src/1kCollage.jpg");
    }
    /**
     * Lab 7 extricated code.
     */
    private static void lab7() {
        String fileSource = "/Users/MattCasiro/OneDrive/Camosun/comp132/labs/lab7/src/Beach.jpg";
        String fileTarget1 = "/Users/MattCasiro/OneDrive/Camosun/comp132/labs/lab7/src/Pixellate.jpg";
        String fileTarget2 = "/Users/MattCasiro/OneDrive/Camosun/comp132/labs/lab7/src/Offset.jpg";
        Picture source = new Picture(fileSource);
        Picture target = new Picture(source.getWidth(), source.getHeight());
        Scanner scan = new Scanner(System.in);
        String input;
        int num;
        source.show();

        System.out.println("Press enter to flip image.");
        input = scan.nextLine();
        target.flipHorizontal(source);
        target.repaint();
        target.show();
        source.hide();
        
        System.out.println("Press enter to show pixelation effect.");
        input = scan.nextLine();
        target.copyPicture(source);
        target.pixellate();
        target.repaint();
        System.out.println("Done, writing file to disk.");
        target.write(fileTarget1);
        
        System.out.println("Press enter show offset rows effect.");
        input = scan.nextLine();
        target.copyPicture(source);
        target.offsetPixels(source);
        target.repaint();
        System.out.println("Done, writing file to disk.");
        target.write(fileTarget2);
        
        System.out.println("Select a horizontal line on which to mirror,\n"
                + "between 0 and "+ (source.getHeight() - 1) +":");
        do {
            num = scan.nextInt();
            scan.nextLine();
        } while (0 > num || num >= source.getHeight());
        target.copyPicture(source);
        target.mirrorHorizontal(source, num);
        target.repaint();
        target.show();
        System.out.println("Program Complete");
    }
}
