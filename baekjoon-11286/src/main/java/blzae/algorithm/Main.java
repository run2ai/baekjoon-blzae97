package blzae.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int operationsNumber= Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
            int firstValue = Math.abs(o1);
            int secondValue = Math.abs(o2);

            if(firstValue == secondValue){
                return o1 > o2 ? 1 : -1;
            }else{
                return firstValue - secondValue;
            }
        }));

        for(int i =0; i< operationsNumber; i++){
            int inputValue = Integer.parseInt(bufferedReader.readLine());

            if(inputValue == 0){
                if(priorityQueue.isEmpty()){
                    System.out.println("0");
                }else{
                    System.out.println(priorityQueue.poll());
                }
            }else{
                priorityQueue.add(inputValue);
            }
        }
    }
}