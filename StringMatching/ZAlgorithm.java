class ZAlgorithm {

    public int[] ZAlgo(char[] text){
        int[] Z = new int[text.length];
        int L = 0;
        int R = 0;
        for(int k=1;k<text.length;k++){
              if(k>R){
                L=R=k;
                while(R<text.length && (int)text[R] == (int)text[(R-L)]){
                    R++;
                } 
                Z[k] = R-L; 
                R--;
              }
              else{
                  int i = k-L;
                  if(((int)Z[i]+k)>=R){
                    L=k;
                    while(R<text.length && (int)text[R] == (int)text[(R-L)]){
                        R++;
                    } 
                    Z[k] = R-L; 
                    R--;
                  }else{
                    Z[k] = Z[k];
                  }
                }
        }
        return Z;
}
public static void main(String[] args) {
    char[] arr = {'a','b','a','x','a','b','a','b'};
    int[] Z = new ZAlgorithm().ZAlgo(arr);
    for(int c:Z){
        System.out.print(c+" ");
    }
}
}