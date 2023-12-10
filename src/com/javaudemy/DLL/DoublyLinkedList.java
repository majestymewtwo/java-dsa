package com.javaudemy.DLL;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;
    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
    public void getHead(){
        System.out.println("Head " + head.value);
    }
    public void getTail(){
        System.out.println("Tail " + tail.value);
    }
    public void getLength(){
        System.out.println("Length " + length);
    }
    public void printList(){
        Node temp = head;
        if(length == 0){
            System.out.println("Empty list");
            return;
        }
        System.out.println("Elements in the list are");
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;

    }
    public void removeLast(){
        if(length == 0) return;
        if(length == 1){
            head = null;
            tail = null;
        }else{
            Node prev = tail.prev;
            prev.next = null;
            tail = prev;
        }
        length--;
    }
    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }
    public void removeFirst(){
        if(length == 0) return;
        if(length == 1){
            head = null;
            tail = null;
        }else{
            Node temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
    }
    public Node get(int index){
        if(index < 0 || index >= length) return null;
        Node temp;
        if(index < length/2){
            temp = head;
            for(int i=0; i<index; i++)
                temp = temp.next;
        }else{
            temp = tail;
            for(int i = length - 1; i > index; i--)
                temp = temp.prev;
        }
        return temp;
    }
    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }
    public boolean insert(int index, int value){
        if(index<0 || index>=length) return false;
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length-1){
            append(value);
            return true;
        }
        Node before = get(index - 1);
        Node newNode = new Node(value);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }
    public void remove(int index){
        if(index < 0 || index >= length) return;
        if(index == 0){
            removeFirst();
        }
        if(index == length-1){
            removeLast();
        }
        Node temp = get(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        length--;
    }
    public void swapFirstLast(){
        if(head == tail) return;
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }
    public void reverse(){
        if (head == null || head == tail) return;
        Node left = head, right = tail;
        while (left != right && left.prev != right) {
            int temp = left.value;
            left.value = right.value;
            right.value = temp;
            left = left.next;
            right = right.prev;
        }
    }
    public boolean isPalindrome(){
        if(head == tail) return true;
        Node left = head, right = tail;
        for(int i=0; i<length/2; i++){
            if(left.value != right.value)
                return false;
            left = left.next;
            right = right.prev;
        }
        return true;
    }
    public void swapPairs(){
        if(length <= 1) return;
        Node temp = head;
        while(temp != null && temp.next != null){
            int value = temp.value;
            temp.value = temp.next.value;
            temp.next.value = value;
            temp = temp.next.next;
        }
    }
}