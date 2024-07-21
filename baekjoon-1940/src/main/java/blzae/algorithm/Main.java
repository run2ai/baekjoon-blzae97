package blzae.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int valuesCount = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long resultSum = Long.parseLong(stringTokenizer.nextToken());

        long[] valueArray = new long[valuesCount];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < valuesCount; i++) {
            valueArray[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        bufferedReader.close();

        Arrays.sort(valueArray);

        int q = 0;
        int w = valueArray.length - 1;
        int count = 0;
        while (q < w) {
            if (valueArray[q] + valueArray[w] < resultSum) {
                q++;
            } else if (valueArray[q] + valueArray[w] > resultSum) {
                w--;
            } else {
                count++;
                q++;
                w--;
            }
        }
        System.out.println(count);
    }
}