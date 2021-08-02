/*
3A. Write a Java program to read two integers a andb. Compute a/b and print,
when b is not zero. Raise an exception when b is equal to zero.
*/

import java.util.*;

public class Prog3A {

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    try {
      int result;
      System.out.print("Enter a = ");
      int a = s.nextInt();
      System.out.print("Enter b = ");
      int b = s.nextInt();
      result = a / b;
      System.out.println("a / b = " + result);
    } catch (Exception e) {
      System.out.println(e);
    }
    s.close();
  }
}
