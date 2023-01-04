package aggrcow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*

1
5 3
1
2
8
4
9


1
4
8


 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int testCase = 0; testCase < testCases; testCase++) {

            String[] caseLine = reader.readLine().split(" ");
            int N = Integer.parseInt(caseLine[0]);
            int cowNumber = Integer.parseInt(caseLine[1]);
            int[] stallLocations = new int[N];

            for (int i = 0; i < N; i++) {
                stallLocations[i] = Integer.parseInt(reader.readLine());
            }
            Arrays.sort(stallLocations);
            System.out.println(largestMinDist(stallLocations, N, cowNumber));
        }


    }


    static boolean isFeasible(int mid, int arr[], int n,
                              int k) {
        int pos = arr[0];
        int elements = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] - pos >= mid) {

                pos = arr[i];
                elements++;

                if (elements == k)
                    return true;
            }
        }
        return false;
    }


    static int largestMinDist(int arr[], int n, int k) {
        int result = -1;

        // max distance
        int left = 1, right = arr[n - 1];

        while (left < right) {
            int mid = (left + right) / 2;
            if (isFeasible(mid, arr, n, k)) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else
                right = mid;
        }

        return result;
    }


}


