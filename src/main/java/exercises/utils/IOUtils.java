package exercises.utils;

import exercises.Graph;

import java.io.*;
import java.nio.file.Files;

public class IOUtils {

    public static String getTextFromFile(String path) {
        try {
            return String.join("\n", Files.readAllLines(new File(path).toPath()));
        } catch (IOException ex) {
            return null;
        }
    }

    public static void writeContentToCsv(Graph graph) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter("input-routes.csv"));
        writer.write(graph.toString());
        writer.close();
    }

}
