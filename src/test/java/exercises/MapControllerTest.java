package exercises;

import exercises.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest({Application.class})
public class MapControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturnOkStatus() throws Exception {
        mvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(content().string("Cliente não encontrado!"));
    }
//
//    @Test
//    public void shouldGetPartner() throws Exception {
//        mvc.perform(get("/prova-java/partners/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", equalTo(1)))
//                .andExpect(jsonPath("$.full_name", equalTo("Thiago Bardella")));
//    }
//
//    @Test
//    public void shouldNotFindPartner() throws Exception {
//        mvc.perform(get("/prova-java/partners/1000"))
//                .andExpect(status().isNotFound())
//                .andExpect(content().string("Cliente não encontrado!"));
//
//        mvc.perform(put("/prova-java/partners/update/1000"))
//                .andExpect(status().isNotFound())
//                .andExpect(content().string("Cliente não encontrado!"));
//
//        mvc.perform(delete("/prova-java/partners/delete/1000"))
//                .andExpect(status().isNotFound())
//                .andExpect(content().string("Cliente não encontrado!"));
//    }
//
//    @Test
//    public void shouldAssociateCampaign() throws Exception {
//        mvc.perform(post("/prova-java/partners/1/join"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].name", equalTo("first")));
//
//        mvc.perform(get("/prova-java/partners/1/campaigns"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].name", equalTo("first")));
//    }
//
//    @Test
//    public void shouldAddPartner() throws Exception {
//        PartnerInput partnerInput = new PartnerInput(1, "New Client",
//                "newClient@gmail.com",
//                DateUtils.formatter.parse("01-01-2000"));
//
//        mvc.perform(post("/prova-java/partners/add")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(gson.toJson(partnerInput)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].name", equalTo("first")));
//    }
//
//    @Test
//    public void shouldUpdatePartner() throws Exception {
//        mvc.perform(put("/prova-java/partners/update/1")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("team_id", "200")
//                .param("full_name", "New")
//                .param("email", "new@gmail.com")
//        )
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.team_id", equalTo(200)))
//                .andExpect(jsonPath("$.full_name", equalTo("New")))
//                .andExpect(jsonPath("$.email", equalTo("new@gmail.com")));
//
//        mvc.perform(get("/prova-java/partners/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.team_id", equalTo(200)))
//                .andExpect(jsonPath("$.full_name", equalTo("New")))
//                .andExpect(jsonPath("$.email", equalTo("new@gmail.com")));
//
//    }
//
//    @Test
//    public void shouldDeletePartner() throws Exception {
//        mvc.perform(delete("/prova-java/partners/delete/2"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Cliente 2 excluído!"));
//
//        mvc.perform(get("/prova-java/partners/2"))
//                .andExpect(status().isNotFound())
//                .andExpect(content().string("Cliente não encontrado!"));
//
//    }
}