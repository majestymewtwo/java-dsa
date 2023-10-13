package com.javaudemy;

public class Queue {
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int length;
    public Queue(int value){
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }
    public void printQueue(){
        if(first == null){
            System.out.println("\nEmpty queue");
        }else{
            System.out.println("\nElements in queue are ");
            Node temp = first;
            while(temp != null){
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
        }
    }
    public void getFirst(){
        System.out.println("First " + first);
    }
    public void getLast(){
        System.out.println("Last " + last);
    }
    public void getLength(){
        System.out.println("Length " + length);
    }
    public void enqueue(int value){
        Node newNode = new Node(value);
        if(length == 0){
            first = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        length++;
    }
    public void dequeue(){
        if(length == 0) return;
        if(first == last){
            first = null;
            last = null;

        }else{
            Node temp = first;
            first = first.next;
            temp.next = null;
        }
        length--;
    }
}
