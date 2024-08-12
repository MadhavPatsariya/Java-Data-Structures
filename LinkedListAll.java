public class LinkedListAll {
    public static void main(String[] args) {
        Node root = null;
        for(int i=1; i<50; i=i+10) {
            if(root == null) {
                root = new Node(i);
            }
            else{
                Node next = new Node(i);
                Node temp = root;
                while(temp.next != null) {
                    temp = temp.next;
                }
                temp.next = next;
            }
        }
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}