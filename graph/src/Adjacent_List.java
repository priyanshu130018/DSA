import java.util.ArrayList;
import java.util.Scanner;

public class Adjacent_List {
    int v;
    ArrayList<ArrayList<Integer>>adjList;
    Adjacent_List(int c){
        this.v=v;
        adjList=new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<v; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    public void addEdge(int src, int dest) {
        if(src>=0 && dest>=0 && dest<v){
            adjList.get(src).add(dest);
        }
    }
    public void printList() {
        for(int i=0; i<v; i++) {
            System.out.print("Neighbour's of a"+i+"->");
            for(int neighbour : adjList.get(i)) {
                System.out.print(neighbour+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int vertices=sc.nextInt();

        Adjacent_List graph =new Adjacent_List(vertices);
        int edges=sc.nextInt();
        for(int i=0; i<edges; i++) {
            graph.addEdge(sc.nextInt(),sc.nextInt());
        }
        sc.close();
        graph.printList();
    }
}
