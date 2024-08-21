package datastructures.graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("A");

        graph.addVertex("B");

        graph.addVertex("C");

        graph.addVertex("D");

        graph.printGraph();

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("A", "C");
        graph.addEdge("D", "B");
        graph.addEdge("D", "C");

        graph.printGraph();

//        graph.removeEdge("A", "C");

        graph.removeVertex("D");

        graph.printGraph();
    }
}
