package com.javaudemy;

public class Stack {
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    private Node top;
    private int height;
    public Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }
    public void printStack(){
        if(top == null){
            System.out.println("\nEmpty stack");
        }else{
            System.out.println("\nElements in stack are ");
            Node temp = top;
            while(temp != null){
                System.out.println(temp.value);
                temp = temp.next;
            }
        }
    }
    public void getTop(){
        System.out.println("Top " + top.value);
    }
    public void getHeight(){
        System.out.println("Height " + height);
    }
    public void push(int value){
        Node newNode = new Node(value);
        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
        height++;
    }
    public void pop(){
        if(top == null) return;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
    }
}
