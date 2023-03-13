package com.JavaCal;
import java.util.*;
import java.io.Serializable;
import java.util.function.Consumer;

public class LList<T> implements Iterable<T>{
    private Node<T> head = null;
    private Node<T> tail = null;

    private int size = 0;

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    private static class Node<T>{
        private Node<T> nxt;
        String name;
        String email;
        String PhoneNumber;

        public Node(String name, String email, String PhoneNumber, Node<T> nxt){
            this.name = name;
            this.email = email;
            this.PhoneNumber = PhoneNumber;
            this.nxt = nxt;

        }



    }

    public class Contact{
        String name;
        String email;
        String PhoneNumber;

        public Contact(String name, String email,String PhoneNumber){
            this.name = name;
            this.email = email;
            this.PhoneNumber = PhoneNumber;
        }
    }


    public void addLast(String name, String email, String PhoneNumber){
        if(isEmpty()){
            head = tail = new Node<T>(name, email, PhoneNumber, null);
        }
        else{
            tail.nxt = new Node<T>(name,email,PhoneNumber, null);
            tail = tail.nxt;

        }
        size++;
    }
    public void addFirst(String name, String email, String PhoneNumber){
        if(isEmpty()){
            head = tail = new Node<T>(name, email, PhoneNumber, null);
        }
        else{
            Node<T> trav = head;
            head = new Node<T>(name,email,PhoneNumber, null);

        }
        size++;
    }

    public void add(String name, String email, String PhoneNumber){
        addLast(name, email, PhoneNumber);
    }

    public void EmailSearch(String email){
        Node<T> current = head;
        int index = 0;
        boolean empty = true;

        while(current != null) {
            if (isEmpty()) {
                System.out.println("List is empty!");
            }
            else {
                if (current.email.equals(email)) {

                    System.out.println("Email: " + email + " is found at index: " + index);

                    empty = false;
                }
            }



            current = current.nxt;
            index++;
        }
        if(empty){
            System.out.println("Email " + email + " is not found on the contact book");
        }

    }

    public void NameSearch(String name){
        Node<T> current = head;
        int index = 0;
        boolean empty = true;

        while(current != null) {
            if (isEmpty()) {
                System.out.println("List is empty!");
            }
            else {
                if (current.name.equals(name)) {

                    System.out.println("\nName: " + name + " ," + " Email: " + current.email + " ," + " Phone Number: " + current.PhoneNumber);
                    System.out.println("index: " + index);

                    empty = false;
                }
            }



            current = current.nxt;
            index++;
        }
        if(empty){
            System.out.println("Name " + name + " is not found on the contact book");
        }

    }
    public T removeFirst() {
        // Can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        // Extract the data at the head and move
        // the head pointer forwards one node
        String name = head.name;
        String PhoneNumber = head.PhoneNumber;
        String email = head.email;
        head = head.nxt;
        size--;

        // If the list is empty set the tail to null
        if (isEmpty()) tail = null;


        // Return the data that was at the first node we just removed
        return (T) new Contact(name, PhoneNumber, email);
    }
    public T removeLast() {
        // Can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        // Extract the data at the tail and move
        // the tail pointer backwards one node
        String name= tail.name;
        String PhoneNumber = tail.PhoneNumber;
        String email = tail.email;
        tail = tail.nxt;
        size--;

        // If the list is now empty set the head to null
        if (isEmpty()) head = null;

            // Do a memory clean of the node that was just removed
        else tail.nxt = null;

        // Return the data that was in the last node we just removed
        return (T) new Contact(name, email, PhoneNumber);
    }
    public T Delete(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException(Integer.toString(index)); //if out of bounds, throw an exception
        }
        if(index == 0){
            return removeFirst();//if the index is the head, add the element as the head
        }
        else{ //otherwise add the new data at the given index
            Node<T> node = getNode(index-1);
            return removeLast();
        }

    }



    public boolean isEmpty(){
        return (size == 0);
    }


    private Node<T> getNode(int index)
    {
        Node<T> node = head;
        for(int i = 0; i < index && node != null; i++)
        {
            node = node.nxt;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("****************************\n");
        LList.Node<T> trav = head;
        int i = 1;
        int index = 0;
        while (trav != null) {
            sb.append(i + "\nName: "+trav.name + "\nEmail: "  + trav.email + "\nPhone Number: " + trav.PhoneNumber + "\nIndex: " + index);
            if(trav.nxt != null){
                sb.append("\n");
            }
            trav = trav.nxt;
            i++;
            index++;
        }
        sb.append("\n****************************");
        return sb.toString();
    }
}
