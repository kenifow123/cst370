/*
 * INSTRUCTION:
 *     This is a Java starting code for hw2_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw2_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Main_hw2_1.java
 * Abstract: reads two timestamps of two events, displays difference between two timestamps
 * Name: Kenneth Ao
 * Date: 9/12/2023
 */

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.*;

class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = 0, minutes = 0, seconds = 0, carry = 0;
        String firstTimestamp, secondTimeStamp;
        firstTimestamp = scanner.nextLine();
        secondTimeStamp = scanner.nextLine();

        String[] firstTimeArray = firstTimestamp.split(":");
        String[] secondTimeArray = secondTimeStamp.split(":");

        //get seconds
        int currSec = Integer.parseInt(firstTimeArray[2]);
        int endSec = Integer.parseInt(secondTimeArray[2]);
        while (currSec != endSec) {
            seconds += 1;
            currSec += 1;
            if (currSec == 60) {
                currSec = 0;
                carry = 1;
            }
        }

        //get minutes
        int currMin = Integer.parseInt(firstTimeArray[1]) + carry;
        carry = 0;
        int endMin = Integer.parseInt(secondTimeArray[1]);
        while (currMin != endMin) {
            minutes += 1;
            currMin += 1;
            if (currMin == 60) {
                currMin = 0;
                carry = 1;
            }
        }

        //get hours
        int currHour = Integer.parseInt(firstTimeArray[0]) + carry;
        carry = 0;
        int endHour = Integer.parseInt(secondTimeArray[0]);
        while (currHour != endHour) {
            hours += 1;
            currHour += 1;
            if (currHour == 24) {
                currHour = 0;
                carry = 1;
            }
        }

        System.out.println(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }
}

