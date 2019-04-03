package exercises;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//
//        // TODO (while true???)
//        // TODO (bring parameters to it)
//        String testFilePath = "/input-file.txt";
//        String csv = IOUtils.getTextFromFile(testFilePath);
//        // TODO (create custom Exception)
//        if (csv == null || csv.isEmpty()) throw new RuntimeException();
//        Graph map = new Graph(csv);

    }

}
