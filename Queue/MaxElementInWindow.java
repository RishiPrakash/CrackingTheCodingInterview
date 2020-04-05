import java.util.Deque;
import java.util.LinkedList;

class MaxElementInWindow{
    public static void main(String[] args) {
        int[] A = {2,5,-1,7,-3,-1,-2,-6,-4};
        int[] ans = new MaxElementInWindow().maxElementinWindow(A, 4);
        for(int a:ans){
            System.out.print(a+" ");
        }
        System.out.println("min Element starts..");
        int[] ans_2 = new MaxElementInWindow().minElementinWindow(A, 4);
        for(int a:ans_2){
            System.out.print(a+" ");
        }
  }

int[] maxElementinWindow(int[] A, int K){
    int i=0;
    int j=0;
    int[] ans = new int[A.length+1-K];
    Deque<Integer> deque = new LinkedList<>();
    while(j<A.length){
        if((j-i)>=K){
            ans[i] = A[deque.peekFirst()];
            i++;
            if(deque.peekFirst()<i){
                deque.pollFirst();
            }
        }
        while(deque.size()>0 && A[deque.peekLast()]<A[j]){
            deque.pollLast();
        }
        deque.addLast(j);
        j++;
    }
    if((j-i)>=K){
        ans[i] = A[deque.peekFirst()];
        i++;
    }
    return ans;
}
int[] minElementinWindow(int[] A, int K){
    int i=0;
    int j=0;
    int[] ans = new int[A.length+1-K];
    Deque<Integer> deque = new LinkedList<>();
    while(j<A.length){
        if((j-i)>=K){
            ans[i] = A[deque.peekFirst()];
            i++;
            if(deque.peekFirst()<i){
                deque.pollFirst();
            }
        }
        while(deque.size()>0 && A[deque.peekLast()]>A[j]){
            deque.pollLast();
        }
        deque.addLast(j);
        j++;
    }
    if((j-i)>=K){
        ans[i] = A[deque.peekFirst()];
        i++;
    }
    return ans;
}


}