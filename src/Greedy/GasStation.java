package Greedy;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println("Starting Position: " + canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        boolean[] visited = new boolean[gas.length];
        int i = 0;
        int currentGas = 0;
        int starting = -1;
        while(!visited[i]) {
            currentGas += gas[i];
            if(currentGas < cost[i]) {
                currentGas = 0;
                starting = i + 1;
            }
            else{
                currentGas -= cost[i];
                visited[i] = true;
            }
            i = (i + 1) % gas.length;
        }
        for(int j = 0; j < visited.length; j++) {
            if(!visited[j]) {
                 return -1;
            }
        }
        return starting % gas.length;
    }
}
