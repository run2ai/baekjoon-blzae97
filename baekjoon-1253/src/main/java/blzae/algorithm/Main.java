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

        int numberCount = Integer.parseInt(stringTokenizer.nextToken());

        long[] values = new long[numberCount];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < numberCount; i++) {
            values[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        bufferedReader.close();

        Arrays.sort(values);
        int resultCount = 0;
        for (int i = 0; i < values.length; i++) {
            long findValue = values[i];
            int startPoint = 0;
            int endPoint = values.length - 1;

            while (startPoint < endPoint) {
                if (values[startPoint] + values[endPoint] < findValue) {
                    startPoint++;
                } else if (values[startPoint] + values[endPoint] > findValue) {
                    endPoint--;
                } else {
                    if (startPoint != i && endPoint != i) {
                        resultCount++;
                        break;
                    }

                    if (startPoint == i) {
                        startPoint++;
                    }

                    if (endPoint == i) {
                        endPoint--;
                    }
                }
            }
        }
        System.out.println(resultCount);
    }
}