import java.util.*;

import javax.swing.text.StyleConstants;

public class MyStack {

    // ======= 1. Array-based Stack =======
    class ArrayStack {
        int[] arr;
        int top, capacity;

        ArrayStack(int capacity) 
        {
           this.arr= new int[capacity];
           this.top = -1;

        }

        boolean isEmpty() 
        {
           
           return top==-1;
        }

        boolean isFull()
        {
            return top==capacity-1;
        }

        void push(int val) 
        {
           if(top<capacity-1)
           {
            top++;
            arr[top]=val;
            
           }
           else{
            System.err.println("stack over flow");
           }
        }

        int pop() 
        {
            if(top==-1)
            {
                System.err.println("stack under flow");
            }
            else
            {
                int val = arr[top];
                arr[top]=0;
                top--;
                return val;
            }
            return 0;
           
        }

        int peek() 
        {
            if(top==-1) return -1;
            return arr[top];
           
        }
    }

    // ======= 2. Linked List-based Stack =======
    class LinkedStack 
    {
         Node top;
        class Node {
            int val;
            Node next;
            Node(int val) {
                this.val = val;
                this.next=null;
    
                
             }
        }

        

        void push(int val) {
            Node node = new Node(val);
            node.next = top;
            top = node;
        }

        int pop() 
        {
           if(top==null)
           {
            System.err.println("stack underflow");
           }
           else
           {
                int value = top.val;
                top = top.next;
                return value;
           }
           return -1;
           
        }

        int peek() 
        {
            if(top == null) return -1;
            return top.val;
        }

        boolean isEmpty() {
            if(top==null) return true;
            else return false;
        }
    }

    // ======= 3. Min Stack (getMin in O(1)) =======
    class MinStack 
    {
        Stack<Integer> mainStack;
        Stack<Integer> minStack;

        MinStack() 
        {
            this.mainStack = new Stack();
            this.minStack = new Stack();
        }

        void push(int val) 
        {
           mainStack.push(val);
           if(minStack.peek()>val) minStack.push(val);
        }

        void pop() {
            int pop = mainStack.pop();
            if(pop==minStack.peek())
            {
                minStack.pop();
            }
        }

        int top() {
            if (mainStack.isEmpty()) {
                System.err.println("Stack is empty");
                return -1;
            }
            return mainStack.peek(); 
        }

        int getMin() {
            if (minStack.isEmpty()) {
                System.err.println("Stack is empty");
                return -1;
            }
            return minStack.peek(); 
        }
    }

    // ======= 4. Stack using 2 Queues =======
    class StackUsingQueues 
    {
        Queue<Integer> q1;
        Queue<Integer> q2;

        StackUsingQueues()
         {
            this.q1= new LinkedList<>();
            this.q2 = new LinkedList<>();
        }

        void push(int val) 
        {
            while(!q2.isEmpty())
            {
                q1.add(q2.poll());
            }
            q2.add(val);
            while(!q1.isEmpty())
            {
                q2.add(q1.poll());
            }
        }

        int pop() 
        {
           q2.poll();

        }

        int top() 
        {
           q2.peek();
        }

        boolean isEmpty() 
        {
            return q2.isEmpty();
        }
    }

    
    boolean isBalanced(String expr) 
    {
        Stack<Character> arr = new Stack<>();

        for(char s: expr.toCharArray())
        {
            if (s == '(' || s == '{' || s == '[') 
            {
                arr.push(s);
            }
            else
            {
                if(!arr.isEmpty() &&s==('}') && (arr.peek()==('{')))
                {
                    arr.pop();
                }
                else if(!arr.isEmpty() &&s==(']')&&arr.peek()==('['))
                {
                    arr.pop();
                }
                else if(!arr.isEmpty() &&s==(')') &&arr.peek()==('('))
                {
                    arr.pop();
                }
                else
                {
                    arr.push(s);
                }
            }
        }
       if(arr.isEmpty())
       {
        return true;
       }
       return false;
    }

    void sortStack(Stack<Integer> stack) 
    {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            if(temp.isEmpty())
            {
                temp.push(stack.pop());

            }
            else if(temp.peek()>stack.peek())
            {
                temp.push(stack.pop());
            }
            else if(stack.peek()>=temp.peek())
            {
                int current = stack.pop();
                while(!temp.isEmpty() && current<=temp.peek())
                {
                    stack.push(temp.pop());
                }
                temp.push(current);
            }
        }
        while(!temp.isEmpty())
        {
            stack.push(temp.pop());
        }
        
    }

    void reverseStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
    
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    int evaluatePostfix(String expression) 
    {
        
    }
}
