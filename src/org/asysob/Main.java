package org.asysob;

public class Main {

    public static void main(String[] args) {
        Graph rgraph = Graph.RandomGraph(100,99);
        rgraph.print(System.out);

        Graph bag = Graph.BarabasiAlbertGraph(100);
        bag.print(System.out);
    }
}
