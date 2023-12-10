package com.javaudemy.LL;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;
    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
    public void append(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
            length = 1;
        }else{
            tail.next = newNode;
            tail = newNode;
            length++;
        }
    }
    public void prepend(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
            length = 1;
        }else{
            newNode.next = head;
            head = newNode;
            length++;
        }
    }
    public Node removeLast(){
        if(length == 0) return null;
        Node temp = head;
        Node prev = head;
        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        tail = prev;
        length--;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }
    public Node removeFirst(){
        if(length == 0) return null;
        Node temp = head;
        head = temp.next;
        temp.next = null;
        length--;
        if(length == 0){
            tail = null;
        }
        return temp;
    }
    public Node get(int index){
        if(index<0 || index>=length) return null;
        Node temp = head;
        for(int i=0; i<index;i++){
            temp = temp.next;
        }
        return temp;
    }
    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp == null){
            return false;
        }
        temp.value = value;
        return true;
    }
    public boolean insert(int index, int value){
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        if(index<0 || index > length){
            return false;
        }
        Node temp = get(index-1);
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }
    public Node remove(int index){
        if(index<0 || index >= length) return null;
        if(index == 0){
            return removeFirst();
        }
        if(index == length-1){
            return removeLast();
        }
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node before = null,after;
        for(int i=0; i<length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
    public void printList(){
        if(head == null){
            System.out.println("\nEmpty List");
        }else{
            System.out.println("\nElements in list are ");
            Node temp = head;
            while(temp != null){
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
        }
    }
    public Node getHead(){
        return head;
    }
    public Node getTail(){
        return tail;
    }
    public int getLength(){
        return length;
    }
    public Node findMiddleNode(){
        if(head == tail) return head;
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean hasLoop(){
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
    public Node findKthFromEnd(int k){
        Node fast = head, slow = head;
        for(int i=0; i<k; i++){
            if(fast == null)
                return null;
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public void partitionList(int x){
        if(head == null){
            return;
        }
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;
        while(current != null){
            if(current.value < x){
                prev1.next = current;
                prev1 = current;
            }else{
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;
        head = dummy1.next;
    }
    public void removeDuplicates(){
        Set<Integer> values = new HashSet<>();
        Node prev = null, cur = head;
        while(cur != null){
            if(values.contains(cur.value)){
                prev.next = cur.next;
            }else{
                values.add(cur.value);
                prev = cur;
                length--;
            }
            cur = cur.next;
        }
    }
    public int binaryToDecimal() {
        int num = 0;
        Node current = head;
        while (current != null) {
            num = num * 2 + current.value;
            current = current.next;
        }
        return num;
    }
    public void reverseBetween(int startIndex , int endIndex){
        if(head == null) return;
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        for(int i=0; i<startIndex; i++)
            prev = prev.next;
        Node cur = prev.next;
        for(int i=0; i<(endIndex-startIndex); i++){
            Node nextToMove = cur.next;
            cur.next = nextToMove.next;
            nextToMove.next = prev.next;
            prev.next = nextToMove;
        }
        head = dummy.next;
    }
}