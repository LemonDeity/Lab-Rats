import java.util.PriorityQueue;
import java.util.ArrayList;
public class Graph {
    ArrayList<Node> graph;
    ArrayList<Node> finished;
    public Graph(){
        graph = new ArrayList<>();
        finished = new ArrayList<>();
    }

    public boolean contains(int num){
        for(Node n : graph){
            if (n.NUM == num){
                return true;
            }
        }
        return false;
    }

    public boolean contains(Node n){
        return contains(n.NUM);
    }

    public Node get(int num){
        for(Node n : graph){
            if (n.NUM == num){
                return n;
            }
        }
        return null;
    }

    public Node get(Node n){
        return get(n.NUM);
    }

    public void addNode(Node n){
        graph.add(n);
    }

    public void addConnection(int[] arr){
        // [0,1,2]
        //creates a new edge and adds it to the first node
        Node f = get(arr[0]);
        Node s = get(arr[1]);
        Edge e = new Edge(f,s,arr[2]);
        get(arr[0]).addConn(e);
    }

    public void printList(){
        for (Node n : graph){
            System.out.println(n);
        }
    }

    //This will return the number of mice that will make it out of the maze
    public int Dijkstra(int Exit ,int time){
        //number of mice that make it out of Maze in time
        int out = 0;

        for(Node n : graph){
            Dijkstra(n.NUM);
            if (get(Exit).getCost() <= time){
                out++;
            }
        }

        return out;
    }
    //this assigns the cost to each Node from exit
    //Node has instance variable called cost
    private void Dijkstra(int Exit){
        //for loop starting at exit and going through list of nodes assigning cost
        PriorityQueue<Node> queue = new PriorityQueue<>();
        finished = new ArrayList<>();
        for(Node n : graph){
            n.updateCost(1000);
            n.updatePrevious(null);
        }

        //this is to make sure the source is the exit
        get(Exit).updateCost(0);

        for(Node n : graph){
            queue.add(n);
        }

        while(!queue.isEmpty()){
            Node n1 = queue.remove();
            finished.add(n1);
            ArrayList<Edge> update = n1.connections;
            for(Edge e : update){
                Node other = e.getOther(n1.NUM);
                //only if it isn't in finished
                if (!finished.contains(other)){
                    if (other.getCost() > n1.getCost()+e.getLength()){
                        queue.remove(other);
                        other.updateCost(n1.getCost()+e.getLength());
                        other.updatePrevious(n1);
                        queue.add(other);
                    }
                }
            }
        }
    }
}
