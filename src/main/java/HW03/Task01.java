/**
 * Реализовать алгоритм сортировки слиянием.
 */

package HW03;

import java.util.Arrays;
import java.util.Random;

public class Task01 {

    public static void main(String[] args) {
        int[] array1 = randomArr();
        int[] result = mergesort(array1);
        System.out.println(Arrays.toString(result));
    }

    public static int[] randomArr() {
        Random rand = new Random();
        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        return arr;
    }

    public static int[] mergesort(int[] array1) {
        int[] leftside = Arrays.copyOf(array1, array1.length);
        int[] rightside = new int[array1.length];
        int[] result = mergesortInner(leftside, rightside, 0, array1.length);
        return result;
    }

    public static int[] mergesortInner(int[] leftside, int[] rightside,
                                       int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return leftside;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sort1 = mergesortInner(leftside, rightside, startIndex, middle);
        int[] sort2 = mergesortInner(leftside, rightside, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sort1 == leftside ? rightside : leftside;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sort1[index1] < sort2[index2]
                    ? sort1[index1++]
                    : sort2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sort1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sort2[index2++];
        }
        return result;
    }

}