package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        HashSet<ArrayList<Coordinates>> set = new HashSet<>();
        ArrayList<Coordinates> list = new ArrayList<>();
        for(int i =0 ; i < 3; i++) {
            list.add(new Coordinates(0, 0));
            list.add(new Coordinates(0, 1));
            set.add(list);
            list.clear();
        }
        Iterator<ArrayList<Coordinates>> coordinatesIterator = set.stream().iterator();
        while(coordinatesIterator.hasNext()){
            ArrayList<Coordinates> l = coordinatesIterator.next();
            System.out.println("New List --> ");
            for(Coordinates c : l) {
                System.out.println("x : " + c.x + " , y: " + c.y);
            }

        }
    }
}

class Coordinates {
    int x;
    int y;
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
