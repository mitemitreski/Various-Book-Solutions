import java.util.ArrayList;
import java.util.Collections;


//very ugly solution
public class Problem22 {

  public static int numValFrom(String str) {
    int out = 0;

    for (int i = 0; i < str.length(); i++) {
      out += str.charAt(i) - 'A' + 1;

    }
    return out;
  }

  public static void main(String[] args) {


    String con = EulerUtil.readFromFile("src/22.in");
    con = con.replaceAll("[\",\n]", " ");
    long totalSum = 0;
    String[] niza = con.split("\\s");
    ArrayList<String> list = new ArrayList<String>();

    for (int i = 0; i < niza.length; i++) {
      String element = niza[i];
      if (element.equals("")) {
        continue;
      }
      list.add(element);
    }

    Collections.sort(list);

    for (int i = 0; i < list.size(); i++) {
      String element = list.get(i);


      if (element.equals("")) {
        continue;
      }
      totalSum += (numValFrom(element) * (i + 1));


    }
    System.out.println("totalSum " + totalSum);

  }
}
