
import java.util.HashMap;

/**
 *
 * 
 * NOTE 
 * 
 *  THERE IS A LOT SMARTER SOLUTION TO THIS BUT THIS WAS MINE so 
 *  Also the map can be smaller but I made a lot of speling errors so 
 * @author mite
 */
public class Problem17 {

    public static HashMap<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "fifteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(30, "thirty");
        map.put(40, "forty");
        map.put(50, "fifty");
        map.put(60, "sixty");
        map.put(70, "seventy");
        map.put(80, "eighty");
        map.put(90, "ninety");
        map.put(100, "onehundred");
        map.put(200, "twohundred");
        map.put(300, "threehundred");
        map.put(400, "fourhundred");
        map.put(500, "fivehundred");
        map.put(600, "sixhundred");
        map.put(700, "sevenhundred");
        map.put(800, "eighthundred");
        map.put(900, "ninehundred");
        map.put(1000, "onethousand");
    }
    // the example 342 (three hundred and forty-two)

    public static void main(String[] args) {

        String out = "";
        for (int i = 1; i <= 1000; i++) {
            if (i == 30 || i == 100 || i == 50) {
                out += map.get(i) + "\n";
                continue;
            }
            if (i <= 20) {

                out += map.get(i) + "\n";
                continue;

            } else if (i < 100) {
                if (i % 10 == 0) {
                    out += map.get((i - (i % 10))) + "\n";
                    continue;

                }
                out += map.get((i - (i % 10))) + map.get(i % 10) + "\n";
                continue;
            } else if (i < 1000) {
                if (i % 100 == 0) {
                    out += map.get(i) + "\n";
                    continue;
                }
                if (i % 100 <= 20) {
                    out += map.get(i - (i % 100)) + "and" + map.get((i % 100)) + "\n";
                    continue;
                }
                if (i % 10 == 0) {
                    out += map.get(i - (i % 100)) + "and" + map.get((i % 100) - (i % 10)) + "\n";
                    continue;

                }

                out += map.get(i - (i % 100)) + "and" + map.get((i % 100) - (i % 10)) + map.get(i % 10) + "\n";
                continue;



            }

        }
        out += map.get(1000) + "\n";
//        System.out.println(out); // to test  the string output
        System.out.println(out.replaceAll("\n", "").length());
       
    }
}
