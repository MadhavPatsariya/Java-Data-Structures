import java.util.Scanner;

/**
 * LeastCommonFactor
 */
public class LeastCommonFactor {

    public static void main(String[] args) {
        int[] input = takeInput();
        int n = input[0];
        int m = input[1];
        int lcm = findLCM(n,m);
        display(lcm);
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

    /**
     * @param n
     * @param m
     * @return
     * using the formula lcm*hcf = n*m
     * n*m/hcf 
     */
    private static int findLCM(int n, int m) {
        int hcf = (n>m) ? findHCF(n, m) : findHCF(m, n);
        System.out.println("The HCF is: " + hcf);
        int lcm = ((n*m)/hcf);
        return lcm;
    }

    public static void display(int spf) {
        System.out.println("The LCM is: " + spf);
    }
}