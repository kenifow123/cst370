/*
 * INSTRUCTION:
 *     This is a Java starting code for hw2_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw2_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Main_hw2_2.java
 * Abstract: reads elements of set, display all possible decimal numbers, corresponding binary numbers, and subsets
 * Name: Kenneth Ao
 * Date: 9/12/2023
 */

import java.util.*;

class Main
{
    public static void main(String[] args) {
        int binaryLength;
        int count = 0;
        int currBinary, endBinary;
        String printString = "";

        //get input binary length and words to use
        Scanner scanner = new Scanner(System.in);
        binaryLength = scanner.nextInt();

        //print and end program if first input is 0
        if (binaryLength == 0) {
            System.out.println("0:0:EMPTY");
            return;
        }

        scanner.nextLine();
        String inputString = scanner.nextLine();
        String[] inputArray = inputString.split(" ");
        String binaryString = "";
        String endString = "";

        //create binary strings
        for (int i=0; i<binaryLength; i++) {
            binaryString = binaryString + "0";
            endString = endString + "1";
        }

        //get integer of binary string
        currBinary = Integer.parseInt(binaryString, 2);
        endBinary = Integer.parseInt(endString, 2);

        //print first as empty
        System.out.println(String.format("%d:%s:EMPTY", count, binaryString).replace(" ", "0"));

        //continue adding 1 and printing until reach end binary
        while (currBinary != endBinary) {
            count++;
            currBinary += 1;

            //
            binaryString = String.format("%" + binaryLength + "s", Integer.toBinaryString(currBinary).replace(" ", "0"));

            for (int i=0; i<inputArray.length; i++) {
                if (binaryString.charAt(i) == '1') {
                    printString = printString + inputArray[i] + " ";
                }
            }
            printString = printString.trim();

            System.out.println(String.format("%d:%" + binaryLength + "s:%s", count, binaryString.replace(" ", "0"), printString));

            printString = "";
        }

    }
}

