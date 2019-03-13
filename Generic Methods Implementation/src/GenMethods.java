/**
 *  Program #7a
 *  Creating multiple generic methods for Array and linked Lists
 *  CS108-2 (or CS108-3)
 *  Date 12/3/2018
 *  @author  Pranav Kalra
 */

import java.util.*;

public class GenMethods
{
    //Also include a getIdentificationString method again
    /**
     * Getting identification method
     * @return String
     */
    public String getIdentificationString()
    {
        return "Program 7a, Pranav Kalra";
    }

    //(1) Write the following method that returns a new ArrayList.
    //The new list contains the nonduplicate (i.e., distinct) elements from the original list.
    /**
     * The method returns a new arrayList and removing all the duplicate elements
     * @param list
     * @return <E> ArrayList<E>
     * */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
    {
        //Creating a used array list
        ArrayList<E> usedList = new ArrayList<E>();
        //creating a new array list
        ArrayList<E> newList = new ArrayList<E>();

        for(int i = 0; i < list.size(); i++){//loop starts

            /*
            * Getting a generic type object from the list from
            * the parameter and storing it in object E
            * */
            E object = list.get(i);

            if(! usedList.contains(object))
            {
                usedList.add(object);
                newList.add(object);
            }
        }

        return newList;
    }

    /*
    * (2) Write the following method that shuffles an ArrayList.
    * It should do this specifically by swapping two indexes determined
    * by the use of the random class (use Random rand = new Random(340L); ),
    * and it should do 30 of these swaps (this number was chosen arbitrarily by us for testing purposes).
    **/
    /**
     * Shuffles an arrayList by swapping two indices, using random class and 30 swaps are performed
     * @param list
     * @return void
     * */
    public static <E> void shuffle(ArrayList<E> list)
    {
        Random rand = new Random(340L);

        for (int i = 0; i < 30; i++)
        {
            int shuffledIndex = rand.nextInt(list.size());
            int anotherIndex = rand.nextInt(list.size());
            Collections.swap(list, shuffledIndex, anotherIndex);
        }
        System.out.print(list);
    }

    //(3) Write the following method that returns the largest element in an ArrayList:
    /**
     * Returns the largest element in an ArrayList
     * @param list
     * @return E max
     * */
    public static <E extends Comparable<E>> E max(ArrayList<E> list)
    {
        E max = list.get(0);
        for (int i = 1; i < list.size(); i++)
        {
            E element = list.get(i);
            if (element.compareTo(max) > 0)
            {
                max = element;
            }
        }

        return max;
    }

    //(4) Implement the following generic method for linear search.
    /**
     * Generic method for linear search
     * @param list, key
     * @return int
     * */
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key)
    {
        for (int i = 0; i<list.length; ++i)
            if (list[i].compareTo(key) == 0)
                return i;
        return -1;
    }

    //(5) Implement the following method that returns the maximum element in an array:
    /**
     * Returns teh maximum element in an array
     * @param list
     * @return E max
     * */
    public static <E extends Comparable<E>> E max(E[] list)
    {
        E max = list[0];

            for (int i = 1; i < list.length; i++) {
                E element = list[i];
                if (element.compareTo(max) > 0) {
                    max = list[i];
                }
            }

        return max;
    }

    //(6) Implement a generic method that returns the maximum element in a two-dimensional array.
    /**
     * Generic method that returns the maximum element in a two- dimensional array
     * @param list
     * @return E max
     * */
    public static <E extends Comparable<E>> E max(E[][] list)
    {
        E max = list[0][0];
        for (E[] elements : list) {
            for (E element : elements) {
                if (element.compareTo(max) > 0) {
                    max = element;
                }
            }
        }

        return max;
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * Driven method
     * @param  args
     * @return void
     * */
    public static void main(String[] args) throws IndexOutOfBoundsException
    {
        //Read in a number n that represents the number of elements in the lists.
        Scanner n = new Scanner(System.in);

        /*
        * Read in n elements to initialize and fill an array of Integers named 'list'
        * while simultaneously initializing a linked list of Integers named 'linked' from the same input.
        * */
        int listElements = n.nextInt();
        Integer[] list = new Integer[listElements];
        LinkedList<Integer> linked = new LinkedList<Integer>();
        for (int i = 0; i < listElements; ++i)
        {
            Integer element = n.nextInt();
            list[i] = element;
            linked.add(element);
        }

        //Print 'list'. (use Arrays.toString(array))
        for (int i = 0; i < list.length; i++)
        {
            if (i == 0)
            {
                System.out.print("[");
            }
            //System.out.print(Arrays.toString(new Integer[]{list[i]}));
            //System.out.print(list[i] + ", ");
            if (i == (list.length-1))
            {
                System.out.print(list[i]);
                System.out.print("]");
            }
            else
                System.out.print(list[i] + ", ");
        }
        System.out.println("");//for new line

        //Print 'linked' (just put 'linked' into print statement)
        System.out.println(linked);

        //Read in k key value to search for in list.
        int k = n.nextInt();

        /*
        * Call linearSearch(list, k) and print the result: Key k was found at position result, or Key k was not found.
        * */
        int linearSearchResult = linearSearch(list, k);
        if (linearSearchResult != -1)
        {
            System.out.println("Key " + k + " was found at position " + linearSearchResult);
        }
        else
            System.out.println("Key " + k + " was not found");

        //Call max(list) and print the result: 'Result' is the max element
        System.out.println(max(list) + " is the max element");

        //Read in an integer m for first dimension of a 2-D array.
        //System.out.println("Enter an index for the first dimension of the 2D array");
        int m = n.nextInt();


        //Read in an integer p for second dimension of a 2-D array.
        //System.out.println("Enter an index for the second dimension of the 2D array");
        int p = n.nextInt();

        //Initialize a 2-D array using m and p named 'list2'
        Integer[][] list2 = new Integer[m][p];

        //Read in m x p elements to fill 'list2'.
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < p; j++)
            {
                //System.out.println("Enter a value for [" + i + "]" + " [" + j +"]");
                list2[i][j] = n.nextInt();
            }
        }

        /*
        Print 'list2'. You can not just use a single print statement,
        but will instead need to implement nested for loops.
        (Format: rows of data on separate lines with a space in between each data)
         */
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < p; j++)
            {
                //System.out.println("list 2 is printed");
                System.out.print(list2[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");

        //Call max(list2) and print the result: 'Result' is the max element
        System.out.println(max(list2) + " is the max element");

        /*
        * Instantiate an ArrayList of type Integer named 'alist' from 'linked' (meaning 'alist' is a copy of 'linked')
        * */
        ArrayList alist = new ArrayList(linked);

        //Print out 'alist' using System.out.println(alist);
        System.out.println(alist);

        //Call removeDuplicates using 'alist' as the parameter
        //removeDuplicates(alist);

        //Print the now unique 'alist' using System.out.println(alist);
        System.out.println(removeDuplicates(alist));

        //Call shuffle using 'alist' as the parameter.
        shuffle(removeDuplicates(alist));
        System.out.println("");

        //Print 'alist' again using System.out.println(alist);
        //System.out.println(shuffle(alist));

        //Find the max element of 'alist' and print: 'Result' is the max element
        System.out.println(max(alist) + " is the max element");



    }
    }
