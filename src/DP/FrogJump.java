package DP;

import java.util.*;

public class FrogJump {
    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();
        int[] stones =  {0,1,3,5,6,8,12,17};
        System.out.println(frogJump.canCross(stones));
    }

    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> memo = new HashMap<>();
        for(int stone: stones) {
            memo.put(stone, new HashSet<>());
        }

        memo.get(stones[0]).add(1);
        for(int i = 0; i < stones.length; i++) {
            Set<Integer> jumps = memo.get(stones[i]);
            for(int jump: jumps) {
                if(jump > 0) {
                    int newPosition = stones[i] + jump;
                    if(newPosition == stones.length - 1) {
                        return true;
                    }
                    if(memo.containsKey(newPosition)) {
                        memo.get(newPosition).add(jump);
                        memo.get(newPosition).add(jump - 1);
                        memo.get(newPosition).add(jump + 1);
                    }
                }
            }
        }
        return false;
    }
}
