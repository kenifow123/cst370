/*
 * INSTRUCTION:
 *     This is a Java starting code for hw4_3.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw4_3.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Main_hw4_3.java
 * Abstract: topological sorting based on Kahn algo
 * Name: Kenneth Ao
 * Date: 10/3/2023
 */

import java.util.*;

class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalVertices = scanner.nextInt();
        int totalEdges = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[totalVertices][totalVertices];

        //add edges to matrix
        for (int i = 0; i < totalEdges; i++) {
            String inputString = scanner.nextLine();
            String[] stringArray = inputString.split(" ");
            int vertex1 = Integer.parseInt(stringArray[0]);
            int vertex2 = Integer.parseInt(stringArray[1]);

            matrix[vertex1][vertex2] = 1;
        }

        //         Print the adjacency matrix
//        for (int i = 0; i < totalVertices; i++) {
//            for (int j = 0; j < totalVertices; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }

        int[] markArray = new int[totalVertices];

        //fill in degree
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    markArray[j] = markArray[j] + 1;
                }
            }
        }

        //print markArray
        for (int i=0; i < markArray.length; i++) {
            System.out.println(String.format("In-degree[%d]:%d", i, markArray[i]));
        }

        //initiate queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < markArray.length; i++) {
            if (markArray[i] == 0) {
                queue.offer(i);
            }
        }

        if (queue.isEmpty()) {
            System.out.println("No Order:");
        }

        int count = 0;
        int removedVertex;
        int[] topologicalArray = new int[totalVertices];

        //topological sort
        while (!queue.isEmpty()) {
            removedVertex = queue.poll();
            topologicalArray[count] = removedVertex;
            count++;

            //subtract 1 from vertices adjacent to the removedVertex
            for (int i =0; i < markArray.length; i++) {
                if (matrix[removedVertex][i] == 1) {
                    markArray[i] = markArray[i] - 1;
                    if (markArray[i] == 0) {
                        queue.offer(i);
                    }
                }
            }

        }

//        //check for cycle
//        if (count != totalVertices) {
//            System.out.println("cycle detected");
//        }

        //print topological order
        String printString = "";
        for (int i = 0; i < topologicalArray.length; i++) {
            printString = printString + topologicalArray[i] + " ";
        }
        printString = printString.trim();
        printString = printString.replace(" ", "->");
        System.out.println(String.format("Order:%s",printString));

    }
}

