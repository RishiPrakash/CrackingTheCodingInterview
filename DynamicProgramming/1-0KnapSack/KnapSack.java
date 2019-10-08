class KnapSack{
static int[][] memo = null;

  public static void main(String[] s){
    int val[] = new int[]{60, 100, 120};//value of each item
    int wt[] = new int[]{10, 20, 30}; //weight of each item
    int  W = 50;//total weight possible
    int n = val.length-1;//number of items
    memo = new int[W+1][n+2];
    for(int i =0;i<memo.length;i++){
      for(int j=0;j<memo[i].length;j++){
        memo[i][j] = -1;
      }
    }

    System.out.println(knapSack(W, wt, val, n));
  }


 static int knapSack(int W, int[] wt, int[] val, int n){
  if(W == 0 || n ==0 )return 0;
  if(wt[n] > W) return knapSack(W, wt, val, n - 1);
  else{
    if(memo[W][n]>-1){
      return memo[W][n];
    }else{
        memo[W][n] =  Math.max(val[n] +  knapSack(W-wt[n] , wt, val, n-1),knapSack(W, wt, val, n - 1));
        return memo[W][n];

    }

  }
}



}
