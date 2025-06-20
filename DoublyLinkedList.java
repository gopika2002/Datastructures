class DoublyLinkedList {

    class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
        }
    }

    public void display(Node head)
     {
        Node node = head;
        while(node!=null)
        {
            System.out.println(node.val);
            node = node.next;
        }
     }
     public Node insertAtBegin(Node head, int val)
     {
        if (head==null ) return new Node(val);
        Node n = new Node(val);
        n.prev=null;
        n.next=head;
        head.prev=n;
        head=n;
        return head;
    }
    public Node insertAtEnd(Node head, int val) 
    {if (head==null ) return new Node(val);

        Node node = head;
        Node newNode = new Node(val);
        while(node.next!=null)
        {   
            node=node.next;

        }   
        newNode.prev=node;
        node.next=newNode;
        return head;
    }
    public Node deleteAtBegin(Node head) 
    {
        if (head==null || head.next==null) return null;
        head = head.next;
        head.prev=null;
        return head;
         
    }
    public Node deleteAtEnd(Node head) {
        if (head==null || head.next==null) return null;
        Node node = head;

       while(node.next.next!=null)
        {   
            node=node.next;

        }
        node.next.prev=null;
        node.next=null;
        
        return head;
      }
    public int getLength(Node head) 
    {
        int count =0;
        Node node = head;
        while(node!=null)
        {
           ++count;
           node=node.next;
        }
        return count;
    }

    // Intermediate
    public Node insertAfter(Node head, int targetVal, int newVal) 
    {
        Node newNode = new Node(newVal);
        Node node = head;
    
        while(node.next!=null)
        {

            if(node.val==targetVal)
            {
                break;
            }
            node = node.next;
        }
        Node temp = node.next;
        node.next=newNode;
        newNode.prev=node;
       newNode.next=temp;
       if(temp!=null)
       {
        temp.prev=newNode;
       }
    
        return head;
    }
    public Node deleteNode(Node head, int val) 
{
    if (head == null) return null;

    // Special case: deleting the head node
    if (head.val == val) {
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        return head;
    }

    Node node = head;

    while (node != null) {
        if (node.val == val) {
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            break;
        }
        node = node.next;
    }

    return head;
}


    // Advanced
    public Node reverse(Node head) {
        Node node = head;
        Node last = null;
        while(node!=null)
        {
          Node temp = node.next;
          node.next = node.prev;
          node.prev = temp;
          last = node;
          node = node.next;
        }
        

        return last;
    }
    public Node sortList(Node head) 
    {
        Node mid = findMiddleNode(head);
        Node right = mid.next;
        mid.next = null;
        Node left = head;
        right = sortList(right);
        left = sortList(head);
        return merge(right,left);
        
    }
    private Node merge(Node left, Node right)
    {
        Node dummy = new Node(-1);
        Node tail = dummy;
        while(left!=null && right!=null)
        {
            if(left.val>right.val)
            {
                tail.next= right;
                right.prev=tail;
                right=right.next;
            }
            else
            {
                tail.next=left;
                left.prev=tail;
                left=left.next;
            }
            tail = tail.next;
        }
        if(left!=null)
        {

            tail.next=left;
            left.prev=tail;
        }
        if(right!=null)
        {
            tail.next=right;
            right.prev=tail;
        }
        return dummy.next;
    }
    
    public Node removeDuplicates(Node head)
    { 
       head = sortList(head);
       Node node = head;
       while(node!=null && node.next!=null)
       {
           if(node.val == node.next.val)
           {
          
            node.next = node.next.next;
            if(node.next!=null)
            {
                node.next.prev=node;
            }
              
            }
            else
           {
               node = node.next;
           }
           
       }
       return head;
    }
      

    public Node rotate(Node head, int k) {
        if (head == null || k == 0) return head;
    
       
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
    
        k = k % count;
        if (k == 0) return head; 
    
        
        head = reverse(head);
    
       
        Node firstK = head;
        Node node = head;
        for (int i = 1; i < k; i++) {
            node = node.next;
        }
    
        Node nextPart = node.next;
        node.next = null;
        if (nextPart != null) nextPart.prev = null;
    
        Node firstPart = reverse(firstK);
        Node secondPart = reverse(nextPart);
    
        
        Node tail = firstPart;
        while (tail.next != null) {
            tail = tail.next;
        }
    
        tail.next = secondPart;
        if (secondPart != null) secondPart.prev = tail;
    
        return firstPart;
    }
    
    public Node findMiddleNode(Node head) 
    {
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        } 
        return slow;
    }

    // Cycle (DLL)
    public boolean hasCycle(Node head) 
    {
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast)
            {
                return true;
            }
        } 
        return false;

    }
}
