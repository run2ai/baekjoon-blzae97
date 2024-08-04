package blzae.algorithm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        int size = input.length();

        int[] arrayInput = new int[size];
        for (int i = 0; i < size; i++) {
            arrayInput[i] = Integer.parseInt(input.substring(i, i + 1));
        }

        for (int i = 0; i < size; i++) {
            int max = i;
            for (int j = i + 1; j < size; j++) {
                if (arrayInput[j] > arrayInput[max]) {
                    max = j;
                }
            }

            if (arrayInput[i] < arrayInput[max]) {
                int temp = arrayInput[i];
                arrayInput[i] = arrayInput[max];
                arrayInput[max] = temp;
            }
        }
        for(int i = 0; i < size; i++){
            System.out.print(arrayInput[i]);
        }
    }
}