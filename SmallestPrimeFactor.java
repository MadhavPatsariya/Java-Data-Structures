import java.util.Scanner;

public class SmallestPrimeFactor {
     public static void main(String[] args) {
        int n = takeInput();
        int spf = findSPF(n);
        display(n, spf);
    }

    private static int takeInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextInt();
        }
    }

    private static int findSPF(int n) {
        int sqrt = (int) Math.ceil(Math.sqrt(n));
        int minimum = Integer.MAX_VALUE;
        for(int i = 2; i< sqrt; i++){
            if(n%i==0){
                if(minimum > i) {
                    minimum = i;
                }
            }
        }
        return minimum;
    }

    public static void display(int number, int spf) {
        System.out.print("The Smallest Prime Factor for Number " + "'" + number + "' " + "is: " + spf);
    }
}
