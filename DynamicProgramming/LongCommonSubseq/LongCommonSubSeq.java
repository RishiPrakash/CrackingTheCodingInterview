import java.time.Duration;
import java.time.Instant;

class LongCommonSubSeq{
  static StringBuffer _commonSubSeq = new StringBuffer();

  static int lenOfCommonSubSeq(char[] a, char[] b,int lastIndexA, int lastIndexB){

    if(lastIndexA ==-1 || lastIndexB==-1)return 0;
    else if(a[lastIndexA] == b[lastIndexB])
    {return 1+lenOfCommonSubSeq(a,b,lastIndexA-1,lastIndexB-1);}
    else{return Math.max(lenOfCommonSubSeq(a,b,lastIndexA-1,lastIndexB),lenOfCommonSubSeq(a,b,lastIndexA,lastIndexB-1));}

}


static int lenOfCommonSubSeqWithDP(char[] a, char[] b,int lastIndexA, int lastIndexB,int[][] memo){

try{
  if(lastIndexA ==-1 || lastIndexB==-1)return 0;
  else if(a[lastIndexA] == b[lastIndexB]){
    _commonSubSeq.append(b[lastIndexB]);
    if(memo[lastIndexA][lastIndexB]==0){
      memo[lastIndexA][lastIndexB] = 1+lenOfCommonSubSeqWithDP(a,b,lastIndexA-1,lastIndexB-1,memo);
    }
    return memo[lastIndexA][lastIndexB];
  }
  else{
    if(memo[lastIndexA-1][lastIndexB]==0){

      memo[lastIndexA-1][lastIndexB] = lenOfCommonSubSeqWithDP(a,b,lastIndexA-1,lastIndexB,memo);

    }
    if(memo[lastIndexA][lastIndexB-1]==0){
      memo[lastIndexA][lastIndexB-1] = lenOfCommonSubSeqWithDP(a,b,lastIndexA,lastIndexB-1,memo);
    }
    memo[lastIndexA][lastIndexB] = Math.max(memo[lastIndexA][lastIndexB-1],memo[lastIndexA-1][lastIndexB]);
  }
  return memo[lastIndexA][lastIndexB] ;

}catch(Exception e){
  return 0;
}

}

public static void main(String[] s){
  Instant start = Instant.now();
  char[] a = new char[]{'A','B','C','D','G','H'};
  char[] b = new char[]{'A','E','D','F','H','R'};

  System.out.println("Length of Common subSeq==="+lenOfCommonSubSeq(a,b,5,5));
  Instant end = Instant.now();
  System.out.println("Time taken: "+ Duration.between(start, end).toMillis() +" milliseconds");

  Instant start_Dyan = Instant.now();
  int[][] memo = new int[6][6];
  for(int i=0;i<memo.length;i++){
    for(int j =0;j<memo[i].length;j++){
      memo[i][j] = 0;
    }
  }
lenOfCommonSubSeqWithDP(a,b,5,5,memo);


System.out.println(_commonSubSeq.toString()+"<--Length of it-->"+_commonSubSeq.length());


Instant end_Dyan = Instant.now();
System.out.println("Time taken: "+ Duration.between(start_Dyan, end_Dyan).toMillis() +" milliseconds");

}




}
