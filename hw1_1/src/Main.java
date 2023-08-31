/*
 * INSTRUCTION:
 *     This is a Java staring code for hw1_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw1_1.java". Please DO NOT change
 *     the name of the main class "Main"
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Main_hw1_1.java
 * Abstract: Display closest distance between two numbers among all input numbers
 * Name: Kenneth Ao
 * Date: 9/5/2023
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //get total numbers
        int array_length = scanner.nextInt();
        int[] numbers = new int[array_length];
        int number;

        //get numbers
        for (int i = 0; i < array_length; i++) {
            number = scanner.nextInt();
            numbers[i] = number;
        }

        Arrays.sort(numbers);

        int firstIndex = 0;
        int secondIndex = 1;
        int minDistance = Math.abs(numbers[firstIndex] - numbers[secondIndex]);
        int currDistance;

        //get minDistance of all numbers
        for (int i = 0;i < array_length; i++) {
            for (int j = i+1; j < array_length; j++) {
                currDistance = Math.abs(numbers[i] - numbers[j]);
                if (currDistance < minDistance) {
                    minDistance = currDistance;
                }
            }
        }

        System.out.println("Min Distance:" + minDistance);

        //print pairs that have minDistance
        for (int i = 0;i < array_length; i++) {
            for (int j = i+1; j < array_length; j++) {
                currDistance = Math.abs(numbers[i] - numbers[j]);
                if (currDistance == minDistance) {
                    firstIndex = i;
                    secondIndex = j;
                    if (numbers[firstIndex] > numbers[secondIndex]) {
                        System.out.println(String.format("Pair:%d %d", numbers[secondIndex], numbers[firstIndex]));

                    } else {
                        System.out.println(String.format("Pair:%d %d", numbers[firstIndex], numbers[secondIndex]));
                    }
                }
            }
        }
    }
}
