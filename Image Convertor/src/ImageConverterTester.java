import java.util.Scanner;
import java.io.IOException;

/**
 * Driver program: Converts a color image into various colors
 * @author cs108
 *
 */
public class ImageConverterTester {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        ImageConverter ic = new ImageConverter();
        int x=30,y=30;  // test pixel values

        String filename = scan.next();
        ic.readImage(filename);
        System.out.println(ic.getPixelRGB(x, y));
        ic.toGrayscale();
        System.out.println(ic.getPixelRGB(x, y));
        ic.writeImage();

        // TODO: Re-read in image, convert to Red; repeat for Green and Blue
    }

}