// implementation of quicksort (O(n^2) worst case)

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class randomized_quicksort {

    public static void quickSort (ArrayList<String[]> arr, int begin, int end)
    {
        if (begin < end)
        {
            Random r = new Random();
            int randPivot = r.nextInt(end-begin)+begin;
            String [] temp = arr.get(randPivot);
            arr.set(randPivot, arr.get(end));
            arr.set(end, temp);
            // randomize pivot

            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1); // partitions first half subproblem
            quickSort(arr, partitionIndex+1, end); // partitions second half subproblem
        }
    }

    public static int partition(ArrayList<String[]> arr, int begin, int end) {
        int pivot = Integer.parseInt(arr.get(end)[0]);
        int i = (begin-1);

        for (int j = begin; j < end; j++) { // j iterates through entire subproblem
            if (Integer.parseInt(arr.get(j)[0]) <= pivot) {
                i++; // i is always at the partition boundary

                String[] swapTemp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, swapTemp);
                // swap i and j
            }
        }

        String[] swapTemp = arr.get(i + 1);
        arr.set(i + 1, arr.get(end));
        arr.set(end, swapTemp);
        // swap pivot with partition boundary (+ side)

        return i+1;
    }


    public static void main(String[] args) throws Exception
    //args[0] is the path to the .csv
    {
        //int input_size = 28000;
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

        int begin = 0;
        int end = a1_list.size() -1;
        quickSort(a1_list, begin, end);

        for (int i = 0; i < a1_list.size(); i++)
        {
            System.out.println(Arrays.toString(a1_list.get(i)));
        }

        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns");
    }

}
