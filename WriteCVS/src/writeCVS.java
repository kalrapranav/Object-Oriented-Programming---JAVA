// TODO import statements

import java.io.*;
import java.util.Scanner;

public class WriteCSV {
    public static void main(String[] args) throws IOException
    {

        //  Grading program needs hardcoded filename. Oh, well. "
        String inputFilename = "coords.txt";
        String outputFilename = changeFileExtToCsv(inputFilename);

        // Open files
        Scanner input = openInput(inputFilename);
                //TODO:  call method to open input file
                PrintWriter output = openOutput(outputFilename);//TODO:  call method to open output file

        // TODO:  Read input line, replace all spaces with commas,


        //               and write output line
        while (input.hasNextLine())
        {
            // store every lines from the file to string
            String nextLine = input.nextLine();

            // replace the empty spaces from the file to comma
            String content = nextLine.replaceAll(" ", ",");

            // write to the new file
            output.println(content);


        }

        // TODO: close streams
        output.close();
        System.out.println("The file" + outputFilename + "has been created");


    }
    /**
     * Changes file extension to ".csv"
     * @param filename
     * @return
     */
    public static String changeFileExtToCsv(String filename) {
        return filename.substring(0,filename.lastIndexOf('.')) + ".csv";
    }
    /**
     * Open input for reading
     * @param filename
     * @return
     */
    public static Scanner openInput(String filename) {
        Scanner in = null;
        try {
            File infile = new File(filename);
            in = new Scanner(infile);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println(filename + " could not be found");
            System.exit(0);
        }
        return in;
    }
    /**
     * Open output for writing
     * @param filename
     * @return
     */
    public static PrintWriter openOutput(String filename) {

        //TODO:  Write method to open a PrintWriter ;  use openInput() as a guide

    }
}
