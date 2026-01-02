class MyLinkedList {
        Node head;
        Node tail;
  public  class Node{
    int data;
    Node next;
    Node prev;
    public Node(int data){
        this.data=data;
        this.prev=null;
        this.next=null;

    }
  }

    public MyLinkedList() {
    

        
    }
    
  public int get(int index) {
    Node current = head;
    int count = 0;
    while (current != null) {
        if (count == index) return current.data;
        count++;
        current = current.next;
    }
    return -1; // Index not found
}
    
    public void addAtHead(int val) {
        Node newNode=new Node(val);
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
        
    }
    
    public void addAtTail(int val) {
        Node newNode=new Node(val);
        if(tail==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }
    
public void addAtIndex(int index, int val) {
    if (index == 0) {
        addAtHead(val);
        return;
    }
    
    Node current = head;
    // Traverse to the node JUST BEFORE the insertion point
    for (int i = 0; i < index - 1; i++) {
        if (current == null) return; 
        current = current.next;
    }

    if (current == null) return; // Index out of bounds
    if (current == tail) {
        addAtTail(val);
        return;
    }

    // Insert newNode between current and current.next
    Node newNode = new Node(val);
    newNode.next = current.next;
    newNode.prev = current;
    current.next.prev = newNode;
    current.next = newNode;
}
    
  public void deleteAtIndex(int index) {
    if (head == null) return;

    Node current = head;
    for (int i = 0; i < index; i++) {
        current = current.next;
        if (current == null) return;
    }

    // Case 1: Deleting the Head
    if (current == head) {
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null; // List is now empty
    } 
    // Case 2: Deleting the Tail
    else if (current == tail) {
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
    } 
    // Case 3: Deleting a Middle Node
    else {
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }
}
}
