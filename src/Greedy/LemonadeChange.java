package Greedy;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5,5,5,10,5,5,10,20,20,20};
        System.out.println("Is it possible: " + lemonadeChange(bills));
    }
    public static boolean lemonadeChange(int[] bills) {
        int countOfFive = 0;
        int countOfTen = 0;
        for (int bill : bills) {
            if (bill == 5) {
                countOfFive++;
            } else if (bill == 10) {
                if (countOfFive < 1) {
                    return false;
                }
                countOfFive--;
                countOfTen++;
            } else {
                if (countOfFive < 1) {
                    return false;
                }
                int fiveValue = 5 * countOfFive;
                int tenValue = 10 * countOfTen;
                if (fiveValue + tenValue < 15) {
                    return false;
                }
                if (tenValue == 0) {
                    countOfFive -= 3;
                } else {
                    countOfFive--;
                    countOfTen--;
                }
            }
        }
        return true;
    }
}
