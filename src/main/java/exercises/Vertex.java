package exercises;

public class Vertex {
    private String name;

    Vertex(String name) {
        this.name = name;
    }

    String getName() {
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