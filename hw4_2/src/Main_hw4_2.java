/*
 * INSTRUCTION:
 *     This is a Java starting code for hw4_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw4_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Main_hw4_2.java
 * Abstract: display biggest number in array using divide and conquer
 * Name: Kenneth Ao
 * Date: 10/3/2023
 */

import java.util.Scanner;

class Main
{
    //third party code - https://replit.com/@fjia/sumdivNconqcpp#main.cpp
    public static int findMax(int[] inputArray, int startIndex, int endIndex) {
        //recursive, divide and conquer
        if (startIndex == endIndex) {
            return inputArray[startIndex];
        } else {
            int max1 = findMax(inputArray, startIndex, (startIndex+endIndex)/2);
            int max2 = findMax(inputArray, (startIndex+endIndex)/2+1, endIndex);
            return Math.max(max1, max2);

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalValues = scanner.nextInt();
        scanner.nextLine();
        String inputString = scanner.nextLine();

        String[] splitString = inputString.split(" ");
        int[] inputArray = new int[totalValues];
        int max = 0;

        //convert string to int
        for (int i = 0; i < totalValues; i++) {
            inputArray[i] = Integer.parseInt(splitString[i]);
        }

//        max = Math.max(max, inputArray[0]);
        max = findMax(inputArray, 0, inputArray.length - 1);

        System.out.println(max);

    }
}

