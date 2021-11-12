package edu.northeastern.qian.question1;

/**
 * This is a thread-safe implementation of linked list
 */
public class LinkedList {
    ListNode head;
    ListNode tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public synchronized void addAtPosition(int index, int element) {
        if (index > this.size() || index < 0) {
            throw new IllegalArgumentException("index is not valid");
        }

        ListNode node = new ListNode(element);
        if (this.size() == 0) {
            head = node;
            tail = node;
        } else if (index == 0) { // append before original head
            node.next = head;
            head = node;
        } else if (index == size) { // append after original tail
            tail.next = node;
            tail = node;
        } else { // truly insert
            ListNode cur = head;
            // move cur to a position so that node can be inserted after cur.
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            // insert after cur
            ListNode curNext = cur.next;
            cur.next = node;
            node.next = curNext;
        }
        size++;
    }

    public synchronized void removeAtPosition(int index){
        if (index >= this.size() || index < 0) {
            throw new IllegalArgumentException("index is not valid");
        }
        if (index == 0) { // remove head
            head = head.next;
        } else {
            ListNode cur = head;
            // move cur to a position right before the element to be removed
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            // remove the element after cur
            cur.next = cur.next.next;
        }
        size--;
    }

    public synchronized int getFirst() {
        if (size != 0) {
            return head.val;
        }
        return -1;
    }

    public synchronized int getLast() {
        if (size != 0 ) {
            return tail.val;
        }
        return -1;
    }

    public synchronized int size(){
        return size;
    }
}
