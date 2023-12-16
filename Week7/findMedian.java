package src.Week7;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    private static int partition(List<Integer> list, int low, int high) {
        int pivot = list.get(high);
        int idMin = low;

        for (int i = low; i < high; ++i) {
            if (list.get(i) < pivot) {
                Collections.swap(list, i, idMin);
                ++idMin;
            }
        }
        Collections.swap(list, high, idMin);
        return idMin;
    }

    public static int findMedian(List<Integer> list) {
        // Write your code here
        int low = 0, high = list.size() - 1;
        int id = partition(list, low, high);
        int median = list.size() / 2;

        while (id != median) {
            if (id > median) {
                high = id - 1;
            } else {
                low = id + 1;
            }

            id = partition(list, low, high);
        }
        return list.get(id);
    }


}

public class findMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = Result.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
