/*
 * INSTRUCTION:
 *     This is a Java starting code for hw1_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw1_2.java". Please DO NOT change
 *     the name of the main class "Main"
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Main_hw1_2.java
 * Abstract: check if input string is palindrome
 * Name: Kenneth Ao
 * Date: 09/05/2023
 */

import java.util.*;

class Main
{
    public static void main(String[] args) {
        // Develop your program here.
        // The following is just a sample statement.
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String newString = "";

        String palindromeCheck = "TRUE";

        // create new string with no symbols
        for (char c : inputString.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                newString = newString + c;
            }
        }

        newString = newString.toLowerCase();

        //check if opposite char is the same
        for (int i = 0; i < newString.length() / 2; i++) {
            if (newString.charAt(i) != newString.charAt(newString.length() - 1 - i)) {
                palindromeCheck = "FALSE";
                break;
            }
        }

        System.out.println(palindromeCheck);
    }
}

