package exercises;

class Edge {
    Vertex destination;
    int weight;

    Edge(Vertex destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}