package org.asysob;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;

class Graph implements IGraph {
    private HashMap<Integer,Set<Integer>> graph;

    private Graph ( int n_nodes ) {
        graph = new HashMap<Integer,Set<Integer>>(n_nodes);
    }

    @Override
    public int nodeCount () {
        return graph.size();
    }

    @Override
    public int edgeCount () {
        int sum = 0;
        for (HashMap.Entry<Integer,Set<Integer>> entry : graph.entrySet())
            sum += entry.getValue().size();
        return sum/2;
    }

    @Override
    public void addNode(int id) {
        assert(!graph.containsKey(id));
        graph.put(id,new HashSet<Integer>());
    }

    @Override
    public int edgeDegree(int id) {
        assert(graph.containsKey(id));
        int degree = graph.get(id).size();
        return degree;
    }

    @Override
    public void addEdge(int id_1, int id_2) {
        assert(graph.containsKey(id_1));
        assert(graph.containsKey(id_2));
        assert(id_1 != id_2);
        graph.get(id_1).add(id_2);
        graph.get(id_2).add(id_1);
    }

    @Override
    public boolean existsEdge(int id_1, int id_2) {
        assert(graph.containsKey(id_1));
        assert(graph.containsKey(id_2));
        assert(id_1 != id_2);
        return graph.get(id_1).contains(id_2);
    }

    @Override
    public void print(PrintStream out) {
        out.println("{");
        out.print("\tNodes");
        for (HashMap.Entry<Integer,Set<Integer>> entry : graph.entrySet())
            out.print(" "+entry.getKey());
        out.println();
        out.print("\tEdges");
        for (HashMap.Entry<Integer,Set<Integer>> entry : graph.entrySet()) {
            for (Integer n : entry.getValue())
            	if(entry.getKey() <= n){
            		out.print(" <"+entry.getKey()+","+n+">");
            	}
        }
        out.println();
        out.println("}");
    }

    public static Graph EmptyGraph (int n_nodes ) {
        return new Graph(n_nodes);
    }

    public static Graph RandomGraph (int n_nodes, int n_edges ) {
        assert(n_edges <= n_nodes * (n_nodes-1) / 2);

        Graph g = EmptyGraph(n_nodes);
        for (int i=1; i<=n_nodes; i++) g.addNode(i);
        Random rand = new Random();
        for (int e=1; e<=n_edges; e++) {
            int node_1;
            int node_2;
            do {
                node_1 = rand.nextInt(n_nodes) + 1;
                node_2 = rand.nextInt(n_nodes) + 1;

            } while (g.existsEdge(node_1,node_2) || node_1 == node_2);
            System.out.println(node_1 +" "+node_2 );
            g.addEdge(node_1,node_2);
        }
        return g;
    }

    public static double GlobalClusteringCoefficient ( Graph g ) {
        return 42.0;
    }

    public static Graph BarabasiAlbertGraph ( int n_nodes ) {
        assert(n_nodes > 2);

        Graph bag = EmptyGraph(n_nodes);
        bag.addNode(0);
        bag.addNode(1);
        bag.addEdge(0,1);
        Random rand = new Random();

        for (int i=2; i<n_nodes; i++) {
            float v = rand.nextFloat();
            int edge_degree_count = 0;
            for (HashMap.Entry<Integer,Set<Integer>> entry : bag.graph.entrySet()) {
                edge_degree_count += entry.getValue().size();
            }
            float l = 0.0f;
            for (HashMap.Entry<Integer,Set<Integer>> entry : bag.graph.entrySet()) {
                l += ((float) entry.getValue().size())/((float)edge_degree_count);
                if (v < l) {
                    bag.addNode(i);
                    bag.addEdge(i,entry.getKey());
                    break;
                }
            }
        }
        return bag;
    }
}
