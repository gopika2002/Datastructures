class CircularDoublyLinkedList {

    class Node {
        int val;
        Node next, prev;

        Node(int val) {
            this.val = val;
        }
    }

    public void display(Node head) {}
    public Node insertAtBegin(Node head, int val) {}
    public Node insertAtEnd(Node head, int val) {}
    public Node deleteAtBegin(Node head) {}
    public Node deleteAtEnd(Node head) {}
    public int getLength(Node head) {}

    // Advanced
    public Node reverse(Node head) {}
    public boolean search(Node head, int val) {}
    public Node rotate(Node head, int k) {}
    public Node splitIntoHalves(Node head) {}
}
