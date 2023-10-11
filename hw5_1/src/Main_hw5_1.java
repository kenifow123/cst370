/*
 * INSTRUCTION:
 *     This is a Java starting code for hw5_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw5_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Main_hw5_1.java
 * Abstract: takes input and turns into heap, use commands to displayMax, insert, deleteMax, and display
 * Name: Kenneth Ao
 * Date: 10/10/2023
 */

import java.util.*;

class Main
{
    public static boolean heapCheck(int[] heap) {
        //check if array is a heap
        boolean check = true;
        int parent = (heap.length-1)/2;
        int leftChild = parent * 2;
        int rightChild = leftChild + 1;
        int currChild;

        while (parent > 0) {
            //check if two child nodes
            if (rightChild < heap.length) {
                if (Math.max(heap[leftChild], heap[rightChild]) == heap[leftChild]) {
                    currChild = leftChild;
                } else {
                    currChild = rightChild;
                }

            } else {
                currChild = leftChild;
            }

            //check parent > child
            if (heap[parent] < heap[currChild]) {
                return false;
            }
            parent = parent / 2;
            leftChild = parent * 2;
            rightChild = leftChild + 1;
        }



        return check;
    }

    public static void display(int[] heap) {
        //prints heap
        String printString = "";
        for (int i = 1; i < heap.length; i++) {
            printString = printString + heap[i] + " ";

        }
        printString = printString.trim();
        System.out.println(printString);
    }

    public static int[] insert(int[] heap, String command) {
        //insert node at bottom left
        String[] stringArray = command.split(" ");
        int insertValue = Integer.parseInt(stringArray[1]);

        //new heap with 1 empty at the end
        int[] newHeap = new int[heap.length+1];

        for (int i=1; i<heap.length; i++) {
            newHeap[i] = heap[i];
        }

        //add new value to end of heap
        newHeap[newHeap.length-1] = insertValue;

        newHeap = heapify(newHeap);

        return newHeap;
    }

    private static int[] deleteMax(int[] heap) {

        //make new heap with 1 less spot
        int[] newHeap = new int[heap.length-1];

        //move last child to top
        heap[1] = heap[heap.length-1];

        //fill new heap
        for (int i = 0; i < newHeap.length; i++) {
            newHeap[i] = heap[i];
        }

        newHeap = heapify(newHeap);

        return newHeap;
    }

    public static int[] doCommand(String command, int[] heap) {
        //chooses command

        if (command.equals("displayMax")) {
            System.out.println(heap[1]);
        } else if (command.startsWith("insert")) {
            heap = insert(heap, command);
        } else if (command.equals("deleteMax")) {
            heap = deleteMax(heap);

        } else if (command.equals("display")) {
            display(heap);
        }

        return heap;
    }

    public static int[] heapify(int[] heap) {
        //turns array into valid heap

        int currChild, currParentIndex;
        boolean heapCheck;

        for (int i = (heap.length-1)/2; i >= 1; i--){
            currParentIndex = i;
            heapCheck = false;

            //while not a heap and is not a leaf node
            while (!heapCheck && (2 * currParentIndex <= (heap.length - 1))) {
                currChild = currParentIndex*2;
                if (currChild+1 < heap.length) {    //if there are 2 children
                    if (heap[currChild] < heap[currChild + 1]) {
                        currChild += 1;
                    }
                }
                if (heap[currParentIndex] >= heap[currChild]) {
                    heapCheck = true;
                } else {
                    int temp = heap[currParentIndex];
                    heap[currParentIndex] = heap[currChild];
                    heap[currChild] = temp;
                    currParentIndex = currChild;    //check children after swapping
                }
            }
        }

        return heap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNodes = scanner.nextInt();
        scanner.nextLine();

        String stringLine = scanner.nextLine();
        String[] stringArray = stringLine.split(" ");
        int[] inputArray = new int[totalNodes+1];

        //convert string array to int array
        for (int i = 0; i < totalNodes; i++) {
            inputArray[i+1] = Integer.parseInt(stringArray[i]);
        }

        int totalCommands = scanner.nextInt();
        scanner.nextLine();

        String[] commandsArray = new String[totalCommands];
        String command;
        for (int i = 0; i < totalCommands; i++) {
            command = scanner.nextLine();
            commandsArray[i] = command;
        }

        if (heapCheck(inputArray)) {
            System.out.println("This is a heap.");
        } else {
            System.out.println("This is NOT a heap.");
            inputArray = heapify(inputArray);
        }

        for (String each : commandsArray) {
            inputArray = doCommand(each, inputArray);
        }

    }
}

