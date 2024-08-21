package datastructures.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

//        Heap heap = new Heap();
//
//        heap.insert(99);
//        heap.insert(72);
//        heap.insert(61);
//        heap.insert(58);
//
//        System.out.println("Before insert: ");
//        System.out.println(heap.getHeap());
//
//        heap.insert(100);
//        System.out.println("After insert: ");
//        System.out.println(heap.getHeap());
//
//        heap.insert(75);
//        System.out.println("After insert: ");
//        System.out.println(heap.getHeap());
//
//        heap.remove();
//        System.out.println(heap.getHeap());

        int[] nums1 = {1, 5, 2, 9, 3, 6, 8};
        System.out.println("Test case 1:");
        System.out.println("Input: [1, 5, 2, 9, 3, 6, 8]");
        System.out.println("Expected output: [1, 5, 5, 9, 9, 9, 9]");
        System.out.println("Actual output: " + streamMax(nums1));
        System.out.println();
    }

    public static int findKthSmallest (int[] arr, int k)
    {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : arr)
        {
            heap.add(num);
        }

        System.out.println(heap);

        int sm = -1;
        for (int i = 0; i < k; i++)
        {
            sm = heap.poll();
        }
        return sm;
    }

    public static List<Integer> streamMax(int[] arr) {
        Heap heap = new Heap();

        List<Integer> list = new ArrayList<>();
        for (int num : arr)
        {
            heap.insert(num);
            list.add(heap.getHeap().getFirst());
        }


        return list;
    }
}
