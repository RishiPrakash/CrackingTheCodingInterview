import java.util.Stack;

class NearestSmallerRight{

    public static void main(String[] args) {
        int[] A = {90,58,69,70,82,100,13,57,47,18};
        int[] res = new NearestSmallerRight().nearestSmallerRight(A);
        for(int r:res){
            System.out.print(r+" ");
        }
    }


public int[] nearestSmallerRight(int[] A){
    int[] res = new int[A.length];
    int j=0;
    for(int a:A){
        res[j]=-1;
        j++;
    }
    Stack<Element> stack = new Stack<>();
    for(int i=A.length-1;i>=0;i--){
        if(stack.empty()){
            stack.push(new Element(i,A[i]));
        }else{
            while(!stack.empty() && A[i]<stack.peek().value){
                Element temp = stack.pop();
                res[temp.index] = A[i];
            }
            stack.push(new Element(i,A[i]));
        }
    }
    return res;
}
public class Element{
    int index;
    int value;
    public Element(int index, int value){
        this.index = index;
        this.value = value;
    }
}


}