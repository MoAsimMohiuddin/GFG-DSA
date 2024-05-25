import java.util.ArrayList;
import java.util.Scanner;

public class Graphs_1_Implementation_Using_AdjacencyList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result=returnAdjacencyList();
        System.out.println(result);

        addEdge(result, 2, 3);
        System.out.println(result);
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

    static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int fromVertex, int toVertex) {
        adjacencyList.get(fromVertex).add(toVertex);
        adjacencyList.get(toVertex).add(fromVertex);
    }
}
