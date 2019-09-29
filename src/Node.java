import java.util.ArrayList;
public class Node implements Comparable<Node>{
    int NUM;
    private int cost;
    Node previous;
    ArrayList<Edge> connections;
    public Node(int NUM){
        this.NUM = NUM;
        cost = 10000;
        connections = new ArrayList<>();
        previous = null;
    }

    public void updateCost(int cost){
        this.cost = cost;
    }

    public void updatePrevious(Node n){
        previous = n;
    }

    public int getCost(){
        return cost;
    }

    //This method will tell if a Node is directly connected tp a Node
    public boolean connected(Node n){
        for(Edge k : connections){
            if(k.contains(n)){
                return true;
            }
        }
        return false;
    }

    private boolean containsEdge(Edge e){
        for(Edge k : connections){
            if (k == e){
                return true;
            }
        }
        return false;
    }

    public void addConn(Edge e){
        connections.add(e);
    }
    //returns Edge with least cost
    //need to be aware of case where there is nothing in connections
    public Edge getLeastEdge(){
        if (connections.size() == 0){
            return null;
        }
        Edge least = connections.get(0);
        for(Edge e : connections){
            if (e.length < least.length){
                least = e;
            }
        }
        return least;
    }

    public int compareTo(Node n){
        if (cost < n.getCost()){
            return -1;
        }else if(cost > n.getCost()){
            return 1;
        }
        return 0;
    }

    public String toString(){
        String str = NUM+" Cost: "+cost+" via ";
        if (previous == null){
            str += "null";
        }else{
            str += previous.NUM;
        }
        return str;
    }
}
