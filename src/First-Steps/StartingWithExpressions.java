public class StartingWithExpressions{
   
   public static void main(String[] args){
      
      int myFirstNum= 35;
      int mySecondNum= 12;
      int myThirdNum= 6;
      int myTotal= myFirstNum + mySecondNum + myThirdNum;
      
      System.out.println(myTotal);
      
      myThirdNum= myFirstNum * 2;
      myTotal= myFirstNum + mySecondNum + myThirdNum;
      System.out.println(myTotal);
      
      int myLastNum= myTotal - 1000;
      
      System.out.println(myLastNum);
   }
}