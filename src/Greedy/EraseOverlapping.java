package Greedy;

import java.util.Arrays;

public class EraseOverlapping {
    public static void main(String[] args) {
        int[][] intervals = {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {return a[1] - b[1];});
        int count = 0;
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(prevEnd > intervals[i][0]) {
                count++;
            }
            else{
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}
