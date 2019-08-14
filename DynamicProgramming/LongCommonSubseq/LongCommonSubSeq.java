class LongCommonSubSeq{

  static int lenOfCommonSubSeq(char[] a, char[] b,int lastIndexA, int lastIndexB){

    if(lastIndexA ==0 || lastIndexB==0)return 0;
    else if(a[lastIndexA] == b[lastIndexB])
    {return 1+lenOfCommonSubSeq(a,b,lastIndexA-1,lastIndexB-1);}
    else{return Math.max(lenOfCommonSubSeq(a,b,lastIndexA-1,lastIndexB),lenOfCommonSubSeq(a,b,lastIndexA,lastIndexB-1));}

}

public static void main(String[] s){
  char[] a = new char[]{'A','B','C','D','G','H'};
  char[] b = new char[]{'A','E','D','F','H','R'};

  System.out.println("Length of Common subSeq==="+lenOfCommonSubSeq(a,b,5,5));


}




}
