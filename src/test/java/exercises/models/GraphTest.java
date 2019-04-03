package exercises.models;

import exercises.utils.IOUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GraphTest {

    private String testFilePath = "/csv-unit-tests-file.txt";
    private Graph graph = new Graph(IOUtils.getTextFromFile(testFilePath));

    @Test
    public void shouldGetPathForSameCity() {
        Vertex fromCity = new Vertex("GRU");
        Vertex toCity = new Vertex("GRU");
        List<Path> result = graph.getAllPaths(fromCity, toCity);
        assertEquals(1, result.size());
        assertEquals(0, result.get(0).weight);
        assertEquals("GRU > $0", result.get(0).toString());
    }

    @Test
    public void shouldGetPathFromGRUtoCDG() {
        Vertex fromCity = new Vertex("GRU");
        Vertex toCity = new Vertex("CDG");
        List<Path> result = graph.getAllPaths(fromCity, toCity);
        assertEquals(4, result.size());

        assertEquals(40, result.get(0).weight);
        assertEquals("GRU - BRC - SCL - ORL - CDG > $40", result.get(0).toString());

        assertEquals(45, result.get(1).weight);
        assertEquals("GRU - SCL - ORL - CDG > $45", result.get(1).toString());

        assertEquals(61, result.get(2).weight);
        assertEquals("GRU - ORL - CDG > $61", result.get(2).toString());

        assertEquals(75, result.get(3).weight);
        assertEquals("GRU - CDG > $75", result.get(3).toString());
    }

    @Test
    public void shouldGetPathFromGRUtoORL() {
        Vertex fromCity = new Vertex("GRU");
        Vertex toCity = new Vertex("ORL");
        List<Path> result = graph.getAllPaths(fromCity, toCity);
        assertEquals(3, result.size());

        assertEquals(35, result.get(0).weight);
        assertEquals("GRU - BRC - SCL - ORL > $35", result.get(0).toString());

        assertEquals(40, result.get(1).weight);
        assertEquals("GRU - SCL - ORL > $40", result.get(1).toString());

        assertEquals(56, result.get(2).weight);
        assertEquals("GRU - ORL > $56", result.get(2).toString());
    }

}