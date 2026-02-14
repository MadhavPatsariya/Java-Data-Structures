package SlidingWindow;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        SearchInRotatedArray searchInRotatedArray = new SearchInRotatedArray();
        int[] nums = {3, 5, 1};
        int target = 3;
        System.out.println("Search Target Found at: " + searchInRotatedArray.search(nums, target));
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int low, int high) {
        if(low <= high) {
            int mid = (high - low) / 2 + low;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] >= nums[low] && nums[mid] > nums[high]) {
                if(nums[low] > target) {
                    return binarySearch(nums, target, mid + 1, high);
                }
                else return binarySearch(nums, target, low, mid - 1);
            }
            else {
                if(nums[low] > target) {
                    return binarySearch(nums, target, low, mid - 1);
                }
                else return binarySearch(nums, target, mid + 1, high);
            }
        }
        return -1;
    }
}
