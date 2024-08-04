package blzae.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        Data[] data = new Data[n];
        for(int i = 0; i< n; i++){
            data[i] = new Data(Integer.parseInt(bufferedReader.readLine()), i);
        }

        Arrays.sort(data);

        int max = 0;
        for(int i = 0; i < n; i++){
            int indexSubtraction = data[i].index - i;
            if(max < indexSubtraction){
                max = indexSubtraction;
            }
        }

        System.out.println(max + 1);
    }

    static class Data implements Comparable<Data>{
        private int value;
        private int index;

        public Data(int value, int index){
            this.value = value;
            this.index = index;
        }


        @Override
        public int compareTo(Data o) {
            return this.value - o.value;
        }
    }
}