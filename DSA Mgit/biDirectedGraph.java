
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class biDirectedGraph {
    public static void main(String[] args) {
        // Graph g = new Graph();
        // g.addEdge(1, 2);
        // g.addEdge(1, 3);
        // g.addEdge(2, 4);

        // g.printAdjacencyMatrix();

        // g.bfsTraversal(1);

        // g.minimumDistance(1, 4);

        // g.parentNode(1, 4);

        // g.parentNodeList(1);

        // g.dfsTraversal(1);

        int[][] matrix={
            {1,1,0,0,0},
            {0,1,0,0,1},
            {1,0,0,1,1},
            {0,0,0,0,0},
            {1,0,1,0,0}
        };

        int result=islandCounting(matrix);
        System.out.println(result);
    }
}

class Cell {
    int row, col;

    Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Graph {
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

    void addEdge(int source, int destination) {
        // Adding a new Edge from source to destination.
        if (this.graph.containsKey(source)) {
            this.graph.get(source).add(destination);
        } else {
            this.graph.put(source, new ArrayList<Integer>());
            this.graph.get(source).add(destination);
        }

        // Adding a new Edge from destination to source.
        if (this.graph.containsKey(destination)) {
            this.graph.get(destination).add(source);
        } else {
            this.graph.put(destination, new ArrayList<Integer>());
            this.graph.get(destination).add(source);
        }
    }

    void printAdjacencyMatrix() {
        System.out.println(this.graph);
    }

    void bfsTraversal(int start) {
        // In BFS We pick all the adjacent elements to the vertex. We insert the newly
        // visited elements into the queue and delete their parent node/previous node
        // from the front end of the queue.

        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Boolean> isVisited = new HashMap<>();
        ;

        for (int vertex : this.graph.keySet()) {
            isVisited.put(vertex, false);
        }

        queue.add(start);
        isVisited.put(start, true);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.println("temp=" + temp + " ");
            for (int nbr : graph.get(temp)) {
                if (isVisited.get(nbr) != true) {
                    queue.add(nbr);
                    isVisited.put(nbr, true);
                }
                // System.out.println(queue);
            }
        }
    }

    void minimumDistance(int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Boolean> isVisited = new HashMap<>();
        Map<Integer, Integer> distance = new HashMap<>();

        for (int vertex : this.graph.keySet()) {
            isVisited.put(vertex, false);
        }

        queue.add(start);
        isVisited.put(start, true);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            // System.out.println("temp="+temp+" ");
            for (int nbr : graph.get(temp)) {
                if (isVisited.get(nbr) != true) {
                    queue.add(nbr);
                    isVisited.put(nbr, true);
                    distance.put(nbr, distance.get(temp) + 1);
                    System.out.println("distance array" + distance);
                    if (nbr == end) {
                        System.out.println("Distance from start to end=" + distance.get(nbr));
                        return;
                    }
                }
                // System.out.println(queue);
            }
        }
    }

    void parentNode(int start, int child) {
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Boolean> isVisited = new HashMap<>();
        ;

        for (int vertex : this.graph.keySet()) {
            isVisited.put(vertex, false);
        }

        queue.add(start);
        isVisited.put(start, true);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.println("temp=" + temp + " ");
            for (int nbr : graph.get(temp)) {
                if (isVisited.get(nbr) != true) {
                    queue.add(nbr);
                    isVisited.put(nbr, true);

                    if (nbr == child) {
                        System.out.println("Parent is " + temp);
                    }
                }
                // System.out.println(queue);
            }
        }
    }

    void parentNodeList(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Boolean> isVisited = new HashMap<>();
        ;
        Map<Integer, Integer> parents = new HashMap<>();

        for (int vertex : this.graph.keySet()) {
            isVisited.put(vertex, false);
        }

        queue.add(start);
        isVisited.put(start, true);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.println("temp=" + temp + " ");
            for (int nbr : graph.get(temp)) {
                if (isVisited.get(nbr) != true) {
                    queue.add(nbr);
                    isVisited.put(nbr, true);

                    parents.put(nbr, temp);
                }
                // System.out.println(queue);
            }
        }

        System.out.println(parents);
    }

    void dfsTraversal(int start) {
        // In DFS, We pick only one adjacent element. As we traverse through the graph
        // one by one by inserting any of the adjacent elements into the stack, When we
        // don't have any new unvisited elements, We backtrack to the previously visited
        // elements until the stack is empty.

        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Boolean> isVisited = new HashMap<Integer, Boolean>();

        for (int vertex : this.graph.keySet()) {
            isVisited.put(vertex, false);
        }

        stack.push(start);
        isVisited.put(start, true);

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            System.out.println(temp);
            for (int nbr : this.graph.get(temp)) {
                if (!isVisited.get(nbr)) {
                    stack.push(nbr);
                    isVisited.put(nbr, true);
                    // continue;
                }
            }
        }

        // Finding number of islands, DFS important question.
    }

    static int islandCounting(int[][] matrix) {
        int counter = 0;
        int rows = matrix.length, cols = matrix[0].length;

        boolean[][] isVisited = new boolean[rows][cols];

        int[] deltaRow={-1, 0, 1, 0};
        int[] deltaColumn={0, 1, 0, -1};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!isVisited[row][col] && matrix[row][col] == 1) {
                    counter++;
                    bfs(row, col, matrix, isVisited, deltaRow, deltaColumn);
                }
            }
        }

        return counter;
    }

    static void bfs(int row, int col, int[][] matrix, boolean[][] isVisited, int[] deltaRow, int[] deltaColumn) {
        Queue<Cell> queue = new ArrayDeque<>();

        int r = matrix.length, c = matrix[0].length;

        queue.add(new Cell(row, col));
        isVisited[row][col] = true;

        while (!queue.isEmpty()) {
            Cell temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = temp.row+deltaRow[i], nCol = temp.col+deltaColumn[i];

                if (isValid(nRow, nCol, r, c) && !isVisited[nRow][nCol] && matrix[nRow][nCol] == 1) {
                    isVisited[nRow][nCol]=true;
                    bfs(nRow, nCol, matrix, isVisited, deltaRow, deltaColumn);
                }
            }
        }
    }

    static boolean isValid(int row, int col, int rows, int cols) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return true;
        }
        return false;
    }

    // int numberOfIslands(int[][] grid, int n, int m) {
    // HashMap<Integer, Integer> visitedIndices=new HashMap<Integer, Integer>();
    // int islands=0;

    // for(int i=0; i<n; i++) {
    // for(int j=0; j<m; j++) {
    // if(grid[i][j]==1) {
    // if(visitedIndices.containsKey(i)){
    // if(visitedIndices.get(i)==j) {
    // continue;
    // }
    // }
    // islands++;

    // // Start BFS From grid[i][j] and mark all ones as visited.
    // bfs(grid, n, m, i, j, visitedIndices);
    // }
    // }
    // }

    // return islands;
    // }

    // static void bfs(int[][] grid, int n, int m, int i, int j, HashMap<Integer,
    // Integer> visitedIndices) {
    // Queue<Integer> queue=new ArrayDeque<>();
    // Map<Integer, Boolean> isVisited=new HashMap<>();;

    // // for(int vertex: this.graph.keySet()) {
    // // isVisited.put(vertex, false);
    // // }

    // }
}