/*
3A. Write a Java program to implement the Stack using arrays. Write Push(),
Pop(), and Display() methods to demonstrate its working.
*/

import java.util.*;

public class Prog1B {
  static int[] stack;
  static int top;
  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    stack = new int[100];
    top = 0;
    int option;
    do {
      menu();
      System.out.print("Choose an option: ");
      option = s.nextInt();

      switch (option) {
      case 1:
        System.out.print("Enter a number: ");
        int number = s.nextInt();
        push(number);
        break;

      case 2:
        pop();
        break;

      case 3:
        display();
        break;

      case 0:
        break;

      default:
        System.out.println("Invalid Option");
      }
    } while (option != 0);
    s.close();
  }

  public static void menu() {
    System.out.println("\n---Menu---");
    System.out.println("1. Push");
    System.out.println("2. Pop");
    System.out.println("3. Display");
    System.out.println("0. Exit\n");
  }

  public static void push(int number) { stack[top++] = number; }

  public static void pop() { top--; }
  public static void display() {
    System.out.print("\n|");
    for (int i = 0; i < top; i++) {
      System.out.print("\t" + stack[i] + "\t|");
    }
    System.out.println("\n");
  }
}
