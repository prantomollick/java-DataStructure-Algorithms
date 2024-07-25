package algorithms.sorting;

public class CountingSort {
    public void sort(int[] array, int max) {
        int[] counts = new int[max + 1];
        for(var item : array) {
            counts[item]++;
        }


        var k = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                array[k++] = i;
            }
        }
    }
}
