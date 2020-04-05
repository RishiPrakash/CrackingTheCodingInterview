import java.util.HashMap;

class SpecialString { 
    public static void main(String[] args) 
	{ 
		String S =  "aaabcegfh";
		System.out.println(new SpecialString().find_sub(S)); 
	} 

	int find_sub(String s){ 
        int len = s.length(); 
        int k = 2;
        int lp = 0, rp = 0; 
		int ans = 0; 
        HashMap<String, Integer> freqMap = new HashMap<>();
		for (; rp < len; rp++){ 
            freqMap.put(s.charAt(rp)+"",freqMap.getOrDefault(s.charAt(rp)+"",0)+1);
			while (freqMap.get(s.charAt(rp)+"") > k) { 
                freqMap.put(s.charAt(rp)+"",freqMap.getOrDefault(s.charAt(rp)+"",0)-1);
                ans = Math.max(ans,rp - lp );
                while(lp<rp){
                   if((s.charAt(rp)+"").equals(s.charAt(lp)+"")){
                       lp++;
                       break;
                   } 
                   lp++; 
                }  
                
                
            } 
        }
        ans = Math.max(ans,rp - lp  );
        //ans = Math.max(ans,rp - lp + 1);  
		return ans; 
	} 
} 


