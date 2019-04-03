package exercises;

import java.util.*;

import static java.util.Comparator.*;

public class Graph {

    private Map<Vertex, List<Edge>> adjVertices = new HashMap<>();

    public Graph(String csv) {
        if (csv == null) return;
        Arrays.stream(csv.split("\n")).forEach(line -> {
            String[] components = line.split(",");
            String sourceName = components[0];
            String destinationName = components[1];
            int weight = Integer.valueOf(components[2]);
            addNode(sourceName, destinationName, weight);
        });
    }

    public boolean contains(String sourceName, String destinationName) {
        Vertex vertexSource = new Vertex(sourceName);
        if (!adjVertices.containsKey(vertexSource)) return false;
        return adjVertices.get(vertexSource).stream()
                .anyMatch(edge -> edge.destination.getName().equals(destinationName));
    }

    public List<Path> getAllPaths(String source, String destination) {
        Vertex fromCity = new Vertex(source);
        Vertex toCity = new Vertex(destination);
        Set<Vertex> isVisited = new HashSet<>();
        List<Path> result = new ArrayList<>();

        if (fromCity.equals(toCity)) {
            result.add(new Path(fromCity));
            return result;
        }

        searchGraph(fromCity, toCity, isVisited, result, new Path(fromCity));
        result.sort(comparingInt(path -> path.weight));
        return result;
    }

    public void addNode(String sourceName, String destinationName, int weight) {
        Vertex source = addVertex(sourceName);
        Vertex destination = new Vertex(destinationName);
        addEdge(source, destination, weight);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        adjVertices.forEach((vertice, edges) ->
                edges.forEach(edge -> {
                    String verticeString =  vertice.getName() + ',' +
                            edge.destination.getName() + "," +
                            edge.weight;
                    if (stringBuilder.indexOf(verticeString) == -1) {
                        stringBuilder.append(verticeString).append(",\n");
                    }
                }));
        return stringBuilder.toString();
    }

    private Vertex addVertex(String name) {
        Vertex newVertex = new Vertex(name);
        List<Edge> edges = new ArrayList<>();
        adjVertices.putIfAbsent(newVertex, edges);
        return newVertex;
    }

    private void addEdge(Vertex source, Vertex destination, int weight) {
        Edge newEdge = new Edge(destination, weight);
        List<Edge> edgesFromSource = adjVertices.get(source);
        edgesFromSource.add(newEdge);
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

