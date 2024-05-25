import java.util.ArrayList;
import java.util.Scanner;

public class Graphs_2_Depth_First_Search {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph=returnAdjacencyList();
        ArrayList<Integer> dfsResult=new ArrayList<>();
        boolean[] visited=new boolean[8];

        DFS(graph, dfsResult, 0, visited);

        System.out.println(dfsResult);
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

    static void DFS(ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> dfsResult, int source, boolean[] visited){
        dfsResult.add(source);
        visited[source]=true;

        for(int neighbour: graph.get(source)) {
            if(!visited[neighbour]) DFS(graph, dfsResult, neighbour, visited);
        }
    }
}
