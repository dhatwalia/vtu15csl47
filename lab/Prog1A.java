/*
1A. Create a Java class called Studentwith the following details as variables
within it. 
(i) USN 
(ii) Name 
(iii) Branch 
(iv) Phone 
Write a Java program to
create nStudent objects and print the USN, Name, Branch, and Phoneof these
objects with suitable headings.
*/

import java.util.*;

public class Prog1A {

  Scanner s = new Scanner(System.in);
  private String usn, name, branch, phno;

  public void input() {
    System.out.println("Enter the fields usn,name,branch,phno");
    usn = s.nextLine();
    name = s.nextLine();
    branch = s.nextLine();
    phno = s.nextLine();
    s.close();
  }

  public void output() {
    System.out.println("The fields are");
    System.out.println("usn = " + usn + " name is " + name + " branch is " +
                       branch + " phno is " + phno);
  }

  public static void main(String args[]) {
    int n;
    Scanner a = new Scanner(System.in);
    System.out.print("Enter no. of students : ");
    n = a.nextInt();

    Prog1A[] obj = new Prog1A[n];
    for (int i = 0; i < n; i++) {
      obj[i] = new Prog1A();
    }

    for (int i = 0; i < n; i++) {
      System.out.println("Enter the details of " + (i + 1));
      obj[i].input();
    }

    for (int i = 0; i < n; i++) {
      System.out.print("The details of " + (i + 1) + " are");
      obj[i].output();
    }
    a.close();
  }
}
