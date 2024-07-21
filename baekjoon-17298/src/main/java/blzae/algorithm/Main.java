package blzae.algorithm;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int numberSize = Integer.parseInt(stringTokenizer.nextToken());
        int[] inputNumbers = new int[numberSize];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < numberSize; i++){
            inputNumbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        long[] resultNumbers = new long[numberSize];

        stack.push(0);
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 1; i < numberSize; i++){
            while (!stack.empty() && inputNumbers[stack.peek()] < inputNumbers[i]){
                resultNumbers[stack.pop()] = inputNumbers[i];
            }
            stack.push(i);
        }

        while (!stack.empty()){
            resultNumbers[stack.pop()] = -1;
        }

        BufferedWriter bufferedWriter =new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < resultNumbers.length; i++){
            bufferedWriter.write(resultNumbers[i] + " ");
        }
        bufferedWriter.flush();
    }
}