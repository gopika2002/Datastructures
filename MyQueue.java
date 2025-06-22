import java.util.*;

public class MyQueue {

    // ======= 1. Array-based Queue =======
    class ArrayQueue {
        int[] arr;
        int front, rear, size, capacity;

        ArrayQueue(int capacity) {
            // constructor
        }

        boolean isEmpty() {
            // logic
        }

        boolean isFull() {
            // logic
        }

        void enqueue(int val) {
            // logic
        }

        int dequeue() {
            // logic
        }

        int peek() {
            // logic
        }
    }

    // ======= 2. Linked List-based Queue =======
    class LinkedQueue {
        class Node {
            int data;
            Node next;
            Node(int data) { }
        }

        Node front, rear;

        void enqueue(int val) {
            // logic
        }

        int dequeue() {
            // logic
        }

        int peek() {
            // logic
        }

        boolean isEmpty() {
            // logic
        }
    }

    // ======= 3. Circular Queue =======
    class CircularQueue {
        int[] arr;
        int front, rear, size, capacity;

        CircularQueue(int capacity) {
            // constructor
        }

        boolean isFull() {
            // logic
        }

        boolean isEmpty() {
            // logic
        }

        void enqueue(int val) {
            // logic
        }

        int dequeue() {
            // logic
        }

        int peek() {
            // logic
        }
    }

    // ======= 4. Deque using DLL =======
    class Deque {
        class Node {
            int data;
            Node prev, next;
            Node(int data) { }
        }

        Node front, rear;

        void insertFront(int val) {
            // logic
        }

        void insertRear(int val) {
            // logic
        }

        int deleteFront() {
            // logic
        }

        int deleteRear() {
            // logic
        }

        int getFront() {
            // logic
        }

        int getRear() {
            // logic
        }

        boolean isEmpty() {
            // logic
        }
    }

    // ======= 5. Queue using 2 Stacks =======
    class QueueUsingStacks {
        Stack<Integer> s1, s2;

        QueueUsingStacks() {
            // constructor
        }

        void enqueue(int val) {
            // logic
        }

        int dequeue() {
            // logic
        }

        boolean isEmpty() {
            // logic
        }
    }

    // ======= 6. Utility Methods =======
    void reverseQueue(Queue<Integer> q) {
        // reverse logic
    }

    Queue<Integer> interleaveQueue(Queue<Integer> q) {
        // interleave halves
    }

    int firstNonRepeatingChar(String stream) {
        // frequency + queue
    }

    boolean isPalindromeQueue(Queue<Integer> q) {
        // use stack to check
    }
}
