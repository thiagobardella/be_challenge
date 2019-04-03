package exercises;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Path implements Cloneable {

    int weight;
    List<Vertex> vertices;

    Path(Vertex firstVertex) {
        this.weight = 0;
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(firstVertex);
        this.vertices = vertices;
    }

    @Override
    public Path clone() {
        try {
            Path result = (Path) super.clone();
            result.vertices = new ArrayList<>(this.vertices);
            return result;
        } catch(CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        String path = String.join(" - ", this.vertices.stream().map(Vertex::getName).collect(toList()));
        return path + " > $" + this.weight;
    }
}