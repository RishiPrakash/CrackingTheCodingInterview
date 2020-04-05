class TripletBoxes{

int triplets(int[] A, int[] B){
    int total = 0;
    for(int i=0;i<A.length;i++){
        for(int j=i+1;j<A.length;j++){
            for(int k=j+1;k<A.length;k++){
                if((A[i]+A[j]+A[k])>(B[i]+B[j]+B[k])){
                    total++;
                }
            }
        }
    }
    return total;
}
public static void main(String[] args) {
    int[] A = {2,1,10,8,2};
    int[] B = {1,5,6,3,13};
    System.out.println(new TripletBoxes().triplets(A, B));
}

}