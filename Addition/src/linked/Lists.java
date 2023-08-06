package linked;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Lists {

  Scanner sc = new Scanner(System.in);

  public Lists() {
    List<String> ob = new LinkedList<String>();
    ob.add("Ujjwal Pandey");
    ob.add("Golden Boy");
    System.out.println("How many entries you want?");
    int x = sc.nextInt();
    int i = 0;
    while (i < x) {
      ob.add(sc.next());
      i++;
    }
    System.out.println(ob);
  }
}
