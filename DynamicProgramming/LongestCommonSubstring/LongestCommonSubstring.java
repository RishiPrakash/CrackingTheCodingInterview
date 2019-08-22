class LongestCommonSubstring{

int longestCommSubStr(char[] a,char[] b,int lengA, int lengB, int[][] memo){

for(int i=0;i<=lengA;i++){
  for(int j=0;j<=lengB;j++){

    if(i==0 || j==0)memo[i][j];
    else if(a[i-1] == b[j-1]) memo[i][j] = 1 + memo[i-1][j-1];
    else memo[i][j] = 0;

  }
}


for(int i=0;i<=lengA;i++){
  for(int j=0;j<=lengB;j++){

    System.out.print(memo[i][j]+" ");

  }
  System.out.println("");
}



}

public static void main(String[] s){

  char[] a = new char[]{'A','B','C','D','G','H'};
  char[] b = new char[]{'A','E','D','F','H','R'};


  int[][] memo = new int[6][6];
  for(int i=0;i<memo.length;i++){
    for(int j =0;j<memo[i].length;j++){
      memo[i][j] = 0;
    }
  }
longestCommSubStr(a,b,6,6,memo);
}


}
