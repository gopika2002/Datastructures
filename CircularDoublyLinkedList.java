class CircularDoublyLinkedList {

    class Node {
        int val;
        Node next, prev;

        Node(int val) {
            this.val = val;
        }
    }


    public void display(Node head)
    {
        if (head == null) return;
        Node node = head;
        do
        {
            System.out.println(node.val);
            node = node.next;
        }while((node!=head));
    }
    public Node insertAtBegin(Node head, int val) {
        if (head == null)
        {
            Node node = new Node(val);
            node.next= node;
            node.prev=node;
            return node;
        }
        else
        {
           Node newNode = new Node(val);
           newNode.next=head;
           newNode.prev=head.prev;
           head.prev.next=newNode;
           head.prev=newNode;
           head=newNode;
        }
       return head;
    }
    public Node insertAtEnd(Node head, int val)
    {
        if (head == null)
        {
            Node node = new Node(val);
            node.next= node;
            node.prev=node;
            return node;
        }
        else
        {
           Node newNode = new Node(val);
           newNode.next=head;
           newNode.prev=head.prev;
           head.prev.next=newNode;
           head.prev=newNode;

        }
       return head;
    }
    public Node deleteAtBegin(Node head) 
    {
        if (head == null || head.next==head)
        {
           return null;
        }
       else
        {
          Node node= head.next;
          node.prev=head.prev;
          head.prev.next=node;
          head=node;
        }
       return head;
    }
    public Node deleteAtEnd(Node head) {
        if (head == null || head.next==head)
        {
           return null;
        }
       else
        {
            Node node = head.prev;
            head.prev = node.prev;
            node.prev.next=head;

        }
       return head;
    }
    public int getLength(Node head) 
    {
        int count=0;
        if (head == null) return 0;
        Node node = head;
        do
        {
            ++count;
            node = node.next;
        }while((node!=head));
        return count;

    }

    // Advanced
    public Node reverse(Node head) {
        
        if (head == null) return head;
        Node node = head;
        Node currNode = node;
        do
        {
            Node temp=currNode.next;
            currNode.next=currNode.prev;
            currNode.prev=temp;
           node = node.next;
        }while((node!=head));
        return head.prev;

    }
    public boolean search(Node head, int val) {
        if (head == null) return false;
    
        Node node = head;
        while (true) {
            if (node.val == val) return true;
            node = node.next;
            if (node == head) break;
        }
    
        return false;
    }
    public Node rotate(Node head, int k) 
    {
        int n=getLength(head);
        k=k%n;
        for(int i=0;i<k;i++)
        {
            head=head.next;
        }
        return head;
        
    }
    public Node findMidNode(Node head) 
    {
      Node fast = head;
      Node slow = head;
      while(fast.next!=head && fast.next.next!=head)
      {
        fast= fast.next.next;
        slow=slow.next;
      }
      return slow;
        
    }
    public Node[] splitIntoHalves(Node head) 
    {
        Node miNode= findMidNode(head);
        Node right = miNode.next;
        Node left = head;
        Node lastNode = head.prev;
        miNode.next=left;
        left.prev=miNode;
        lastNode.next=right;
        right.prev=lastNode;
        
       


        return new Node[]{left,right};

    }
}
