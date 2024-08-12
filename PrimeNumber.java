/**
 * @author mpatsariya
 * PrimeNumber
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumber {

    public static void main(String[] args) {
        int n = takeInput();
        display(sieveOfErathothenes(n));
    }

    private static int takeInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextInt();
        }
    }
    /**
     * 
     * @param n
     * @return
     * This is the method that I wrote; 
     * It's inefficient as we have 2 ArrayList; rather we could've used only one.
     * Why to set again when we can have a boolean array with 0,1 marked as false :)
     * And why do we need to check every element after p, we can directly jump to p^2 and go to 
     * it's multiple
     */
    @SuppressWarnings("unused")
    private static List<Integer> findAllPrimeNumbers(int n) {
        if(n == 2) return new ArrayList<Integer>(Arrays.asList(2));
        List<Integer> primeNumbers = new ArrayList<>();
        List<Integer> allNumbers = new ArrayList<>();
        for(int i=2; i<=n; i++){
            allNumbers.add(i);
        }
        for(int i=0; i<allNumbers.size(); i++) {
            if(allNumbers.get(i) < 0) {
                continue;
            }
            int p = allNumbers.get(i);
            int index = i+1;
            while(index < allNumbers.size()) {
                int currentNumber = allNumbers.get(index);
                if(currentNumber >= (p*p) && currentNumber % p == 0) {
                    currentNumber = currentNumber*(-1);
                }
                allNumbers.set(index, currentNumber);
                index++;
            }
        }
        for(int i=0; i<allNumbers.size(); i++) {
            if(allNumbers.get(i) > 0) {
                primeNumbers.add(allNumbers.get(i));
            }
        }
        return primeNumbers;
    }
    
    /***
     * Efficient Implementation
     * @param n
     * @return
     */
    public static List<Integer> sieveOfErathothenes(int n){
        List<Integer> primeNumbers = new ArrayList<>();
        boolean[] allNumbers = new boolean[n+1];
        Arrays.fill(allNumbers, true);
        allNumbers[0] = allNumbers[1] = false;

        for(int i=2; i<=n; i++) {
            if(allNumbers[i]) {
                for(int multiple = (i*i) ; multiple<=n; multiple+=i) {
                    allNumbers[multiple] = false;
                }
            }   
        }
        for(int i=0; i<=n; i++) {
            if(allNumbers[i]){
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    public static <T> void display(List<T> list) {
        System.out.print("The Prime Numbers are: ");
        for(int i=0 ; i< list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
    }
}