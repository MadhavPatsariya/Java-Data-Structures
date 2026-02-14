package Graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> rank;
    List<Integer> parent;
    List<Integer> size;

    public DisjointSet(int V) {
        this.rank = new ArrayList<>();
        this.parent = new ArrayList<>();
        this.size = new ArrayList<>();
        for(int i = 0; i < V + 1; i++) {
            rank.add(0);
            size.add(1);
            parent.add(i);
        }
    }

    public int findParent(int u) {
        if(u == parent.get(u)) {
            return u;
        }
        int ultimateParent = findParent(parent.get(u));
        parent.set(u, ultimateParent);
        return parent.get(u);
    }

    public void unionByRank(int u, int v) {
        int parentOfU = findParent(u);
        int parentOfV = findParent(v);
        if(parentOfU == parentOfV) {
            return;
        }
        int rankOfU = rank.get(parentOfU);
        int rankOfV = rank.get(parentOfV);
        if(rankOfU == rankOfV) {
            parent.set(parentOfV, parentOfU);
            rank.set(parentOfU, rankOfU + 1);

        }
        else if(rankOfU < rankOfV) {
            parent.set(parentOfU, parentOfV);
        }
        else {
            parent.set(parentOfV, parentOfU);
        }
    }

    public void unionBySize(int u, int v) {
        int parentOfU = findParent(u);
        int parentOfV = findParent(v);
        if(parentOfU == parentOfV) {
            return;
        }
        int sizeOfU = size.get(parentOfU);
        int sizeOfV = size.get(parentOfV);
        if(sizeOfU == sizeOfV) {
            parent.set(parentOfV, parentOfU);
            int newSize = size.get(parentOfU) + size.get(parentOfV);
            size.set(parentOfU, newSize);

        }
        else if(sizeOfU < sizeOfV) {
            parent.set(parentOfU, parentOfV);
            int newSize = size.get(parentOfU) + size.get(parentOfV);
            size.set(parentOfV, newSize);
        }
        else {
            parent.set(parentOfV, parentOfU);
            int newSize = size.get(parentOfU) + size.get(parentOfV);
            size.set(parentOfU, newSize);
        }
    }
}

class Main{
    public static void main(String[] args) {
        DisjointSet set = new DisjointSet(7);
        set.unionBySize(1, 2);
        set.unionBySize(2, 3);
        set.unionBySize(4, 5);
        set.unionBySize(6, 7);
        set.unionBySize(5, 6);
        if(set.findParent(3) == set.findParent(7)) {
            System.out.println("3 & 7 has same parent");
        }
        else{
            System.out.println("3 & 7 has different parent");
        }
        set.unionBySize(3, 7);
        if(set.findParent(3) == set.findParent(7)) {
            System.out.println("3 & 7 has same parent");
        }
        else{
            System.out.println("3 & 7 has different parent");
        }
        System.out.println(set.parent.get(7));
        System.out.println(set.size.get(set.parent.get(7)));
    }
}
