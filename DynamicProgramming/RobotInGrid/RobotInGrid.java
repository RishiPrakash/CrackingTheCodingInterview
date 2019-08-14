
import java.time.Duration;
import java.time.Instant;

class RobotInGrid{

static int rightBound = 10;
static int bottomBound =10;

static int reachTillEnd(int m, int n){

  if(m  == rightBound || n == bottomBound){
    return 0;
  }else if(m==rightBound-1 && n==bottomBound-1){
    return 1;
  }
  return reachTillEnd(m+1,n)+reachTillEnd(m,n+1);

}


static int reachTillEndWithDP(int m, int n,int[][] memo){
  if(m  == rightBound || n == bottomBound){
    return 0;
  }else if(m==rightBound-1 && n==bottomBound-1){
    return 1;
  }

  if(memo[m][n]==-1){
    memo[m][n] = reachTillEndWithDP(m+1,n,memo)+reachTillEndWithDP(m,n+1,memo);
  }
  return memo[m][n];

}

public static void main(String s[]){
  Instant start = Instant.now();
  System.out.println(reachTillEnd(0,0));
  Instant end = Instant.now();
  System.out.println("Time taken: "+ Duration.between(start, end).toMillis() +" milliseconds");


  Instant start_DP = Instant.now();
  int [][] memo = new int[rightBound][bottomBound];

  for(int i=0;i<memo.length;i++){
    for(int j=0;j<memo[i].length;j++){
      memo[i][j] = -1;
    }
  }


  System.out.println(reachTillEndWithDP(0,0,memo));
  Instant end_DP = Instant.now();
  System.out.println("Time taken: "+ Duration.between(start_DP, end_DP).toMillis() +" milliseconds");



}
}
