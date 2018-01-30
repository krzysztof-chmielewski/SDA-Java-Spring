package com.kchmielewski.sda.java.spring02java.player.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class PlayerControllerTest {
    private final PlayerController controller = new PlayerController();
    private final MockMvc mvc = standaloneSetup(controller).build();

    @Test
    public void superFancyMethodReturnsWhatItShouldReturn() throws Exception {
        mvc.perform(get("/extremelyFancyMethodMappingWithEvenMoreFancyEverythingAndNothingAtTheSameTime"))
                .andExpect(status().isOk());
    }
}