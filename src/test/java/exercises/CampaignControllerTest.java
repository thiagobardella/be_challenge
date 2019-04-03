package exercises;

import exercises.utils.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CampaignControllerTest {

    @Autowired
    private MockMvc mvc;

    private String testFilePath = "input-routes.csv";

    @Test
    public void shouldReturnOkStatus() throws Exception {
        mvc.perform(get("/map/routes/all"))
            .andExpect(status().isOk())
            .andExpect(content().string(IOUtils.getTextFromFile(testFilePath)));
    }
}