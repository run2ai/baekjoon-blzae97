package blzae.algorithm;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        long[] values = new long[size];
        for (int i = 0; i < size; i++) {
            values[i] = scanner.nextInt();
        }

        long num = 1;
        boolean result = true;
        StringBuffer stringBuffer = new StringBuffer();
        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < values.length; i++) {
            long value = values[i];

            if (value >= num) {
                while (value >= num) {
                    stack.push(num++);
                    stringBuffer.append("+\n");
                }

                stack.pop();
                stringBuffer.append("-\n");
            } else {
                Long popValue = stack.pop();

                if (popValue > value) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    stringBuffer.append("-\n");
                }

            }
        }

        if (result) {
            System.out.println(stringBuffer.toString());
        }

    }
}