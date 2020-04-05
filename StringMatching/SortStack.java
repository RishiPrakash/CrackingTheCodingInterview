import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        int[] A = {66, 96, 43, 28, 14, 1, 41, 76, 70, 81, 22, 11, 42, 78, 4, 88, 70, 43, 90, 6, 12};
        int[] B = new SortStack().solve(A);
        for(int b:B){
            System.out.print(b+" ");
        }
    }

    public int[] solve(int[] A) {//5,17,100,11
        Stack<Integer> stack = new Stack<>();
        for(int a:A){
            stack.push(a);//[5,17,100,11]
        }
        Stack<Integer> auxStack = new Stack<>();
        while(!stack.empty()){
            auxStack.push(stack.pop());//[11,100,17,5]
        }
        while(!auxStack.empty()){
            int topElement = auxStack.pop();//5,17,100,11
            if(stack.empty()){
                stack.push(topElement);//5
            }else{
                while(stack.peek()>topElement){
                    auxStack.push(stack.pop());
                }
                stack.push(topElement);//5,17,100
            }
        }
        int i=A.length-1;
        while(!stack.empty()){
            A[i] = stack.pop();
            i--;
        }
        return A;
    }
}
