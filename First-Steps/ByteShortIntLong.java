public class ByteShortIntLong {
   
   public static void main (String[] args){
   
      // each data type takes up a certain amount of space within the memory, which is called the *width* of the type
   
      //******** BYTES ********//--------------
      byte byteMin= Byte.MIN_VALUE;
      byte byteMax= Byte.MAX_VALUE;
      
      System.out.println("Byte Minimun Value: " + byteMin);
      System.out.println("Byte Maximum Value: " + byteMax);
      
      // Width: 8 (1 byte = 8 bits)
      
      
      System.out.println();
      //******** SHORTS ********//--------------
      short shortMin= Short.MIN_VALUE;
      short shortMax= Short.MAX_VALUE;
      
      System.out.println("Short Minimun Value: " + shortMin);
      System.out.println("Short Maximum Value: " + shortMax);
      
      //Width: 16 (1 short = 16 bits)
      
 
      System.out.println();
      //******** INTS ********//--------------
      int myInt= 10000;
      
      int intMin= Integer.MIN_VALUE;
      int intMax= Integer.MAX_VALUE;
      
      // Note: Integer used above is a Wrapper class, which gives us ways to do stuff to ints
      
      System.out.println("Integer Minimun Value: " + intMin);
      System.out.println("integer Maximun Value: " + intMax);
      System.out.println("Busted Integer Max Value: " + (intMax +1));
      // output: -2147483648 ---> Called OVERFLOW 
      // Conclusion: if the number assigned does not fit the parameters set for integers, the computer will automatically change the number so that it fits into a ints range
      System.out.println("Busted Integer Max Value: " + (intMax +1));
      // output: 2147483647 ---> Called UNDERFLOW
      
      // int maxIntTest= 2147483648;
      // ^^^ will result in an error b/c it is a literal expression, and so the editor will catch it.
      
      int intTest= 2_147_483_647;
      System.out.println(intTest);
      // INTERESTING: When printing, it will not print the underscores, this is a way to make it easier for human readers
      
      //Width: 32 (1 int = 32 bits)
      
      
      
      System.out.println();
      //******** LONGS ********//--------------
      long myLong= 100L;
      // don't forget to add on a captial 'L' on the end of the number right before the semicolon
      
      long longMin= Long.MIN_VALUE;
      long longMax= Long.MAX_VALUE;
      
      System.out.println("Long Minimun Value: " + longMin);
      System.out.println("Long Maximum Value: " + longMax);
      
      long bigLiteralLong = 2_147_483_647_234;
      /* ^^^^ will bring an error saying:
      
      "error: integer number too large"
      
      Conclusion: without the 'L' on the end of a long, the computer recognizes the number as an int!
      
      //Width: 64 (1 long = 64 bits)

   }
}