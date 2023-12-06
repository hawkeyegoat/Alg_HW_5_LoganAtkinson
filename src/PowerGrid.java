import java.util.*;

public class PowerGrid {

    SimpleGraph myGraph;
    ArrayList optimalSet;
    PowerGrid() {
        myGraph = new SimpleGraph();
        GraphInput.LoadSimpleGraph(myGraph);
    }
    public static void main(String[] args) {
//        SimpleGraph temp = new SimpleGraph();
//        GraphInput.LoadSimpleGraph(temp);
        PowerGrid power = new PowerGrid();
        power.kruskal(power.myGraph);
    }
    public Set<Edge> kruskal(SimpleGraph graph) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        minHeap.addAll(graph.edgeList);
        for(Object v : graph.vertexList) {
            //v = (Vertex) v;
            ((Vertex) v).setData(((Vertex) v).getName()); //maybe this will work
        }
        while(!minHeap.isEmpty()) {
            // for all edges {u, v}

            // if (find(u != find(v) {
            //if()
            // add edge to optimalSet
            // union(u, v)
            // }
        }
        return null; //TEMP
    }

    // Helper methods for find and union
    //going to try and use vertex data to store parent, similar to the uptree pointing at itself for find
//    public int find(Vertex x) {
////        ListIterator iterator = myGraph.edgeList.listIterator();
////        while (iterator.hasNext()) {
////            if (x = iterator.)
////        }
//        x.getData();
//    }

}
