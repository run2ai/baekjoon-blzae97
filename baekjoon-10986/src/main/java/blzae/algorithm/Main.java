package blzae.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        long[] s = new long[n];
        long[] c = new long[m];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            long value = Long.parseLong(stringTokenizer.nextToken());
            s[i] = (i == 0) ? value : s[i - 1] + value;
        }

        long answer = 0;
        for (int i = 0; i < n; i++) {
            int remainder = (int) (s[i] % m);

            if (remainder == 0) {
                answer += 1;
            }

            c[remainder]++;
        }

        for (int i = 0; i < m; i++) {
            if (c[i] > 1) {
                answer += ((c[i] * (c[i] - 1)) / 2);
            }
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.flush();
    }
}