public class DigitsTester {
    public static void main(String[] args) {

        Digits d = new Digits();
        int first = d.firstDigit(17292);
        int last = d.lastDigit(17295);
        int num = d.digits(172912345);

        if (first == 1) {
            System.out.println("firstDigit(17292) correctly returned " + first );
        } else {
            System.out.println("firstDigit(17292) incorrectly returned " + first );
        }
        if (last == 5) {
            System.out.println("lastDigit(17295) correctly returned " + last );
        } else {
            System.out.println("lastDigit(17295) incorrectly returned " + last );
        }
        System.out.println(num);
//        if (num == 4) {
//            System.out.println("digit(1729) correctly returned " + last );
//        } else {
//            System.out.println("digit(1729) incorrectly returned " + last );
//        }
        // More tests here....


    }
}