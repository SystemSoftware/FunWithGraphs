package org.asysob;

import java.util.HashMap;

class Graph<NodeContent, EdgeContent> implements IGraph<NodeContent, EdgeContent> {
    private class EdgeType {
        EdgeContent content;
        EdgeType ( EdgeContent c ) {
            content = c;
        }
    }

    private class NodeType {
        NodeContent content;
        NodeType ( NodeContent c ) {
            content = c;
            edges = new HashMap<Integer, EdgeType>();
        }
        HashMap<Integer,EdgeType> edges;
    }

    private HashMap<Integer,NodeType> nodes;

    private Graph ( int n_nodes ) {
        nodes = new HashMap<Integer, NodeType>(n_nodes);
    }

    @Override
    public int nodeCount () {
        return nodes.size();
    }

    @Override
    public int edgeCount () {
        int sum = 0;
        for (HashMap.Entry<Integer,NodeType> entry : nodes.entrySet())
            sum += entry.getValue().edges.size();
        return sum;
    }

    @Override
    public void addNode(int id, NodeContent c) {
        nodes.put(id,new NodeType(c));
    }

    @Override
    public NodeContent queryNode(int id) {
        if (nodes.containsKey(id))
            return nodes.get(id).content;
        else
            return null;
    }

    @Override
    public int edgeDegree(int id) {
        if (nodes.containsKey(id))
            return nodes.get(id).edges.size();
        else
            return -1;
    }

    @Override
    public void addEdge(int id_1, int id_2, EdgeContent c) throws Exception {
        int min_id = id_1 < id_2 ? id_1 : id_2;
        int other_id = min_id == id_1 ? id_2 : id_1;
        EdgeType edge = new EdgeType(c);
        if (nodes.containsKey(min_id))
            nodes.get(min_id).edges.put(other_id,edge);
        else
            throw new Exception("Edge needs two nodes");
    }

    @Override
    public boolean existsEdge(int id_1, int id_2) {
        int min_id = id_1 < id_2 ? id_1 : id_2;
        int other_id = min_id == id_1 ? id_2 : id_1;
        if (!nodes.containsKey(min_id))
            return false;
        if (!nodes.get(min_id).edges.containsKey(other_id))
            return false;
        return true;
    }

    @Override
    public EdgeContent queryEdge(int id_1, int id_2) {
        int min_id = id_1 < id_2 ? id_1 : id_2;
        int other_id = min_id == id_1 ? id_2 : id_1;
        if (existsEdge(min_id,other_id))
            return nodes.get(min_id).edges.get(other_id).content;
        else
            return null;
    }

    public static <NodeContent, EdgeContent> Graph<NodeContent, EdgeContent> EmptyGraph (int n_nodes ) {
        return new Graph<NodeContent,EdgeContent>(n_nodes);
    }

    public static <NodeContent, EdgeContent> Graph<NodeContent, EdgeContent> RandomGraph (int n_nodes, int n_edges ) {
        Graph g = EmptyGraph(n_nodes);
        for (int i=1; i<=n_nodes; i++)
            ;
        return g;
    }
}
