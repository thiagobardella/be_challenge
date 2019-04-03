package exercises;

import exercises.utils.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/map")
public class MapController {

    @GetMapping("/routes/all")
    @ResponseBody
    public ResponseEntity<String> paths() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(IOUtils.getTextFromFile(Application.routesCSV));
    }

    @PostMapping("/routes/add")
    @ResponseBody
    public String add(
            @RequestParam String route,
            @RequestParam(required = false) String csvOutputPath) throws Exception {
        String sourceName = route.split(",")[0];
        String destinationName = route.split(",")[1];
        int weight = Integer.valueOf(route.split(",")[2]);

        Graph map = new Graph(IOUtils.getTextFromFile(Application.routesCSV));
        if (map.contains(sourceName, destinationName)) return "Route already registered!";

        map.addNode(sourceName, destinationName, weight);
        if (csvOutputPath == null)
        IOUtils.writeContentToCsv(map);
        return "Route registered!";
    }

    @GetMapping("/routes/get")
    @ResponseBody
    public static String get(
            @RequestParam String from,
            @RequestParam String to
    ) {
        Graph map = new Graph(IOUtils.getTextFromFile(Application.routesCSV));

        List<Path> allPaths = map.getAllPaths(from, to);
        if (allPaths.isEmpty()) System.out.println("There's no route from '" + from + "' to '" + to + "'");
        return allPaths.get(0).toString();
    }
}
