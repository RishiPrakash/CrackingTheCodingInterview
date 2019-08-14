import java.time.Duration;
import java.time.Instant;



class TripleStep{

  static int findWays(int n){

    if(n==0)return 1;
    if(n==1)return 1;
    if(n==2)return 2;

    return findWays(n-1)+findWays(n-2)+findWays(n-3);

  }

static int findWaysWithMemo(int n, int[] memo){
if(memo[n]==-1){
    memo[n] = findWaysWithMemo(n-1,memo) + findWaysWithMemo(n-2,memo) + findWaysWithMemo(n-3,memo);
}
return memo[n];
}


  public static void main(String s[]){
    Instant start = Instant.now();
    System.out.println(findWays(100));
    Instant end = Instant.now();
    System.out.println("Time taken: "+ Duration.between(start, end).toMillis() +" milliseconds");

    Instant start_Dyn = Instant.now();
    int[] _memo = new int[101];
    _memo[0]=1;
    _memo[1]=1;
    _memo[2]=2;
    for(int i=3;i<_memo.length;i++){
      _memo[i]=-1;
    }
    System.out.println(findWaysWithMemo(100,_memo));
    Instant end_Dyn = Instant.now();
    System.out.println("Time taken with memo: "+ Duration.between(start_Dyn, end_Dyn).toMillis() +" milliseconds");


  }



}
