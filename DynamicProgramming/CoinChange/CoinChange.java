class CoinChange{

int coinChangePossib(int[] S,int i, int N ){
  if(N==0)return 1;
  else if(N<0)return 0;
  else if(i<0)return 0;
  else{
    return coinChangePossib(S,i-1,N) +  coinChangePossib(S,i,N-S[i]);
  }
}

public static void main(String[] s){
  System.out.println(new CoinChange().coinChangePossib(new int[]{1,3,5,7},3,8));
}


}
