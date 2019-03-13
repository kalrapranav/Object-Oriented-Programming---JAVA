import java.util.Scanner;
import java.util.ArrayList;

public class NameFinder {
    /* Finds index of string in vector of strings, else -1.
       Searches only with index range low to high
       Note: Upper/lower case characters matter
    */
    public static int findMatch(ArrayList<String> stringList, String itemMatch,
                                int lowVal, int highVal, String indentAmt) { // indentAmt used for print debug
        int midVal;        // Midpoint of low and high values
        int itemPos;       // Position where item found, -1 if not found
        int rangeSize;     // Remaining range of values to search for match

        System.out.println(indentAmt + "Find() range " + lowVal + " " + highVal);
        rangeSize = (highVal - lowVal) + 1;
        midVal = (highVal + lowVal) / 2;

        if (itemMatch.equals(stringList.get(midVal))) {           // Base case 1: item found at midVal position
            System.out.println(indentAmt + "Found person.");
            itemPos = midVal;
        }
        else if (rangeSize == 1) {                                // Base case 2: match not found
            System.out.println(indentAmt + "Person not found.");
            itemPos = -1;
        }
        else {                                                    // Recursive case: search lower or upper half
            if (itemMatch.compareTo(stringList.get(midVal)) < 0) { // Search lower half, recursive call
                System.out.println(indentAmt + "Searching lower half.");
                itemPos = findMatch(stringList, itemMatch, lowVal, midVal, indentAmt + "   ");
            }
            else {                                                 // Search upper half, recursive call
                System.out.println(indentAmt + "Searching upper half.");
                itemPos = findMatch(stringList, itemMatch, midVal + 1, highVal, indentAmt + "   ");
            }
        }

        System.out.println(indentAmt + "Returning pos = " + itemPos + ".");
        return itemPos;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<String> attendeesList = new ArrayList<String>(); // List of attendees
        String attendeeName;                                       // Name of attendee to match
        int matchPos;                                              // Matched position in attendee list

        // Omitting part of program that adds attendees
        // Instead, we insert some sample attendees in sorted order
        attendeesList.add("Adams, Mary");
        attendeesList.add("Carver, Michael");
        attendeesList.add("Domer, Hugo");
        attendeesList.add("Fredericks, Carlos");
        attendeesList.add("Li, Jie");

        // Prompt user to enter a name to find
        System.out.print("Enter person's name: Last, First: ");
        attendeeName = scnr.nextLine(); // Use nextLine() to allow space in name

        // Call function to match name, output results
        matchPos = findMatch(attendeesList, attendeeName, 0, attendeesList.size() - 1, "   ");
        if (matchPos >= 0) {
            System.out.println("Found at position " + matchPos + ".");
        }
        else {
            System.out.println("Not found.");
        }
    }
}