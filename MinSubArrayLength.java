class MinSubArrayLength {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5};
        int target = 11;
        int len = minSubArrayLen(target , nums);
        System.out.println("Length: " + len);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        // if(greaterThanTarget) remove intialElements
        // else keep adding the elements;
        // if all the elements are added and yet !>= to target; return 0
        int current = 0;
        int last = 0;
        int total = 0;
        int minimum = Integer.MAX_VALUE;
        while(current<nums.length) {
            total += nums[current];
            while (total >= target) {
                if(minimum > current-last+1) {
                    minimum = current-last+1;
                }
                total = total - nums[last];
                last++; 
            }
            current++;
        }
        return minimum == Integer.MAX_VALUE ? 0 : minimum;
    }
}