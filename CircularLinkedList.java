class CircularSinglyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public void display(Node head) {}
    public Node insertAtBegin(Node head, int val) {}
    public Node insertAtEnd(Node head, int val) {}
    public Node deleteAtBegin(Node head) {}
    public Node deleteAtEnd(Node head) {}
    public boolean isCircular(Node head) {}
    public boolean search(Node head, int val) {}
    public int getLength(Node head) {}

    // Advanced
    public Node splitIntoTwoLists(Node head) {}
    public int josephusProblem(Node head, int k) {}
}
