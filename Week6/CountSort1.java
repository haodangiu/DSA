package src.Week6;

import java.io.*;
import java.util.*;

public class CountSort1 {
    static Integer[] counting(List<Integer> arr) {
        Integer[] ans = new Integer[100];
        for(int i = 0; i < 100; i ++) {
            ans[i] = 0;
        }
        for(int number: arr) {
            ++ans[number];
        }
        return ans;
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List result = Arrays.asList(counting(arr));
        return result;
    }

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

        List<Integer> result = countingSort(arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


