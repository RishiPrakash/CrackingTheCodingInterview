import java.util.*;
class WordBreak{

static Set<String> dictionary = new HashSet<String>();
  public static void main(String []args){

        // array of strings to be added in dictionary set.
        String temp_dictionary[] = {"mobile","samsung","sam","sung",
                            "man","mango","icecream","and",
                            "go","i","like","ice","cream"};

        // loop to add all strings in dictionary set
        for (String temp :temp_dictionary){
            dictionary.add(temp);
        }

        // sample input cases
        System.out.println(wordBreak("ilikesamsung"));
        System.out.println(wordBreak("iiiiiiii"));
        System.out.println(wordBreak(""));
        System.out.println(wordBreak("ilikelikeimangoiii"));
        System.out.println(wordBreak("samsungandmango"));
        System.out.println(wordBreak("samsungandmangok"));
  }
static Map<String,Boolean> memo = new HashMap<>();
static boolean wordBreak(String str){
  if(str.length() == 0)return true;
  for(int i=1;i<=str.length();i++){
     if(memo.containsKey(str))return memo.get(str);
     else{

       boolean result =  dictionary.contains(str.substring(0,i))
       && wordBreak(
                    str.substring(i,str.length())
                   );
       if(result){
         memo.put(str,true);
        return true;
       }
     }
  }
memo.put(str,false);
return false;
}





}
