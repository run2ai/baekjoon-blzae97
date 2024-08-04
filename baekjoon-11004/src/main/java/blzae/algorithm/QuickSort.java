package blzae.algorithm;

public class QuickSort {

    public void sort(long[] data, int startPoint, int endPoint, int targetIndex){
        if(startPoint < endPoint){
            int pivot = partition(data, startPoint, endPoint);
            if(pivot == targetIndex){
                return;
            }else if(targetIndex < pivot){
                sort(data, startPoint, pivot - 1, targetIndex);
            }else{
                sort(data, pivot + 1, endPoint, targetIndex);
            }
        }
    }

    public int partition(long[] data, int startPoint, int endPoint) {
        if (startPoint + 1 == endPoint) {
            if (data[startPoint] > data[endPoint]) {
                swap(data, startPoint, endPoint);
            }
            return endPoint;
        }

        int middlePoint = (startPoint + endPoint) / 2;
        swap(data, startPoint, middlePoint);

        long pivot = data[startPoint];

        int start = startPoint + 1;
        int end = endPoint;

        while (start <= end) {
            while (end >= startPoint + 1 && pivot < data[start]) {
                end--;
            }

            while (start <= endPoint && pivot > data[start]) {
                start++;
            }

            if (start <= end) {
                swap(data, start++, end--);
            }
        }

        data[startPoint] = data[end];
        data[end] = pivot;

        return end;
    }

    public void swap(long[] data, int i, int j) {
        long temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
