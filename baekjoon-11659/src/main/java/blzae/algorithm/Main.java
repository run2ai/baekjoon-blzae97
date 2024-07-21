package blzae.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int dataSize = Integer.parseInt(stringTokenizer.nextToken());
        int loop = Integer.parseInt(stringTokenizer.nextToken());

        int[] number = new int[dataSize];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < dataSize; i++) {
            int prev = (i == 0 ? 0 : i - 1);
            number[i] = number[prev] + Integer.parseInt(stringTokenizer.nextToken());
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < loop; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int startPoint = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int endPoint = Integer.parseInt(stringTokenizer.nextToken()) - 1;

            int fixStartPoint = startPoint - 1;

            int endValue = number[endPoint];
            int startValue = fixStartPoint < 0 ? 0 : number[fixStartPoint];

            result.append(endValue - startValue).append("\n");
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(result.toString());
        bufferedWriter.flush();
    }
}