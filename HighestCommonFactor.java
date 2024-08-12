import java.util.Scanner;

public class HighestCommonFactor {
public static void main(String[] args) {
        int[] input = takeInput();
        int n = input[0];
        int m = input[1];
        int spf = (n>m) ? findHCF(n, m) : findHCF(m, n);
        display(n, spf);
    }

    private static int[] takeInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            return new int[] {x,y};
        }
    }

    private static int findHCF(int n, int m) {
        int dividend = n;
        int divisor = m;
        while(divisor > 0) {
            int remainder = dividend%divisor;
            dividend = divisor;
            divisor = remainder;
        }
        return dividend;
    }

    public static void display(int number, int spf) {
        System.out.print("The Smallest Prime Factor for Number " + "'" + number + "' " + "is: " + spf);
    }
}
