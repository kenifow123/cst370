/*
 * INSTRUCTION:
 *     This is a Java starting code for hw3_3.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw3_3.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Main_hw3_3.java
 * Abstract: use DFS to create mark array from input vertices and edges
 * Name: Kenneth Ao
 * Date: 9/19/2023
 */
import java.util.*;

class Main
{
    public static int count = 1;

    //recursive dfs, fills markArray
    public static int[] dfs(int[][]matrix, int[]markArray, int startIndex) {
        //if markArray at index is unvisited, 0 = unvisited, positive number = order it was visited
        if (markArray[startIndex] < 1) {
            markArray[startIndex] = count;
            count++;

            //look for edge from current vertex
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[startIndex][i] == 1) {
                    dfs(matrix, markArray, i);
                }
            }
        }
        //return if already visited
        return markArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalVertices = scanner.nextInt();
        int totalEdges = scanner.nextInt();
        scanner.nextLine();
        String edgeString;
        String[] edge;
        int first, second;
        int[][] matrix = new int[totalVertices][totalVertices];
        int[] markArray = new int[totalVertices];

        //fill adjacency matrix
        for (int i = 0; i < totalEdges; i++) {
            edgeString = scanner.nextLine();
            edge = edgeString.split(" ");
            first = Integer.parseInt(edge[0]);
            second = Integer.parseInt(edge[1]);
            matrix[first][second] = 1;

        }

        //         Print the adjacency matrix
//        for (int i = 0; i < totalVertices; i++) {
//            for (int j = 0; j < totalVertices; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }

        //start dfs traversal
        //always start 0
        markArray = dfs(matrix, markArray, 0);

        //print markArray
        for (int i = 0; i < markArray.length; i++) {
            System.out.println(String.format("Mark[%d]:%d", i, markArray[i]));
        }
    }
}

