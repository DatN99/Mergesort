package com.company;

/**
 * This class holds my mergesort.
 * It's a recursive divide and conquer algorithm that sorts an integer array
 *
 * The worst case and average case time complexities are both O(NlogN).
 * For every recursive call, the array is divided into two halves.
 *
 * For 8 elements, the array would be divided 3 times. However, for each array division,
 * the algorithm requires that both sides are sorted before merging. Therefore, all elements are being iterated through for each division.
 *
 * For example, if an array with 8 elements were mergesorted, On the first recursive call, it would iterate through 8(log2 8) = 8(3) = 24 elements
 *
 * This is a little hard to understand so here's another way to explain it:
 * The recurrence relation for mergesort can be described as (time for mergesort) = (time to sort left subarray) + (time to sort right sub array) + (time to merge)
 * In other words, it can be written as T(n) = T(n/2) + T(n/2) + n which can be simplified to O(NlogN)
 *
 * Compared to quicksort, this algorithm handles better the worst-case scenario. In quicksort, there is no guarantee that
 * the pivot position will divide the array evenly. If the pivot is too close to either the beginning or end, the sorting
 * may take up to O(n^2) time.
 *
 * However, mergesort guarantees the array is split evenly for every division.
 */

public class Main {

    public static void main(String[] args) {
	int[] array = {4, 2, 3, 1, 7, 5, 9, 6};
	array = mergesort(array);
	print(array);
    }

    public static void print(int[] array){
        String string ="[";

        for (int i = 0; i < array.length; i++){
            string += array[i] + ", ";
        }

        string += "]";

        System.out.print(string);

    }

    public static int[] mergesort(int[] array){
        if (array.length == 1){
            return array;
        }

        int[] left_array = getLeftArray(array);
        int[] right_array = getRightArray(array);

        left_array = mergesort(left_array);
        right_array = mergesort(right_array);

        array = merge(left_array, right_array);

        return array;
    }

    public static int[] getLeftArray(int[] array){

        float size = Math.round((float) array.length/ (float) 2);
        int[] temp = new int[(int) size];

        for (int i = 0; i < size; i++){
            temp[i] = array[i];
        }

        return temp;
    }

    public static int[] getRightArray(int[] array){

        int subSize = 0;

        int[] temp = new int[subSize];

        int t = 0;


        if (array.length %2 == 0){
            subSize =  Math.round((float) array.length/ (float) 2);

            temp = new int[subSize];

            for (int i = subSize; i < array.length; i++){
                temp[t] = array[i];
                t++;
            }
        }

        else{
            double size =  Math.floor((float) array.length/ (float) 2);
            subSize = (int) size;
            temp = new int[subSize];


            for (int i = subSize+1; i < array.length; i++){
                temp[t] = array[i];
                t++;
            }
        }




        return temp;
    }

    public static int[] merge(int[] left_array, int[] right_array){
        int[] temp = new int[left_array.length + right_array.length];
        int left_size = left_array.length;
        int right_size = right_array.length;

        int l = 0;
        int r = 0;
        int t = 0;

        while (left_size > 0 && right_size > 0){


            if (left_array[l] < right_array[r]){
                temp[t] = left_array[l];
                t++;
                l++;
                left_size-=1;
            }

            else{
                temp[t] = right_array[r];
                t++;
                r++;
                right_size-=1;


            }


        }

        while (left_size > 0){
            while (l < left_array.length){
                temp[t] = left_array[l];
                t++;
                l++;
                left_size-=1;
            }
        }

        while (right_size > 0){
            while (r < right_array.length){
                temp[t] = right_array[r];
                r++;
                t++;
                right_size-=1;
            }
        }

        return temp;
    }
}
