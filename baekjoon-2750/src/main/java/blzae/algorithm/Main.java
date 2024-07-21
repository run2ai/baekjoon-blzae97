package blzae.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int inputSize = Integer.parseInt(bufferedReader.readLine());

        int[] input = new int[inputSize];
        for (int i = 0; i < inputSize; i++) {
            input[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - 1; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }

        for(int i : input){
            System.out.println(i);
        }
    }
}