package com.kchmielewski.sda.java.spring04java.player.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class PlayerControllerTest {
    private final PlayerController controller = new PlayerController();
    private final MockMvc mvc = standaloneSetup(controller).build();

    @Test
    public void display() throws Exception {
        MvcResult result = mvc.perform(get("/display")).andExpect(status().isOk()).andReturn();

        assertThat(result.getModelAndView().getViewName()).isEqualTo("players");
    }

    @Test
    public void add() throws Exception {
        MvcResult result = mvc.perform(post("/add").param("name", "Name").param("surname", "Surname"))
                .andExpect(status().isOk()).andReturn();

        assertThat(result.getModelAndView().getViewName()).isEqualTo("players");
    }

    @Test
    public void remove() throws Exception {
        MvcResult result = mvc.perform(post("/remove").param("name", "Name").param("surname", "Surname"))
                .andExpect(status().isOk()).andReturn();

        assertThat(result.getModelAndView().getViewName()).isEqualTo("players");
    }
}