public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[] {5,27,23,4,5,5};
        System.out.println("Before Sorting");
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
        insertionSort(nums, nums.length);
        System.out.println("After Sorting");
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public static void insertionSort(int[] nums, int n) {
        for(int i=1; i<n; i++) {
            int j = i-1;
            int key = nums[i];
            while(j>=0 && nums[j] > key ) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }
}
