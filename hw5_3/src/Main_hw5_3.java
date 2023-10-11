/*
 * INSTRUCTION:
 *     This is a Java starting code for hw5_3.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw5_3.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Main_hw5_3.java
 * Abstract: simulate linear probing in hashtable, commands to insert, displayStatus, tableSize, and search
 * Name: Kenneth Ao
 * Date: 10/10/2023
 * Comments: isPrime(): https://www.educative.io/answers/how-to-check-if-a-number-is-prime-in-java
 */

import java.util.*;

class Main
{
    public static void printArray(int[] array) {
        //print array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static boolean isPrime(int num) {
        //https://www.educative.io/answers/how-to-check-if-a-number-is-prime-in-java

        if(num<=1)
        {
            return false;
        }
        for(int i=2;i<=num/2;i++)
        {
            if((num%i)==0)
                return  false;
        }
        return true;
    }

    public static void displayStatus(String command, int[] hashTable) {
        //display value at the given hash, "Empty" if none
        String[] commandArray = command.split(" ");
        int hash = Integer.parseInt(commandArray[1]);
        int value = hashTable[hash];

        if (value == 0) {
            System.out.println("Empty");
        } else {

            System.out.println(hashTable[hash]);
        }
    }

    public static int[] checkLoadFactor(int[] hashTable) {
        //get load factor
        int totalKeys = 0;
        int[] newHashTable;
        for (int each : hashTable) {
            if (each != 0) {
                totalKeys++;
            }
        }

        double loadFactor = (double)totalKeys / hashTable.length;

        //rehash if loadfactor too large
        if (loadFactor > 0.5) {
            hashTable = rehash(hashTable);
        }

        return hashTable;
    }

    public static int[] rehash(int[] hashTable) {
        //rehash if loadFactor > 0.5
        int[] newHashTable;
        int newSize = hashTable.length * 2;
        while (!isPrime(newSize)) {
            //https://www.educative.io/answers/how-to-check-if-a-number-is-prime-in-java
            newSize++;
        }
        newHashTable = new int[newSize];

        for (int each : hashTable) {
            if (each != 0) {
                newHashTable = insert(each, newHashTable);
            }
        }
        return newHashTable;

    }

    public static int[] insert(int key, int[] hashTable) {
        //insert key
        int size = hashTable.length;
        int hash = key % size;

        //keep incrementing index until find empty
        while (hashTable[hash] != 0) {
            hash = (hash + 1) % size;
        }
        if (hashTable[hash] == 0) {
            hashTable[hash] = key;
        }

        return hashTable;
    }

    public static boolean search(int key, int[] hashTable) {
        //search for key starting from hash
        int hash = key % hashTable.length;

        //if reach a 0 and still haven't found key, key is not in hashTable
        while (hashTable[hash] != key && hashTable[hash] != 0) {
            hash = (hash + 1) % hashTable.length;
        }
        if (hashTable[hash] == key) {
            return true;
        }

        return false;
    }

    public static int[] doCommand(String command, int[] hashTable) {
        //chooses command

        if (command.startsWith("displayStatus")) {
            displayStatus(command, hashTable);

        } else if (command.startsWith("insert")) {
            String[] commandArray = command.split(" ");
            int key = Integer.parseInt(commandArray[1]);
            hashTable = insert(key, hashTable);

            //check if need to rehash after inserting
            hashTable = checkLoadFactor(hashTable);

        } else if (command.equals("tableSize")) {
            System.out.println(hashTable.length);

        } else if (command.startsWith("search")) {
            String[] commandArray = command.split(" ");
            int key = Integer.parseInt(commandArray[1]);
            if (search(key, hashTable)) {
                System.out.println(key + " Found");
            } else {
                System.out.println(key + " Not found");
            }
        }

        return hashTable;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hashSize = scanner.nextInt();
        int totalCommands = scanner.nextInt();
        scanner.nextLine();

        String[] commandsArray = new String[totalCommands];

        for (int i = 0; i < totalCommands; i++) {
            String command = scanner.nextLine();
            commandsArray[i] = command;
        }

        int[] hashTable = new int[hashSize];

        for (String each : commandsArray) {
            each = each.trim();
            hashTable = doCommand(each, hashTable);
        }


    }
}

