package com.spoj.mitemitreski.mitemitreski.PT07Y;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*

3 2
1 2
2 3



9 8
7 8
2 3
8 3
6 3
5 3
7 9
9 1
9 4

YES


9 8
1 2
2 3
3 4
1 4
5 6
7 8
9 7
8 9
NO

 */
public class Main {
    static class Graph {

        public static int V;
        public static int edges;
        public static ArrayList<ArrayList<Integer>> adjMatrix;

        public Graph(int V) {
            edges = 0;
            this.V = V;
            adjMatrix = new ArrayList<ArrayList<Integer>>(V);
            for (int i = 0; i < V; i++)
                adjMatrix.add(new ArrayList<Integer>());
        }


        static void dfsTraversal(int v, boolean[] visited, int parent) {
            // Mark the current node as visited
            visited[v] = true;


            for (int i : adjMatrix.get(v)) {

                if (!visited[i]) {
                    dfsTraversal(i, visited, v);
                }
            }
        }

        public static void addEdge(int v, int w) {
            edges++;
            adjMatrix.get(w).add(v);
            adjMatrix.get(v).add(w);
        }

        public static boolean isConnected() {
            // Mark all the vertices as not visited and not part
            // of recursion stack
            boolean[] visited = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;


            dfsTraversal(0, visited, -1);


            for (int u = 0; u < V; u++)
                if (!visited[u])
                    return false;

            return true;
        }

        public static boolean isTree() {

            return isConnected() && edges == V - 1;
        }

        // A utility function to print the adjacency list

        static void printGraph() {
            for (int i = 0; i < adjMatrix.size(); i++) {
                System.out.println("\n List of vertex" + i);
                System.out.print("h");
                for (int j = 0; j < adjMatrix.get(i).size(); j++) {
                    System.out.print(" -> " + adjMatrix.get(i).get(j));
                }
                System.out.println();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] firstLine = reader.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        Graph graph = new Graph(N);

        for (int i = 0; i < M; i++) {
            String[] row = reader.readLine().split(" ");
            int u = Integer.parseInt(row[0]);
            int v = Integer.parseInt(row[1]);
            Graph.addEdge(u - 1, v - 1);

        }

        if (Graph.isTree()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }


}


