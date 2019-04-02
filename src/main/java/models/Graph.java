package models;

import java.util.*;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Graph {

    private Map<Vertex, List<Edge>> adjVertices = new HashMap<>();

    public Graph(String csv) {
        // TODO (Improve this logic)
        String[] lines = csv.split("\n");
        for (String line : lines) {
            String[] components = line.split(",");
            String sourceName = components[0];
            String destinationName = components[1];
            int weight = Integer.valueOf(components[2]);
            Vertex source = addVertex(sourceName);
            Vertex destination = new Vertex(destinationName);
            addEdge(source, destination, weight);
        }
    }

    public Vertex addVertex(String name) {
        Vertex newVertex = new Vertex(name);
        List<Edge> edges = new ArrayList<>();
        adjVertices.putIfAbsent(newVertex, edges);
        return newVertex;
    }

    public void addEdge(Vertex source, Vertex destination, int weight) {
        // TODO (check if destination already has a weight)
        Edge newEdge = new Edge(destination, weight);
        List<Edge> edgesFromSource = adjVertices.get(source);
        // TODO (create custom exception)
        if (edgesFromSource == null) throw new RuntimeException();
        edgesFromSource.add(newEdge);
    }

    public List<Path> getAllPaths(Vertex fromCity, Vertex toCity) {
        Set<Vertex> isVisited = new HashSet<>();
        List<Path> result = new ArrayList<>();

        // TODO (insert this logic for the recursive method)
        if (fromCity.equals(toCity)) {
            result.add(new Path(fromCity));
            return result;
        }

        searchGraph(fromCity, toCity, isVisited, result, new Path(fromCity));
//        isVisited.put(fromCity, true);
//        result.add(path);
        result.sort(comparingInt(path -> path.weight));
        return result;
    }

    private void searchGraph(
            Vertex fromCity, Vertex toCity,
            Set<Vertex> isVisited,
            List<Path> result,
            Path localPath
    ) {

        isVisited.add(fromCity);

        if (fromCity.equals(toCity)) {
            result.add(localPath.clone());
            isVisited.remove(fromCity);
            return;
        }

        if (!this.adjVertices.containsKey(fromCity)) return;

        for (Edge edge : adjVertices.get(fromCity)) {
            if (!isVisited.contains(edge.destination)) {
                localPath.weight += edge.weight;
                localPath.vertices.add(edge.destination);
                searchGraph(edge.destination, toCity, isVisited, result, localPath);
                localPath.weight -= edge.weight;
                localPath.vertices.remove(edge.destination);
            }
        }

        isVisited.remove(fromCity);
    }

}

// TODO (bring it to a different file)
class Vertex {
    private String name;

    Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        Vertex other = (Vertex) o;
        if (this.name.equals(other.name)) return true;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

// TODO (bring it to a different file)
class Edge {
    Vertex destination;
    int weight;

    Edge(Vertex destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    // TODO (equals and hashCode)
}

// TODO (bring it to a different file)
class Path implements Cloneable {
    int weight;
    // TODO (make it LinkedList)
    List<Vertex> vertices;

    Path(Vertex firstVertex) {
        this.weight = 0;
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(firstVertex);
        this.vertices = vertices;
    }

    // TODO (is this initializer necessary?)
    Path(int weight, List<Vertex> vertices) {
        this.weight = weight;
        this.vertices = vertices;
    }

    @Override
    //TODO (treat exception)
    public Path clone() {
        try {
            Path result = (Path) super.clone();
            result.vertices = new ArrayList<>(this.vertices);
            return result;
        } catch(CloneNotSupportedException e) {
            return null;
        }
    }

    public String toString() {
        String path = String.join(" - ", this.vertices.stream().map(Vertex::getName).collect(toList()));
        return path + " > $" + this.weight;
    }
}