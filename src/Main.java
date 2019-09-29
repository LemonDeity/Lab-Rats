import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Main {
    public static void main(String[] args)throws IOException {
        //Rats Judge Case 02 - INPUT.txt
        Scanner input = new Scanner(new File("Rats Judge Case 08 - INPUT.txt"));

        int NUM_TEST = input.nextInt();
        input.nextLine();
        input.nextLine();

        /*for (int i = 0; i < NUM_TEST; i++) {

        }*/
        //Number of Nodes goes from 1 to NUM_NODES
        int NUM_NODES = input.nextInt();
        input.nextLine();

        Graph graph = new Graph();
        for (int i = 0; i < NUM_NODES; i++) {
            graph.addNode(new Node(i+1));
        }

        int Exit = input.nextInt();
        input.nextLine();
        int Timer = input.nextInt();
        input.nextLine();
        int NUM_CONNECTIONS = input.nextInt();
        input.nextLine();

        //connections are formatted as a b l
        //Node a goes to b by length l

        //This loop creates the Graph
        for (int i = 0; i < NUM_CONNECTIONS; i++) {
            String str = input.nextLine();
            graph.addConnection(formatCon(str));
        }

        System.out.println(graph.Dijkstra(Exit,Timer));
        System.out.println();

    }

    public static int[] formatCon(String str){
        String[] arr = str.split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        return nums;
    }

}
