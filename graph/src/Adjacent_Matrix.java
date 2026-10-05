import java.util.Scanner;
public class Adjacent_Matrix {
    int v;
    int adjMat[][];

    public Adjacent_Matrix(int vertices) {
        this.v=vertices;
        adjMat=new int[v][v];
    }

    public void addEdge(int src, int dest) {
        if(src>=0 && dest>=0 && dest<v){
            adjMat[src][dest]=1;
            adjMat[dest][src]=1;
        }
    }
    public void printMatrix() {
        for(int i=0; i<v; i++) {
            for(int j=0; j<v; j++) {
                System.out.print(adjMat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int vertices=sc.nextInt();
        Adjacent_Matrix graph =new Adjacent_Matrix(vertices);

        int edges=sc.nextInt();
        for(int i=0; i<edges; i++) {
            int src=sc.nextInt();
            int dest=sc.nextInt();
            graph.addEdge(src, dest);
        }
        graph.printMatrix();
    }
}
