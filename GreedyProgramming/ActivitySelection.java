import java.util.*;
class ActivitySelection{

public static void main(String[] s){

    List<Activity> allActivities = new ArrayList<>();
    allActivities.add( new Activity(3,8));
    allActivities.add( new Activity(5,9));
    allActivities.add( new Activity(6,10));
    allActivities.add( new Activity(8,11));
    allActivities.add( new Activity(8,12));
    allActivities.add( new Activity(2,13));
    allActivities.add( new Activity(12,14));
    allActivities.add(new Activity(1,4));
    allActivities.add( new Activity(3,5));
    allActivities.add( new Activity(0,6));
    allActivities.add( new Activity(5,7));
    for(Activity a:allActivities){
      System.out.print("("+a.start+","+a.end+") ");
    }
    Collections.sort(allActivities);
    System.out.println("After sorting is done..");

    for(Activity a:allActivities){
      System.out.print("("+a.start+","+a.end+") ");
    }

    System.out.println("Final Optimum List:");
    new ActivitySelection().selectOptimActi(allActivities);
    
    for(Activity a:optimList){
      System.out.print("("+a.start+","+a.end+") ");
    }

}
static List<Activity> optimList = new ArrayList<>();
public void selectOptimActi(List<Activity> allActivities){
  optimList.add(allActivities.get(0));
  for(int i = 1;i<allActivities.size();i++){
    if(allActivities.get(i).start>optimList.get(optimList.size()-1).end){
      optimList.add(allActivities.get(i));
    }
  }
}

}




class Activity implements Comparable<Activity>{
  int start;
  int end;
  Activity(int start, int end){
    this.start = start;
    this.end = end;
  }
  public int compareTo(Activity activity){
    if(this.end<activity.end)return -1;
    else if(this.end>activity.end)return 1;
    else return 0;
}
}
