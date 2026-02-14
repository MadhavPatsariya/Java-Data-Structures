package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class TimeToBuyTicket {
    public static void main(String[] args) {
        int[] tickets = {2,3,2};
        System.out.println(timeRequiredToBuy(tickets, 2));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Buyer> queue = new LinkedList<>();
        for(int i = 0; i < tickets.length; i++) {
            queue.offer(new Buyer(i, tickets[i]));
        }
        int time = 0;
        while(!queue.isEmpty()) {
            Buyer current = queue.poll();
            if(current.index == k && current.count == 0) {
                break;
            }
            if(current.count > 0) {
                queue.offer(new Buyer(current.index, current.count - 1));
                time++;
            }
        }
        return time;
    }
}

class Buyer {
    int index;
    int count;

    public Buyer(int index, int count) {
        this.index = index;
        this.count = count;
    }
}