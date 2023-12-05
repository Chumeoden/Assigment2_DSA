package org.example;

public class CustomStack {
    private static final int MAX_STACK_SIZE = 1;

    private String[] customStack;
    private int top;

    public CustomStack() {
        this.customStack = new String[MAX_STACK_SIZE];
        this.top = -1;
    }

    public void push(String message) {
        if (!isFull()) {
            customStack[++top] = message;
        }
    }

    public String pop() {
        String message = null;
        if (!isEmpty()) {
            message = customStack[top--];
        }
        return message;
    }

    public boolean isFull() {
        return top >= MAX_STACK_SIZE - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void displayCustomStack() {
        System.out.print("Current CustomStack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(customStack[i]);
            if (i < top) {
                System.out.print("; ");
            }
        }
        System.out.println();
    }

    public int size() {
        return top + 1;
    }

    public int capacity() {
        return MAX_STACK_SIZE;
    }
}
