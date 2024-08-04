package blzae.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int dataSize = Integer.parseInt(stringTokenizer.nextToken());
        int targetIndex = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long[] data = new long[dataSize];

        for (int i = 0; i < dataSize; i++) {
            data[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        QuickSort quickSort = new QuickSort();
        quickSort.sort(data, 0, dataSize - 1, targetIndex - 1);
        System.out.print(data[targetIndex - 1]);
    }


}