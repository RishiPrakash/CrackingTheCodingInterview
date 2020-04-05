
 
  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
 
public class ReorderList {

public static void main(String[] args) {
    int[] A = {99,83};//{90,94,25,51,45,29,55,63,48,27};
    ListNode head = new ListNode(A[0]);
    ListNode pointer = head;

    for(int i=1;i<A.length;i++){
        ListNode newElement = new ListNode(A[i]);
        pointer.next  =newElement;
        pointer = pointer.next;
    }

    ListNode res = new ReorderList().reorderList(head);
    while(res!=null){
        System.out.print(res.val+"->");
        res = res.next;
    }

}
    public ListNode reorderList(ListNode A) {
        if(A.next==null)return A;
        //90 -> 94 -> 25 -> 51 -> 45 -> 29 -> 55 -> 63 -> 48 -> 27
        ListNode start = A;
        int length = 1;
        while(start.next!=null){
            start = start.next;
            length++;
        }
        int middle = length/2;
        int firstPartLength = length-middle;
        //90 -> 94 -> 25 -> 51 -> 45 -> 29 -> 55 -> 63 -> 48 -> 27
        //90 -> 94 -> 25 -> 51 -> 45 -> 
        //27->48->63->55->29

        ListNode P1 = A;
        ListNode breakP1 = null;
        ListNode P2 = A;
        while(firstPartLength>0){
            if(P2==null){
                P2=A;
            }else{
                P2 = P2.next;  
            }
            if(firstPartLength==2){
                breakP1 = P2;
            }
            firstPartLength--;
        }
        if(breakP1!=null){
            breakP1.next = null;
        }else{
            P1.next = null;
        }
        if(P2.next!=null){
            reverse(P2,start,A);    
            P2 = start;
        }
        ListNode nextP1 = null;
        if(P1!=null){
           nextP1 =  P1.next;
        }
        ListNode nextP2 = null;
        if(P2!=null){
           nextP2 =  P2.next;
        }
        //90 -> 94 -> 25 -> 51 -> 45 -> 
        //27->48->63->55->29
        while(P1!=null && P2!=null){
            P1.next = P2;
            P1 = nextP1;
            if(nextP1!=null){
                nextP1 = nextP1.next;    
            }
            P2.next =P1;
            P2 = nextP2;
            if(nextP2!=null){
                nextP2 = nextP2.next;
            }
             
        }
        return A;
    }
    void reverse(ListNode start,ListNode end, ListNode A){
        ListNode curr = start;
        ListNode prev = null;
        ListNode further = curr.next;
        while(curr!=null && curr!=end){
            curr.next = prev;
            prev = curr;
            curr = further;
            further = further.next;
        }
             curr.next = prev;
             prev = curr;
    }
}
