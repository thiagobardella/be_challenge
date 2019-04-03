package exercises;

import exercises.models.Graph;
import exercises.utils.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/map")
public class MapController {

    private final static String routesPath = "/input-routes.csv";

    @GetMapping("/routes/all")
    @ResponseBody
    public ResponseEntity<String> paths() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(IOUtils.getTextFromFile(routesPath));
    }

    @PostMapping("/routes/add")
    @ResponseBody
    //TODO (handle exception)
    public String add(@RequestBody String route) throws Exception {
        String sourceName = route.split(",")[0];
        String destinationName = route.split(",")[1];
        int weight = Integer.valueOf(route.split(",")[2]);

        Graph map = new Graph(IOUtils.getTextFromFile(routesPath));
        if (map.contains(sourceName, destinationName)) return "Rota já cadastrada!";

        map.addNode(sourceName, destinationName, weight);
        IOUtils.writeContentToCsv(map);
        return "Rota cadastrada!";
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<String> all() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(IOUtils.getTextFromFile(routesPath));
    }


}
