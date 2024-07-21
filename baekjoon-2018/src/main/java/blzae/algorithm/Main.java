package blzae.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        long n = Long.parseLong(stringTokenizer.nextToken());

        long count = 1;
        long startIndex = 1;
        long endIndex = 1;
        long sum = 1;

        while (endIndex != n) {
            if (sum < n) {
                endIndex++;
                sum += endIndex;
            } else if (sum > n) {
                sum -= startIndex;
                startIndex++;
            } else {
                count++;
                endIndex++;
                sum += endIndex;
            }
        }
        System.out.print(count);
    }
}