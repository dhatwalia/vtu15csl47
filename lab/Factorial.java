import java.util.Scanner;

public class Factorial {
  public static void main(String a[]) {
    int fact;
    Scanner s = new Scanner(System.in);
    System.out.print("Enter a number : ");
    fact = s.nextInt();
    s.close();
    int answer;
    answer = factfunc(fact);
    System.out.println(fact + "! = " + answer);
  }

  public static int factfunc(int fact) {
    if (fact == 0)
      return 0;
    else if (fact == 1)
      return 1;
    else
      return fact * factfunc(fact - 1);
  }
}
