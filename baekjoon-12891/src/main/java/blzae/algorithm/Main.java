package blzae.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int s = Integer.parseInt(stringTokenizer.nextToken());
        int p = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String dna = stringTokenizer.nextToken();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Map<Character, Integer> initCount = new HashMap<>();
        initCount.put('A', Integer.valueOf(stringTokenizer.nextToken()));
        initCount.put('C', Integer.valueOf(stringTokenizer.nextToken()));
        initCount.put('G', Integer.valueOf(stringTokenizer.nextToken()));
        initCount.put('T', Integer.valueOf(stringTokenizer.nextToken()));

        bufferedReader.close();

        Map<Character, Integer> currentCount = new HashMap<>();
        currentCount.put('A', 0);
        currentCount.put('C', 0);
        currentCount.put('G', 0);
        currentCount.put('T', 0);

        for (int i = 0; i < p; i++) {
            addChar(dna.charAt(i), currentCount);
        }

        int result = 0;
        if (check(currentCount, initCount)) {
            result++;
        }

        for (int i = p; i < s; i++) {
            addChar(dna.charAt(i), currentCount);
            removeChar(dna.charAt(i - p), currentCount);
            if (check(currentCount, initCount)) {
                result++;
            }
        }
        System.out.print(result);
    }


    public static void addChar(char c, Map<Character, Integer> count) {
        count.put(c, count.get(c) + 1);
    }

    public static void removeChar(char c, Map<Character, Integer> count) {
        count.put(c, count.get(c) - 1);
    }

    public static boolean check(Map<Character, Integer> currentCount, Map<Character, Integer> initCount) {
        for (char key : initCount.keySet()) {
            if (currentCount.get(key) < initCount.get(key)) {
                return false;
            }
        }

        return true;
    }
}