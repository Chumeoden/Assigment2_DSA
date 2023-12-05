package org.example;

import java.util.Scanner;

public class CustomMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomQueue customMessageQueue = new CustomQueue();
        CustomStack customMessageStack = new CustomStack();
        System.out.println("Wellcome User");
        boolean continueMessaging = true;

        while (continueMessaging) {
            // customMessageQueue.displayCustomQueue();

            System.out.println("Enter message: ");
            String message = scanner.nextLine();

            if (isValidMessage(message)) {
                processValidMessage(message, customMessageQueue, customMessageStack);
            } else {
                System.out.println("Invalid message. Message length must be below 250 characters.");
            }

            if (customMessageQueue.isFull()) {
                String dequeuedMessage = customMessageQueue.dequeue();
                System.out.println("Queue is full. Message dequeued: " + dequeuedMessage);
                customMessageStack.push(dequeuedMessage);
                System.out.println("Message pushed to Stack: " + dequeuedMessage);
            }
            if (customMessageStack.size() >= customMessageStack.capacity()) {
                String poppedMessage = (String) customMessageStack.pop();
                System.out.println("Stack is full. Message popped from Stack and displayed to the user: " + poppedMessage);
            }
            customMessageQueue.displayCustomQueue();
            // customMessageStack.displayCustomStack();
        }
        scanner.close();
    }

    private static boolean isValidMessage(String message) {
        return message.length() < 250;
    }

    private static void processValidMessage(String message, CustomQueue customMessageQueue, CustomStack customMessageStack) {
        customMessageQueue.enqueue(message);
        System.out.println("Valid message. Enqueued into the CustomQueue.");
    }
}
