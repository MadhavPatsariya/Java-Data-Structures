package Greedy;

public class IslandSurvival {
    public static void main(String[] args) {
        System.out.println(minimumDays(10, 9, 8)); // 9 output
    }

//    static int minimumDays(int S, int N, int M) {
//        //int numberOfSundays = S / 7;
////        int extraAmountNeeded = M * numberOfSundays;
//        // X = S * M + M * numberOfSundays;
//        12 - 1 * 20 = 240;
//        11 * 20 = 220
//        // X = 10 * 2 + 2 * 1;
//        // X * 16 = 22;
//        // X = ceiling ( 22 / 16) + 1;
//
//        // X * 9 = 10 * 8 + 8 * 1
//        // X = 88 / 9 = 10
//
//        // X / 7 > 0 then we are returning -1;
//        int totalAmountNeeded = S * M;
//        int minimumDaysToBuy = -1;
//        if(totalAmountNeeded % N == 0) {
//            minimumDaysToBuy = totalAmountNeeded / N;
//        }
//        else {
//            minimumDaysToBuy = totalAmountNeeded / N + 1;
//        }
//        return (minimumDaysToBuy < 7) ? minimumDaysToBuy : -1;
//    }

//    static int minimumDays(int S, int N, int M) {
//        int daysCanBuy = S - (S / 7);  // Shop closed on Sundays
//        int totalNeeded = S * M;
//        int totalBought = daysCanBuy * N;
//
//        if (M > N) return -1; // Can't buy enough food for a day
//        if (totalBought < totalNeeded) return -1; // Not enough food even if buying on all available days
//
//        int minimum = (int) Math.ceil((double) totalNeeded / N);
//        return minimum;
//    }

    static int minimumDays(int S, int N, int M) {
        int daysCanBuy = S - (S / 7);
        int totalBought = daysCanBuy * N;
        int totalNeeded = S * M;
        if (M > N) return -1;
        if (daysCanBuy * N < totalNeeded) return -1;
        int minimum = (int) Math.ceil((double) totalNeeded / N);
        return (minimum <= daysCanBuy) ? minimum : -1;
    }
}
