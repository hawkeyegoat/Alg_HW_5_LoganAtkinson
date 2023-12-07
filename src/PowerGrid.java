//import com.sun.source.tree.BinaryTree;

import java.util.*;

public class PowerGrid  {

    SimpleGraph myGraph;
    HashSet optimalSet = new HashSet<Edge>();
    HashSet verticesSet = new HashSet<Vertex>();

    //BinaryTree mainUpTree;
    double totalCost = 0;
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
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(new EdgeComparator());
        //while (myGraph.vertices().hasNext()) {
//        for(int i = 0; i < myGraph.numVertices(); i++) {
//            Vertex temp = (Vertex) myGraph.vertexList.get(i); //myGraph.vertices().next();
//            temp.setData(temp.getName());
//            //}
//        }

        minHeap.addAll(graph.edgeList);   // nlogn                                                                      // Add all edges from the graphs edgelist into minHeap

        //LinkedList vList = graph.vertexList;                                                                          //Copy values from
        for(Edge e : minHeap) {
//            v = (Vertex) v;
//            ((Vertex) v).setData(((Vertex) v).getName()); //maybe this will work
              e.getFirstEndpoint().setData(e.getFirstEndpoint().getName());
              e.getSecondEndpoint().setData(e.getSecondEndpoint().getName());
        }
        while(!minHeap.isEmpty()) { //&& optimalSet.size() < myGraph.numVertices() - 1) {
            //Object temp = minHeap.poll();
            //Edge tempE = (Edge) temp;
            Edge tempE =  minHeap.poll();
            // for all edges {u, v}

            // if (find(u != find(v) { , set u as first point v as second point of edge
            Vertex u = tempE.getFirstEndpoint();
            Vertex v = tempE.getSecondEndpoint();

            //if(optimalSet.contains(u) != optimalSet.contains(v)) {                                                    // similar to original but may not work
            //if (!optimalSet.contains(u) && !optimalSet.contains(v)) {
            //(verticesSet.contains(u) && !verticesSet.contains(v)) || (!verticesSet.contains(u) && !verticesSet.contains(v))
            //if ((!(verticesSet.contains(u)) ^ verticesSet.contains(v)) || (verticesSet.contains(u)) ^ !verticesSet.contains(v) || verticesSet.isEmpty()) { //&& verticesSet.contains(v))) {
            //if (!(verticesSet.contains(u) ^ verticesSet.contains(v)) || verticesSet.isEmpty()) {
            if (!u.getData().equals("1") || !v.getData().equals("1")) { //&& v.getData() != "1") {
            //if (!u.getData().equals(v.getData()) && !verticesSet.contains())  {      //using data to store what uptree it is in, this should work similar to find                                                                                                  // This should work in theory, could end up doing an up tree implementation
                optimalSet.add(tempE);
                //verticesSet.add(u);
                //verticesSet.add(v);
                //u.setData("1");
                //v.setData(u.getData());
                v.setData("1");
                //u.setData(v.getData());
                //v.setData(u.getData());
                totalCost += (double) tempE.getData();
                //totalCost += temp.getData();                                                                          // should update cost here, just not sure how yet

                //union here
                //String us =

            }


            //if()
            // add edge to optimalSet
            // union(u, v)
            // }
        }
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Optimal set: ");
        Iterator it = optimalSet.iterator();
        StringBuilder sb = new StringBuilder();
        sb.append("["); //System.out.print("[");
        while (it.hasNext()) {
            Edge temp = (Edge) it.next();
            sb.append(temp.getFirstEndpoint().getName() + "-" + temp.getSecondEndpoint().getName()) ;       //System.out.print(temp.getFirstEndpoint().getName() + "-" + temp.getSecondEndpoint().getName());
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        System.out.println(sb);
        return optimalSet;
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
    public Vertex find (Vertex x) {
        //while (x != mainUpTree.
        //while ()
        //myGraph.

        return null; //temp
    }
    public void union(Vertex x, Vertex y) {

    }

    /**
     *
     */
    class EdgeComparator implements Comparator<Edge> {

        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         * <p>
         * The implementor must ensure that {@link Integer#signum
         * signum}{@code (compare(x, y)) == -signum(compare(y, x))} for
         * all {@code x} and {@code y}.  (This implies that {@code
         * compare(x, y)} must throw an exception if and only if {@code
         * compare(y, x)} throws an exception.)<p>
         * <p>
         * The implementor must also ensure that the relation is transitive:
         * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies
         * {@code compare(x, z)>0}.<p>
         * <p>
         * Finally, the implementor must ensure that {@code compare(x,
         * y)==0} implies that {@code signum(compare(x,
         * z))==signum(compare(y, z))} for all {@code z}.
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         * @apiNote It is generally the case, but <i>not</i> strictly required that
         * {@code (compare(x, y)==0) == (x.equals(y))}.  Generally speaking,
         * any comparator that violates this condition should clearly indicate
         * this fact.  The recommended language is "Note: this comparator
         * imposes orderings that are inconsistent with equals."
         */
        @Override
        public int compare(Edge o1, Edge o2) {
            double i = (double) o1.getData();
            double j = (double) o2.getData();
            // (i - j);
            if (i - j > 0) {
                return 1;
            }
            else if (i - j < 0) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }
}
