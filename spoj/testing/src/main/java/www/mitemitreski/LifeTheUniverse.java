package www.mitemitreski;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LifeTheUniverse {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = r.readLine()).startsWith("42")) System.out.println(s);
    }

}
