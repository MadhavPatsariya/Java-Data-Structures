public class ArrayRotation {
    public static void main(String[] args) {
        int[] nums = new int[] {1,27,23,4,8,5};
        System.out.println("Before Sorting: ");
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        // System.out.println("");
        // rotateArray(nums, 3);
        // System.out.println("After Sorting using normal rotate Array: ");
        // for(int i=0; i<nums.length; i++){
        //     System.out.print(nums[i] + " ");
        // }
        System.out.println("");
        rotateArrayWithAuxSpace(nums, 7);
        System.out.println("After Sorting using aux space rotate Array: ");
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
    /*
     * O(n^m) where n is length of array and m is no. of shift 
     * Space: O(1)
     */
    public static void rotateArray(int[] nums, int n){
        int shift = n;
        while(shift>0){
            int prev = nums[0];
            int next = nums[1];
            for(int i=1; i< nums.length; i++){
                next = nums[i];
                nums[i] = prev;
                prev = next;
            }
            nums[0] = prev;
            shift--;
        }
    }

    /**
     * 
     */
    public static void rotateArrayWithAuxSpace(int[] nums, int m) {
        int n = nums.length;
        if(m < n){
            int[] elementToBeShifted = new int[m];
            for(int i=n-m; i<n; i++) {
                elementToBeShifted[i-(n-m)] = nums[i];
            }
            for(int i=n-m-1; i>=0; i--) {
                nums[i+m] = nums[i];
            }
            for(int i=0; i<m; i++) {
                nums[i] = elementToBeShifted[i];
            }
        }
        else{
            m = m - n;
            int[] elementToBeShifted = new int[m];
            for(int i=n-m; i<n; i++) {
                elementToBeShifted[i-(n-m)] = nums[i];
            }
            for(int i=n-m-1; i>=0; i--) {
                nums[i+m] = nums[i];
            }
            for(int i=0; i<m; i++) {
                nums[i] = elementToBeShifted[i];
            }
        }
    }
}
