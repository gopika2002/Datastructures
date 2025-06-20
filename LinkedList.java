class LinkedList 
{

    class Node
    {
        int val;
        Node next;
        Node(int val,Node next)
        {
            this.val = val;
            this.next = next;
        }
        Node(int val)
        {
            this.val = val;
            this.next = null;
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
     public Node insertAtBegin(Node head,int val)
     {
           if(head!=null)
           {
            Node node = new Node(val,head);
            head = node;
           }
           else{
            Node node = new Node(val);
            head = node;
           }
           return head;

     }
     public Node insertAtEnd(Node head,int val)
     {
       
        if(head==null)
        {
            return new Node(val,head);
        }
        Node node = head;
        while(node.next!=null)
        {
            node = node.next;
        }
        Node newNode = new Node(val,null);
        node.next = newNode;
        return head;


     }
     public Node deleteAtBegin(Node head)
     {
        return head!=null?head.next:null;
        
     }
     public Node deleteAtEnd(Node head)
     {
        if(head == null) return null;
        else if(head.next==null) return null;
        else
        {
            Node node = head;
            Node prevNode = head;
            while(node.next!=null)
            {
                prevNode=node;
               node = node.next; 
            }
            prevNode.next=null;

            
        }
        return head;

     }
     public Boolean search(int val,Node head)
     {
        Node node = head;
        while(node!=null)
        {
            if(node.val==val)
            {
                return true;
            }
            node = node.next;
        }
        return false;

     }
     public Boolean detectCycle(Node head)
     {
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
            {
                return true;
            }
        }
        return false;
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
    public Node findCycleStartingPoint(Node head)
    {
        Node fast = head;
        Node slow = head;
        Boolean hasCycle = false;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
            {
                hasCycle=true;
                break;
            }
        }
        if(hasCycle)
        {
        slow = head;
        while(slow!=fast)
        {
            slow =slow.next;
            fast = fast.next;
        }
        return slow;
    }
        return null;

    }
    public Node reverse(Node head)
    { 
        Node curr= head;
        Node prev = null;
        while(curr!=null)
        {
            Node temp = curr.next;
            curr.next= prev;
            prev = curr;
            curr= temp;
        }
        return prev;
    }
    public Node removeNthFromEnd(Node head, int n) 
    {
        
        Node first = head;
        Node second = head;
        for(int i =1;i<=n;i++)
        {
            first = first.next;
        }
        if(first==null)
        {
            return head.next;
        }
        while(first!=null)
        {
            first=first.next;
            second= second.next;
        }
        second.next=second.next.next;
        return head;

    }
     public Node mergeSorted(Node l1, Node l2) 
     { 
        Node dummy = new Node(-1,null);
        Node tail=dummy;
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                Node n = new Node(l1.val);
                tail.next=n;
                tail = n;
                l1=l1.next;
            }
            else if(l1.val>l2.val)
            {Node n = new Node(l2.val);
                tail.next=n;
                tail = n;
                l2=l2.next;
            }
            else
            {
                Node n = new Node(l2.val);
                tail.next=n;
                tail = n;
                l2=l2.next;
                Node n2 = new Node(l1.val);
                tail.next=n2;
                tail = n2;
                l1=l1.next;
            }
        }
        while(l1!=null)
        {
            Node n=new Node(l1.val);
            tail.next=n;
            tail=n;
            l1=l1.next;
        }
        while(l2!=null)
        {
            Node n=new Node(l2.val);
            tail.next=n;
            tail=n;
            l2=l2.next;
        }
        return dummy.next;
     }
public boolean isPalindrome(Node head) 
{ 
     Node fast = head;
    Node slow = head;
    while(fast!=null && fast.next!=null)
    {
        fast = fast.next.next;
        slow=slow.next;
    }
    if(fast!=null)
    {
        slow = slow.next;
    }
    Node second = reverse(slow);
    Node node =  head;
    Node node2 = second;
    while(node!=null && node2!=null)
    {
        if(node.val!=node2.val)
        {
            return false;
        }
        node=node.next;
        node2=node2.next;
    }
    return true;
}
public int getLength(Node head) {
    int count = 0;
    while (head != null) {
        count++;
        head = head.next;
    }
    return count;
}

public Node sortList(Node head) 
{
    if(head==null || head.next==null)
    {
        return head;
    }
   Node mid= findMiddleNode(head);
   Node right = mid.next;
   mid.next=null;
   Node left= head;
    right = sortList(right);
    left = sortList(left);
    return merge(left,right);
    
    
    
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
                right=right.next;
            }
            else
            {
                tail.next=left;
                left=left.next;
            }
            tail = tail.next;
        }
        if(left!=null)
        {
            tail.next=left;
        }
        if(right!=null)
        {
            tail.next=right;
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
           
        }
        else
        {
            node = node.next;
        }
    }
    return head;
 }
public Node getIntersectionNode(Node headA, Node headB)
 { 
    Node nod1= headA;
    Node node2= headB;
    while(nod1!=node2)
    {
        nod1=nod1!=null?nod1.next:headA;
        node2=node2!=null?node2.next:headB;
    }
    return nod1;
 }
public int cycleLength(Node head)
 { 
    Node fast = head;
    int count =0;
        Node slow = head;
       
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
            {
                 count = 1;
                Node temp = slow.next;
                while (temp != slow) {
                    count++;
                    temp = temp.next;
                }
                return count;
            }
        }
    
    
        return count;
 }




}