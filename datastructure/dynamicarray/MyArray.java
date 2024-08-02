package datastructure.dynamicarray;

import java.util.Arrays;

public class MyArray {
    private int[] items;
    private int currentIdx;

    public MyArray(int initialSize) {
        this.items = new int[initialSize];
        this.currentIdx = 0;
    }   

    public void insert(int value) {
        this.items[currentIdx] = value;
        currentIdx++;
    }

    public int indexOf(int value) {
        for (int i = 0; i < currentIdx; i++) {
            if (items[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public void removeAt(int idx) {
        if(idx >=  currentIdx) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        for(int i = idx; i < currentIdx; i++) {
            items[i] = items[i + 1];
        }
        currentIdx--;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < currentIdx; i++) {
            str.append(items[i]).append(", ");
        }
        str.append("\b").append("\b").append("]");
        return str.toString();
    }

    

}
