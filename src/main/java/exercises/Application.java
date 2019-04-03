package exercises;

import exercises.utils.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application {

    private static final String ESC = "esc";

    static String routesCSV = "input-routes.csv";

    public static void main(String[] args) {
        if (args.length != 0) { routesCSV = args[0]; }

        String csv = IOUtils.getTextFromFile(routesCSV);
        if (csv == null) {
            System.out.println("File '" + args[0] + "' not found!");
            return;
        }

        Scanner reader = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Please enter the route (or writes 'esc' to keep application on Background): ");
            input = reader.nextLine();
            if (input.equals(ESC)) break;
            if (input.split("\\s").length < 2) {
                System.out.println("2 parameters are necessary: SOURCE and DESTINATION.");
            }
            String sourceName = input.split("\\s")[0];
            String destinationName = input.split("\\s")[1];
            System.out.println(MapController.get(sourceName, destinationName));
        }

        SpringApplication.run(Application.class, args);
    }

}
