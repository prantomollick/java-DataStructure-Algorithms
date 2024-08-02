import java.util.ArrayList;
import java.util.List;

import datastructure.dynamicarray.MyArray;

public class Main {
    public static void main(String[] args ) {
        MyArray arr = new MyArray(5);
        arr.insert(1);
        arr.insert(2);
        arr.insert(3);
        arr.insert(4);

        arr.removeAt(30);
        System.out.println(arr);
        // System.out.println(arr.indexOf(0));

        
        

    }

}

