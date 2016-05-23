package org.asysob;

import java.util.HashMap;

public class Graph<NodeContent, EdgeContent> implements IGraph<NodeContent, EdgeContent> {
    protected class NodeType {
        public NodeContent content;
    }

    protected class EdgeType {
        public EdgeContent content;
        public int node_1;
        public int node_2;
    }

    protected HashMap<Integer,NodeType> nodes;
    protected HashMap<Integer,EdgeType> edges;

    protected Graph ( int n_nodes, int n_edges ) {
        nodes = new HashMap<Integer, NodeType>(n_nodes);
        edges = new HashMap<Integer, EdgeType>(n_edges);
    }

    public int nodeCount () {
        return nodes.size();
    }

    public int edgeCount () {
        return edges.size();
    }

    public static <NodeContent, EdgeContent> Graph<NodeContent, EdgeContent> EmptyGraph ( int n_nodes, int n_edges ) {
        return new Graph<NodeContent,EdgeContent>(n_nodes,n_edges);
    }
}
