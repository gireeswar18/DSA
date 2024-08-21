package datastructures.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap ()
    {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap ()
    {
        return new ArrayList<>(heap);
    }

    private int leftChild (int index)
    {
        return (index * 2) + 1;
    }

    private int rightChild (int index)
    {
        return (index * 2) + 2;
    }

    private int parent (int index)
    {
        return (index - 1) / 2;
    }

    private void swap(int ind1, int ind2)
    {
        int temp = heap.get(ind1);
        heap.set(ind1, heap.get(ind2));
        heap.set(ind2, temp);
    }

    public void insert(int value)
    {
        heap.add(value);
        int current = heap.size() - 1;

        while (current > 0)
        {
            int parentInd = parent(current);
            if (heap.get(parentInd) < heap.get(current))
            {
                swap(parentInd, current);
                current = parentInd;
            }
            else
            {
                break;
            }
        }
    }

    public Integer remove()
    {
        if (heap.isEmpty()) return null;

        if (heap.size() == 1)
        {
            return heap.remove(0);
        }

        int maxVal = heap.get(0);

        heap.set(0, heap.remove(heap.size() - 1));

        sinkDown(0);

        return maxVal;
    }


    private void sinkDown(int index)
    {
        int maxInd = index;
        while (true)
        {
            int leftChildInd = leftChild(index);
            int rightChildInd = rightChild(index);

            if (leftChildInd < heap.size() && heap.get(leftChildInd) > heap.get(maxInd))
            {
                maxInd = leftChildInd;
            }
            if (rightChildInd < heap.size() && heap.get(rightChildInd) > heap.get(maxInd))
            {
                maxInd = rightChildInd;
            }

            if (maxInd != index)
            {
                swap(maxInd, index);
                index = maxInd;
            }
            else
            {
                return;
            }
        }
    }

}
