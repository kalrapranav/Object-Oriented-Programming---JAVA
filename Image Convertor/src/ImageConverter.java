/**
 * TODO: My info
 * Pranav Kalra
 * 821916362
 * 11/28/2018
 * Program 4b
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * class ImageConverter for jpg
 * TODO:  description
 * Methods can return negative value if read/write fail. 
 * Does not call System.exit().
 */
public class ImageConverter {
    // Private instance variables

    private BufferedImage img;
    private String color;
    private String inputFilename;



    public ImageConverter() {
        img = null;
        color = "";
        inputFilename = "";
    }

    /**
     * Read image file into buffer
     * @param filename name of local image file
     * throws IOException
     */
    public void readImage(String filename) throws IOException {
        //TODO
        File inputFilename = new File(filename);
        if(!inputFilename.isFile()) {
            throw new IOException();
        }
        else {
            img = ImageIO.read(inputFilename);
        }
    }

    /**
     * Replace each img pixel with its R+G+B average
     */
    public void toGrayscale() {
        for (int y = 0; y < img.getHeight(); ++y ) {
            for (int x = 0; x < img.getWidth(); ++x ) {
                int p = img.getRGB(x, y);

                int t = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                int avg = (r + g + b) / 3;

                // replace RGB with average value
                p = (t<<24) | (avg<<16) | (avg<<8) | avg;

                // update pixel
                img.setRGB(x, y, p);
                color = "Grayscale";
                //setColor("Grayscale");
            }
        }
    }
    /**
     * Replace each img pixel with only its Red component
     * leaving transparency intact
     */
    public void toRed() {
        //TODO
        for (int y = 0; y < img.getHeight(); ++y ) {
            for (int x = 0; x < img.getWidth(); ++x ) {
                int p = img.getRGB(x, y);

                int t = (p>>24)&0xff;
                int r = p&0xffff0000;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                // update pixel
                img.setRGB(x, y, r);

                color = "Red";
                //setColor("Red");
            }
        }
    }


    /**
     * Replace each img pixel with only its Green component
     * leaving transparency intact
     */
    public void toGreen() {
        //TODO
        for (int y = 0; y < img.getHeight(); ++y ) {
            for (int x = 0; x < img.getWidth(); ++x ) {
                int p = img.getRGB(x, y);

                int t = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = p&0xff00ff00;
                int b = p&0xff;

                // update pixel
                img.setRGB(x, y, g);

                color = "Green";
            }
        }

    }
    /**
     * Replace each img pixel with only its Blue component
     * leaving transparency intact
     */
    public void toBlue() {
        //TODO
        for (int y = 0; y < img.getHeight(); ++y ) {
            for (int x = 0; x < img.getWidth(); ++x ) {
                int p = img.getRGB(x, y);

                int t = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                // update pixel
                img.setRGB(x, y, b);

                color = "Blue";

            }
        }

    }
    /**
     * Create new file from current img buffer. Adds current value of
     *    color variable to sourceFile name.
     *    Example: myImageFile.jpg --> myImageFileGrayscale.jpg
     * @throws IOException
     */
    public void writeImage() throws IOException {
        // TODO
        File f2 = new File(inputFilename);
        ImageIO.write(img, "jpg", f2);
    }

    // Helper methods


    /*
     * Output the value of img(x,y) pixel
     */
    public String getPixelRGB(int x, int y) {
        int p = img.getRGB(x, y);
        int r = (p>>16)&0xff;
        int g = (p>>8)&0xff;
        int b = p&0xff;
        return "RGB: " + r + ":" + g + ":" + b;
    }
    public String toString()
    {
        return "The image is now " + color + ".";
    }

    public void classDemo() {}


}