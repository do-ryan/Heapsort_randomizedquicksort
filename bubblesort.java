// implementation of bubble sort (O(n^2))

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class bubblesort {

    public static void bubbleSort (ArrayList<String[]> arr)
    {
        String[] temp;
        boolean swapped;

        int n = arr.size();

        for (int i = 0; i < n-1; i++)
        {
            swapped = false;
            for (int j = 0; j < n-i-1; j++)
            {
                if (Integer.parseInt(arr.get(j)[0]) > Integer.parseInt(arr.get(j + 1)[0]))
                {
                    temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    // swap if adjacent values out of order
                    swapped = true;
                }

            }
            if (swapped == false)
            {
                break; // if no swaps are made, the list is sorted and we can exit
            }
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

        bubbleSort(a1_list);

        //for(String[] i : a1_list)
        for (int i = 0; i < a1_list.size(); i++)
        {
            System.out.println(Arrays.toString(a1_list.get(i)));
        }

        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns");
    }

}
