import java.util.HashMap;
import java.util.Stack;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String A = "nsutwcgpgpxonqbzsvpmjksjminhitsfenbhowixva";
        System.out.println("===>"+new RemoveDuplicates().solve(A));
    }

    public String solve(String A) {
        //mcnbntsu
        HashMap<String,Integer> freq = new HashMap<>();
        HashMap<String,Boolean> visited= new HashMap<>();
        for(int i=0;i<A.length();i++){
            String s = A.charAt(i)+"";
            freq.put(s, freq.getOrDefault(s,0)+1);
            visited.put(s,false);
        }
        Stack<String> stack = new Stack<>();
        for(int i=0;i<A.length();i++){
            String s = A.charAt(i)+"";
           if(stack.empty()){
               stack.push(s);
               visited.put(s,true);
           }else{
              // int top = (int)stack.peek().charAt(0);
               int newElement = (int)s.charAt(0);
               if(visited.get(s)){
                    //DoNothing;
               }
               else{
                 while(!stack.empty() && (int)stack.peek().charAt(0)>newElement){
                     if(freq.get(stack.peek())>0){
                         visited.put(stack.pop(),false);
                     }
                 }
                 stack.push(s);
                 visited.put(s,true);
               } 
           }
           freq.put(s, freq.get(s)-1);
        }
        String ans = "";
        while(!stack.empty()){
            ans = stack.pop()+ans;
        }
        return ans;
        
    }
}
