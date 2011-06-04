
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public   class EulerUtil {

    public static void printMatix(Integer[][] a) {

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");

            }
            System.out.println("");
        }
    }

    public static Integer[] getAllDivisors(int x) {
        HashSet<Integer> divisorList = new HashSet<Integer>();
        divisorList.add(1);
        final int max = (int) (Math.round(Math.sqrt(x)) + 1);
        for (int i = 2; i < max; i++) {
            if (x % i == 0) {
                divisorList.add(i);
                divisorList.add(x / i);
            }
        }
        return divisorList.toArray(new Integer[0]);

    }

    public static String readFromFile(String filename) {
        String content = "";
        try {




            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            while (line != null) {
                content += line;

                line = br.readLine();

            }
        } catch (IOException ex) {
            ex.printStackTrace();

        }

        return content;


    }
}
