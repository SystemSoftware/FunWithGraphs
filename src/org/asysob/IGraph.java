package org.asysob;

public interface IGraph {
    public int nodeCount ();
    public int edgeCount ();

    public void addNode ( int id );
    public int edgeDegree ( int id );

    public void addEdge ( int id_1, int id_2 );
    public boolean existsEdge ( int id_1, int id_2);

    public void print ( java.io.PrintStream out );
}
