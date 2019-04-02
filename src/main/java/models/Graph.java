package models;

import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Vertex, List<Vertex>> adjVertices;
}

class Vertex {
    String label;

    Vertex(String label) {
        this.label = label;
    }

    // equals and hashCode
}