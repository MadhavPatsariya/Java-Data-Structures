package Queue;

public class FIndTheWinner {
    public static void main(String[] args) {
        System.out.println(findTheWinner(6, 5));
    }

    public static int findTheWinner(int n, int k) {
            boolean[] out = new boolean[n];
            int index = 0;
            int count = n - 1;
            while(count > 0) {
                while(out[index]) {
                    index++;
                }
                index += (k - 1);
                index %= n;
                out[index] = true;
                count--;
            }
            int i = 0;
            for(; i < n; i++) {
                if(!out[i]) {
                    break;
                }
            }
            return i + 1;
        }
}
