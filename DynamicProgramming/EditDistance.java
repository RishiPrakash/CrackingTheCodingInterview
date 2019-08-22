class EditDistance{

static int minDis(char[] a,char[] b,int lengthA, int lengthB){

	if(lengthA==0)return lengthB;
	if(lengthB==0)return lengthA;
	
	
	
	else if(a[lengthA-1] == b[lengthB-1]) return minDis(a,b, lengthA-1,lengthB-1);
	else{
		return 1+ Math.min(minDis(a,b,lengthA,lengthB-1),Math.min (minDis(a,b,lengthA-1,lengthB),minDis(a,b,lengthA-1,lengthB-1)));
	} 

}

public static void main(String[] s){
System.out.println(minDis("un".toCharArray(),"atr".toCharArray(),"un".length(),"atr".length()));


}


}


