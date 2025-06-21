class CircularSinglyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public void display(Node head) 
    {
        if (head == null) return;
        Node node = head;
        while(node!=null)
        {
            System.out.println(node.val);
            node = node.next;
            if(node==head)
            {
                break;
            }
        }
    }
    public Node insertAtBegin(Node head, int val) 
    {
        if(head==null)
        {
            Node node = new Node(val);
            node.next=node;
            return node;
        }
        else
        {
            Node node = new Node(val);
            node.next=head;
            Node temp = head;
            Node prev = head;
            while(temp!=null)
            {

                prev=temp;
                temp = temp.next;
            if(temp==head)
            {
                break;
            }
            }
            prev.next=node;
            head=node;


        }
        return head;
    }
    public Node insertAtEnd(Node head, int val) 
    {
        if(head==null)
        {
            Node node= new Node(val);
            node.next=node;
            return node;
        }
        Node node = head.next;
        Node lastNode = node;
        while(node!=null && node != head)
        {
            lastNode= node;
            node = node.next;
        }
        Node newNode = new Node(val);
        lastNode.next= newNode;
        newNode.next= head;
       
       
        return head;

    }
    public Node deleteAtBegin(Node head) {
        if(head == null || head.next==head) return null;
        Node node = head;
        while(node.next!=head)
        {
            node = node.next;
        }
        node.next= head.next;
        head=head.next;
       return head;
        
    }
    public Node deleteAtEnd(Node head)
    {
        if(head == null || head.next==head) return null;
        Node node = head;
        Node prevNode = head;
        while(node.next!=head)
        {
            prevNode = node;
            node = node.next;
        }
        prevNode.next= head;
        
        return head;

}
    public boolean isCircular(Node head) 
    {
        if(head==null) return false;
        Node node = head.next;
        while(node != null && node != head)
        {
            node = node.next;

        }
        return node==head;
    }

    public boolean search(Node head, int val)
    {
        if(head==null) return false;
        if(head.val==val) return true;
        Node node = head.next;
        while(node != null && node != head)
        {
            if(node.val==val)
            {
                return true;
            }
            node = node.next;

        }
        return false;
    }
    public int getLength(Node head) {
        if(head==null) return 0;
        if(head.next==head) return 1;
        Node node = head.next;
        int count=1;
        while(node != head)
        {
           ++count;
            node = node.next;

        }
        return count;
    }
    public Node findMiddleNode(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast.next!=head && fast.next.next!=head)
        {
            fast=fast.next.next;
            slow = slow.next;
        
        }
        return slow;
    }

    // Advanced
    public Node[] splitIntoTwoLists(Node head)
    {
        Node mid = findMiddleNode(head);
        Node right = mid.next;
        Node node = right;
        mid.next = head;
        while(node.next!=head)
        {
            node = node.next;
        }
        node.next = right;
        return new Node[]{head, right};

    }
    public int josephusProblem(Node head, int k) 
    {
        Node node = head;
        Node prev = head;
while (prev.next != head) {
    prev = prev.next;
}
        while(node.next!=node)
               {
                for (int i=1;i<k;i++)
                {
                    prev=node;
                    node=node.next;
                }
                prev.next=node.next;
               node = node.next;
               }
               

        return node.val;
    }
    private int countTheNumberOfNodes(Node head) 
            {
                int count =1;
                Node node=head;
               while(node.next!=head)
               {
                 count++;
                 node=node.next;
                
               }
               return count;
            }
}
