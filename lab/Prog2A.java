/*
2A. Design a superclass called Staff with details as StaffId, Name, Phone,
Salary. Extend this class by writing three subclasses namely Teaching (domain,
publications), Technical (skills), and Contract (period). Write a Java program
to read and display at least 3 staff objects of all three categories.
*/

import java.util.*;

public class Prog2A {
  private String id, name, phno, salary;

  public void input() {
    System.out.println("Enter ID , Name, PhNo, Salary");
    Scanner s = new Scanner(System.in);
    id = s.nextLine();
    name = s.nextLine();
    phno = s.nextLine();
    salary = s.nextLine();
    s.close();
  }

  public void output() {
    System.out.println("ID = " + id + "\tName= " + name + "\nPhNo = " + phno +
                       "\tSalary = " + salary);
  }

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int n;
    System.out.print("Enter no. of employees : ");
    n = s.nextInt();
    // Prog2A[]  obj = new Prog2A[n];

    // for(int i=0;i<n;i++)
    // obj[i]= new Prog2A();

    for (int i = 0; i < n; i++) {
      System.out.println("Enter option 1:teaching 2:tech 3:contract");
      int x;
      x = s.nextInt();
      switch (x) {
      case 1:
        System.out.print("Enter no. of employees : ");
        int f = s.nextInt();
        Teaching[] obj = new Teaching[f];

        for (int j = 0; j < f; j++)
          obj[i] = new Teaching();
        obj[i].input();
        obj[i].output();
        break;

      case 2:
        int v = s.nextInt();
        Technical[] obj1 = new Technical[v];

        for (int j = 0; j < v; j++) {
          obj1[j] = new Technical();
          obj1[j].input();
          obj1[j].output();
        }
        break;

      case 3:
        int b = s.nextInt();
        Contract[] obj2 = new Contract[b];

        for (int j = 0; j < b; j++)
          obj2[i] = new Contract();
        obj2[i].input();
        obj2[i].output();
        break;
      }
      s.close();
    }
  }
}
class Teaching extends Prog2A {
  private String domain, publications;
  public void input() {
    super.input();
    System.out.println("Enter domain and publications");
    Scanner s = new Scanner(System.in);
    domain = s.nextLine();
    publications = s.nextLine();
    s.close();
  }

  public void output() {
    super.output();
    System.out.println("Domain = " + domain +
                       "\tNo. of Publications = " + publications);
  }
}

class Technical extends Prog2A {
  private String skill;
  public void input() {
    super.input();
    System.out.println("Enter skill");
    Scanner s = new Scanner(System.in);
    skill = s.nextLine();
    s.close();
  }

  public void output() {
    super.output();
    System.out.println("Skill = " + skill);
  }
}

class Contract extends Prog2A {
  private String period;
  public void input() {
    super.input();
    System.out.println("Enter period");
    Scanner s = new Scanner(System.in);
    period = s.nextLine();
    s.close();
  }
  public void output() {
    super.output();
    System.out.println("Period = " + period);
  }
}
