/*
 * INSTRUCTION:
 *     This is a Java starting code for hw3_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw3_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Main_hw3_2.java
 * Abstract: present path for traveling salesman problem
 * Name: Kenneth Ao
 * Date: 9/19/2023
 */

import java.util.*;

class Main
{
    //third party code
    //https://replit.com/@fjia/JavaPermutations#Main.java
    public static List<int[]> Permute(int[] input, int startIndex, List<int[]> permutationsList) {

        int size = input.length;

        if (size == startIndex + 1)
        {
            permutationsList.add(Arrays.copyOf(input, input.length));
        }
        else
        {
            for (int i = startIndex; i < size; i++)
            {
                int temp = input[i];
                input[i] = input[startIndex];
                input[startIndex] = temp;

                permutationsList = Permute(input, startIndex + 1, permutationsList);
                temp = input[i];
                input[i] = input[startIndex];
                input[startIndex] = temp;
            }
        }

        return permutationsList;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numVertices = scanner.nextInt();
        int numEdges = scanner.nextInt();
        scanner.nextLine();

        //create adjacency matrix
        int[][]matrix = new int[numVertices][numVertices];

        String edgeString;

        for (int i = 0; i < numEdges; i ++) {
            edgeString = scanner.nextLine();
            String[] edgeSplit = edgeString.split(" ");
            matrix[Integer.parseInt(edgeSplit[0])][Integer.parseInt(edgeSplit[1])] = Integer.parseInt(edgeSplit[2]);

        }

        int startVertex = scanner.nextInt();

//         Print the adjacency matrix
//        for (int i = 0; i < numVertices; i++) {
//            for (int j = 0; j < numVertices; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }

        //permute
        int[] permuteArray;
        int count = 0;

        if (numVertices == 2) {
            permuteArray = new int[1];
        } else {
            permuteArray = new int[numVertices-1];
        }
        for (int i = 0; i < permuteArray.length; i++) {
            if (count == startVertex) {
                count++;
            }
            permuteArray[i] = count;
            count++;
        }
        List<int[]> permutationsList = new ArrayList<>();
        permutationsList = Permute(permuteArray, 0, permutationsList);

        //print permutationsList
//        for (int i = 0; i < permutationsList.size(); i++) {
//            int[] intArray = permutationsList.get(i);
//            for (int each : intArray) {
//                System.out.print(each + " ");
//            }
//            System.out.println();
//        }

        int minCost = 999;
        int currCost = 0;
        int[] bestPath = new int[numVertices+1];
        int firstVertex;
        int secondVertex;
        boolean skip = false;


        // get best path
        for (int[] permutationArray : permutationsList) {
            int[] currArray = new int[permutationArray.length + 2];
            //fill in first and last vertex = start vertex
            currArray[0] = startVertex;
            currArray[currArray.length-1] = startVertex;

            //fill currArray with curr permutation
            for (int i = 0; i < permutationArray.length; i++) {
                currArray[i+1] = permutationArray[i];
            }

            //add cost for current path
            for (int i = 0; i < currArray.length-1; i++) {
                firstVertex = currArray[i];
                secondVertex = currArray[i+1];
                if (matrix[firstVertex][secondVertex] == 0) {
                    skip = true;
                    break;
                }
                currCost += matrix[firstVertex][secondVertex];
            }
            //skip = found a permutation with nonexisting edge
            if (skip) {
                skip = false;
                currCost = 0;
                continue;
            }

            //compare current path and min path
            if (currCost < minCost) {
                bestPath = currArray;
                minCost = currCost;
            }
            currCost = 0;

        }

        //creating print
        String printString = String.format("Path:%d->", startVertex);
        for (int each : bestPath) {
            if (each != startVertex) {
                printString = printString + each + "->";
            }
        }
        printString = printString + startVertex;

        //print bestPath
//        for (int each: bestPath) {
//            System.out.print(each + " ");
//        }
//        System.out.println();

        //print this if no possible path found, noncyclic
        if (minCost == 999) {
            System.out.println("Path:");
            System.out.println("Cost:-1");


        } else {
            //print this if path possible
            System.out.println(printString);
            System.out.println("Cost:" + minCost);
        }

    }
}

