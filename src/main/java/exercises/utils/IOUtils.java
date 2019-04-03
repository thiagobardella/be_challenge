package exercises.utils;

import exercises.Application;
import exercises.models.Graph;

import java.io.*;

public class IOUtils {

    public static String getTextFromFile(String path) {
        try {
            Class clazz = Application.class;
            // TODO (get Input Stream from file path that should come as parameter from main)
            InputStream inputStream = clazz.getResourceAsStream(path);
            String result = readFromInputStream(inputStream);
            inputStream.close();
            return result;
        } catch (IOException ex) {
            return null;
        }
    }

    private static String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    public static void writeContentToCsv(Graph graph) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/routes.csv"));
        writer.write(graph.toString());
        writer.close();
    }

}
