import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graphs_2_Breadth_First_Search {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph=returnAdjacencyList();
        BFSForDisconnectedGraph(graph, 15);
    }

    static ArrayList<ArrayList<Integer>> returnAdjacencyList() {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of vertices");
        int vertices=sc.nextInt();

        for(int i=0; i<vertices; i++) {
            ArrayList<Integer> edgeList=new ArrayList<>();
            System.out.println("Enter the number of edges for "+i+" vertex");
            int edges=sc.nextInt();

            for(int e=0; e<edges; e++) {
                System.out.println("Enter the "+(e+1)+" edge");
                int edge=sc.nextInt();

                edgeList.add(edge);
            }

            result.add(edgeList);
        }

        sc.close();

        return result;
    }

    static void BFS(ArrayList<ArrayList<Integer>> graph, int source, int vertices) {
        Queue<Integer> bfsQueue=new LinkedList<>();
        boolean[] visited=new boolean[vertices];

        bfsQueue.add(source);

        System.out.println("BREADTH FIRST SEARCH TRAVERSAL");
        while(!bfsQueue.isEmpty()) {
            int poppedElement=bfsQueue.poll();
            visited[poppedElement]=true;

            for(int i: graph.get(poppedElement)) {
                if(!visited[i]) {
                    visited[i]=true;
                    bfsQueue.add(i);
                }
            }

            System.out.println(poppedElement);
        }
    }

    static void BFSForDisconnectedGraph(ArrayList<ArrayList<Integer>> graph, int vertices) {
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[vertices];
        int numberOfConnectedComponents=1;

        queue.add(0);

        System.out.println("BREADTH FIRST SEARCH TRAVERSAL");
        while(!queue.isEmpty()) {
            int poppedElement=queue.poll();
            visited[poppedElement]=true;

            System.out.println(poppedElement);
            for(int k: graph.get(poppedElement)) {
                if(!visited[k]) {
                    visited[k]=true;
                    queue.add(k);
                }
            }

            if(queue.isEmpty() && visitedHasUnvisitedElements(visited)) {
                System.out.println("NEW SUB GRAPH");
                numberOfConnectedComponents++;
                for(int i=0; i<vertices; i++) {
                    if(!visited[i]) {
                        queue.add(i);
                        break;
                    }
                }
            }
        }

        System.out.println("NUMBER OF CONNECTED COMPONENTS="+numberOfConnectedComponents);
    }

    static boolean visitedHasUnvisitedElements(boolean[] visited) {
        for(boolean bool: visited) {
            if(!bool) {
                return true;
            }
        }

        return false;
    }
}
