import java.util.Arrays;
import java.util.HashMap;

class PowerofStrigs{
    public static void main(String[] args) {
        String[] A = {"akash","scaler","problem"};
        String B = "rishabh";
        System.out.println(new PowerofStrigs().mad(A, B));
    }
    int mad(String[] A, String B){
        HashMap<String,Integer> pow = new HashMap<>();
        for(int i=0;i<B.length();i++){
            pow.put(B.charAt(i)+"",pow.getOrDefault(B.charAt(i)+"",0)+1);
        }
        int[] madArr = new int[A.length];
        for(int i=0;i<A.length;i++){
            madArr[i] = computePower(A[i], pow);
        }
        Arrays.sort(madArr);
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<madArr.length-1;i++){
            if(madArr[i+1] - madArr[i] <diff){
                diff = madArr[i+1] - madArr[i];
            }
        }
        return diff;
        
    }

    int computePower(String S, HashMap<String,Integer> powerRepo){
        int totalPower = 0;
        for(int i=0;i<S.length();i++){
            totalPower+=powerRepo.getOrDefault(S.charAt(i)+"",0);
        }
        return totalPower;
    }
}