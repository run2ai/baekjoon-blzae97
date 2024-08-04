package blzae.algorithm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        long[] inputData = new long[size];

        for (int i = 0; i < size; i++) {
            inputData[i] = scanner.nextInt();
        }

        for (int i = 1; i < size; i++) {
            int point = i;
            long pointValue = inputData[i];

            for (int j = i - 1; j >= 0; j--) {
                if (inputData[j] < inputData[i]) {
                    point = j + 1;
                    break;
                }

                if (j == 0) {
                    point = 0;
                }
            }

            for (int j = i; j > point; j--) {
                inputData[j] = inputData[j - 1];
            }

            inputData[point] = pointValue;
        }

        long[] sumTime = new long[size];
        sumTime[0] = inputData[0];

        for(int i = 1; i < size; i++){
            sumTime[i] = sumTime[i - 1] + inputData[i];
        }

        long sum = 0;
        for(int i = 0; i < size; i++){
            sum += sumTime[i];
        }

        System.out.print(sum);

    }
}