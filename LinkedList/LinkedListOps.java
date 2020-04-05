class LinkedListOps{

    static Node head = null;
    //head->20->null
    public static void insert_node(int position, int value) {
        Node newNode = new Node(value,null);
        Node currentNode = head;
        while(position>2){
            if(currentNode!=null){
                currentNode = currentNode.next;
            }
            position--;
        }
        if(currentNode!=null){
            Node nextNode =currentNode.next;
            newNode.next = nextNode;
            currentNode.next = newNode;
        }else{
            head = newNode;
        }
    }

    public static void delete_node(int position) {
        Node currentNode = head;
        if(position==1){
            head = head.next;
            return;
        }
        while(position>2){
            if(currentNode!=null){
                currentNode = currentNode.next;    
            }
        position--;
            
        }
        if(currentNode!=null && currentNode.next!=null ){
            currentNode.next = currentNode.next.next;
        }
        
    }

    public static void print_ll() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = head;
        while(currentNode!=null){
            sb.append(currentNode.val+" ");
            currentNode = currentNode.next;
        }
        System.out.println(sb.toString());
    }

static class Node{
    int val;
    Node next;
    Node(int value, Node next){
        this.val = value;
        this.next = next;
    }
}

public static void main(String[] args) {
    insert_node(1, 20);
    print_ll();
    insert_node(2, 21);
    print_ll();
    delete_node(1);
    print_ll();
}

}