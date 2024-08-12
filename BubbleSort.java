class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[] {5,27,23,4,5,5};
        System.out.println("Before Sorting");
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
        bubbleSort(nums, nums.length);
        System.out.println("After Sorting");
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public static void bubbleSort(int[] nums, int n) {
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(nums[j] < nums[i]) {
                    swap(nums, j, i);
                }
            }
        }
    }

    public static void swap(int[] nums, int x, int y) {
        int greaterNum = nums[x];
        nums[x] = nums[y]; 
        nums[y] = greaterNum;
    }
}