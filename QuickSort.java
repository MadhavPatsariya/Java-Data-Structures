public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[] {5,27,23,4,5,5};
        System.out.println("Before Sorting");
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
        quickSort(nums, 0, nums.length-1);
        System.out.println("After Sorting");
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public static void quickSort(int[] nums, int low, int high) {
        if(low>=high) return;
        int partition = high;
        int sortedIndex = low;
        for(int i=low; i<high; i++){
            if(nums[i] > nums[partition]) continue;
            else{
                swap(nums, sortedIndex, i);
                sortedIndex++;
            }
        }
        swap(nums, sortedIndex, partition);
        quickSort(nums, sortedIndex+1, high);
        quickSort(nums, low, sortedIndex-1);
    }

    public static void swap(int[] nums, int x, int y) {
        int greaterNum = nums[x];
        nums[x] = nums[y]; 
        nums[y] = greaterNum;
    }
}
