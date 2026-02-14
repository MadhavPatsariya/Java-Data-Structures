package Recursion;

public class MinimumInDuplicateRotateArray {
    public static void main(String[] args) {
        int[] nums = {5,5,5,8,9,9,1,1};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public static int search(int[] nums, int low, int high) {
        if(low <= high) {
            int mid = (high - low) / 2 + low;
            int belowMid = mid;
            int aboveMid = mid;
            while(belowMid > low && nums[belowMid] == nums[mid]) {
                belowMid--;
            }
            while(aboveMid < high && nums[aboveMid] == nums[mid]) {
                aboveMid++;
            }
            if(nums[belowMid] == nums[mid] && nums[aboveMid] == nums[mid]) {
                return nums[mid];
            }
            if((mid == low || nums[belowMid] > nums[mid]) && ((mid == high) || nums[aboveMid] > nums[mid])) {
                return nums[mid];
            }
            if(nums[mid] >= nums[low] && nums[mid] > nums[high]) {
                return search(nums, mid + 1, high);
            }
            else return search(nums, low, mid - 1);
        }
        return -1;
    }
}
