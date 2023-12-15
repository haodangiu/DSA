package src.Week8;

import java.util.Scanner;

public class MinPriorityQueue {
    private int[] array;
    private int size;

    public MinPriorityQueue(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue item: " + item);
            return;
        }

        array[size] = item;
        size++;
        heapifyUp(size - 1);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue item.");
            return -1;
        }

        int minItem = array[0];
        array[0] = array[size - 1];
        size--;
        heapifyDown(0);

        return minItem;
    }

    public int countStepsToEmpty(int k) {
        int steps = 0;

        while (!isEmpty() && array[0] < k) {
            int min1 = dequeue();
            if (!isEmpty()) {
                int min2 = dequeue();
                int newItem = min1 + 2 * min2;
                enqueue(newItem);
            }
            steps++;
        }
        if (array[0] < k) {
            return -1;
        }

        return steps;
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        while (index > 0 && array[index] < array[parentIndex]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;

        if (leftChildIndex < size && array[leftChildIndex] < array[smallestIndex]) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < size && array[rightChildIndex] < array[smallestIndex]) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != index) {
            swap(index, smallestIndex);
            heapifyDown(smallestIndex);
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        MinPriorityQueue pq = new MinPriorityQueue(n);
        while (n != 0) {
            int i = sc.nextInt();
            pq.enqueue(i);
            n--;
        }
        int cnt = pq.countStepsToEmpty(k);
        System.out.println(cnt);
    }
}