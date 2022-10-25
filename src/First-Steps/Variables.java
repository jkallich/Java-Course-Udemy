public class Variables{
   public static void main(String[] args){
      int myFirstNum= 5; 
      // this is a delcaration statement, where I declared the variable and also (optionally) initialized it
      System.out.println(myFirstNum);
      
      myFirstNum= 10 + 5;
      // you can also add operators (+, -, *, /, =, etc) and combine numbers
      System.out.println(myFirstNum);
      
      myFirstNum= (10+5) + (2*10); 
      // can have more complex operations
      System.out.println(myFirstNum);
   }
}