package media;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saryta
 */
public class MediaExample {
    public static void main(String[] args) {
        String fileName = FileChooser.pickAFile();
        Picture myPic = new Picture(fileName);
        myPic.show();
    }
}
