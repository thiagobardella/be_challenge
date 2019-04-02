package Utils;

import Boot.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtils {

    public static String getTextFromFile(String path) {
        try {
            Class clazz = Application.class;
            // TODO (get Input Stream from file path that should come as parameter from main)
            InputStream inputStream = clazz.getResourceAsStream(path);
            return readFromInputStream(inputStream);
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

}
