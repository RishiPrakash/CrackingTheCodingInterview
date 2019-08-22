class EditDistance{

static int minDis(char[] a,char[] b,int lengthA, int lengthB){

	if(lengthA==0)return lengthB;
	if(lengthB==0)return lengthA;



	else if(a[lengthA-1] == b[lengthB-1]) return minDis(a,b, lengthA-1,lengthB-1);
	else{
		return 1+ Math.min(minDis(a,b,lengthA,lengthB-1),Math.min (minDis(a,b,lengthA-1,lengthB),minDis(a,b,lengthA-1,lengthB-1)));
	}

}

static int minDisDP(char[] a,char[] b,int[][] memo){
int finalVal = 0;
	for(int i=0;i<=a.length;i++){
		for(int j=0;j<=b.length;j++){
			if(i==0)memo[i][j] = j;
			else if(j==0)memo[i][j] = i;
			else if(a[i-1]==b[j-1]){
				memo[i][j] = memo[i-1][j-1];
			}else{
				memo[i][j] = 1 + Math.min(memo[i][j-1],Math.min(memo[i-1][j],memo[i-1][j-1]));
			}
		}

	}

return memo[a.length][b.length];
}



public static void main(String[] s){
System.out.println(minDis("un".toCharArray(),"atr".toCharArray(),"un".length(),"atr".length()));
System.out.println(minDisDP("un".toCharArray(),"atr".toCharArray(),new int["un".length()+1]["atr".length()+1]));


}


}
