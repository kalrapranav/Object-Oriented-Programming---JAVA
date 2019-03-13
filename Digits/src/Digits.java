/**
 * Program #2a
 * Cretaing a class with different methods i order to calculate  * the first digit,last digit and the number of digits in an     * argument
 * CS108-2 (or CS108-3)
 * 9/9/2018
 *
 * @author Pranav Kalra
 */
public class Digits
{
    public int firstDigit(int n)
    {
        int q = digits(n) - 1;
        int dividingFactor = (int) Math.pow(10,q);
        //System.out.println( dividingFactor);
        int p = n / dividingFactor;
        return p;
    }

    public int lastDigit(int n)
    {
        int p = n % 10;
        return p;
    }

    public int digits(int n)
    {
        int numDigits = 0;
        while(n != 0)
        {
            // num = num/10
            n /= 10;
            ++numDigits;
        }
        return numDigits;
    }
    public String getIdentificationString()
    {
        return "Program 2a, Pranav Kalra";
    }
}
