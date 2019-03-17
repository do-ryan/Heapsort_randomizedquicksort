// implement randomized quicksort (n^2 worst case), heap-sort (nlogn worst case), bubble sort

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class heapsort {

    public static void heapSort (ArrayList<String[]> arr)
    {
        int n = arr.size();

        buildHeap(arr);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Swap current root (highest value) with the last leaf
            String[] temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);

            // call max heapify on the reduced heap (bubble down the now low value root to the leaves)
            // maintains heap property
            heapify(arr, i, 0);
        }

    }

    public static void buildHeap (ArrayList<String[]> arr)
    {
        int n = arr.size();

        for (int i = n/2-1; i >= 0; i--) // iterate through all nodes with children. results in a heap
        {
            heapify(arr, n, i);
        }
    }

    public static void heapify (ArrayList<String[]> arr, int n, int i)
            // for a given tree rooted at i, ensure that i and its children satisfy heap property
            // takes O(lgn)
    {
        int largest = i;
        int l = 2*i + 1; // heap stored in an array indexed level wise
        int r = 2*i + 2;

        if (l < n && Integer.parseInt(arr.get(l)[0]) > Integer.parseInt(arr.get(largest)[0])) // if left child larger than the root
        {
            largest = l;
        }

        if (r < n && Integer.parseInt(arr.get(r)[0]) > Integer.parseInt(arr.get(largest)[0])) // if right child larger than root and larger than left child
        {
            largest = r;
        }

        // If largest isn't the root
        if (largest != i)
        {
            // swap root with the largest
            String[] swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) throws Exception
    //args[0] is the path to the .csv
    {
        //int input_size = 12000;
        long startTime = System.nanoTime();

        BufferedReader br = new BufferedReader(new FileReader(args[0])); // modify this to take in arg
        String line = null;

        ArrayList<String[]> a1_list = new ArrayList<>();

        while ((line = br.readLine()) != null)
        //for (int i =0; i < input_size; i++)
        {
            String[] values = line.split(",");
            a1_list.add(values); // read csv values into a1_list
        }
        br.close();

        heapSort(a1_list);

        for (int i = 0; i < a1_list.size(); i++)
        {
            System.out.println(Arrays.toString(a1_list.get(i)));
        }

        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns");
    }

}
