/*
2B. Write a Java class called Customer to store their name and date_of_birth.
The date_of_birth format should be dd/mm/yyyy. Write methods to read customer
data as <name, dd/mm/yyyy> and display as <name, dd, mm, yyyy> using
StringTokenizer class considering the delimiter character as “/”.
*/

import java.util.*;

public class Prog2B {
  private String name, dob;

  Scanner s = new Scanner(System.in);
  public void input() {
    System.out.println("Enter name: ");
    name = s.nextLine();
    System.out.println("Enter DOB in dd/mm/yy format");
    dob = s.nextLine();
  }

  public void output() {
    StringTokenizer st = new StringTokenizer(dob, "/");
    System.out.print("<" + name);
    while (st.hasMoreTokens()) {
      System.out.print("," + st.nextToken());
    }
    System.out.println(">");
  }
  public static void main(String args[]) {
    Prog2B obj = new Prog2B();
    obj.input();
    obj.output();
  }
}
