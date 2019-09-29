public class Edge {
    int length;
    Node a,b;

    public Edge(Node a, Node b, int length){
        this.a = a;
        this.b = b;
        this.length = length;
    }

    public int getLength(){
        return length;
    }
    //returns whether or not this edge contains the Node in the parameter
    public boolean contains(Node n){
        if (n == a || n == b){
            return true;
        }
        return false;
    }

    public Node getOther(int num){
        if (a.NUM == num){
            return b;
        }else if(b.NUM == num){
            return a;
        }
        return null;
    }

    public String toString(){
        String str = "";
        str += ""+a.NUM+" "+b.NUM+" Length: "+length;
        return str;
    }


}
