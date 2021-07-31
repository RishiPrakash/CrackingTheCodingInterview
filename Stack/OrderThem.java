import java.util.Stack;

public class TruckRank {
    public static void main(String[] args) {
        int[] A={5,3,1,4,6,3};
        System.out.print(solve(A));
    }
    private static int solve(int[] A){
        int N=A.length;
        int[] B=new int[N];
        Stack<Integer> C=new Stack<>();

        for(int i=0;i<N;i++){
            if(A[i]==1)
                B[0]=A[i];
            else if(A[i]==N)
                C.push(A[i]);
        }

        int j=0;
        for(int i=0;i<N;i++){
            if(A[i]!=1 && A[i]!=N){
                if(B[j]+1==A[i])
                    B[++j]=A[i];
                else if(C.peek()==A[i]+1)
                    C.push(A[i]);
                else
                    return 0;
            }
        }
        return 1;
    }
}
