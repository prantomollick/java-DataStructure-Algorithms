import java.util.Arrays;

import algorithms.searching.Search;
import algorithms.sorting.BubbleSort;
import algorithms.sorting.BucketSort;
import algorithms.sorting.CountingSort;
import algorithms.sorting.InsertionSort;
import algorithms.sorting.MergeSort;
import algorithms.sorting.QuickSort;
import algorithms.sorting.SelectionSort;
import datastructure.graph.Graph;
import datastructure.graph.WeightedGraph;
import datastructure.heap.Heap;
import datastructure.heap.MaxHeap;
import datastructure.trie.Trie;

public class Main {
    public static void main(String[] args ) {
        // int[] numbers = { 7, 3, 1, 4, 6, 2, 3 };
        int[] numbers = { 1, 2, 3, 4, 6, 7};
        var search = new Search();
        var index = search.ternarySearchRec(numbers, 1);
        System.out.println(index);
        
        
    }

}

// https://release.fiverr.com/summer24/?utm_source=release_message&utm_campaign=202407_release&utm_content=registered&utm_term=freelancers#freelancers