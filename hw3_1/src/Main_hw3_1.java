/*
 * INSTRUCTION:
 *     This is a Java starting code for hw3_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw3_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Main_hw3_1.java
 * Abstract: display input numbers in ascending order
 * Name: Kenneth Ao
 * Date: 9/19/2023
 */

import com.sun.tools.jconsole.JConsoleContext;

import java.util.*;

class Main
{
    public static int consecutiveCheck(int[] inputArray, int currIndex) {
        //find last index of consecutive numbers in array
        if (currIndex != inputArray.length - 1 && inputArray[currIndex] + 1 == inputArray[currIndex + 1]) {
            return consecutiveCheck(inputArray, currIndex + 1);
        }
        return currIndex;
    }

    public static void main(String[] args) {
        //get input numbers
        int arrayLength = 0;
        Scanner scanner = new Scanner(System.in);
        arrayLength = scanner.nextInt();
        scanner.nextLine();
        int[] inputArray = new int[arrayLength];

        //get array length
        for (int i = 0; i < arrayLength; i++) {
            inputArray[i] = scanner.nextInt();
        }

        Arrays.sort(inputArray);
        String printString = "";
        int currIndex = 0;
        int consecutiveLastIndex = 0;

        //iterate array to create string
        for (int i = 0; i < arrayLength; i++) {
            currIndex = i;
            consecutiveLastIndex = consecutiveCheck(inputArray, currIndex);

            //next number not consecutive
            if (i == consecutiveLastIndex) {
                printString = printString + String.format(" %d", inputArray[i]);
            } else {
                //consecutive numbers found
                printString = printString + String.format(" %d-%d", inputArray[i], inputArray[consecutiveLastIndex]);
                i = consecutiveLastIndex;
            }
        }

        System.out.println(printString.trim());
    }
}

