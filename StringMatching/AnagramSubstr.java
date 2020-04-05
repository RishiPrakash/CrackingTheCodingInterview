import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnagramSubstr {
    //Anagram Substring Search
    // Given a string A and a string B. Find and return the starting indices of 
    // the substrings of A which matches any of the anagrams of B.

    public static void main(String[] args) {
        String A = "llud";
        String B = "l";
        ArrayList<Integer> ans = new AnagramSubstr().solve(A, B);
        for(int a:ans){
            System.out.print(a+" ");
        }
    }
    public ArrayList<Integer> solve(String A, String B) {
        if(A.length()<B.length()){return new ArrayList<Integer>();}
        int i=0;
        int j=B.length()-1;
        ArrayList<Integer> ans = new ArrayList<>();
        String prefix = A.substring(i,j+1);
        int BHash = hash(B);
        int rollingHash  = hash(prefix);    
        
        if(rollingHash==BHash){
            if(equals_String(prefix,B)){
                ans.add(j);
            }
        }
        while(j<A.length()-1){
            j++;
             rollingHash = rollingHash-(int)A.charAt(i)+(int)A.charAt(j);
            if(rollingHash==BHash){
                 prefix = A.substring(i,j+1);
                 if(equals_String(prefix,B)){
                    ans.add(j);
                }
            }
        }
        return ans;
        
        
    }
    public int hash(String A){
        int hashVal = 0;
        for(int i=0;i<A.length();i++){
            hashVal+= (int)A.charAt(i);
        }
        return hashVal;
    }

    public boolean equals_String(String A,String B){
        HashMap<String,Integer> AMap = new HashMap<>();
        for(int i=0;i<A.length();i++){
            AMap.put(A.charAt(i)+"",AMap.getOrDefault(A.charAt(i)+"",0)+1);
        }
        
        HashMap<String,Integer> BMap = new HashMap<>();
        for(int i=0;i<B.length();i++){
            BMap.put(B.charAt(i)+"",BMap.getOrDefault(B.charAt(i)+"",0)+1);
        }
        for(Map.Entry e:AMap.entrySet()){
            String key = (String)e.getKey();
            int value = (int)e.getValue();
            if(!BMap.containsKey(key)){
                return false;
            }else{
                int b_value = (int)BMap.get(key);
                if(b_value!=value){return false;}
                else{BMap.put(key,-1);}
            }
        }
        for(Map.Entry e:BMap.entrySet()){
            if((int)e.getValue()!=-1)return false;        
        }
        return true;
    }
}
