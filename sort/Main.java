package datastructures.sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 6, 1, 7, 3, 2, 5};

//        int pivot = pivot(arr, 0, arr.length - 1);
//
//        System.out.println("Pivot Index: " + pivot);

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {

        if (left == right) return;

        int pivot = pivot(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);

    }

    private static int pivot(int[] arr, int pivotInd, int endInd) {
        int swapInd = pivotInd;

        for (int i = pivotInd + 1; i <= endInd; i++) {

            if (arr[i] < arr[pivotInd]) {

                swapInd++;
                swap(arr, swapInd, i);

            }
        }

        swap(arr, pivotInd, swapInd);
        return swapInd;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
