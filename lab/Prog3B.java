/*
3B. Write a Java program that implements a multi-thread application that has
three threads. First thread generates a random integer for every 1 second;
second thread computes the square of the number andprints; third thread will
print the value of Cube of the number.
*/

import java.util.Random;

public class Prog3B {
  public static void main(String args[]) {
    rand a1 = new rand();
    a1.start();

    square a2 = new square();
    a2.start();

    Cube a3 = new Cube();
    a3.start();
  }
}

class rand extends Thread {
  static int num;
  int result;

  public static int generate() {

    Random a = new Random();
    System.out.println("Number : ");
    num = a.nextInt(100);
    return num;
  }
  public void run() {
    int result;
    while (true) {
      try {
        result = generate();
        System.out.println(result);
        Thread.sleep(1000);
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }
}

class square extends Thread {
  public static int square1(int a) { return a * a; }
  void display(int a) { System.out.println(a); }
  public void run() {

    while (true) {
      try {
        display(square1(rand.num));

        Thread.sleep(1000);
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }
}
class Cube extends Thread {
  public static int cube(int a) { return a * a * a; }
  void display(int a) { System.out.println(a); }
  public void run() {

    while (true) {
      try {
        display(cube(rand.num));

        Thread.sleep(1000);
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }
}
