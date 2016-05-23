package org.asysob;

public interface IGraph<NodeContent, EdgeContent> {
    public int nodeCount ();
    public int edgeCount ();

    public void addNode ( int id, NodeContent c);
    public NodeContent queryNode ( int id );
    public int edgeDegree ( int id );

    public void addEdge ( int id_1, int id_2, EdgeContent c) throws Exception;
    public EdgeContent queryEdge ( int id_1, int id_2 );
    public boolean existsEdge ( int id_1, int id_2);
}
