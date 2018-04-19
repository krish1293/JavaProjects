import com.sun.corba.se.impl.orbutil.graph.Node;

public class LinkedList2{
    static Node head;

    static class Node{
        Node next;
        int data;

        public Node(int d){
            next = null;
            data = d;
        }
    }

    void append(int newData){
        if(head == null){
            head = new Node(newData);
            
        }
        else{
            Node newNode = new Node(newData);
            newNode.next = null;
            
            Node last = head;
            while(last.next != null){
                last = last.next;
            }
            last.next = newNode;
        }
    } // append

    void push(int newData){
        
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode; 
        
    } // push

    void detectLoop(Node newNode){

    } // detectloop


}