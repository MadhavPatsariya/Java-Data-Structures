public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[] {90,2,46,4,4,1,120,12,34,12};
        System.out.println("Before Sorting");
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
        mergeSort(nums, 0, nums.length-1);
        System.out.println("After Sorting");
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if(low<high) {
            int mid = (high-low)/2 + low;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] leftArray = new int[mid+1-low];
        int[] rightArray = new int[high-mid];
        for(int i=0; i<leftArray.length; i++) {
            leftArray[i] = nums[low+i];
        }
        for(int i=0; i<rightArray.length; i++) {
            rightArray[i] = nums[mid+1+i];
        }
        int mainIndex = low;
        int left = 0;
        int right = 0;
        while(left<leftArray.length && right<rightArray.length) {
            if(leftArray[left] > rightArray[right]) {
                nums[mainIndex] = rightArray[right];
                right++;
            }
            else{
                nums[mainIndex] = leftArray[left];
                left++;
            }
            mainIndex++;
        }
        while(left<leftArray.length && mainIndex <= high) {
            nums[mainIndex] = leftArray[left];
            left++;
            mainIndex++;
        }
        while(right<rightArray.length && mainIndex <= high) {
            nums[mainIndex] = rightArray[right];
            right++;
            mainIndex++;
        }
    }

}
