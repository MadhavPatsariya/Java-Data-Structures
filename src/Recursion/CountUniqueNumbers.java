package Recursion;

public class CountUniqueNumbers {
    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(1));
    }

    public static int countNumbersWithUniqueDigits(int n) {
        if(n == 0) {
            return 1;
        }
        int starting = 9;
        int temp = n - 1;
        int total = 9;
        while(temp-- > 0) {
            total *= starting;
            starting--;
        }
        return total + countNumbersWithUniqueDigits(n - 1);
    }

}
