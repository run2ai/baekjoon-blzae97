package blzae.algorithm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int valueSize = scanner.nextInt();
        String values = scanner.next();

        char[] valuesCharArray = values.toCharArray();

        if (valueSize != valuesCharArray.length) {
            System.out.print("입력 받은 숫자의 개수와 N개의 숫자의 개수가 다릅니다.\n");
            return;
        }

        int valueSum = 0;
        for (char value : valuesCharArray) {
            boolean isDigit = Character.isDigit(value);
            if (!isDigit) {
                System.out.printf("숫자가 아닌 값이 들어왔습니다. find : %c\n", value);
                continue;
            }

            valueSum += Character.getNumericValue(value);
        }

        System.out.print(valueSum);
    }
}