public class DoublyLinkedList {
    public static void main(String[] args) {
        Node root = null;
        for (int i = 10; i < 70; i += 10) {
            Node newNode = new Node(i);
            if(root == null) {
                root = newNode;
            }
            else{
                Node temp = root;
                Node prev = null;
                while(temp.next != null) {
                    prev = temp;
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.prev = temp;
                temp.prev = prev;
            }
        }

        Node temp = root;
        while (temp != null) {
            int prevData = -1;
            if(temp.prev!=null) {
                prevData = temp.prev.data;
            }
            System.out.print("Current Data: " + temp.data + "Previous Data: " + prevData);
            temp = temp.next;
        }
        System.out.println();
    }
}

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}