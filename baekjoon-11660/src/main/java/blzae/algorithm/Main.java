package blzae.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int arraySize = Integer.parseInt(stringTokenizer.nextToken());
        int questionCount = Integer.parseInt(stringTokenizer.nextToken());

        int[][] array = new int[arraySize][arraySize];

        for (int row = 0; row < arraySize; row++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int column = 0; column < arraySize; column++) {
                array[row][column] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[][] sumArray = new int[arraySize][arraySize];

        for (int row = 0; row < arraySize; row++) {
            for (int column = 0; column < arraySize; column++) {
                sumArray[row][column] = array[row][column]
                        + (row > 0 ? sumArray[row - 1][column] : 0)
                        + (column > 0 ? sumArray[row][column - 1] : 0)
                        - (row > 0 && column > 0 ? sumArray[row - 1][column - 1] : 0);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < questionCount; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int y1 = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int x2 = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int y2 = Integer.parseInt(stringTokenizer.nextToken()) - 1;

            int sum = sumArray[x2][y2]
                    - (x1 > 0 ? sumArray[x1 - 1][y2] : 0)
                    - (y1 > 0 ? sumArray[x2][y1 - 1] : 0)
                    + (x1 > 0 && y1 > 0 ? sumArray[x1 - 1][y1 - 1] : 0);

            result.append(sum).append("\n");
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(result.toString());
        bufferedWriter.flush();
    }
}