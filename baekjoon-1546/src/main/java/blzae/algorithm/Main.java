package blzae.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testSize = scanner.nextInt();
        scanner.nextLine();

        if (testSize > 1000) {
            return;
        }

        String testResult = scanner.nextLine();
        scanner.close();

        List<String> testResultList = Arrays.asList(testResult.split(" "));

        List<Integer> intTestResults = testResultList.stream()
                .map(Main::validate)
                .collect(Collectors.toList());

        int maxResult = intTestResults.stream()
                .mapToInt(i -> i)
                .max()
                .orElse(0);

        int resultSum = intTestResults.stream()
                .mapToInt(i -> i)
                .sum();

        double avg = (resultSum * 100.0) / maxResult / testSize;
        System.out.printf("%f", avg);

    }

    public static int validate(String result) {
        int i = Integer.parseInt(result);

        if (i > 0 && i <= 100) {
            return i;
        }

        return 0;
    }
}