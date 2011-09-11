
import java.util.Arrays;

public class Problem24 {

    /*
    
     * 
     *
     * NextPermutation(a1a2...an; permutation of {1, 2,..., n} != to n, (n-1),...2, 1)
    {
    j = n -1;
    while (a[j] > a [j+1])
    {j = j - 1;}
    k = n;
    while (a[j] > a[k])
    {k = k -1;}
    swap a[j] and a[k];
    r = n;
    s = j + 1;
    while (r > s)
    {
    swap a[r] and a[s];
    r = r - 1;
    s = s + 1;
    }
    
     */
    public static void nextPermuatation(int[] a) {
        int j = a.length - 2;

        while (a[j] > a[j + 1]) {
            j--;
            if (j < 0) {
                Arrays.sort(a);
                j = 0;
            }
        }
        int k = a.length - 1;

        while (a[j] > a[k]) {
            k--;
        }

        swap(a, j, k);
        int r = a.length - 1;
        int s = j + 1;
        while (r > s) {
            swap(a, r, s);
            r = r - 1;
            s = s + 1;
        }


    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};// the first permutation
        for (int i = 1; i < 1000000; i++) {
            nextPermuatation(arr);
//            System.out.println(Arrays.toString(arr).replaceAll(", ", ""));
        }
        System.out.println(Arrays.toString(arr).replaceAll(", ", ""));

    }

    private static void swap(int[] array, int aIndex, int bIndex) {
        int temp = array[aIndex];
        array[aIndex] = array[bIndex];
        array[bIndex] = temp;

    }
}
