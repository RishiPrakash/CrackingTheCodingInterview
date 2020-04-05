import java.util.Stack;

class NearestSmallerLeft{

    public static void main(String[] args) {
        int[] A = {2,1,5,6,2,3};
        int[] res = new NearestSmallerLeft().nearestSmallerLeft(A);
        for(int r:res){
            System.out.print(r+" ");
        }
    }


public int[] nearestSmallerLeft(int[] A){
    int[] res = new int[A.length];
    int j=0;
    for(int a:A){
        res[j]=-1;
        j++;
    }
    Stack<Element> stack = new Stack<>();
    for(int i=0;i<A.length-1;i++){
        if(stack.empty()){
            stack.push(new Element(i,A[i]));
        }else{
            while(!stack.empty() && A[i]<stack.peek().value){
                Element temp = stack.pop();
                res[temp.index] = i;
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