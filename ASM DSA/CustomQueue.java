package org.example;

public class CustomQueue {
    private static final int MAX_QUEUE_SIZE = 4;

    private String[] customQueue;
    private int front;
    private int rear;
    private int size;

    public CustomQueue() {
        this.customQueue = new String[MAX_QUEUE_SIZE];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public void enqueue(String message) {
        if (!isFull()) {
            customQueue[rear] = message;
            rear = (rear + 1) % MAX_QUEUE_SIZE;
            size++;
        }
    }

    public String dequeue() {
        String message = null;
        if (!isEmpty()) {
            message = customQueue[front];
            front = (front + 1) % MAX_QUEUE_SIZE;
            size--;
        }
        return message;
    }

    public boolean isFull() {
        return size == MAX_QUEUE_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void displayCustomQueue() {
        System.out.print("Values in the current CustomQueue: ");
        int index = front;
        for (int i = 0; i < size; i++) {
            System.out.print(customQueue[index]);
            if (i < size - 1) {
                System.out.print("; ");
            }
            index = (index + 1) % MAX_QUEUE_SIZE;
        }
        System.out.println();
    }
}
