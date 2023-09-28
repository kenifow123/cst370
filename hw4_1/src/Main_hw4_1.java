/*
 * INSTRUCTION:
 *     This is a Java starting code for hw4_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw4_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Main_hw4_1.java
 * Abstract: partition array. move negatives to front and positives to end, 2 approaches
 * Name: Kenneth Ao
 * Date: 10/3/2023
 */

import java.util.*;

class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalValues = scanner.nextInt();
        scanner.nextLine();
        String inputString = scanner.nextLine();

        String[] splitString = inputString.split(" ");
        int[] inputArray = new int[totalValues];
        String printString = "";

        //convert string to int
        for (int i = 0; i < totalValues; i++) {
            inputArray[i] = Integer.parseInt(splitString[i]);
        }

        //first approach
        int i = 0;
        int j = totalValues - 1;
        while (i < j) {
            if (inputArray[i] < 0) {
                i++;
            }
            if (inputArray[j] > 0) {
                j--;
            }
            if (inputArray[i] > 0 && inputArray[j] < 0 && i < j) {
                int temp = inputArray[i];
                inputArray[i] = inputArray[j];
                inputArray[j] = temp;
            }
        }

        //print array
        for (int each : inputArray) {
            printString = printString + each + " ";
        }
        System.out.println(printString.trim());

        //reset inputArray
        //convert string to int
        for (int x = 0; x < totalValues; x++) {
            inputArray[x] = Integer.parseInt(splitString[x]);
        }

        //second approach, nested loop
        for (i = 0; i < inputArray.length; i++) {
            //found negative positive i
            if (inputArray[i] > 0) {
                j = i;

                //look for negative j
                while (j < inputArray.length && inputArray[j] > 0) {
                    j++;
                }

                //swap if i < j
                if (j < inputArray.length && inputArray[j] < 0 && inputArray[i] > 0) {
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[j];
                    inputArray[j] = temp;
                }

            }
        }

        //print array
        printString = "";
        for (int each : inputArray) {
            printString = printString + each + " ";
        }
        System.out.println(printString.trim());

    }
}

